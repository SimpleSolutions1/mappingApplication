package com.simpleSolutions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MappingModelDTO implements Serializable {
    private static final long serialVersionUID = -5039271016448861471L;
    private String categoryName;

    private List<Integer> numberList;
}
