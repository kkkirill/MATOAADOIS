package com.kukhotskovolets;

import java.util.ArrayList;


public class PythonCourse extends ITCourse{

    PythonCourse(ArrayList<String> technologiesStack, Integer cost, Integer duration) {
        super(technologiesStack, cost, duration);
    }

    @Override
    public PythonProgrammer createProgrammer() {
        PythonProgrammer programmer = new PythonProgrammer();
        programmer.learn(this.technologiesStack);
        return programmer;
    }
}
