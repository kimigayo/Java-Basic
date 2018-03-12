package com.kimigayo.basics.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class CollectionTest {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("望海路","61号");
        map.put("观日路","20号");
        Map map1 = Collections.synchronizedMap(map);//使map支持线程同步
        Map map2 = Collections.unmodifiableMap(map);//使map不可修改，Collections设置相当于快照，不够安全
//        map2.put("金山路","101号");
        map.put("金山路","101号");
        System.out.println(map.size());
        Map  map3 = Collections.singletonMap("观日路","21号");
//        map3.put("望海路","62号");
    }
}
