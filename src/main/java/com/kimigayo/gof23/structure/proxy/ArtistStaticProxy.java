package com.kimigayo.gof23.structure.proxy;

/**静态代理
 * Created by chenbinbin on 2018/2/10.
 */
public class ArtistStaticProxy implements IArtist {
    private Singer singer;

    public ArtistStaticProxy(Singer singer) {
        this.singer = singer;
    }

    @Override
    public void sing() {
        singer.sing();
    }

    @Override
    public void dance() {
        singer.dance();
    }

    public static class ArtistStaticProxyTest{
        public static void main(String[] args) {
            ArtistStaticProxy staticProxy = new ArtistStaticProxy(new Singer());
            staticProxy.sing();
            staticProxy.dance();
        }
    }
}
