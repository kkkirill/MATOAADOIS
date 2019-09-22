package com.kukhotskovolets;

import java.util.ArrayList;


public class JavaCourse extends ITCourse{

    JavaCourse(ArrayList<String> technologiesStack, Integer cost, Integer duration) {
        super(technologiesStack, cost, duration);
    }

    @Override
    public JavaProgrammer createProgrammer() {
        JavaProgrammer programmer = new JavaProgrammer();
        programmer.learn(this.technologiesStack);
        return programmer;
    }
}
