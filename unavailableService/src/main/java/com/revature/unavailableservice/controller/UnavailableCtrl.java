package com.revature.unavailableservice.controller;

import com.revature.unavailableservice.domain.ResponseErrorDTO;
import com.revature.unavailableservice.domain.UnavailabilityRoom;

import com.revature.unavailableservice.domain.UnavailabilityTrainer;
import com.revature.unavailableservice.domain.Unavailable;
import com.revature.unavailableservice.service.DaoService;

import com.revature.unavailableservice.service.UnavailabilityRoomService;
import com.revature.unavailableservice.service.UnavailabilityTrainerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Nick Edwards on 3/2/2017.
 */

//@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v2/unavailable")
@ComponentScan(basePackages="com.revature.assignforce.service")
@Api(value = "Unavailable Controller", description = "Operations regarding unavailable data")
public class UnavailableCtrl {

	@Autowired
	DaoService<Unavailable, Integer> unavailableService;

	@Autowired
	UnavailabilityTrainerService unavailableTrainerService;

	@Autowired
	UnavailabilityRoomService unavailableRoomService;

	// CREATE
	// creating new room unavailabilities
//	@PreAuthorize("hasPermission('', 'basic')")
	@RequestMapping(value="/createRoomUnavailability",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create room Unavailable ", response = UnavailabilityRoom.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully received Unavailable information"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot create Unavailable")
	})
	public Object createRoomUnavailability( @RequestBody UnavailabilityRoom in ) {
		unavailableRoomService.saveItem(in);
		int ID = in.getId();
		int roomId = in.getRoomId();
		Timestamp startDate = in.getStartDate();
		Timestamp endDate = in.getEndDate();

		UnavailabilityRoom out = new UnavailabilityRoom( ID, roomId, startDate, endDate );
		out = unavailableRoomService.saveItem( out );

		if (out == null) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Unavailability failed to save."), HttpStatus.NOT_IMPLEMENTED);
		} else {
			return new ResponseEntity<UnavailabilityRoom>(in, HttpStatus.OK);
		}
	}

	// creating new trainer unavailabilities
//	@PreAuthorize("hasPermission('', 'basic')")
	@RequestMapping(value="/createTrainerUnavailability",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create trainer Unavailable ", response = UnavailabilityTrainer.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully received Unavailable information"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot create Unavailable")
	})
	public Object createTrainerUnavailability( @RequestBody UnavailabilityTrainer in ) {
		unavailableTrainerService.saveItem(in);
		int ID = in.getId();
		String trainerId = in.getTrainerId();
		Timestamp startDate = in.getStartDate();
		Timestamp endDate = in.getEndDate();

		UnavailabilityTrainer out = new UnavailabilityTrainer( ID, trainerId, startDate, endDate );
		out = unavailableTrainerService.saveItem( out );

		if (out == null) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Unavailability failed to save."), HttpStatus.NOT_IMPLEMENTED);
		} else {
			return new ResponseEntity<UnavailabilityTrainer>(in, HttpStatus.OK);
		}
	}
	// RETRIEVE
	// retrieve trainer unavailability with given ID
//	@PreAuthorize("hasPermission('', 'basic')")
	@RequestMapping(value = "/trainer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get a list of trainer Unavailables with a given ID", response = UnavailabilityTrainer.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully received Unavailable information"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot retrieve Unavailable")
	})
	public Object retrieveUnavailabilityTrainers( @PathVariable("id") String ID ) {
		List<UnavailabilityTrainer> out = unavailableTrainerService.findByTrainerId(ID);
		if (out == null) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("No unavailability found of ID " + ID + "."), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<UnavailabilityTrainer>>(out, HttpStatus.OK);
		}
	}

	// retrieve room unavailability with given ID
//	@PreAuthorize("hasPermission('', 'basic')")
	@RequestMapping(value = "/room/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Get a list of room Unavailables with a given ID", response = UnavailabilityRoom.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully received Unavailable information"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot retrieve Unavailable")
	})
	public Object retrieveUnavailabilitiesRooms( @PathVariable("id") int ID ) {
		List<UnavailabilityRoom> out = unavailableRoomService.findByRoomId(ID);
		if (out == null) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("No unavailability found of ID " + ID + "."), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<UnavailabilityRoom>>(out, HttpStatus.OK);
		}
	}

	// Update
	// updating new room unavailabilities
//	@PreAuthorize("hasPermission('', 'basic')")
	@RequestMapping(value="/updateRoomUnavailability", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "update room Unavailable ", response = UnavailabilityRoom.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully received Unavailable information"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot create Unavailable")
	})
	public Object updateRoomUnavailability( @RequestBody UnavailabilityRoom in ) {
		unavailableRoomService.deleteItem(in.getId());
		int ID = in.getId();
		int roomId = in.getRoomId();
		Timestamp startDate = in.getStartDate();
		Timestamp endDate = in.getEndDate();
		UnavailabilityRoom out = new UnavailabilityRoom(ID, roomId, startDate, endDate );
		out = unavailableRoomService.saveItem( out );

		if (out == null) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Unavailability failed to save."), HttpStatus.NOT_IMPLEMENTED);
		} else {
			return new ResponseEntity<UnavailabilityRoom>(in, HttpStatus.OK);
		}
	}

	// updating new trainer unavailabilities
//	@PreAuthorize("hasPermission('', 'basic')")
	@RequestMapping(value="/updateTrainerUnavailability", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "update trainer Unavailable ", response = UnavailabilityTrainer.class)
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully received Unavailable information"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot create Unavailable")
	})
	public Object updateTrainerUnavailability( @RequestBody UnavailabilityTrainer in ) {
		unavailableTrainerService.deleteItem(in.getId());
		int ID = in.getId();
		String trainerId = in.getTrainerId();
		Timestamp startDate = in.getStartDate();
		Timestamp endDate = in.getEndDate();
		UnavailabilityTrainer out = new UnavailabilityTrainer( ID, trainerId, startDate, endDate );
		out = unavailableTrainerService.saveItem( out );

		if (out == null) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Unavailability failed to save."), HttpStatus.NOT_IMPLEMENTED);
		} else {
			return new ResponseEntity<UnavailabilityTrainer>(in, HttpStatus.OK);
		}
	}

	@RequestMapping(value="/deleteTrainerUnavailability/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "delete a trainer Unavailable ")
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully received Unavailable information"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot create Unavailable")
	})
	public Object deleteTrainerUnavailability( @PathVariable("id") int id ) {
		unavailableTrainerService.deleteItem(id);
		UnavailabilityTrainer out = unavailableTrainerService.getOneItem(id);

		if (out != null) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Unavailability failed to save."), HttpStatus.NOT_IMPLEMENTED);
		} else {
			return new ResponseEntity<UnavailabilityTrainer>(out, HttpStatus.OK);
		}
	}

	@RequestMapping(value="/deleteRoomUnavailability/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "delete a room Unavailable ")
	@ApiResponses({
			@ApiResponse(code=200, message ="Successfully received Unavailable information"),
			@ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
			@ApiResponse(code=500, message ="Cannot create Unavailable")
	})
	public Object deleteRoomUnavailability( @PathVariable("id") int id ) {
		unavailableRoomService.deleteItem(id);
		UnavailabilityRoom out = unavailableRoomService.getOneItem(id);

		if (out != null) {
			return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Unavailability failed to save."), HttpStatus.NOT_IMPLEMENTED);
		} else {
			return new ResponseEntity<UnavailabilityRoom>(out, HttpStatus.OK);
		}
	}

}
