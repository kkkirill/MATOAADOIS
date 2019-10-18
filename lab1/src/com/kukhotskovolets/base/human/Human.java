package com.kukhotskovolets.base.human;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private String secondName;
    private Gender gender;
    private Integer age;
    private Date birthDate;

    public Human(String name, String surname, String secondName, Gender gender, Integer age, Date birthDate) {
        this.name = name;
        this.surname = surname;
        this.secondName = secondName;
        this.gender = gender;
        this.age = age;
        this.birthDate = birthDate;
    }

    public Human(Human human) {
        this(human.name, human.surname, human.secondName, human.gender, human.age, human.birthDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Human human = (Human) obj;
        return Objects.equals(this.name, human.name) && Objects.equals(this.surname, human.surname)
                && Objects.equals(this.secondName, human.secondName) && Objects.equals(this.gender, human.gender)
                && Objects.equals(this.birthDate, human.birthDate);
    }

    @Override
    public String toString() {
        DateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        return String.format("%s %s %s %s %d %s", name, surname, secondName, gender.toString(), age,
                dateformat.format(birthDate));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public static class Builder {
        private String name = "Default Name";
        private String surname = "Default Surname";
        private String secondName = "Default Second name";
        private Gender gender = Gender.MALE;
        private Integer age = 0;
        private Date birthDate = new Date();

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setSecondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public Builder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public Builder setDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Human build() {
            return new Human(name, surname, secondName, gender, age, birthDate);
        }
    }
}
