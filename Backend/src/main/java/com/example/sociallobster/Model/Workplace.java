package com.example.sociallobster.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "workplace")
public class Workplace {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int location_id;
    private String name;
    private String workplace_type;
}
