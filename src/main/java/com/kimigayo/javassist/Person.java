package com.kimigayo.javassist;

public class Person {
    private String name;
    private int age;

    public void setName(String var1) {
        this.name = var1;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int var1) {
        this.age = var1;
    }

    public Person(int var1, String var2) {
        this.age = var1;
        this.name = var2;
    }

    public Person() {
    }
}
