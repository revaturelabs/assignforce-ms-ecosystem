package com.revature.assignforcebatchms.web;


import java.sql.Timestamp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import com.revature.assignforcebatchms.domain.*;
import com.revature.assignforcebatchms.domain.dto.ResponseErrorDTO;
import com.revature.assignforcebatchms.service.ActivatableObjectDaoService;
import com.revature.assignforcebatchms.service.BatchDaoService;
import com.revature.assignforcebatchms.service.DaoService;

import com.revature.assignforcebatchms.service.BatchLocationDaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.access.prepost.PostAuthorize;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.oauth2.client.OAuth2ClientContext;
//
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/*
import com.revature.assignforce.domain.dto.BatchDTO;
import com.revature.assignforce.domain.dto.ResponseErrorDTO;
import com.revature.assignforce.service.DaoService;*/

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v2/batch")
@ComponentScan(basePackages = "com.revature.assignforce.service")
@Api(value = "Batch Controller", description = "CRUD with Batches")
public class BatchCtrl {
	private final static Log logger = LogFactory.getLog(BatchCtrl.class);

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	DaoService<BatchLocation, Integer> batchLocationService;

	@Autowired
	DaoService<Batch, Integer> batchService;

/*
	@Autowired
	DaoService<Curriculum, Integer> currService;

	@Autowired
	DaoService<Location, Integer> locationService;

	@Autowired
	DaoService<Room, Integer> roomService;

	@Autowired
	DaoService<Trainer, Integer> trainerService;

	@Autowired
	DaoService<Unavailable, Integer> unavailableService;*/




	// CREATE
	// creating new batch object from information passed from batch data
//	@PreAuthorize("hasPermission('', 'manager')")
	@ApiOperation(value = "Create a branch", response = BatchDaoService.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully Created a Batch"),
			@ApiResponse(code=400, message ="Bad Request, BatchDTO"),
			@ApiResponse(code=500, message ="Cannot retrieve batch")
	})
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	public Object createBatch(@RequestBody Batch in) {
		System.out.println("Hey, I got something!");
		Batch batch = new Batch();
		batch.setCotrainer(in.getCotrainer());
		batch.setCurriculum(in.getCurriculum());
		batch.setTrainer(in.getTrainer());
		batch.setEndDate(in.getEndDate());
		batch.setFocus(in.getFocus());
		batch.setName(in.getName());
		batch.setStartDate(in.getStartDate());
		batch.setSkills(in.getSkills());
		Integer locationID = batchLocationService.saveItem(in.getBatchLocation()).getId();
		batch.setBatchLocation(batchLocationService.getOneItem(locationID));
		System.out.println(batchLocationService.getOneItem(locationID));
		System.out.println("creating batch: " + batch);
		batchService.saveItem(batch);
		if (batch == null) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Batch failed to save."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Batch>(batch, HttpStatus.OK);
		}
	}

//	@PreAuthorize("hasPermission('', 'manager')")
	@ApiOperation(value = "Retrieve a batch", response = BatchDaoService.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully retrieved a Batch"),
			@ApiResponse(code=400, message ="Bad Request, BatchDTO"),
			@ApiResponse(code=500, message ="Cannot create batch")
	})
	// RETRIEVE
	// retrieve batch with given ID
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object retrieveBatch(@PathVariable("id") Integer ID) {

		Batch out = batchService.getOneItem(ID);
		if (out == null) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("No batch found of ID " + ID + "."),
					HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Batch>(out, HttpStatus.OK);
		}
	}

	// DELETE
	// delete batch with given ID
//	@PreAuthorize("hasPermission('', 'manager')")
	@ApiOperation(value = "Delete a batch", response = BatchDaoService.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully Deleted a Batch"),
			@ApiResponse(code=400, message ="Bad Request, ID"),
			@ApiResponse(code=500, message ="Cannot delete batch")
	})
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	public Object deleteBatch(@PathVariable("id") Integer ID) {
		Batch batch = batchService.getOneItem(ID);
/*		Timestamp startDate = batch.getStartDate();
		Timestamp endDate = batch.getEndDate();
		Trainer trainer = batch.getTrainer();
		BatchLocation batchLocation = batch.getBatchLocation();
		Integer roomId = batchLocation.getRoomId();
		Room room;
		if (roomId != null) {
			room = roomService.getOneItem(roomId);
		} else {
			room = null;
		}*/

		// Remove unavailabilities from trainer and room
//		removeUnavailabilities(trainer, room, startDate, endDate);
		
		Batch b = batchService.getOneItem(ID);
		b.setBatchLocation(null);
		batchService.saveItem(b);
		
		System.out.println("deleting batch: " + batchService.getOneItem(ID));
		batchService.deleteItem(ID);
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}

	
	// GET ALL
	// retrieve all batches
//	@PreAuthorize("hasPermission('', 'Trainers')")


//	@PreAuthorize("hasPermission('', 'basic')")

	@ApiOperation(value = "Retrieve all batches", response = BatchDaoService.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully retrieved all batches"),
			@ApiResponse(code=400, message ="Bad Request"),
			@ApiResponse(code=500, message ="Cannot retrieve all batches")
	})

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object retrieveAllBatches() {

		List<Batch> all = batchService.getAllItems();
		if (all == null) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Fetching all batches failed."),
					HttpStatus.NOT_FOUND);
		} else if (all.isEmpty()) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("No batches available."),
					HttpStatus.NOT_FOUND);
					} else {
			return new ResponseEntity<List<Batch>>(all, HttpStatus.OK);
		}
	}

	// UPDATE
//	@PreAuthorize("hasPermission('', 'manager')")
	@ApiOperation(value = "Update a batch", response = BatchDaoService.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully updated a batch"),
			@ApiResponse(code=400, message ="Bad Request, BATCHDTO"),
			@ApiResponse(code=500, message ="Cannot update batch")
	})
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional
	public Object updateBatch(@RequestBody Batch in) {

		System.out.println("updating Batch: " + batchService.getOneItem(in.getID()));
		// try to get batch from database
		Batch b = batchService.getOneItem(in.getID());

		if (b == null) {
			return new ResponseEntity<ResponseErrorDTO>(
					new ResponseErrorDTO("No batch with id '" + in.getID() + "' could be found to update"),
					HttpStatus.NOT_FOUND);
		}

		b.setName(in.getName());
		b.setSkills(in.getSkills());
		b.setStartDate(in.getStartDate());
		b.setEndDate(in.getEndDate());
		b.setTrainer(in.getTrainer());
		b.setCotrainer(in.getCotrainer());
		
		if (in.getCurriculum() < 1) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Curriculum cannot be null"),
					HttpStatus.BAD_REQUEST);
		}
		
		b.setCurriculum(in.getCurriculum());
		b.setFocus(in.getFocus());

		BatchLocation bl = b.getBatchLocation();
		b.setBatchLocation(bl);

		System.out.println("changing to: " + in);
		
		try {
			batchService.saveItem(b);
		} catch (Exception ex) {
			logger.warn(ex);
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO(ex.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Batch>(b, HttpStatus.OK);
	}
	
}
