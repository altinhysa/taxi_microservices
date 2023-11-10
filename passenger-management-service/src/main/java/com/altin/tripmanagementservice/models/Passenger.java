package com.altin.tripmanagementservice.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String telephone;
}
