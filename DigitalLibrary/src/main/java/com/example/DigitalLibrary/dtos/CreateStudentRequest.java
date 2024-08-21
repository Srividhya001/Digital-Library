package com.example.DigitalLibrary.dtos;

import com.example.DigitalLibrary.entites.Student;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateStudentRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String contact;

    public Student to(){
        return Student.builder()
                .name(name)
                .contact(contact)
                .validity(new Date(System.currentTimeMillis()+31536000000l))
                .build();

    }


}
