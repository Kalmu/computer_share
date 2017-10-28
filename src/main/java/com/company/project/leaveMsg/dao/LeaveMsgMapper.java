package com.company.project.leaveMsg.dao;

import com.company.project.leaveMsg.model.LeaveMsg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LeaveMsgMapper {
    @Insert({
        "insert into tb_leavemsg (name, phoneNo, ",
        "city, bedRoomCunt, ",
        "livingRoomCnt, bathRoomCnt, ",
        "area, product)",
        "values (#{name,jdbcType=VARCHAR}, #{phoneNo,jdbcType=VARCHAR}, ",
        "#{city,jdbcType=VARCHAR}, #{bedRoomCunt,jdbcType=VARCHAR}, ",
        "#{livingRoomCnt,jdbcType=VARCHAR}, #{bathRoomCnt,jdbcType=VARCHAR}, ",
        "#{area,jdbcType=VARCHAR}, #{product,jdbcType=VARCHAR})"
    })
    int insertMsgInfo(LeaveMsg record);

    @InsertProvider(type=LeaveMsgSqlProvider.class, method="insertSelective")
    int insertSelective(LeaveMsg record);

    @Select("SELECT name, phoneNo, city, bedRoomCunt, livingRoomCnt, bathRoomCnt, area, product FROM tb_leaveMsg")
    @ResultType(LeaveMsg.class)
    List<LeaveMsg> queryAllMsgData();
}