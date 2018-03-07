package com.kimigayo.gof23.behavior.chainOfResp;

public class Director extends Leader {
    public Director(String name) {
        super(name);
    }

    @Override
    public void handlerRequest(LeaveRequest request) {
        if(request.getLeaveDay()<3){
            System.out.println(super.name+"：處理三天以下請假申請--");
        }else {
            super.nextLeader.handlerRequest(request);
        }
    }
}
