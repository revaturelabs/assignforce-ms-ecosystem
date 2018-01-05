package com.revature.batchservice;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

import com.revature.assignforcebatchms.AssignforceBatchMsApplication;
import com.revature.assignforcebatchms.domain.Batch;
import com.revature.assignforcebatchms.domain.BatchLocation;
import com.revature.assignforcebatchms.domain.BatchStatusLookup;
import com.revature.assignforcebatchms.service.BatchDaoService;

import utils.JsonMaker;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = AssignforceBatchMsApplication.class)
@AutoConfigureMockMvc
public class AssignforceBatchMsApplicationTests {
	
	private Batch batch;
	
	private BatchLocation batchLocation;
	
	private BatchStatusLookup batchStatus;
	
	List<Integer> skillList = new ArrayList<Integer>();
	
	
	@Autowired
	private BatchDaoService batchService;
	
	@Autowired
	private MockMvc mvc;
	
	private JsonMaker jsonMaker = new JsonMaker();
	
	@Test
	public void contextLoads() {
	}
	
	@Before
	public void setup(){
		skillList.add(1);
		skillList.add(2);
		skillList.add(3);
		batchLocation.setId(1000000000);
		batchLocation.setBuildingId(1000000000);
		batchLocation.setLocationId(1000000000);
		batchLocation.setRoomId(1000000000);
		batchStatus.setBatchStatusID(1);
		batchStatus.setBatchStatusName("Scheduled");
		batch.setID(1000000000);
		batch.setName("Batch Test");
		batch.setBatchLocation(batchLocation);
		batch.setBatchStatus(batchStatus);
		batch.setTrainer("t1");
		batch.setCotrainer("t1");
		batch.setCurriculum(1000000000);
		batch.setFocus(1000000000);
		batch.setSkills(skillList);
		batch.setEndDate(new Timestamp(System.currentTimeMillis()));
		batch.setStartDate(new Timestamp(System.currentTimeMillis()));
	}
	
	@After
	public void tearDown() {
		skillList = null;
		batch = null;
		batchLocation = null;
		batchStatus = null;
	}
	
	@Test
	public void testCreateBatch() throws Exception {
		given(batchService.saveItem(any(Batch.class))).willReturn(batch);
        mvc.perform(post("/api/v2/trainer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMaker.toJsonString(batch)))
                .andExpect(status().isOk());
	}
	
	@Test
	public void testGetBatch() throws Exception {
		given(batchService.saveItem(any(Batch.class))).willReturn(batch);
        mvc.perform(get("/api/v2/trainer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMaker.toJsonString(batch)))
                .andExpect(status().isOk());
	}
	
}
