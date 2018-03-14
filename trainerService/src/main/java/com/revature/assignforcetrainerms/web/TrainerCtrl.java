package com.revature.assignforcetrainerms.web;

import java.util.List;


import com.revature.assignforcetrainerms.domain.Certification;
import com.revature.assignforcetrainerms.domain.ResponseErrorDTO;
import com.revature.assignforcetrainerms.service.TrainerDaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revature.assignforcetrainerms.domain.Trainer;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v2/trainer")
@Api(value = "Trainer Controller", description = "Operations regarding trainers")
//@EnableCircuitBreaker
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableAspectJAutoProxy
public class TrainerCtrl {

	@Autowired
	TrainerDaoService trainerService;

	  // CREATE
		// creating new trainer object from information passed from trainer data transfer object
//	  @PreAuthorize("hasPermission('', 'manager')")

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create a trainer", response = ResponseEntity.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully received Trainer information"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot create Trainer")
	})

	public Object createTrainer( @RequestBody Trainer in ) {

		String firstName = in.getFirstName();
		String lastName = in.getLastName();
		String resume = in.getResume();

		List<Integer> skills = in.getSkills();
		List<Certification> certifications = in.getCertifications();
//		List<Unavailable> unavailabilities = in.getUnavailabilities();

		Trainer out = new Trainer(firstName, lastName, resume, skills, certifications );

		out = trainerService.saveItem( out );

		if (out == null) {
			return new ResponseEntity<ResponseErrorDTO>( new ResponseErrorDTO("Trainer failed to save."), HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Trainer>(out, HttpStatus.OK);
		}
	}

	  // RETRIEVE
		// retrieve trainer with given ID
//	@PreAuthorize("hasPermission('', 'basic')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get a trainer bsed on ID", response = ResponseEntity.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully received Trainer information"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot retrieve Trainer")
	})
  
	public Object retrieveTrainer( @PathVariable("id") String ID ) {

		Trainer out = trainerService.getOneItem(ID);

		if (out == null) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("No trainer found of ID " + ID + "."), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Trainer>(out, HttpStatus.OK);
		}
	}

	//RETRIEVE
	//retrieve trainer with given fistName, lastName
	//@PreAuthorize("hasPermission('', 'basic')")
	@RequestMapping(value = "/{firstName}/{lastName}", method = RequestMethod.GET, produces =  MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get a trainer based on First and Last name", response = ResponseEntity.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully received Trainer information"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot retrieve Trainer")
	})
	public Object retrieveTrainer (@PathVariable("firstName") String fName, @PathVariable("lastName") String lname){
		Trainer out = trainerService.findByFirstNameAndLastName(fName, lname);

		if (out == null) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("No trainer found of name " + fName +" " + lname + "."), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Trainer>(out, HttpStatus.OK);
		}
	}

	  // UPDATE
		// updating an existing trainer object with information passed from trainer data transfer object
	//@PreAuthorize("hasPermission(#in, 'trainer_profile') or hasPermission('', 'manager')")
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update a trainer", response = ResponseEntity.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully updated Trainer information"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot update Trainer")
	})
  
	public Object updateTrainer( @RequestBody Trainer in ) {
		String ID = in.getTrainerId();

		String firstName = in.getFirstName();
		String lastName = in.getLastName();
		String resume = in.getResume();

		List<Integer> skills = in.getSkills();
//		List<Unavailable> unavailabilities = in.getUnavailabilities();
		List<Certification> certifications = in.getCertifications();

//		Trainer out = new Trainer( ID, firstName, lastName, resume, unavailabilities, skills, certifications);
		Trainer out = new Trainer();
		out.setTrainerId(ID);
		out.setFirstName(firstName);
		out.setLastName(lastName);
		out.setResume(resume);
		out.setSkills(skills);
		out.setCertifications(certifications);
		out.setActive(in.getActive());
		out = trainerService.saveItem( out );

		if (out == null) {
			return new ResponseEntity<ResponseErrorDTO>( new ResponseErrorDTO("Trainer failed to update."), HttpStatus.NOT_MODIFIED);
		} else {
			return new ResponseEntity<Trainer>(out, HttpStatus.OK);
		}
	}

	  // DELETE
		// delete trainer with given ID
	  //@PreAuthorize("hasPermission('', 'manager')")

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Delete a trainer of a given ID", response = ResponseEntity.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully deleted Trainer information"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot delete Trainer")
	})
	public Object deleteTrainer( @PathVariable("id") String ID ) {
		trainerService.deleteItem(ID);
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}

	  // GET ALL
		// retrieve all trainers
	 // @PreAuthorize("hasPermission('', 'basic')")
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Retrieve all trainers", response = ResponseEntity.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully retrieved all Trainers information"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot retrieve Trainers")
	})
	public Object retrieveAllTrainers() {

		List<Trainer> all = trainerService.getAllItems();
		if (all == null) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Fetching all trainers failed."), HttpStatus.NOT_FOUND);
		} else if (all.isEmpty()) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("No trainers available."), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity< List<Trainer> >(all, HttpStatus.OK);
		}
	}

}
