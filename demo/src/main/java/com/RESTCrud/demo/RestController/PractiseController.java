package com.RESTCrud.demo.RestController;

import com.RESTCrud.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")

public class PractiseController {
    private List<Student> theTeachers;
    @PostConstruct
    public void loadData(){
        theTeachers=new ArrayList<>();
        theTeachers.add(new Student("Akidul","Islam"));
        theTeachers.add(new Student("Juwl","Iqbal"));
        theTeachers.add(new Student("ismont","Ara"));
        theTeachers.add(new Student("Don","Mafia"));
    }




    @GetMapping("/teacher")
    public List<Student>  getTeachers(){


        return theTeachers;
    }

    @GetMapping("/teacher/{teacherId}")
    public Student getTeacherByID(@PathVariable int teacherId){
        return theTeachers.get(teacherId);


    }
}
