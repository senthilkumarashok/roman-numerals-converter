package com.adobe.service.view;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder

public class RomanNumeralResponses {
    List<RomanNumeralResponse> conversions;
}
