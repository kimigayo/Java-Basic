package com.kimigayo.annotation;
@Entity("t_person")
public class Person {
    @Column(name = "name",type = "varchar",length = "50")
    private String name;
    @Column(name = "name",type = "Integer",length = "3")
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
}
