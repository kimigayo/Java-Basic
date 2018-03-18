package com.kimigayo.javassist;

import javassist.*;
import javassist.bytecode.AccessFlag;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo02 {
    public static void main(String[] args) throws NotFoundException, IOException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.get("com.kimigayo.javassist.Person");
//        byte[] bytes = ctClass.toBytecode();
//        System.out.println(new String(bytes));
//        System.out.println(ctClass.getName());
//        System.out.println(ctClass.getSimpleName());
//        System.out.println(ctClass.getSuperclass());
//        System.out.println(ctClass.getInterfaces());
        CtMethod method = new CtMethod(CtClass.intType,"sum",new CtClass[]{CtClass.intType,CtClass.intType},ctClass);
        method.addParameter(CtClass.intType);
        method.setBody("return $1+$2+$3;");
        method.setModifiers(AccessFlag.PUBLIC);
        method.insertBefore("\n" +
                "        System.out.println(\"a=\"+$1);\n" +
                "        System.out.println(\"b=\"+$2);");
        method.insertAfter("System.out.println(\"计算结束\");");
        ctClass.addMethod(method);
        Class aClass = ctClass.toClass();
        Object obj = aClass.newInstance();
        Method method1 = aClass.getDeclaredMethod("sum",int.class,int.class,int.class);
        System.out.println(method1.invoke(obj,300,200,100));
    }
}
