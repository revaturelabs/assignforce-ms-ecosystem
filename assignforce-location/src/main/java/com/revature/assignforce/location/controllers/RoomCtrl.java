package com.revature.assignforce.location.controllers;

import java.util.List;

import com.revature.assignforce.location.DTOs.ResponseErrorDTO;
import com.revature.assignforce.location.DTOs.RoomDTO;
import com.revature.assignforce.location.model.Room;
import com.revature.assignforce.location.model.Unavailable;
import com.revature.assignforce.location.services.ActivatableObjectDaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/room")
@ComponentScan(basePackages="com.revature.assignforce.service")
@Api(value = "Room Controller", description = "Operations regarding rooms")
public class RoomCtrl {

    @Autowired
    ActivatableObjectDaoService<Room, Integer> roomService;

    // CREATE
    // creating new room object from information passed from room data transfer object
    // @PreAuthorize("hasPermission('', 'manager')")
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a Room", response = ResponseEntity.class)
    @ApiResponses({
            @ApiResponse(code=200, message ="Successfully created Room information"),
            @ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
            @ApiResponse(code=500, message ="Cannot create Room")
    })
    public Object createRoom( @RequestBody RoomDTO in ) {

        int ID = in.getRoomID();
        String name = in.getRoomName();
        int building = in.getBuilding();

        List<Unavailable> unavailabilities = in.getUnavailabilities();

        Room out = new Room( ID, name, building, unavailabilities );
        out = roomService.saveItem( out );

        if (out == null) {
            return new ResponseEntity<ResponseErrorDTO>( new ResponseErrorDTO("Room failed to save."), HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<Room>(out, HttpStatus.OK);
        }
    }

    // RETRIEVE
    // retrieve room with given ID
    // @PreAuthorize("hasPermission('', 'basic')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get a Room of a given ID", response = ResponseEntity.class)
    @ApiResponses({
            @ApiResponse(code=200, message ="Successfully retrieved Room information"),
            @ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
            @ApiResponse(code=500, message ="Cannot retrieve Room")
    })
    public Object retrieveRoom( @PathVariable("id") int ID ) {
        Room out = roomService.getOneItem(ID);
        if (out == null) {
            return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("No room found of ID " + ID + "."), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Room>(out, HttpStatus.OK);
        }
    }

    // UPDATE
    // updating an existing room object with information passed from room data transfer object
    // @PreAuthorize("hasPermission('', 'manager')")
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update a Room", response = ResponseEntity.class)
    @ApiResponses({
            @ApiResponse(code=200, message ="Successfully updated Room information"),
            @ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
            @ApiResponse(code=500, message ="Cannot update Room")
    })
    public Object updateRoom( @RequestBody RoomDTO in ) {

        int ID = in.getRoomID();
        String name = in.getRoomName();
        int building = in.getBuilding();

        List<Unavailable> unavailabilities = in.getUnavailabilities();
        Boolean active = in.getActive();
        Room out = new Room( ID, name, building, unavailabilities, active);
        out = roomService.saveItem( out );

        if (out == null) {
            return new ResponseEntity<ResponseErrorDTO>( new ResponseErrorDTO("Room failed to update."), HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity<Room>(out, HttpStatus.OK);
        }
    }

    // DELETE
    // delete room with given ID
    // @PreAuthorize("hasPermission('', 'manager')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Delete a Room", response = ResponseEntity.class)
    @ApiResponses({
            @ApiResponse(code=200, message ="Successfully deleted Room"),
            @ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
            @ApiResponse(code=500, message ="Cannot delete Room")
    })
    public Object deleteRoom( @PathVariable("id") int ID ) {
        roomService.deleteItem(ID);
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }

    // GET ALL
    // retrieve all rooms
    // @PreAuthorize("hasPermission('', 'basic')")
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve All Rooms", response = ResponseEntity.class)
    @ApiResponses({
            @ApiResponse(code=200, message ="Successfully retrieved all Rooms"),
            @ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
            @ApiResponse(code=500, message ="Cannot retrieve all Rooms")
    })
    public Object retrieveAllRooms() {
        List<Room> all = roomService.getAllItems();

        if (all == null) {
            return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Fetching all rooms failed."), HttpStatus.NOT_FOUND);
        } else if (all.isEmpty()) {
            return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("No rooms available."), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity< List<Room> >(all, HttpStatus.OK);
        }
    }
}
