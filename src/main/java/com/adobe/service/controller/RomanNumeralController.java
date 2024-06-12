package com.adobe.service.controller;

import com.adobe.service.view.RomanNumeralResponse;
import com.adobe.service.view.RomanNumeralResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/romannumeral")
public class RomanNumeralController {


    @GetMapping(value = "/v1", produces = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<RomanNumeralResponse> query(@RequestParam("query") int value) {
        RomanNumeralResponse response = RomanNumeralResponse.builder()
                                                            .input(String.valueOf(value))
                                                            .output(String.valueOf(value)).build();
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/v2", produces = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<RomanNumeralResponses> queryRange(@RequestParam("min") int minValue, @RequestParam("max") int maxValue) {
        RomanNumeralResponse response = RomanNumeralResponse.builder().input(String.valueOf(minValue)).output(String.valueOf(maxValue)).build();
        RomanNumeralResponses responses = RomanNumeralResponses.builder().conversions(List.of(response)).build();
        return ResponseEntity.ok(responses);
    }
}