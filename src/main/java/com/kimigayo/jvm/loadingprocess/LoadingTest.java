package com.kimigayo.jvm.loadingprocess;

/**
 * 类加载过程-》.class加载-》验证-》准备-》解析-》初始化（常量赋值及static块执行）
 * 栈内存-》堆内存（包含方法区）
 *
 */
public class LoadingTest {

    static {
        System.out.println("loading初始化");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        Father father;
        System.out.println(Father.height);//调用静态成员会初始化(final常量除外)-》常量在编译阶段玖存入调用类的常量池中
        Father[] fathers = new Father[10];
//        System.out.println(Son.width);//只有真正声明这个域的Father类才会初始化
//        new Father();//new对象会初始化class对象
//        Father.print();//调用静态成员会初始化(final常量除外)
//        Father.println();
//        Class.forName("com.kimigayo.jvm.loadingprocess.Father");//反射调用会初始化
        Son son = new Son();//加载一个类class对象时,如果其父类还未初始化，先初始化父类
    }
}
class Son extends Father{
    static {
        System.out.println("Son初始化");
    }

    public Son() {
        System.out.println("初始化Son对象");
    }
}
class Father{
    public static int width=100;
    public final static int height=100;
    static {
        System.out.println("Father初始化");
    }

    public Father() {
        System.out.println("初始化Father对象");
    }

    public static void print(){
    }
    public final static void println(){
    }
}

