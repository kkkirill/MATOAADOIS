package com.kukhotskovolets;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

class MyHandler extends DefaultHandler {
    private Stack<String> values;
    private ArrayList<Bank> banksObjects;
    private HashMap<String, String> stringValues;
    private HashMap<String, Integer> integerValues;

    MyHandler() {
        values = new Stack<>();
        banksObjects = new ArrayList<>();
        stringValues = new HashMap<>();
        integerValues = new HashMap<>();
    }

    ArrayList<Bank> getBanksObjects() {
        return banksObjects;
    }

    public void endElement(String uri, String localName, String qName) {
        pushValue(qName, switch (qName) {
            case "name", "capital_unit", "country", "city", "award" -> values.pop();
            case "founding_date", "capital", "workers_amount" -> Integer.valueOf(values.pop());
            case "history" -> String.join(" ", values.toArray(new String[0]));
            default -> "";
        });
    }

    private <T> void pushValue(String tag, T value) {
        if (value instanceof Integer) {
            integerValues.put(tag, (Integer) value);
            return;
        }
        if (tag.equals("bank")) {
            ArrayList<String> awards = stringValues.entrySet()
                    .parallelStream()
                    .filter(key -> key.getKey().startsWith("award"))
                    .map(Map.Entry::getValue).collect(Collectors.toCollection(ArrayList::new));
            banksObjects.add(BankFactory.createBank(stringValues.get("name"), integerValues.get("founding_date"),
                    integerValues.get("capital"), stringValues.get("capital_unit"),
                    integerValues.get("workers_amount"), stringValues.get("country"), stringValues.get("city"),
                    stringValues.get("history"), awards));
            clearTempLists();
        } else if (tag.equals("award")) {
            Long number = stringValues.keySet().parallelStream().filter(key -> key.startsWith("award")).count();
            stringValues.put(tag + number, (String) value);
        } else if (!value.toString().isEmpty()) {
            stringValues.put(tag, (String) value);
        }
    }

    private void clearTempLists() {
        stringValues.clear();
        integerValues.clear();
    }

    public void characters(char[] c, int start, int length) {
        String val = new String(c, start, length).replaceAll("[^\\w., ]|([ ]{2,})", "").strip();
        if (!val.isEmpty()) {
            values.push(val);
        }
    }
}

class MySAXParser {
    private SAXParser parser;

    MySAXParser() throws ParserConfigurationException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        this.parser = factory.newSAXParser();
    }

    ArrayList<Bank> parse(String file) throws IOException, SAXException {
        MyHandler myHandler = new MyHandler();
        this.parser.parse(file, myHandler);
        return myHandler.getBanksObjects();
    }
}
