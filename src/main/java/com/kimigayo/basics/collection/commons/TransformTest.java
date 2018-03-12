package com.kimigayo.basics.collection.commons;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;

public class TransformTest {
    public static void main(String[] args) {
        Transformer transformer = new Transformer<Long,String>(){

            @Override
            public String transform(Long aLong) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd");
                return dateFormat.format(aLong);
            }
        };
        List<Long> list = Lists.newArrayList(1111111111111l,222222222222222l);
        Collection<String> collection = CollectionUtils.collect(list,transformer);
        for(String s :collection)
            System.out.println(s);
    }
}
