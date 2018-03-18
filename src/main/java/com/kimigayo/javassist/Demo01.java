package com.kimigayo.javassist;

import javassist.*;
import javassist.bytecode.AccessFlag;

import java.io.IOException;

public class Demo01 {
    public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.makeClass("com.kimigayo.javassist.Person");
        CtField field1 = CtField.make("private String name;",ctClass);
//        CtField field2 = CtField.make("private int age;",ctClass);
        CtField field2 = new CtField(CtClass.intType,"age;",ctClass);
        field2.setModifiers(AccessFlag.PRIVATE);
        ctClass.addField(field1);
        ctClass.addField(field2);
        CtMethod ctMethod1 = CtMethod.make("public void setName(String name){this.name=name;}",ctClass);
        CtMethod ctMethod2 = CtMethod.make("public String getName(){return this.name;}",ctClass);
        ctClass.addMethod(ctMethod1);
        ctClass.addMethod(ctMethod2);
        CtMethod ctMethod3 = CtNewMethod.getter("getAge",field2);
        CtMethod ctMethod4 = CtNewMethod.setter("setAge",field2);
        ctClass.addMethod(ctMethod3);
        ctClass.addMethod(ctMethod4);
        CtConstructor constructor = new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")},ctClass);
        constructor.setBody("{this.age=$1;this.name=$2;}");
        ctClass.addConstructor(constructor);
        ctClass.writeFile("./");
        System.out.println("-----");
    }
}
