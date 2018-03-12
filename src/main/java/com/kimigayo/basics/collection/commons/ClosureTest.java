package com.kimigayo.basics.collection.commons;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.ClosureUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.ChainedClosure;
import org.apache.commons.collections4.functors.IfClosure;
import org.apache.commons.collections4.functors.WhileClosure;

import java.util.Iterator;
import java.util.List;

public class ClosureTest {
    public static void main(String[] args) {
        Person p1 = new Person("马云",true,1234557);
        Person p2 = new Person("马化腾",true,1234556);
        Person p3 = new Person("李彦宏",true,1234555);
        Person p4 = new Person("自己",false,1234);
        List<Person> list = Lists.newArrayList(p1,p2,p3,p4);

        Closure<Person> closure = new Closure<Person>(){
            @Override
            public void execute(Person s) {
                s.setSalary(s.getSalary()*1.2);
            }
        };
        Closure<Person> closure2 = new Closure<Person>(){
            @Override
            public void execute(Person s) {
                s.setSalary(s.getSalary()+100);
            }
        };
        Predicate<Person> ifpredicate = new Predicate<Person>() {
            @Override
            public boolean evaluate(Person o) {
                return o.isBoss();
            }
        };
        Predicate<Person> whilepredicate = new Predicate<Person>() {
            @Override
            public boolean evaluate(Person o) {
                return o.getSalary()<10000;
            }
        };
//        Closure closure1 = IfClosure.ifClosure(ifpredicate,ClosureUtils.nopClosure(),closure);
        //第三个参数决定true=while，false=do while
//        Closure closure1 = WhileClosure.whileClosure(whilepredicate,closure,false);
        Closure closure1 = ChainedClosure.chainedClosure(closure,closure2);
        CollectionUtils.forAllDo(list,closure1);
        Iterator iterator=list.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());
    }
}
