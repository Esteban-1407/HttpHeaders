package com.example.demo.service;

import com.example.demo.mapping.dtos.StudentDTO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<StudentDTO> students;

    public StudentService() {
        students = new ArrayList<>();
        // Agregar algunos datos de ejemplo
        students.add(new StudentDTO( "John Doe", "ABC123", new Date(2020,6,14)));
        students.add(new StudentDTO( "Jane Smith", "DEF456", new Date(2017,5,25)));
        students.add(new StudentDTO( "Alice Johnson", "GHI789", new Date(2005,9,5)));
    }

    // Método para listar todos los estudiantes
    public List<StudentDTO> listar() {
        return students;
    }


}
