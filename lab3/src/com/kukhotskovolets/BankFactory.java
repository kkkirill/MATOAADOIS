package com.kukhotskovolets;

import java.util.ArrayList;


class BankFactory {
    static Bank createBank(String name, Integer foundingDate, Integer capital, String capitalUnit,
                           Integer workersAmount, String country, String city, String history,
                           ArrayList<String> awards) {
        return new Bank(name, foundingDate, capital, capitalUnit, workersAmount, country, city, history, awards);
    }
}
