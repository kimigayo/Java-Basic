package com.kimigayo.gof23.behavior.memeto;

public class memetoTest {
    public static void main(String[] args) {
        Emp emp = new Emp("张三",18,900);
        CareTake careTake = new CareTake();
        careTake.setEmpMemeto(emp.memeto());
        System.out.println(emp.getAge());
        System.out.println(emp.getName());
        System.out.println(emp.getSalary());
        emp.setAge(30);
        emp.setName("王五");
        System.out.println(emp.getAge());
        System.out.println(emp.getName());
        System.out.println(emp.getSalary());
        emp.recovery(careTake.getEmpMemeto());
        System.out.println(emp.getAge());
        System.out.println(emp.getName());
        System.out.println(emp.getSalary());
    }
}
