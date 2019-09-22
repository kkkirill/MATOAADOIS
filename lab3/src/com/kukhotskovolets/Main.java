package com.kukhotskovolets;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        MyDOMParser parser = new MyDOMParser();
        ArrayList<Bank> banks = parser.parse("resources/file.xml");
        MySAXParser parser1 = new MySAXParser();
        ArrayList<Bank> banks1 = parser1.parse("resources/file.xml");
        for (Bank bank: banks) {
            System.out.println(bank);
        }
        System.out.println("------------------------------------");
        for (Bank bank: banks1) {
            System.out.println(bank);
        }
    }
}
