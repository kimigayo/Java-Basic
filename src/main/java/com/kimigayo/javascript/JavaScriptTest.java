package com.kimigayo.javascript;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaScriptTest {
    public static void main(String[] args) throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        engine.put("msg","hello world!");
        String str ="var person={name:'张三',age:30};";
        engine.eval(str);
        System.out.println(engine.get("msg"));
    }

}
