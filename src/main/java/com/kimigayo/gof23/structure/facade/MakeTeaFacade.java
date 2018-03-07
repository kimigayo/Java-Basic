package com.kimigayo.gof23.structure.facade;

/**
 * 外观模式
 * 核心概念：封装子系统的复杂性，便于客户调用
 * 应用场景：commons提供的DBUtil类，Hibernate提供的工具类，Spring JDBC提供的工具类
 */
public class MakeTeaFacade {
    public void makeTea(){
        new Fountain().BoilWater();
        new DragonWellTeaLeaf().pickTeaLeaf();
        new CeramicTeaSet().putTeaSet();
    }
    public static class MakeTeaFacadeTest{
        public static void main(String[] args) {
            new MakeTeaFacade().makeTea();
        }
    }
}
