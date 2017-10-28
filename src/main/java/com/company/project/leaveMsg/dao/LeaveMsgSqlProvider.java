package com.company.project.leaveMsg.dao;

import com.company.project.leaveMsg.model.LeaveMsg;
import org.apache.ibatis.jdbc.SQL;

public class LeaveMsgSqlProvider {

    public String insertSelective(LeaveMsg record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("tb_leavemsg");
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getPhoneNo() != null) {
            sql.VALUES("phoneNo", "#{phoneNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCity() != null) {
            sql.VALUES("city", "#{city,jdbcType=VARCHAR}");
        }
        
        if (record.getBedRoomCunt() != null) {
            sql.VALUES("bedRoomCunt", "#{bedRoomCunt,jdbcType=VARCHAR}");
        }
        
        if (record.getLivingRoomCnt() != null) {
            sql.VALUES("livingRoomCnt", "#{livingRoomCnt,jdbcType=VARCHAR}");
        }
        
        if (record.getBathRoomCnt() != null) {
            sql.VALUES("bathRoomCnt", "#{bathRoomCnt,jdbcType=VARCHAR}");
        }
        
        if (record.getArea() != null) {
            sql.VALUES("area", "#{area,jdbcType=VARCHAR}");
        }
        
        if (record.getProduct() != null) {
            sql.VALUES("product", "#{product,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }
}