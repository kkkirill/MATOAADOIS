package com.kukhotskovolets;


import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> javaTechnologies = Arrays.asList("Maven", "Spring", "JSP", "JNDI", "JSF");
        List<String> pythonTechnologies = Arrays.asList("Django", "Flask", "Kivy", "PyQT5");
        JavaProgrammer javaProgrammer = CreatingProgrammersFacade.createJavaProgrammer(javaTechnologies, 200, 20);
        JavaProgrammer javaProgrammer1 = CreatingProgrammersFacade.createJavaProgrammer(javaTechnologies, 330, 15);
        PythonProgrammer pythonProgrammer = CreatingProgrammersFacade.createPythonProgrammer(pythonTechnologies, 180, 14);
        PythonProgrammer pythonProgrammer1 = CreatingProgrammersFacade.createPythonProgrammer(pythonTechnologies, 470, 10);

        pythonProgrammer.writeCode();
        pythonProgrammer.copyPasteFromStackOverflow();
        pythonProgrammer1.debug();

        javaProgrammer.writeCode();
        javaProgrammer.copyPasteFromStackOverflow();
        javaProgrammer1.debug();
        javaProgrammer1.askOnStackOverflow();
    }
}
