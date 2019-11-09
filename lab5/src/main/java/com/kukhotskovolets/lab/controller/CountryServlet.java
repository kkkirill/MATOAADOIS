package com.kukhotskovolets.lab.controller;

import com.kukhotskovolets.lab.parser.impl.CountryXmlParser;
import org.xml.sax.SAXException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class CountryServlet extends HttpServlet {
    private CountryXmlParser countriesParser;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        countriesParser = CountryXmlParser.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("countries", countriesParser.getCountries());
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request, response);
    }

    public void setCountriesParser(CountryXmlParser countriesParser) {
        this.countriesParser = countriesParser;
    }
}
