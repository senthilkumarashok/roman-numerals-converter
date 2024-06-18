package com.adobe.romannumeral.controller;

import com.adobe.romannumeral.exception.InvalidInputException;
import com.adobe.romannumeral.service.IConverter;
import com.adobe.romannumeral.view.RomanNumeralResponse;
import com.adobe.romannumeral.view.RomanNumeralResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        if(input < 0 || input > 3999) throw new InvalidInputException("query parameter needs to be in the range between 1 and 3999");
        RomanNumeralResponse romanNumeralResponse = converter.convertToRomanNumeral(input);
        return ResponseEntity.ok(romanNumeralResponse);
    }

    @GetMapping(value = "/v2", produces = {MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<RomanNumeralResponses> queryRange(@RequestParam("min") int minValue, @RequestParam("max") int maxValue) {
        if(minValue < 0 || maxValue > 3999) throw new InvalidInputException("minValue and maxValue parameter must be in the range between 1 and 3999");
        if(minValue > maxValue) throw new InvalidInputException("minValue must be less than maxValue");

        RomanNumeralResponses response = converter.convertToRomanNumeral(minValue, maxValue);
        return ResponseEntity.ok(response);
    }
}