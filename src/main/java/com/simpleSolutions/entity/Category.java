package com.simpleSolutions.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="category", schema = "public")
@Getter
@Setter
public class Category {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
}
