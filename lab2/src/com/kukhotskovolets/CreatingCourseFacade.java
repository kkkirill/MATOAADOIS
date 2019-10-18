package com.kukhotskovolets;

import java.util.ArrayList;
import java.util.List;

class CreatingCourseFacade {

    static PythonCourse createPythonCourse (List<String> technologiesStack, Integer cost, Integer duration) {
        return new PythonCourse(new ArrayList<>(technologiesStack), cost, duration);
    }

    static JavaCourse createJavaCourse (List<String> technologiesStack, Integer cost, Integer duration) {
        return new JavaCourse(new ArrayList<>(technologiesStack), cost, duration);
    }
}
