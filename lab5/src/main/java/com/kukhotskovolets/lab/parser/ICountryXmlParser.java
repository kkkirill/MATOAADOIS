package com.kukhotskovolets.lab.parser;

import com.kukhotskovolets.lab.model.Country;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface ICountryXmlParser {
    List<Country> getCountries() throws ParserConfigurationException, IOException, SAXException;
}
