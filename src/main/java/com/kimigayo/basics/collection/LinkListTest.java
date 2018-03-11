package com.kimigayo.basics.collection;

public class LinkListTest {
    public static void main(String[] args) throws Exception {
        SelfLinkList list = new SelfLinkList();
        list.add("软件园");
        list.add("明发商业广场");
        list.add("万达广场");
        list.add("蔡塘广场");
        list.add(1);
        list.add(2);
        list.remove(1);
        System.out.println(list.getSize());
        for(int i=0;i<list.getSize();i++){
            System.out.println(list.get(i));
        }
    }
}
