package com.kimigayo.gof23.behavior.chainOfResp;

public class Manager extends Leader {
    public Manager(String name) {
        super(name);
    }

    @Override
    public void handlerRequest(LeaveRequest request) {

        if(request.getLeaveDay()<9){
            System.out.println(super.name+":處理三天以下請假申請--");
        }else {
            super.nextLeader.handlerRequest(request);
        }
    }
}
