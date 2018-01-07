package com.revature.batchservice;

import com.revature.assignforcebatchms.AssignforceBatchMsApplication;

import com.revature.assignforcebatchms.domain.*;
import com.revature.assignforcebatchms.service.ActivatableObjectDaoService;
import com.revature.assignforcebatchms.service.BatchLocationDaoService;
import com.revature.assignforcebatchms.service.DaoService;
import utils.JsonMaker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Me on 01/01/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = AssignforceBatchMsApplication.class)
@AutoConfigureMockMvc

public class AssignforceBatchMsApplicationTests {

    private JsonMaker jsonMaker = new JsonMaker();

    @MockBean
    private BatchLocation batchLocation;

    @MockBean
    private BatchStatusLookup batchStatusLookup;

    @MockBean
    private Batch testBatch;

    private Timestamp sTimestamp = new Timestamp(Timestamp.valueOf(LocalDateTime.now().minusMonths(3)).getTime());

    private Timestamp eTimestamp = new Timestamp(Timestamp.valueOf(LocalDateTime.now()).getTime());


    @Autowired
    private MockMvc mvc;

    @MockBean
    DaoService<Batch, Integer> batchService;

    @MockBean
    DaoService<BatchLocation, Integer> batchLocationService;

    @Before
    public void setUp() {
        List<Integer> skills = new ArrayList<Integer>();
        skills.add(0);
        List<Integer> unavailability = new ArrayList<Integer>();
        unavailability.add(0);
        batchStatusLookup = new BatchStatusLookup(0, "aStatus");
        batchLocation = new BatchLocation();
        batchLocation.setId(330);
        batchLocation.setLocationId(0);
        batchLocation.setBuildingId(0);
        batchLocation.setRoomId(0);
        testBatch = new Batch(0, "new batch",
                new Timestamp(Timestamp.valueOf(LocalDateTime.now()).getTime()),
                new Timestamp(Timestamp.valueOf(LocalDateTime.now()).getTime()), 1,
                batchStatusLookup, "trainer", "cotrainer", skills,
                1, batchLocation);
    }

    @After
    public void tearDown() throws Exception {
        testBatch = null;
    }

    @Test
    public void createBatch() throws Exception {
    	given(batchLocationService.saveItem(any(BatchLocation.class))).willReturn(batchLocation);
        given(batchService.saveItem(any(Batch.class))).willReturn(testBatch);
        mvc.perform(post("/api/v2/batch")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMaker.toJsonString(testBatch)))
                    .andExpect(status().isOk());
    }

    @Test
    public void retrieveBatch() throws Exception {
        given(batchService.getOneItem(anyInt())).willReturn(testBatch);
        mvc.perform(get("/api/v2/batch/330"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(testBatch.getID())));
    }

    @Test
    public void retrieveInvalidBatch() throws Exception {
        given(batchService.getOneItem(anyInt())).willReturn(null);
        mvc.perform(get("/api/v2/batch/330"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteBatch() throws Exception {
    	given(batchService.getOneItem(anyInt())).willReturn(testBatch);
        doNothing().when(batchService).deleteItem(anyInt());
        mvc.perform(delete("/api/v2/batch/330"))
                .andExpect(status().isOk());
    }

    @Test
    public void retrieveAllBatches() throws Exception {
        List<Batch> batches = new ArrayList<Batch>();
        batches.add(testBatch);
        given(batchService.getAllItems()).willReturn(batches);
        mvc.perform(get("/api/v2/batch"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(batches.size())));
    }

    @Test
    public void retrieveAllBatchesWithEmptySet() throws Exception {
        List<Batch> batches = new ArrayList<Batch>();
        given(batchService.getAllItems()).willReturn(batches);
        mvc.perform(get("/api/v2/batch"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void retrieveAllBatchesWithError() throws Exception {
        given(batchService.getAllItems()).willReturn(null);
        mvc.perform(get("/api/v2/batch"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateBatch() throws Exception {
        given(batchService.saveItem(any(Batch.class))).willReturn(testBatch);
        given(batchService.getOneItem(anyInt())).willReturn(testBatch);
        mvc.perform(put("/api/v2/batch")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMaker.toJsonString(testBatch)))
                .andExpect(status().isOk());
    }

    @Test
    public void updateBatchWithEmptyDTO() throws Exception {
        given(batchService.saveItem(any(Batch.class))).willReturn(null);
        given(batchService.getOneItem(anyInt())).willReturn(testBatch);
        mvc.perform(put("/api/v2/batch")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
