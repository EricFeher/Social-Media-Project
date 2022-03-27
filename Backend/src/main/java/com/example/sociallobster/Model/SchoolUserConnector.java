package com.example.sociallobster.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "school_user_connector")
public class SchoolUserConnector {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int user_id;
    private int school_id;
}
