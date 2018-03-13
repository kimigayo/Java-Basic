package com.kimigayo.basics.io.stream.Object;

import java.io.*;

/**
 * transient标识的类型不进行序列号
 * 对象序列化中包含不能序列化的类型需要transient标识，不然会报错
 */
public class ObjectInputStreamTest {
    public static void main(String[] args) {
        try {
            write("./person.txt");
            read("./person.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void read(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)));
        Person person = (Person) inputStream.readObject();
        System.out.println(person.toString());
    }
    public static void write(String path) throws IOException {
        Person person = new Person("赵盾",50,true);
        ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
        outputStream.writeObject(person);
        outputStream.flush();
        outputStream.close();
    }
    private static class Country{
        private String name;
        private String location;

        public String getName() {
            return name;
        }

        public String getLocation() {
            return location;
        }

        public Country(String name, String location) {
            this.name = name;
            this.location = location;
        }
    }

    private static class Person implements Serializable{
        private String name;
        private transient int age;//不进行序列化
        private boolean sex;
        private transient Country country;

        public Country getCountry() {
            return country;
        }

        public void setCountry(Country country) {
            this.country = country;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", sex=" + sex +
                    ", country=" + (null==country?"":country.getName()) +
                    '}';
        }

        public Person(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.country = new Country("晋国","");
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public boolean isSex() {
            return sex;
        }
    }
}
