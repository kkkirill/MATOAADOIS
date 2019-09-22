package com.kukhotskovolets;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class MyDOMParser {
    private DocumentBuilder builder;
    private HashMap<String, String> stringValues;
    private HashMap<String, Integer> integerValues;
    private ArrayList<String> STRINGKEYS;
    private ArrayList<String> INTEGERKEYS;

    MyDOMParser() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        stringValues = new HashMap<>(6);
        integerValues = new HashMap<>(3);
        STRINGKEYS = new ArrayList<>(Arrays.asList("name", "capital_unit", "country", "city", "history"));
        INTEGERKEYS = new ArrayList<>(Arrays.asList("founding_date", "capital", "workers_amount"));
        factory.setIgnoringComments(true);
        builder = factory.newDocumentBuilder();
    }

    ArrayList<Bank> parse(String file) throws IOException, SAXException {
        Document document = builder.parse(file);
        document.normalizeDocument();
        ArrayList<Bank> banksObjects = new ArrayList<>(2);
        Element bankList = document.getDocumentElement();
        if (!"banks_list".equals(bankList.getTagName())) {
            return null;
        }
        NodeList banks = bankList.getElementsByTagName("bank");
        for (int i = 0; i < banks.getLength(); ++i) {
            parseNode(banks.item(i));
            banksObjects.add(createBankObject());
            clearTempLists();
        }
        return banksObjects;
    }

    private void clearTempLists() {
        stringValues.clear();
        integerValues.clear();
    }

    private Bank createBankObject() {
        ArrayList<String> awards = stringValues.entrySet()
                .parallelStream()
                .filter(key -> key.getKey().startsWith("award"))
                .map(Map.Entry::getValue).collect(Collectors.toCollection(ArrayList::new));
        return new Bank(stringValues.get("name"), integerValues.get("founding_date"), integerValues.get("capital"),
                stringValues.get("capital_unit"), integerValues.get("workers_amount"), stringValues.get("country"),
                stringValues.get("city"), stringValues.get("history"), awards);
    }

    private void parseNode(Node node) {
        String nodeName = node.getNodeName();
        Node firstChild = node.getFirstChild();
        if (firstChild == null) {
            return;
        }
        String value = firstChild.getTextContent().replaceAll("[^\\w., ]|([ ]{2,})", "").strip();
        if (STRINGKEYS.contains(nodeName)) {
            stringValues.put(nodeName, value);
        } else if (INTEGERKEYS.contains(nodeName)) {
            value = value.replaceAll("[^\\w ]", "").strip();
            integerValues.put(nodeName, Integer.valueOf(value));
        } else if (nodeName.equals("award")) {
            Long number = stringValues.keySet().parallelStream().filter(key -> key.startsWith("award")).count();
            stringValues.put(nodeName + number, value);
        }
        if (node.hasChildNodes()) {
            NodeList childNodes = node.getChildNodes();
            for (int i = 0, length = childNodes.getLength(); i < length; ++i) {
                parseNode(childNodes.item(i));
            }
        }
    }
}
