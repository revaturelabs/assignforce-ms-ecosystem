package com.revature.curriculumservice.web;


import com.revature.curriculumservice.domain.Curriculum;
import com.revature.curriculumservice.domain.dto.CurriculumDTO;
import com.revature.curriculumservice.service.ActivatableObjectDaoService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CurriculumCtrlTest {

    /*private Curriculum testCurriculum;
    private CurriculumDTO curriculumDTO;

    @Autowired
    private MockMvc mvc;

    @MockBean
    ActivatableObjectDaoService<Curriculum, Integer> currService;

    @Before
    public void setUp() throws Exception {
        curriculumDTO = new CurriculumDTO();
        curriculumDTO.setCurrId(1);
        curriculumDTO.setName("Test");

        List<Integer> skills = new ArrayList<>();
        skills.add(1);
        skills.add(2);
        curriculumDTO.setSkills(skills);

        testCurriculum = new Curriculum(curriculumDTO.getCurrId(), curriculumDTO.getName(), curriculumDTO.getSkills(), true);
        // given(customSecurity.hasPermission(any(),any(),any())).willReturn(true);
    }

    @After
    public void tearDown() throws Exception {
        curriculumDTO = null;
        testCurriculum = null;
    }

    @Test
    public void createCurriculumTest() throws Exception {
        given(currService.saveItem(any(Curriculum.class))).willReturn(testCurriculum);
        mvc.perform(post("/api/v2/curriculum")
                .with(csrf().asHeader())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonMaker.toJsonString(curriculumTest)))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    public void createCurriculumWithEmptyDTOTest() throws Exception {
        given(currService.saveItem(any(Curriculum.class))).willReturn(null);
        mvc.perform(post("/api/v2/curriculum")
                .with(csrf().asHeader())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonMaker.toJsonString(curriculumTest)))
                .andExpect(status().isInternalServerError());
    }

    @Test
    @WithMockUser
    public void createCurriculumWithNullDTOTest() throws Exception {
        given(currService.saveItem(any(Curriculum.class))).willReturn(null);
        mvc.perform(post("/api/v2/curriculum")
                .with(csrf().asHeader())
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser
    public void retrieveCurriculumTest() throws Exception {
        given(currService.getOneItem(any(Integer.class))).willReturn(curriculumTest);
        mvc.perform(get("/api/v2/curriculum/1")
                .with(csrf().asHeader())
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(curriculumTest.getName())))
                .andExpect(jsonPath("$.currId", is(curriculumTest.getCurrId())))
                .andExpect(jsonPath("$.active", is(curriculumTest.getActive())));
    }

    @Test
    @WithMockUser
    public void retrieveCurriculumWithBadIdTest() throws Exception {
        given(currService.getOneItem(any(Integer.class))).willReturn(null);
        mvc.perform(get("/api/v2/curriculum/1")
                .with(csrf().asHeader())
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser
    public void updateCurriculumTest() throws Exception {
        given(currService.saveItem(any(Curriculum.class))).willReturn(curriculumTest);
        mvc.perform(put("/api/v2/curriculum")
                .with(csrf().asHeader())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonMaker.toJsonString(curriculumTest)))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    public void updateCurriculumWithEmptyDTOTest() throws Exception {
        curriculumTest = new Curriculum();
        given(currService.saveItem(any(Curriculum.class))).willReturn(null);
        mvc.perform(put("/api/v2/curriculum")
                .with(csrf().asHeader())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonMaker.toJsonString(curriculumTest)))
                .andExpect(status().isNotModified());
    }

    @Test
    @WithMockUser
    public void updateCurriculumWithNullDTOTest() throws Exception {
        curriculumTest = new Curriculum();
        given(currService.saveItem(any(Curriculum.class))).willReturn(null);
        mvc.perform(put("/api/v2/curriculum")
                .with(csrf().asHeader())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(""))
                .andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser
    public void deleteCurriculumTest() throws Exception {
        doNothing().when(currService).deleteItem(any(Integer.class));
        mvc.perform(delete("/api/v2/curriculum/1")
                .with(csrf().asHeader()))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    public void retrieveAllCurriculaTest() throws Exception {
        List<Curriculum> curricula = new ArrayList<>();
        curricula.add(curriculumTest);
        given(currService.getAllItems()).willReturn(curricula);
        mvc.perform(get("/api/v2/curriculum")
                .with(csrf().asHeader()))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    public void retrieveAllCurriculaWithEmptyListTest() throws Exception {
        List<Curriculum> curricula = new ArrayList<>();
        given(currService.getAllItems()).willReturn(curricula);
        mvc.perform(get("/api/v2/curriculum")
                .with(csrf().asHeader()))
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser
    public void retrieveAllCurriculaReturnNullTest() throws Exception {
        given(currService.getAllItems()).willReturn(null);
        mvc.perform(get("/api/v2/curriculum")
                .with(csrf().asHeader()))
                .andExpect(status().isNotFound());
    }*/
}