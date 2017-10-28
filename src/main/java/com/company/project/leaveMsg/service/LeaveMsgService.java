package com.company.project.leaveMsg.service;

import com.company.project.leaveMsg.dao.LeaveMsgMapper;
import com.company.project.leaveMsg.model.LeaveMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveMsgService {

    @Autowired
    LeaveMsgMapper leaveMsgMapper;

    public List<LeaveMsg> queryAllMsgData(){
        List<LeaveMsg> leaveMsgList = leaveMsgMapper.queryAllMsgData();
        return leaveMsgList;
    }

    public int insertMsgInfo(LeaveMsg leaveMsg){
        int status = leaveMsgMapper.insertMsgInfo(leaveMsg);
        return status;
    }
}
