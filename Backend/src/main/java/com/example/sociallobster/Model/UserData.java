package com.example.sociallobster.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERDATA")
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int user_id;
    private int location_id;
    private int photo_id;
    private String first_name;
    private String last_name;
    private String gender;
    private Date birthday;
}
