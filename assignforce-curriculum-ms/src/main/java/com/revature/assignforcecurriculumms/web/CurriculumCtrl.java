package com.revature.assignforcecurriculumms.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/curriculum")
public class CurriculumCtrl {

    @RequestMapping("/ctrl")
    public String ctrlMsg(){
        return "In Curriculum Controller";
    }
}
