package com.kimigayo.annotation;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;

public class CompileTest {
    public static void main(String[] args) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null,null,null,"E:\\self\\Java-Basic\\src\\main\\java\\com\\kimigayo\\annotation\\Person.java");
        System.out.println(result==0?"成功":"失败");
    }
}
