package com.adobe.service;

import com.adobe.romannumeral.service.IConverter;
import com.adobe.romannumeral.service.RomanNumeralConverter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { RomanNumeralConverter.class})
public class RomanNumeralConverterServiceTest {

    @Autowired
    IConverter converter;

    @Test
    public void testConvert() {
        Assert.assertEquals("", converter.convertToRomanNumeral(0));
        Assert.assertEquals("X", converter.convertToRomanNumeral(10));
        Assert.assertEquals("XLVI", converter.convertToRomanNumeral(46));
        Assert.assertEquals("CMXCIX", converter.convertToRomanNumeral(999));
    }
}
