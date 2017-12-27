package com.revature.skillservice.controller;

import com.revature.skillservice.domain.Skill;
//import com.revature.assignforce.domain.dto.SkillDTO;
//import com.revature.skillservice.domain.dto.ResponseErrorDTO;
import com.revature.skillservice.service.ActivatableObjectDaoService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Zach Nelson on 2/9/2017.
 */
@RestController
@RequestMapping("/api/v2/skill")
@ComponentScan(basePackages="com.revature.assignforce.service")
//@Api(value = "Skill Controller", description = "Operations regarding Skillz(such as the ability to do a Backflip)")
public class SkillCtrl {

    @Autowired
    ActivatableObjectDaoService<Skill, Integer> skillService;

    // CREATE
    // creating new curriculum object from information passed from curriculum data transfer object
/*    @PreAuthorize("hasPermission('', 'basic')")
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a skill", response = ResponseEntity.class)
    @ApiResponses({
            @ApiResponse(code=200, message ="Successfully created Skill information"),
            @ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
            @ApiResponse(code=500, message ="Cannot create Skill")
    })
    public Object createSkill( @RequestBody Skill in ) {

        int ID = in.getSkillId();
        String name = in.getName();

        Skill out = new Skill( ID, name );
        out = skillService.saveItem( out );

        if (out == null) {
            return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Skill failed to save."), HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<Skill>(out, HttpStatus.OK);
        }
    }*/

    // RETRIEVE
    // retrieve skill with given ID
  /* @PreAuthorize("hasPermission('', 'basic')")*/
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
/*    @ApiOperation(value = "Get a skill of a given ID", response = ResponseEntity.class)
    @ApiResponses({
            @ApiResponse(code=200, message ="Successfully received Skill information"),
            @ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
            @ApiResponse(code=500, message ="Cannot retrieve Skill")
    })*/
    public Object retrieveSkill( @PathVariable("id") int ID ) {

        Skill out = skillService.getOneItem(ID);
       // if (out == null) {
        //    return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("No skill found of ID " + ID + "."), HttpStatus.NOT_FOUND);
      //  } else {
            return new ResponseEntity<Skill>(out, HttpStatus.OK);
       // }
    }

    // UPDATE
    // updating an existing skill object with information passed from skill data transfer object
/*    @PreAuthorize("hasPermission('', 'basic')")
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update a skill", response = ResponseEntity.class)
    @ApiResponses({
            @ApiResponse(code=200, message ="Successfully updated Skill information"),
            @ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
            @ApiResponse(code=500, message ="Cannot update Skill")
    })
    public Object updateSkill( @RequestBody SkillDTO in ) {

        int ID = in.getSkillId();
        String name = in.getName();

        Skill out = new Skill( ID, name );
        // may need to set outs active to true
        out = skillService.saveItem( out );

        if (out == null) {
            return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Skill failed to save."), HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity<Skill>(out, HttpStatus.OK);
        }
    }

    // DELETE
    // delete skill with given ID
    @PreAuthorize("hasPermission('', 'basic')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Delete a skill", response = ResponseEntity.class)
    @ApiResponses({
            @ApiResponse(code=200, message ="Successfully deleted Skill"),
            @ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
            @ApiResponse(code=500, message ="Cannot delete Skill")
    })
    public Object deleteSkill( @PathVariable("id") int ID ) {

        skillService.deleteItem(ID);
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }

    // GET ALL
    // retrieve all skills
    @PreAuthorize("hasPermission('', 'basic')")
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieve all Skills", response = ResponseEntity.class)
    @ApiResponses({
            @ApiResponse(code=200, message ="Successfully retrieved all SKills"),
            @ApiResponse(code=400, message ="Bad Request, the information recieved maybe invalid"),
            @ApiResponse(code=500, message ="Cannot retrieve Skill")
    })
    public Object retrieveAllSkills() {

        List<Skill> all = skillService.getAllItems();
        if (all == null) {
            return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("Fetching all skills failed."), HttpStatus.NOT_FOUND);
        } else if (all.isEmpty()) {
            return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO("No skills available."), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity< List<Skill> >(all, HttpStatus.OK);
        }
    }*/
}
