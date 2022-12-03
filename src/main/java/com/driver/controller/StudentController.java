package com.driver.controller;

import com.driver.models.Student;
import com.driver.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Add required annotations
@RestController
@RequestMapping("student")
public class StudentController {

    //Add required annotations
    @Autowired
    StudentService studentService;

    @GetMapping("/studentByEmail")
    public ResponseEntity getStudentByEmail(@RequestParam("email") String email){

        Student student = studentService.getDetailsByEmail(email);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    //Add required annotations
    @GetMapping("/studentById")
    public ResponseEntity getStudentById(@RequestParam("id") int id){

        Student student = studentService.getDetailsById(id);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    //Add required annotations
    @PostMapping("")
    public ResponseEntity createStudent(@RequestBody Student student){

        studentService.createStudent(student);

        return new ResponseEntity<>("the student is successfully added to the system", HttpStatus.CREATED);
    }

    //Add required annotations
    @PutMapping("")
    public ResponseEntity updateStudent(@RequestBody Student student){

        studentService.updateStudent(student);

        return new ResponseEntity<>("student is updated", HttpStatus.ACCEPTED);
    }

    //Add required annotations
    @DeleteMapping("")
    public ResponseEntity deleteStudent(@RequestParam("id") int id){

        try {
            studentService.deleteStudent(id);
        }catch (Exception e){
            return new ResponseEntity<>("No student found please check student ID", HttpStatus.BAD_GATEWAY);
        }

        return new ResponseEntity<>("student is deleted", HttpStatus.ACCEPTED);
    }

}
