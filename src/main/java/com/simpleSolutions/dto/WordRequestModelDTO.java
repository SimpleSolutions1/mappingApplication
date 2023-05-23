package com.simpleSolutions.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class WordRequestModelDTO {
    private String categoryName;

    private List<Integer> numberList;
}
