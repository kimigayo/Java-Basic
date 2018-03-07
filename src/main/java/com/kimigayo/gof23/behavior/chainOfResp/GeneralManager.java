package com.kimigayo.gof23.behavior.chainOfResp;

public class GeneralManager extends Leader{
    @Override
    public void handlerRequest(LeaveRequest request) {

        if(request.getLeaveDay()<6){
            System.out.println(super.name+":處理三天以下請假申請--");
        }else {
            super.nextLeader.handlerRequest(request);
        }
    }

    public GeneralManager(String name) {
        super(name);
    }
}
