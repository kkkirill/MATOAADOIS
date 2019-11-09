package com.kukhotskovolets.lab.dao.impl;

import com.kukhotskovolets.lab.parser.impl.CountryXmlParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class CountryXmlParserUnitTest {

    @Test
    public void testParseDate() {
        CountryXmlParser countryXmlParser = CountryXmlParser.getInstance();
        String date = "09.01.2019";
        LocalDate expectedDate = LocalDate.of(2019, 1, 9);
        assertEquals("If input date 09.01.2019 it should be LocalDate[2019-01-09] object!",
                expectedDate,
                countryXmlParser.parseDate(date));
    }
}
