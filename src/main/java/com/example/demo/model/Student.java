package com.example.demo.model;

import java.util.Date;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Student {




        int id;
        private String name;
        private String IDnumber;
        private Date date_birth;

}
