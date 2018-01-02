package unavailabletest;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
	
	@Autowired
	private UnavailabilityRoomService uRoomService;
	
	@Autowired
	private UnavailabilityTrainerService uTrainerService;
	
	@Autowired
	private MockMvc mvc;
	
	private JsonMaker jsonMaker = new JsonMaker();

	@Test
	public void contextLoads() {
	}
	
	@Before
	public void setup(){
		uRoom.setRoomId(1);
		uRoom.setEndDate(new Timestamp(System.currentTimeMillis()));
		uRoom.setStartDate(new Timestamp(System.currentTimeMillis()));
		uTrain.setTrainerId(1);
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
        mvc.perform(post("/api/v2/trainer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMaker.toJsonString(uRoom)))
                .andExpect(status().isOk());
	}
	
	@Test
	public void testCreateTrainerUnavailability() throws Exception {
		given(uTrainerService.saveItem(any(UnavailabilityTrainer.class))).willReturn(uTrain);
        mvc.perform(post("/api/v2/trainer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMaker.toJsonString(uTrain)))
                .andExpect(status().isOk());
	}

}
