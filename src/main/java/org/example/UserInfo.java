package org.example;

public class UserInfo {
    private String name;
    private String surname;
    private Integer age;

    public String printInfo() {
        return "\nName: " + this.name +
                "\nSurname: " + this.surname +
                "\nAge: " + this.age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
