package com.kimigayo.gof23.creator.prototype;

import java.io.*;
import java.util.Date;

/**原型模式：浅拷贝、深度拷贝
 * Created by chenbinbin on 2018/2/9.
 */
public class Cat implements Cloneable,Serializable {
    private String name;
    private Date birthDay;

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Cat(String name, Date birthDay, Integer height) {

        this.name = name;
        this.birthDay = birthDay;
        this.height = height;
    }

    public Cat(String name, Integer height) {
        this.name = name;
        this.height = height;
    }

    private Integer height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        Cat o = (Cat) super.clone();
//        //克隆其中的对象属性
////        o.setBirthDay((Date) this.getBirthDay().clone());
//        return o;
//    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public static class EfficientTest{
        public static void main(String[] args) throws CloneNotSupportedException {
            Date date = new Date();
            long time1 = System.currentTimeMillis();
            long size = 1000000000;
            for (int i=1;i<size;i++){
                Cat cat = new Cat("jack",date,178);
            }
            long time2 = System.currentTimeMillis();
            System.out.println("耗时："+(time2-time1));
            long time3 = System.currentTimeMillis();
            Cat cat = new Cat("jack",date,178);
            for (int i=1;i<size-1;i++){
                Cat cat1 = (Cat) cat.clone();
            }
            long time4 = System.currentTimeMillis();
            System.out.println("耗时："+(time4-time3));
        }
    }

    public static class StreamTest{
        public static void main(String[] args) throws IOException, ClassNotFoundException {
            Date date = new Date();
            Cat cat = new Cat("jack",date,178);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(cat);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Cat  cat1  = (Cat) objectInputStream.readObject();
            System.out.println(cat);
            date.setTime(System.currentTimeMillis()+1000);
            System.out.println(cat.getBirthDay());
            System.out.println(cat1);
            System.out.println(cat1.getBirthDay());
        }
    }


    public static class Test{
        public static void main(String[] args) throws CloneNotSupportedException, InterruptedException {
            Date date = new Date();
            System.out.println(date);
            Cat cat = new Cat("mick",date,175000);
            Cat cat1 = cat;
            Cat cat2 = (Cat) cat.clone();
            System.out.println(cat);
            System.out.println(cat1);
            System.out.println(cat2);
            cat1.setName("jack");
            cat1.setHeight(1720);
            Thread.currentThread().sleep(1000);
            date.setTime(System.currentTimeMillis());
            System.out.println(cat.getName()+":"+cat.getHeight()+":"+cat.getBirthDay());
            System.out.println(cat1.getName()+":"+cat1.getHeight()+":"+cat1.getBirthDay());
            System.out.println(cat2.getName()+":"+cat2.getHeight()+":"+cat2.getBirthDay());
        }
    }
}
