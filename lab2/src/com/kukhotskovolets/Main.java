package com.kukhotskovolets;


import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> javaTechnologies = Arrays.asList("Maven", "Spring", "JSP", "JNDI", "JSF");
        List<String> pythonTechnologies = Arrays.asList("Django", "Flask", "Kivy", "PyQT5");
        JavaCourse javaCourse = CreatingCourseFacade.createJavaCourse(javaTechnologies, 200, 20);
        JavaCourse javaCourse1 = CreatingCourseFacade.createJavaCourse(javaTechnologies, 330, 15);
        PythonCourse pythonCourse = CreatingCourseFacade.createPythonCourse(pythonTechnologies, 180, 14);
        PythonCourse pythonCourse1 = CreatingCourseFacade.createPythonCourse(pythonTechnologies, 470, 10);
        JavaProgrammer javaProgrammer = javaCourse.createProgrammer();
        JavaProgrammer javaProgrammer1 = javaCourse1.createProgrammer();
        PythonProgrammer pythonProgrammer = pythonCourse.createProgrammer();
        PythonProgrammer pythonProgrammer1 = pythonCourse1.createProgrammer();

        pythonProgrammer.writeCode();
        pythonProgrammer.copyPasteFromStackOverflow();
        pythonProgrammer1.debug();

        javaProgrammer.writeCode();
        javaProgrammer.copyPasteFromStackOverflow();
        javaProgrammer1.debug();
        javaProgrammer1.askOnStackOverflow();
    }
}
