package com.kimigayo.gof23.structure.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**动态代理
 * Created by chenbinbin on 2018/2/10.
 */
public class ArtistDynamicProxy {
    private IArtist artist;

    public ArtistDynamicProxy(IArtist artist) {
        this.artist = artist;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(artist.getClass().getClassLoader(), artist.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("进入动态代理");
                method.invoke(artist,args);
                return null;
            }
        });
    }

    public static class ArtistDynamicProxyTest{
        public static void main(String[] args) {
            IArtist singer = new Singer();
            System.out.println(singer);
            IArtist artist = (IArtist) new ArtistDynamicProxy(singer).getProxyInstance();
            System.out.println(artist);
            artist.sing();
        }
    }
}
