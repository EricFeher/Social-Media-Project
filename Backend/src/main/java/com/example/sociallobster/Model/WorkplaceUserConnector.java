package com.example.sociallobster.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "WORKPLACE_USER_CONNECTOR")
public class WorkplaceUserConnector {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private int user_id;
    private int workplace_id;
}
