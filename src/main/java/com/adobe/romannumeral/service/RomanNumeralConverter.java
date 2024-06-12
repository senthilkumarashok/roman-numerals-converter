package com.adobe.romannumeral.service;

import org.springframework.stereotype.Component;
import com.google.common.collect.ImmutableMap;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class RomanNumeralConverter implements IConverter {

    static final Map<String, Integer> romanNumeralMap = new LinkedHashMap<>();

    static {
                romanNumeralMap.put("M", 1000);
                romanNumeralMap.put("CM", 900);
                romanNumeralMap.put("D", 500);
                romanNumeralMap.put("CD", 400);
                romanNumeralMap.put("C", 100);
                romanNumeralMap.put("XC", 90);
                romanNumeralMap.put("L", 50);
                romanNumeralMap.put("XL", 40);
                romanNumeralMap.put("X", 10);
                romanNumeralMap.put("IX", 9);
                romanNumeralMap.put("V", 5);
                romanNumeralMap.put("IV", 4);
                romanNumeralMap.put("I", 1);
    }
    static final ImmutableMap<String, Integer> romanNumeralDictionary = ImmutableMap.copyOf(romanNumeralMap);

    /**
     *
     * @param value
     * @return
     */
    @Override
    public String convertToRomanNumeral(int value) {
        StringBuilder result = new StringBuilder();
        for(Map.Entry<String, Integer> entry : romanNumeralDictionary.entrySet()) {
            int count = value / entry.getValue();
            if(count > 0) {
                result.append(entry.getKey().repeat(count));
                value = value % entry.getValue();
            }
        }
        return result.toString();
    }
}
