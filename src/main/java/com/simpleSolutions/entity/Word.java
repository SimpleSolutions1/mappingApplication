package com.simpleSolutions.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "word", schema = "public")
@Getter
@Setter
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int number;
    private String word;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
}
