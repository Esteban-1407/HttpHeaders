package com.example.demo.mapping.mapper;

import com.example.demo.mapping.dtos.StudentDTO;
import com.example.demo.model.Student;

public class StudentMapper {
    public static StudentDTO mapFromModel(Student cliente){
        return new StudentDTO( cliente.getName(), cliente.getIDnumber(), cliente.getDate_birth());

    }
    public static Student mapFromDTO(StudentDTO clienteDTO){
        return Student.builder()
                .name(clienteDTO.name())
                .IDnumber(clienteDTO.iDnumber())
                .date_birth(clienteDTO.date_birth())
                .build();
    }
}
