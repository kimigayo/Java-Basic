package com.kimigayo.basics.sort.treeCollection;

import java.util.Arrays;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Person> people = new TreeSet<>();
        Person p1 = new Person(50,"马云");
        Person p2 = new Person(40,"马化腾");
        Person p3 = new Person(45,"李彦宏");
        people.add(p1);
        people.add(p2);//插入过程中排序
        System.out.println(people);
        people.add(p3);
        System.out.println(people);
        p2.setName("马云");
        p2.setAge(50);//对象修改时，不重新排序
        System.out.println(people);

    }

    private static class Person implements Comparable<Person>{
        private int age;
        private String name;

        public void setAge(int age) {
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            return this.age-o.age;
        }

        @Override
        public String toString() {
            return "姓名："+name+"\t年龄："+age;
        }
    }
}
