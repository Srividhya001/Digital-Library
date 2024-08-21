package com.example.DigitalLibrary.controller;

import com.example.DigitalLibrary.dtos.CreateStudentRequest;
import com.example.DigitalLibrary.dtos.GetStudentResponse;
import com.example.DigitalLibrary.entites.Student;
import com.example.DigitalLibrary.service.StudentService;
import com.example.DigitalLibrary.service.serviceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")

public class StudentController {

    @Autowired
            /*  Field Injection: For field injection, Spring uses reflection to inject dependencies directly into the field.
Spring checks the type of the studentService field (StudentService).
It searches the ApplicationContext for a bean of type StudentService. Since StudentServiceImpl implements StudentService
 and is annotated with @Service, it is found.
Spring injects the StudentServiceImpl bean into the studentService field.
*/
    StudentService studentService ;


    @PostMapping("/createStudent")
    public String createStudentDetails(@RequestBody CreateStudentRequest studentRequest){
        studentService.createStudent(studentRequest);
        return "Success";
    }

    @GetMapping("/getStudent")
    public Student getStudentDetails(@RequestParam Long studentId){
        System.out.println("Get hit");
        return studentService.getStudentDetails(studentId);
    }

    @GetMapping("/getAllStudent/")
    public List<GetStudentResponse> getAllStudentDetails(){
        return studentService.getAllStudentDetails();
    }

    @PutMapping("/")
    public String updateStudentDetails(@RequestBody CreateStudentRequest student){
        studentService.updateStudentDetails(student);
        return "Success";
    }

    @DeleteMapping("/{studentId}")
    public String deleteStudentDetails(@PathVariable ("studentId")Long studentId){
        studentService.deleteStudentDetails(studentId);
        return "Success";
    }

    @GetMapping("/getStudentByName/{name}")
    public List<GetStudentResponse> getStudentByName(@PathVariable String name){
        return studentService.getStudentDetailsByName(name);
    }




}
