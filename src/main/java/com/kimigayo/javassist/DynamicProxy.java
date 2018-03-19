package com.kimigayo.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.AccessFlag;

import java.lang.reflect.Method;

public class DynamicProxy {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.get("com.kimigayo.javassist.Person");
        CtMethod method = new CtMethod(CtClass.intType,"sum",new CtClass[]{CtClass.intType,CtClass.intType},ctClass);
        method.setBody("return $1+$2;");
        method.setModifiers(AccessFlag.PUBLIC);
        ctClass.addMethod(method);
        Class aClass = ctClass.toClass();
        Object obj = aClass.newInstance();
        Method method1 = aClass.getDeclaredMethod("sum",int.class,int.class);
        System.out.println(method1.invoke(obj,300,200));
    }
}
