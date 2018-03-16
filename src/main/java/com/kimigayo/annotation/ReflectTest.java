package com.kimigayo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
        Class aClass = Class.forName("com.kimigayo.annotation.Person");
        Class bClass = Person.class;
        Class cClass = new Person().getClass();
        System.out.println(aClass==bClass);
        System.out.println(aClass==cClass);
        Constructor constructor = aClass.getConstructor(String.class,int.class);
        Person person1 = (Person) constructor.newInstance("马云",50);
        System.out.println(person1.getAge());
        loopAnnotation(aClass);
        Field[] fields = aClass.getDeclaredFields();
        for (Field field:fields){
            loopAnnotation(field);
        }
        Field field = aClass.getDeclaredField("name");
        field.setAccessible(true);//去除安全检查,增加反射效率
        System.out.println(field.get(person1));
        field.set(person1,"马化腾");
        System.out.println(field.get(person1));
    }

    public static<T extends AnnotatedElement> void loopAnnotation(T t){
        Annotation[] annotations = t.getAnnotations();
        for (Annotation annotation:annotations){
            System.out.println(annotation);
        }
    }
}
