package com.kukhotskovolets;

import java.util.ArrayList;
import java.util.List;

class CreatingProgrammersFacade {
    static PythonProgrammer createPythonProgrammer(List<String> technologiesStack, Integer cost, Integer duration) {
        return new PythonCourse(new ArrayList<>(technologiesStack), cost, duration).createProgrammer();
    }

    static JavaProgrammer createJavaProgrammer(List<String> technologiesStack, Integer cost, Integer duration) {
        return new JavaCourse(new ArrayList<>(technologiesStack), cost, duration).createProgrammer();
    }
}
