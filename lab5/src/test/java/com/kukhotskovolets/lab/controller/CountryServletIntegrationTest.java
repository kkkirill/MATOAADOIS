package com.kukhotskovolets.lab.controller;

import com.kukhotskovolets.lab.model.Country;
import com.kukhotskovolets.lab.parser.impl.CountryXmlParser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.xml.sax.SAXException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CountryServletIntegrationTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private CountryXmlParser countryXmlParser;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Mock
    private List<Country> countries;

    private CountryServlet countryServlet;

    @Before
    public void init() throws IOException, SAXException, ParserConfigurationException {
        countryServlet = new CountryServlet();
        countryServlet.setCountriesParser(countryXmlParser);
        when(countryXmlParser.getCountries()).thenReturn(countries);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
        countryServlet.doGet(request, response);
        verify(request).setAttribute("countries", countries);
        verify(requestDispatcher).forward(request, response);
    }
}
