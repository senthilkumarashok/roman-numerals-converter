package com.adobe.romannumeral.controller;

import com.adobe.romannumeral.service.IConverter;
import com.adobe.romannumeral.view.RomanNumeralResponse;
import com.adobe.romannumeral.view.RomanNumeralResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/romannumeral")
public class RomanNumeralController {

    @Autowired
    private IConverter converter;

    @GetMapping(value = "/v1", produces = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<RomanNumeralResponse> query(@RequestParam("query") int input) {
        RomanNumeralResponse romanNumeralResponse = converter.convertToRomanNumeral(input);
        return ResponseEntity.ok(romanNumeralResponse);
    }

    @GetMapping(value = "/v2", produces = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<RomanNumeralResponses> queryRange(@RequestParam("min") int minValue, @RequestParam("max") int maxValue) {
        RomanNumeralResponses response = converter.convertToRomanNumeral(minValue, maxValue);
        return ResponseEntity.ok(response);
    }
}