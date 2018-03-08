package com.kimigayo.basics.genericity;

public class PersonService extends AbstractBaseService<Person>{

    public static void main(String[] args) {
        Person<String> person = new Person<String>();
//        Person<String> int = new Person<int>();不能为基本类型
        person.setAge(20);
        person.setName("mick");
        person.setStudy("英语");
        PersonService service = new PersonService();
        System.out.println(service.add(person).getStudy());
    }

}