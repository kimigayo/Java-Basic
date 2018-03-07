package com.kimigayo.gof23.behavior.memeto;

public class Emp {
    private String name;
    private int age;
    private double salary;

    public EmpMemeto memeto(){
        return new EmpMemeto(this);
    }

    public void recovery(EmpMemeto empMemeto){
        this.name = empMemeto.getName();
        this.age = empMemeto.getAge();
        this.salary = empMemeto.getSalary();
    }

    public Emp(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
