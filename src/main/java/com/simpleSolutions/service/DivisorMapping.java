package com.simpleSolutions.service;

import com.simpleSolutions.dto.WordRequestModelDTO;
import com.simpleSolutions.exception.OutOfRangeException;

import java.util.List;
import java.util.Map;

public interface DivisorMapping {

    Map<Integer, List<String>> getDivisorsMap(WordRequestModelDTO wordRequestModelDTO) throws OutOfRangeException;
}
