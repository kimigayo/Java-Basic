package com.kimigayo.jvm.classloader;

import com.kimigayo.basics.io.FileUtil;

import java.io.*;

public class SelfClassLoader extends ClassLoader{
    private String rootDir;

    public SelfClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);
        if(null!=c){
            return c;
        }
        try {
            c = this.getParent().loadClass(name);
            if(null!=c){
                return c;
            }
        }catch (Exception e){}
        byte[] bytes = getClassData(name);
        c = defineClass(name,bytes,0,bytes.length);
        return c;
    }

    private byte[] getClassData(String name) {
        String path = rootDir+"/"+name.replace('.','/')+".class";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedInputStream inputStream = null;
        try {
            inputStream= new BufferedInputStream(new FileInputStream(path));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes))>0){
                outputStream.write(bytes,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileUtil.closeAll(outputStream,inputStream);
            return outputStream.toByteArray();
        }
    }
}
