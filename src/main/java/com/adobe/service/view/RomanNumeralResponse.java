package com.adobe.service.view;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RomanNumeralResponse {

    private String input;
    private String output;
}
