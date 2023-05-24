package com.simpleSolutions.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="category", schema = "public")
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
}
