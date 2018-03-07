package com.kimigayo.gof23.structure.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by chenbinbin on 2018/2/10.
 */
public class SelfInvocationHandle implements InvocationHandler {
    private IArtist artist;

    public Object getProxyInstance(IArtist artist) {
        this.artist = artist;
        return Proxy.newProxyInstance(artist.getClass().getClassLoader(), artist.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入自定义代理");
        method.invoke(artist, args);
        return null;
    }
    public static class SelfInvocationHandleTest{
        public static void main(String[] args) {
            IArtist artist = new Singer();
            System.out.println(artist);
            IArtist iArtist = (IArtist) new SelfInvocationHandle().getProxyInstance(new Singer());
            System.out.println(iArtist);
            iArtist.sing();
        }
    }
}
