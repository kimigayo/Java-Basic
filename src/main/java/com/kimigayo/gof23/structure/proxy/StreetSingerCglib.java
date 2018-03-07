package com.kimigayo.gof23.structure.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**动态代理
 * Created by chenbinbin on 2018/2/10.
 */
public class StreetSingerCglib implements MethodInterceptor {
    private StreetSinger singer;

    public StreetSingerCglib(StreetSinger singer) {
        this.singer = singer;
    }

    public Object getProxyInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(singer.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("进入cglib代理");
        method.invoke(singer,objects);
        return null;
    }
    public static class StreetSingerCglibTest{
        public static void main(String[] args) {
            StreetSinger singer = (StreetSinger) new StreetSingerCglib(new StreetSinger()).getProxyInstance();
            singer.sing();
        }
    }
}
