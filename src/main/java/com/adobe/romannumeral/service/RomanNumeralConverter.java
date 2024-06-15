package com.adobe.romannumeral.service;

import com.adobe.romannumeral.view.RomanNumeralResponse;
import com.adobe.romannumeral.view.RomanNumeralResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.google.common.collect.ImmutableMap;

import java.util.*;
import java.util.stream.IntStream;

@Component
@Slf4j
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
     * @param input
     * @return
     */
    @Override
    public RomanNumeralResponse convertToRomanNumeral(int input) {
        log.info("converting romanNumeral for integer {}", input);
        StringBuilder result = new StringBuilder();
        int value = input;
        for(Map.Entry<String, Integer> entry : romanNumeralDictionary.entrySet()) {
            int count = value / entry.getValue();
            if(count > 0) {
                result.append(entry.getKey().repeat(count));
                value = value % entry.getValue();
            }
        }
        return RomanNumeralResponse.builder()
                .input(String.valueOf(input))
                .output(result.toString()).build();
    }

    @Override
    public RomanNumeralResponses convertToRomanNumeral(int minValue, int maxValue) {
        Comparator<RomanNumeralResponse> comparator = Comparator.comparing((RomanNumeralResponse o) -> Integer.valueOf(o.getInput()));
        Set<RomanNumeralResponse> romanNumeralResponses = new TreeSet<>(comparator);
        IntStream.range(minValue, maxValue+1).parallel().forEach(e -> romanNumeralResponses.add(convertToRomanNumeral(e)));
        return RomanNumeralResponses.builder().conversions(romanNumeralResponses).build();
    }


}
