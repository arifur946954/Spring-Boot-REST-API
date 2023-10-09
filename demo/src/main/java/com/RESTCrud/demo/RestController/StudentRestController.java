package com.RESTCrud.demo.RestController;

import com.RESTCrud.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

   private List<Student> theStudents;
   //define post ccnstructure to load data at once
    @PostConstruct
    public void loadData(){
        theStudents=new ArrayList<>();
        Student name=new Student("Arifur","Rahman");
        theStudents.add(name);
        theStudents.add(new Student("zarifur","Rahman"));
        theStudents.add(new Student("SArifur","Rahman"));
        theStudents.add(new Student("Shahid","Afridi"));

    }



    @GetMapping("/student")
    public List<Student> getStudents(){
        return theStudents;
    }
    @GetMapping("/student/{studentID}")
    public Student getStudent(@PathVariable int studentID){
        if (studentID>=theStudents.size() || studentID<0){
            throw new StudentNotFoundException("Studeent not found "+studentID);
        }
        return theStudents.get(studentID);

    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        //create student  ErrorResponse
        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessege(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        //create student  ErrorResponse
        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessege(exc.getMessage());//you can change the error messege anything you want
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }


}
