package com.simpleSolutions.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
public class DividorMappingResponseDTO implements Serializable {

    private static final long serialVersionUID = 894422594134371853L;
    private int dividor;
    private ArrayList<String> wordList;
}
