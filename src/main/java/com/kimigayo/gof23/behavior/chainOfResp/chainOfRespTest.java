package com.kimigayo.gof23.behavior.chainOfResp;

/**
 * 责任链模式
 * 应用场景：java中异常机制的处理、servlet中过滤器的链式处理
 */
public class chainOfRespTest {
    public static void main(String[] args) {
        Leader leader1 = new Director("主管");
        Leader leader2 = new GeneralManager("經理");
        Leader leader3 = new Manager("總監");
        leader1.setNextLeader(leader2);
        leader2.setNextLeader(leader3);
        LeaveRequest request = new LeaveRequest("張三",6,"隨便請假一下");
        leader1.handlerRequest(request);
    }
}
