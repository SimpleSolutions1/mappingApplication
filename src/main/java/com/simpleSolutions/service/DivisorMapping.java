package com.simpleSolutions.service;

import com.simpleSolutions.dto.MappingModelDTO;
import com.simpleSolutions.exception.OutOfRangeException;

import java.util.List;
import java.util.Map;

public interface DivisorMapping {

    Map<Integer, List<String>> getDivisorsMap(MappingModelDTO mappingModelDTO) throws OutOfRangeException;
}
