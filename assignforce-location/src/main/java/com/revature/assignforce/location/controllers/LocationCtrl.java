package com.revature.assignforce.location.controllers;

import java.util.List;

import com.revature.assignforce.location.DTOs.LocationDTO;
import com.revature.assignforce.location.DTOs.ResponseErrorDTO;
import com.revature.assignforce.location.model.Building;
import com.revature.assignforce.location.model.Location;
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
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v2/location")
@ComponentScan(basePackages = "com.revature.assignforce.service")
@Api(value = "Location Controller", description = "Operations regarding Locations")
public class LocationCtrl {

    @Autowired
    ActivatableObjectDaoService<Location, Integer> locationService;

    // CREATE
    // creating new location object from information passed from location data
    // transfer object
    //@PreAuthorize("hasPermission('', 'manager')")
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a Location", response = ResponseEntity.class)
    @ApiResponses({
            @ApiResponse(code=200, message ="Successfully created Location information"),
            @ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
            @ApiResponse(code=500, message ="Cannot create Location")
    })
    public Object createLocation(@RequestBody LocationDTO in) {

        int ID = in.getID();
        String name = in.getName();
        String city = in.getCity();
        String state = in.getState();
        List<Building> buildings = in.getBuildings();

        // buildings, Boolean active
        Location out = new Location(ID, name, city, state, buildings, true);
        out = locationService.saveItem(out);

        if (out == null) {
            return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Location failed to save."),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<Location>(out, HttpStatus.OK);
        }
    }

    // RETRIEVE
    // retrieve location with given ID
    //@PreAuthorize("hasPermission('', 'basic')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Get a Location given an ID", response = ResponseEntity.class)
    @ApiResponses({
            @ApiResponse(code=200, message ="Successfully retrieved Location information"),
            @ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
            @ApiResponse(code=500, message ="Cannot retrieve Location information")
    })
    public Object retrieveLocation(@PathVariable("id") int ID) {

        Location out = locationService.getOneItem(ID);
        if (out == null) {
            return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("No location found of ID " + ID + "."),
                    HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Location>(out, HttpStatus.OK);
        }
    }

    // UPDATE
    // updating an existing location object with information passed from
    // location data transfer object
    //@PreAuthorize("hasPermission('', 'manager')")
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update a Location", response = ResponseEntity.class)
    @ApiResponses({
            @ApiResponse(code=200, message ="Successfully updated Location information"),
            @ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
            @ApiResponse(code=500, message ="Cannot update Location information")
    })
    public Object updateLocation(@RequestBody LocationDTO in) {

        int ID = in.getID();
        String name = in.getName();
        String city = in.getCity();
        String state = in.getState();
        List<Building> buildings = in.getBuildings();
        Boolean active = in.getActive();

        Location out = new Location(ID, name, city, state, buildings, active);
        out = locationService.saveItem(out);

        if (out == null) {
            return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Location failed to update."),
                    HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity<Location>(out, HttpStatus.OK);
        }
    }

    // DELETE
    // delete location with given ID
    // @PreAuthorize("hasPermission('', 'manager')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Delete a Location", response = ResponseEntity.class)
    @ApiResponses({
            @ApiResponse(code=200, message ="Successfully deleted Location"),
            @ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
            @ApiResponse(code=500, message ="Cannot delete Location")
    })
    public Object deleteLocation(@PathVariable("id") int ID) {

        locationService.deleteItem(ID);
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }

    // GET ALL
    // retrieve all locations
    // @PreAuthorize("hasPermission('', 'basic')")
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve all Locations", response = ResponseEntity.class)
    @ApiResponses({
            @ApiResponse(code=200, message ="Successfully retrieved all Locations"),
            @ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
            @ApiResponse(code=500, message ="Cannot retrieve Locations")
    })
    public Object retrieveAllLocations() {

        List<Location> all = locationService.getAllItems();
        if (all == null) {
            return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Fetching all locations failed."),
                    HttpStatus.NOT_FOUND);
        } else if (all.isEmpty()) {
            return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("No locations available."),
                    HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Location>>(all, HttpStatus.OK);
        }
    }

}

