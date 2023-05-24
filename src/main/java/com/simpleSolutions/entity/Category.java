package com.simpleSolutions.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name="category", schema = "public")
@Getter
@Setter
public class Category implements Serializable {
    private static final long serialVersionUID = -2148495959875863694L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
}
