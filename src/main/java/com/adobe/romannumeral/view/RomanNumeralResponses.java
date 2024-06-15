package com.adobe.romannumeral.view;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Data
@Builder

public class RomanNumeralResponses {
    Set<RomanNumeralResponse> conversions;
}
