package web;

import com.revature.assignforce.settingService.SettingsServiceApplication;
import com.revature.assignforce.settingService.domain.Setting;
import com.revature.assignforce.settingService.service.SettingServiceImplementation;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
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
import org.springframework.test.web.servlet.MockMvc;
import utils.JsonMaker;

import java.util.ArrayList;
import java.util.List;


//import org.springframework.security.test.context.support.WithMockUser;
//import com.revature.assignforce.security.CustomSecurity;
//import com.revature.assignforce.service.DaoService;
//import com.revature.assignforce.utils.JsonMaker;

/**
 * Created by gdittric on 7/13/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = SettingsServiceApplication.class)
@AutoConfigureMockMvc
public class SettingCtrlTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
	private SettingServiceImplementation settingServiceImplementation;
    //private DaoService<Setting, Integer> settingService;

	/*
    @MockBean
    CustomSecurity customSecurity;
	*/

    private Setting testSetting = null;

    private JsonMaker jsonMaker = new JsonMaker();

    @Before
    public void setUp(){
		testSetting = new Setting();
		Short x = 10;
		//testSetting.setDefaultMinBatchSize(;
		//testSetting.setDefaultMaxBatchSize;
		//testSetting.setDefaultBatchBuilding;
		//testSetting.setDefaultBatchNamePattern;
		//testSetting.setDefaultIncomingTraineesPerBatch;
		testSetting.setDefaultGradsPerBatch( x);
		//testSetting.setDefaultBatchLength;
		//testSetting.setMinDayBtwBatches;
		testSetting.setTimelineTrainersPerPage( x);
        //given(customSecurity.hasPermission(any(),any(),any())).willReturn(true);
    }

    @After
    public void tearDown(){
        testSetting = null;
    }

    @Test
    //@WithMockUser(roles = "Her Majesty The Queen Of England")
    public void createSettingTest() throws Exception {
        mvc.perform(post("/api/v2/setting")
                //.with(csrf().asHeader())
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonMaker.toJsonString(testSetting)))
                .andExpect(status().isNotImplemented());
    }

    @Test
    //@WithMockUser(roles = "Her Majesty The Queen Of England")
    public void retrieveSettingTest() throws Exception {
        given(settingServiceImplementation.getSettings()).willReturn(testSetting);
        mvc.perform(get("/api/v2/setting"))
			.andExpect(status().isOk());
			//.with(csrf().asHeader())) <- swap this with line above when you
			//get security working

    }

	/*
    @Test
    //@WithMockUser(roles = "Her Majesty The Queen Of England")
    public void retrieveInvalidSettingTest() throws Exception {
        given(settingService.getSettings()).willReturn(null);
        mvc.perform(get("/api/v2/setting/42")
                .with(csrf().asHeader()))
                .andExpect(status().isNotFound());
    }
	*/

	/*
    @Test
    //@WithMockUser(roles = "Her Majesty The Queen Of England")
    public void getGlobalSettingsTest() throws Exception {
        List<Setting> listOfSettings = new ArrayList<Setting>();
        listOfSettings.add(testSetting);
        given(settingService.getAllItems()).willReturn(listOfSettings);
        mvc.perform(get("/api/v2/setting")
                                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()",
                        Matchers.is(listOfSettings.size())));
    }
	*/

	/*
    @Test
    //@WithMockUser(roles = "Her Majesty The Queen Of England")
    public void getEmptyGlobalSettingsTest() throws Exception {
        List<Setting> listOfSettings = new ArrayList<Setting>();
        given(settingService.getAllItems()).willReturn(listOfSettings);
        mvc.perform(get("/api/v2/setting")
                .with(csrf().asHeader()))
                .andExpect(status().isNotFound());
    }

    @Test
    //@WithMockUser(roles = "Her Majesty The Queen Of England")
    public void getGlobalSettingsFailedTest() throws Exception {
        given(settingService.getAllItems()).willReturn(null);
        mvc.perform(get("/api/v2/setting")
                .with(csrf().asHeader()))
                .andExpect(status().isNotFound());
    }
	*/

    @Test
    //@WithMockUser(roles = "Her Majesty The Queen Of England")
    public void updateSettingTest() throws Exception {
       given(settingServiceImplementation.updateOrSaveSettings(
				   testSetting)).willReturn(testSetting);
       mvc.perform(put("/api/v2/setting")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonMaker.toJsonString(testSetting)))
                .andExpect(status().isAccepted());
               //.with(csrf().asHeader())

    }
//TODO: See August or Kevin
//    @Test
//    public void updateSettingFailedTest() throws Exception {
//        testSetting = new Setting();
//        given(settingService.saveItem(testSetting)).willThrow(new RuntimeException());
//        mvc.perform(put("/api/v2/setting")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(jsonMaker.toJsonString(testSetting)))
//                .andExpect(status().isInternalServerError());
//    }

    @Test
    //@WithMockUser(roles = "Her Majesty The Queen Of England")
    public void deleteSettingTest() throws Exception {
        mvc.perform(delete("/api/v2/setting/42"))
				.andExpect(status().isNotImplemented());
				//.with(csrf().asHeader()))

    }
}
