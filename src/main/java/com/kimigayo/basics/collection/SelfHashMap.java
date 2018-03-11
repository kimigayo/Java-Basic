package com.kimigayo.basics.collection;

import java.util.LinkedList;

public class SelfHashMap<K, V> {
    private LinkedList[] list = new LinkedList[999];
    private int size;

    private int getIndex(K key) {
        return (key.hashCode()) % this.list.length;
    }

    public void put(K key, V value) {
        int index = this.getIndex(key);
        if (null == list[index]) {
            LinkedList list = new LinkedList();
            SelfEntryKey entryKey = new SelfEntryKey(key, value);
            list.add(entryKey);
            this.list[index] = list;
            this.size++;
        } else {
            LinkedList list = this.list[index];
            for (int i = 0; i < list.size(); i++) {
                SelfEntryKey<K, V> entryKey = (SelfEntryKey) list.get(i);
                if (key == entryKey.getKey() || entryKey.getKey().equals(key)) {
                    entryKey.setValue(value);
                    return;
                }
            }
            SelfEntryKey entryKey = new SelfEntryKey(key, value);
            list.add(entryKey);
            this.size++;
        }
    }

    public V get(K key) {
        int index = getIndex(key);
        if (null != this.list[index]) {
            LinkedList list = this.list[index];
            for (int i = 0; i < list.size(); i++) {
                SelfEntryKey<K, V> entryKey = (SelfEntryKey) list.get(i);
                if (key == entryKey.getKey() || entryKey.getKey().equals(key)) {
                    return entryKey.getValue();
                }
            }
        }
        return null;
    }

    class SelfEntryKey<K, V> {
        private K key;
        private V value;


        public SelfEntryKey(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        SelfHashMap<String,String> map = new SelfHashMap<String,String>();
        map.put("张三","李四");
        map.put("张三","王五");
        map.put("张三","李斯");
        map.put("张一毛","一毛流浪记");
        System.out.println(map.size);
        System.out.println(map.get("张三"));
        System.out.println(map.get("张一毛"));
    }
}
