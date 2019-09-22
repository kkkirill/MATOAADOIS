package com.kukhotskovolets;

import java.util.ArrayList;


public class JavaProgrammer implements Programmer{
    private ArrayList<String> technologies;

    @Override
    public <T> void learn(Iterable<T> technologies) {
        for (T v : technologies) {
            this.technologies.add(v.toString());
        }
        System.out.println("Java is the best!");
    }

    @Override
    public void writeCode() {
        System.out.println("Write Java code");
    }

    @Override
    public void debug() {
        System.out.println("Debug Java code");
    }

    @Override
    public void visitStackOverflow() {
        System.out.println("Visited best site!");
    }

    @Override
    public void copyPasteFromStackOverflow() {
        System.out.println("Copy Pasted solution!");
    }

    @Override
    public void askOnStackOverflow() {
        System.out.println("Is JavaScript framework on Java?");
    }

    JavaProgrammer() {
        this.technologies = new ArrayList<>(10);
    }

    public ArrayList<String> getTechnologies() {
        return technologies;
    }
}
