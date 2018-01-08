package com.revature.curriculumservice.web;

import com.revature.curriculumservice.domain.Curriculum;
import com.revature.curriculumservice.domain.dto.CurriculumDTO;
import com.revature.curriculumservice.domain.dto.ResponseErrorDTO;
import com.revature.curriculumservice.service.ActivatableObjectDaoService;
import com.revature.curriculumservice.service.CurriculumDaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// @CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v2/curriculum")
@ComponentScan(basePackages="com.revature.curriculumservice.service")
@Api(value = "Curriculum Controller", description = "Operations regarding Curricula")
public class CurriculumCtrl {

	private static final Logger logger = LogManager.getLogger(CurriculumCtrl.class);


	@Autowired
	CurriculumDaoService currService;

	  // CREATE
		// creating new curriculum object from information passed from curriculum data transfer object
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create a Curriculum", response = ResponseEntity.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully created Curriculum information"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot create Curriculum")
	})
	public Object createCurriculum( @RequestBody CurriculumDTO in ) {

		logger.info("Creating Curriculum");
		logger.info("Incoming Curriculum: "+in.toString());
		logger.info("CurrId: "+in.getCurrId());
		int id = in.getCurrId();
		String name = in.getName();
		logger.info("Skills: "+in.getSkills());
		List<Integer> skills = in.getSkills(); // HOW TO GET SKILLS FROM JT? @OneToMany
		boolean core = in.getCore();

		Curriculum out = new Curriculum( id, name, skills, core);
		out.setActive(in.getActive()); // set Active
		logger.info("Curriculum Object: "+ out.toString());
		out = currService.saveItem( out );

		if (out == null) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Curriculum failed to save."), HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Curriculum>(out, HttpStatus.OK);
		}
	}

	  // RETRIEVE
		// retrieve curriculum with given ID
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get a Curriculum given an ID", response = ResponseEntity.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully retrieved Curriculum information"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot retrieve Curriculum information")
	})
	public Object retrieveCurriculum( @PathVariable("id") int ID ) {
		logger.info("Retrieving Curriculum with id "+ ID);

		Curriculum out = currService.getOneItem(ID);
		if (out == null) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("No curriculum found of ID " + ID + "."), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Curriculum>(out, HttpStatus.OK);
		}
	}

	  // UPDATE
		// updating an existing curriculum object with information passed from curriculum data transfer object
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update a Curriculum", response = ResponseEntity.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully updated Curriculum information"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot update Curriculum information")
	})
	public Object updateCurriculum( @RequestBody CurriculumDTO in ) {
		Integer id = in.getCurrId();
		id = (id != null)? in.getCurrId() : 0;
		String name = (in.getName() != null)? in.getName() : "";
		List<Integer> skills = (in.getSkills() != null)? in.getSkills() : new ArrayList<Integer>();
		Boolean core = (in.getCore() != null)? in.getCore() : false;
		
		Curriculum out = new Curriculum( id, name, skills, core );
		out.setActive(in.getActive());
		out = currService.saveItem( out );
		
		if (out == null) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Curriculum failed to save."), HttpStatus.NOT_MODIFIED);
		} else {
			return new ResponseEntity<Curriculum>(out, HttpStatus.OK);
		}
	}
	
	  // DELETE
		// delete curriculum with given ID
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Delete a Curriculum", response = ResponseEntity.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully deleted Curriculum"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot delete Curriculum")
	})
	public Object deleteCurriculum( @PathVariable("id") int ID ) {

		currService.deleteItem(ID);
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}
	
	  // GET ALL
		// retrieve all curricula
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve all Curricula", response = ResponseEntity.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully retrieved all Curricula"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot retrieve Curricula")
	})
	public Object retrieveAllCurricula() {

		List<Curriculum> all = currService.getAllItems();
		if (all == null) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Fetching all curricula failed."), HttpStatus.NOT_FOUND);
		} else if (all.isEmpty()) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("No curricula available."), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity< List<Curriculum> >(all, HttpStatus.OK);
		}
	}

	// GET ALL ACTIVE
	// retrieve all active curricula
	@RequestMapping(value = "/active", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve all active Curricula", response = ResponseEntity.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully retrieved all active Curricula"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot retrieve Curricula")
	})
	public Object retrieveAllActiveCurricula() {

		List<Curriculum> all = currService.getAllActive();
		if (all == null) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Fetching all curricula failed."), HttpStatus.NOT_FOUND);
		} else if (all.isEmpty()) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("No curricula available."), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity< List<Curriculum> >(all, HttpStatus.OK);
		}
	}


	// GET ALL CORE
	// retrieve all core
	@RequestMapping(value = "/core", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve all core Curricula", response = ResponseEntity.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully retrieved all core Curricula"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot retrieve core Curricula")
	})
	public Object retrieveAllCore() {

		List<Curriculum> all = currService.getAllCore();
		if (all == null) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Fetching all curricula failed."), HttpStatus.NOT_FOUND);
		} else if (all.isEmpty()) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("No curricula available."), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity< List<Curriculum> >(all, HttpStatus.OK);
		}
	}

	// GET ALL ACTIVE CORE
	// retrieve all active core
	@RequestMapping(value = "/activeCore", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve all active core Curricula", response = ResponseEntity.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully retrieved all active  core Curricula"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot retrieve active core Curricula")
	})
	public Object retrieveAllActiveCore() {

		List<Curriculum> all = currService.getAllActiveCore();
		if (all == null) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Fetching all curricula failed."), HttpStatus.NOT_FOUND);
		} else if (all.isEmpty()) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("No curricula available."), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity< List<Curriculum> >(all, HttpStatus.OK);
		}
	}

	// GET ALL FOCUS
	// retrieve all focus
	@RequestMapping(value = "/focus", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve all focus Curricula", response = ResponseEntity.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully retrieved all focus Curricula"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot retrieve focus Curricula")
	})
	public Object retrieveAllFocus() {

		List<Curriculum> all = currService.getAllFocus();
		if (all == null) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Fetching all curricula failed."), HttpStatus.NOT_FOUND);
		} else if (all.isEmpty()) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("No curricula available."), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity< List<Curriculum> >(all, HttpStatus.OK);
		}
	}

	// GET ALL ACTIVE FOCUS
	// retrieve all active core
	@RequestMapping(value = "/activeFocus", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve all active focus Curricula", response = ResponseEntity.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully retrieved all active  focus Curricula"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot retrieve active focus Curricula")
	})
	public Object retrieveAllActiveFocus() {

		List<Curriculum> all = currService.getAllActiveFocus();
		if (all == null) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Fetching all curricula failed."), HttpStatus.NOT_FOUND);
		} else if (all.isEmpty()) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("No curricula available."), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity< List<Curriculum> >(all, HttpStatus.OK);
		}
	}
}
