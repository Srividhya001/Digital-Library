package com.example.DigitalLibrary.service;

import com.example.DigitalLibrary.dtos.CreateStudentRequest;
import com.example.DigitalLibrary.dtos.GetStudentResponse;
import com.example.DigitalLibrary.entites.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    public String createStudent(CreateStudentRequest s);
    public Student getStudentDetails(Long studentId);

    public List<GetStudentResponse> getAllStudentDetails();

    public String updateStudentDetails(CreateStudentRequest student);

    public String deleteStudentDetails(Long studentId);

    public List<GetStudentResponse> getStudentDetailsByName(String name);
}
