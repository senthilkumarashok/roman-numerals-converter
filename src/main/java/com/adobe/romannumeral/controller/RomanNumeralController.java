package com.adobe.romannumeral.controller;

import com.adobe.romannumeral.service.IConverter;
import com.adobe.romannumeral.view.RomanNumeralResponse;
import com.adobe.romannumeral.view.RomanNumeralResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/romannumeral")
public class RomanNumeralController {

    @Autowired
    private IConverter converter;

    @GetMapping(value = "/v1", produces = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<RomanNumeralResponse> query(@RequestParam("query") int input) {
        String output = converter.convertToRomanNumeral(input);
        RomanNumeralResponse response = RomanNumeralResponse.builder()
                                                            .input(String.valueOf(input))
                                                            .output(output).build();
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/v2", produces = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<RomanNumeralResponses> queryRange(@RequestParam("min") int minValue, @RequestParam("max") int maxValue) {
        RomanNumeralResponse response = RomanNumeralResponse.builder().input(String.valueOf(minValue)).output(String.valueOf(maxValue)).build();
        RomanNumeralResponses responses = RomanNumeralResponses.builder().conversions(List.of(response)).build();
        return ResponseEntity.ok(responses);
    }
}