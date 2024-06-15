package com.adobe.romannumeral.service;

import com.adobe.romannumeral.view.RomanNumeralResponse;
import com.adobe.romannumeral.view.RomanNumeralResponses;

public interface IConverter {
    RomanNumeralResponse convertToRomanNumeral(int value);
    RomanNumeralResponses convertToRomanNumeral(int minValue, int maxValue);
}
