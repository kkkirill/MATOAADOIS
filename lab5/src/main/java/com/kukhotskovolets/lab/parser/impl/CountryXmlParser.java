package com.kukhotskovolets.lab.parser.impl;

import com.kukhotskovolets.lab.model.Country;
import com.kukhotskovolets.lab.model.submodel.Area;
import com.kukhotskovolets.lab.parser.ICountryXmlParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class CountryXmlParser implements ICountryXmlParser {

    private static CountryXmlParser INSTANCE;
    private String dataSourceFileName;

    private CountryXmlParser() {
        Properties properties = new Properties();
        try {
            File appProperties = new File(Objects.requireNonNull(
                    getClass()
                    .getResource("/properties/app.properties"))
                    .toURI());
            properties.load(new FileInputStream(appProperties));
            this.dataSourceFileName = properties.getProperty("data.source");
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static CountryXmlParser getInstance() {
        if (INSTANCE == null) {
            synchronized (CountryXmlParser.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CountryXmlParser();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public List<Country> getCountries() throws ParserConfigurationException, IOException, SAXException {
        return parseXmlSource();
    }

    private List<Country> parseXmlSource() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(Objects.requireNonNull(getClass()
                .getClassLoader()
                .getResource("data/" + dataSourceFileName))
                .getFile()
        );
        document.getDocumentElement().normalize();
        Element root = document.getDocumentElement();
        NodeList nList = document.getElementsByTagName("country");
        List<Country> countries = new ArrayList<>();
        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                Node area = eElement.getElementsByTagName(Area.FieldNamesXmlSync.AREA.getXmlName()).item(0);
                Country country = new Country(
                        eElement.getAttribute(Country.FieldNamesXmlSync.NAME.getXmlName()),
                        Long.parseLong(eElement.getAttribute(Country.FieldNamesXmlSync.POPULATION.getXmlName())),
                        eElement
                                .getElementsByTagName(Country.FieldNamesXmlSync.CAPITAL.getXmlName())
                                .item(0)
                                .getTextContent(),
                        eElement
                                .getElementsByTagName(Country.FieldNamesXmlSync.POLICY.getXmlName())
                                .item(0)
                                .getTextContent(),
                        parseDate(eElement
                                .getElementsByTagName(Country.FieldNamesXmlSync.FOUNDINGDATE.getXmlName())
                                .item(0)
                                .getTextContent()
                        ),
                        new Area(
                                Long.parseLong(area.getTextContent()),
                                area.getAttributes().getNamedItem(Area.FieldNamesXmlSync.UNITS.getXmlName()).getTextContent()
                        )
                );
                countries.add(country);
            }
        }
        return countries;
    }

    public LocalDate parseDate(String date) {
        List<Integer> dateParts = Arrays.stream(date.split("\\."))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return LocalDate.of(dateParts.get(2), dateParts.get(1), dateParts.get(0));
    }
}
