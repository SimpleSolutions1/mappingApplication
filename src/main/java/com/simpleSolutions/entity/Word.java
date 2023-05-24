package com.simpleSolutions.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "word", schema = "public")
@Getter
@Setter
public class Word implements Serializable {
    private static final long serialVersionUID = -4639471094957126716L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int number;
    private String word;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
}
