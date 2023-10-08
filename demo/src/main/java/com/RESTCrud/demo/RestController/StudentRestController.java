package com.RESTCrud.demo.RestController;

import com.RESTCrud.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    @GetMapping("/student")
    public List<Student> getStudent(){
        List<Student> theStudent=new ArrayList<>();
        Student name=new Student("Arifur","Rahman");
        theStudent.add(name);
        theStudent.add(new Student("zarifur","Rahman"));
        theStudent.add(new Student("SArifur","Rahman"));
        theStudent.add(new Student("Shahid","Afridi"));
        return theStudent;
    }

}
