package com.simpleSolutions.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MappingService implements DivisorMapping {
    private final int MAX_RANGE = 20;
    @Override
    public void findDivisors(List<Integer> numcbers) {

    }
}
