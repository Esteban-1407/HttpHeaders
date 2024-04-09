package com.example.demo.mapping.dtos;

import lombok.Builder;

import java.util.Date;

@Builder
public record StudentDTO(String name, String iDnumber, Date date_birth){
}
