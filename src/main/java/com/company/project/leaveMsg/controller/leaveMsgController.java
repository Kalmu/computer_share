package com.company.project.leaveMsg.controller;

import com.company.project.leaveMsg.dao.LeaveMsgMapper;
import com.company.project.leaveMsg.model.LeaveMsg;
import com.company.project.leaveMsg.service.LeaveMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/leaveMsg")
public class leaveMsgController {
    @Autowired
    LeaveMsgService leaveMsgService;

    @GetMapping("/queryAllMsgData")
    public List<LeaveMsg> queryAllMsgData(){
        List<LeaveMsg> leaveMsgList = leaveMsgService.queryAllMsgData();
        return leaveMsgList;
    }

    @PostMapping("/insertMsgInfo")
    public int insertMsgInfo(@NotNull@RequestBody LeaveMsg leaveMsg){
        int status = leaveMsgService.insertMsgInfo(leaveMsg);
        return status;
    }
}
