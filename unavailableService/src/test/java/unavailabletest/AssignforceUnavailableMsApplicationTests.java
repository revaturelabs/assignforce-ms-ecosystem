package unavailabletest;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;

import com.revature.unavailableservice.controller.GoogleCalCtrl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.unavailableservice.AssignforceUnavailableMsApplication;
import com.revature.unavailableservice.domain.UnavailabilityRoom;
import com.revature.unavailableservice.domain.UnavailabilityTrainer;
import com.revature.unavailableservice.service.UnavailabilityRoomService;
import com.revature.unavailableservice.service.UnavailabilityTrainerService;

import utils.JsonMaker;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = AssignforceUnavailableMsApplication.class)
@AutoConfigureMockMvc
public class AssignforceUnavailableMsApplicationTests {
	
	private UnavailabilityRoom uRoom;

	private UnavailabilityTrainer uTrain;
	
	@MockBean
	private UnavailabilityRoomService uRoomService;

	@MockBean
	GoogleCalCtrl google;
	
	@MockBean
	private UnavailabilityTrainerService uTrainerService;
	
	@Autowired
	private MockMvc mvc;
	
	private JsonMaker jsonMaker = new JsonMaker();

	@Test
	public void contextLoads() {
	}
	
	@Before
	public void setUp(){
		uRoom = new UnavailabilityRoom();
		uTrain = new UnavailabilityTrainer();
		uRoom.setRoomId(1);
		uRoom.setEndDate(new Timestamp(System.currentTimeMillis()));
		uRoom.setStartDate(new Timestamp(System.currentTimeMillis()));
		uTrain.setTrainerId("abc123");
		uTrain.setEndDate(new Timestamp(System.currentTimeMillis()));
		uTrain.setStartDate(new Timestamp(System.currentTimeMillis()));
	}
	
	@After
	public void tearDown() {
		uRoom = null;
		uTrain = null;
	}
	
	@Test
	public void testCreateRoomUnavailability() throws Exception {
		given(uRoomService.saveItem(any(UnavailabilityRoom.class))).willReturn(uRoom);
        mvc.perform(post("/api/v2/unavailable/createRoomUnavailability")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMaker.toJsonString(uRoom)))
                .andExpect(status().isOk());
	}
	
	@Test
	public void testCreateTrainerUnavailability() throws Exception {
		given(uTrainerService.saveItem(any(UnavailabilityTrainer.class))).willReturn(uTrain);
        mvc.perform(post("/api/v2/unavailable/createTrainerUnavailability")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMaker.toJsonString(uTrain)))
                .andExpect(status().isOk());
	}

	@Test
	public void retrieveTrainerUnavailabilityTest() throws Exception {
		given(uTrainerService.getOneItem(any(String.class))).willReturn(uTrain);
		mvc.perform(get("/api/v2/unavailable/trainer/1111"))
				.andExpect(status().isOk());
	}

	@Test
	public void retrieveRoomUnavailabilityTest() throws Exception {
		given(uRoomService.getOneItem(any(Integer.class))).willReturn(uRoom);
		mvc.perform(get("/api/v2/unavailable/room/42"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.startDate", is(uRoom.getStartDate().getTime())))
				.andExpect(jsonPath("$.endDate", is(uRoom.getEndDate().getTime())))
				.andExpect(jsonPath("$.id", is(uRoom.getId())));
	}

	@Test
	public void updateTrainerUnavailabilityTest() throws Exception {
		given(uTrainerService.saveItem(any(UnavailabilityTrainer.class))).willReturn(uTrain);
		doNothing().when(uTrainerService).deleteItem(anyInt());
		mvc.perform(post("/api/v2/unavailable/updateTrainerUnavailability")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonMaker.toJsonString(uTrain)))
				.andExpect(status().isOk());
	}

	@Test
	public void updateRoomUnavailabilityTest() throws Exception {
		given(uRoomService.saveItem(any(UnavailabilityRoom.class))).willReturn(uRoom);
		doNothing().when(uRoomService).deleteItem(anyInt());
		mvc.perform(post("/api/v2/unavailable/updateRoomUnavailability")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonMaker.toJsonString(uRoom)))
				.andExpect(status().isOk());
	}

	@Test
	public void googleStatus() throws Exception {
		mvc.perform(put("/api/v2/google/googleStatus"))
				.andExpect(status().isOk());
	}

}
