package com.revature.batchservice;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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
    public void createBatch() throws Exception {
        given(batchService.saveItem(any(Batch.class))).willReturn(batch);
        mvc.perform(post("/api/v2/batch")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMaker.toJsonString(batch)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id", is(batch.getID())));
    }

    @Test
    public void createBatchWithEmptyDTO() throws Exception {
        given(batchService.saveItem(any(Batch.class))).willReturn(null);
        mvc.perform(post("/api/v2/batch")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMaker.toJsonString(batch)))
                    .andExpect(status().isInternalServerError());
    }

    @Test
    public void retrieveBatch() throws Exception {
        given(batchService.getOneItem(anyInt())).willReturn(batch);
        mvc.perform(get("/api/v2/batch/42")
        		.contentType(MediaType.APPLICATION_JSON)
                .content(jsonMaker.toJsonString(batch)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(batch.getID())));
    }

    @Test
    public void retrieveBatchWithEmptyDTO() throws Exception {
        given(batchService.getOneItem(anyInt())).willReturn(null);
        mvc.perform(get("/api/v2/batch/42")
        		.contentType(MediaType.APPLICATION_JSON)
                .content(jsonMaker.toJsonString(batch)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteBatch() throws Exception {
        doNothing().when(batchService).deleteItem(anyInt());
        given(batchService.getOneItem(anyInt())).willReturn(batch);
//        given(roomService.getOneItem(anyInt())).willReturn(aRoom);
        mvc.perform(delete("/api/v2/batch/42")
        		.contentType(MediaType.APPLICATION_JSON)
                .content(jsonMaker.toJsonString(batch)))
                .andExpect(status().isOk());
    }

    @Test
    public void retrieveAllBatches() throws Exception {
        List<Batch> batches = new ArrayList<Batch>();
        batches.add(batch);
        given(batchService.getAllItems()).willReturn(batches);
        mvc.perform(get("/api/v2/batch")
        		.contentType(MediaType.APPLICATION_JSON)
                .content(jsonMaker.toJsonString(batch)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(batches.size())));
    }

    @Test
    public void retrieveAllBatchesWithEmptySet() throws Exception {
        List<Batch> batches = new ArrayList<Batch>();
        given(batchService.getAllItems()).willReturn(batches);
        mvc.perform(get("/api/v2/batch")
        		.contentType(MediaType.APPLICATION_JSON)
                .content(jsonMaker.toJsonString(batch)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void retrieveAllBatchesWithError() throws Exception {
        given(batchService.getAllItems()).willReturn(null);
        mvc.perform(get("/api/v2/batch")
        		.contentType(MediaType.APPLICATION_JSON)
                .content(jsonMaker.toJsonString(batch)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateBatch() throws Exception {
        given(batchService.saveItem(any(Batch.class))).willReturn(batch);
        given(batchService.getOneItem(anyInt())).willReturn(batch);
        mvc.perform(put("/api/v2/batch")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMaker.toJsonString(batch)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(batch.getID())));
    }

    @Test
    public void updateBatchWithEmptyDTO() throws Exception {
        given(batchService.saveItem(any(Batch.class))).willReturn(null);
        given(batchService.getOneItem(anyInt())).willReturn(batch);
        mvc.perform(put("/api/v2/batch")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
	
}
