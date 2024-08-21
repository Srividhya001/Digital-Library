package com.example.DigitalLibrary.service.serviceImpl;

import com.example.DigitalLibrary.dtos.CreateStudentRequest;
import com.example.DigitalLibrary.dtos.GetStudentResponse;
import com.example.DigitalLibrary.entites.Student;
import com.example.DigitalLibrary.repository.StudentRepository;
import com.example.DigitalLibrary.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

//this annotation used to tell spring to include this impl when component scan and inject when needed
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public String createStudent(CreateStudentRequest studentRequest) {
            Student studEntity= studentRequest.to();
         studentRepository.save(studEntity);
         return "success";
    }

    @Override
    public Student getStudentDetails(Long studentId){
        Student studentEntity=studentRepository.findById(studentId).get();
        //GetStudentResponse getStudentResponse=new GetStudentResponse();
       // return getStudentResponse.to(studentEntity);
        return studentEntity;
    }

    @Override
    public List<GetStudentResponse> getAllStudentDetails(){
        List<GetStudentResponse> allStudentsList=new ArrayList<>();
        for(Student studentEntity:studentRepository.findAll()){
            GetStudentResponse getStudentResponse=new GetStudentResponse();
            allStudentsList.add(getStudentResponse.to(studentEntity));

        }
        return allStudentsList;

    }

    @Override
    public List<GetStudentResponse> getStudentDetailsByName(String name){
        List<GetStudentResponse> studentList=new ArrayList<>();
        List<Student> studEntity=studentRepository.findByName(name);
        for(Student s:studEntity){
            studentList.add(new GetStudentResponse( ).to(s));
        }
        return studentList;


    }

    @Override

    public String updateStudentDetails(CreateStudentRequest student){
        Student s=student.to();
        studentRepository.save(s);
        return "Success";

    }

    @Override

    public String deleteStudentDetails(Long studentId){
        studentRepository.deleteById(studentId);
        return "Success";
    }


}
