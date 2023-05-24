
package com.simpleSolutions.controller;

import com.simpleSolutions.dto.MappingModelDTO;
import com.simpleSolutions.service.DivisorMapping;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class MappingController {


    private DivisorMapping divisorService;

    @GetMapping(value = "/divisorMapping")
    ResponseEntity<?> findByCategoryAndDivisorList(@RequestBody MappingModelDTO mappingModelDTO) {
        return ResponseEntity.ok(divisorService.getDivisorsMap(mappingModelDTO));
    }
}

