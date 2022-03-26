package com.example.sociallobster.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SCHOOL")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int location_id;
    private String name;
    private String school_type;
}
