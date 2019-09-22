package com.kukhotskovolets;

import java.util.ArrayList;


abstract class ITCourse {
    private Integer duration;
    private Integer cost;
    ArrayList<String> technologiesStack;

    ITCourse(ArrayList<String> technologiesStack, Integer cost, Integer duration) {
        this.technologiesStack = technologiesStack;
        this.cost = cost;
        this.duration = duration;
    };

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public ArrayList<String> getTechnologiesStack() {
        return technologiesStack;
    }

    public void setTechnologiesStack(ArrayList<String> technologiesStack) {
        this.technologiesStack = technologiesStack;
    }

    public abstract Programmer createProgrammer();  //factory method
}
