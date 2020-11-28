package com.atguigu.dao.impl;

import java.sql.SQLException;
import java.util.List;
import com.atguigu.pojo.*;
import com.atguigu.util.DBUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class dao {
	
    public static List<Province> getWorldData_() throws SQLException {
        QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
        String sql = "select * from provinces  order by confirm desc";
        List<Province> query = qr.query(sql, new BeanListHandler<Province>(Province.class));
        return query;
    }
    
  
    public static List<Province> getWorldData_1() throws SQLException {
        QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
        String sql = "select * from provinces  order by heal desc";
        List<Province> query = qr.query(sql, new BeanListHandler<Province>(Province.class));
        return query;
    }
    
  
    public static List<Province> getWorldData_2() throws SQLException {
        QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
        String sql = "select * from provinces  order by dead desc";
        List<Province> query = qr.query(sql, new BeanListHandler<Province>(Province.class));
        return query;
    }

   /*
    public List<Total> getWorldinfo() throws SQLException {
        QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
        String sql = "select * from provinces  order by confirm desc";
        List<Total> query = qr.query(sql, new BeanListHandler<Total>(Total.class));
        return query;
    }
*/
   
    public static List<Province> getWorldData_H() throws SQLException {
        QueryRunner qr = new QueryRunner(DBUtils.getDataSource());
        String sql = "select * from world";
        List<Province> query = qr.query(sql, new BeanListHandler<Province>(Province.class));
        return query;
    }
}
