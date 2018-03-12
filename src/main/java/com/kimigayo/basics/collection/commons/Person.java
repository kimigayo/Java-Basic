package com.kimigayo.basics.collection.commons;

public class Person {
    private String name;
    private boolean isBoss;
    private double salary;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", isBoss=" + isBoss +
                ", salary=" + salary +
                '}';
    }

    public Person(String name, boolean isBoss, double salary) {
        this.name = name;
        this.isBoss = isBoss;
        this.salary = salary;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBoss() {
        return isBoss;
    }

    public void setBoss(boolean boss) {
        isBoss = boss;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
