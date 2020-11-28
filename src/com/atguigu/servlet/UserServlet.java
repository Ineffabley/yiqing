package com.atguigu.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.dao.impl.dao;
import com.atguigu.pojo.Province;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.util.Utils;
import com.google.gson.Gson;

public class UserServlet  {
	private static final long serialVersionUID = 1L;

	 
	    private void world_dt(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
	        List<Province> list = dao.getWorldData_();
	        Gson gson = new Gson();
	        String json = gson.toJson(list);
	        response.getWriter().write(json);
	    }

	    /**
	     * @param request
	     * @param response
	     */
	    private void history(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
	        List<Province> list = dao.getWorldData_H();
	        Gson gson = new Gson();
	        String json = gson.toJson(list);
	        response.getWriter().write(json);
	    }

	    /**
	     * @param request
	     * @param response
	     */
	    private void total(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
	        List<Province> list = dao.getWorldData_();
	        List<Province> list_1 = dao.getWorldData_1();
	        List<Province> list_2 = dao.getWorldData_2();
	        int allTotal = 0;
	        int allDead = 0;
	        int allHeal = 0;
	        for (Province total : list) {
	            allTotal += Integer.parseInt(total.getConfirm());
	            allDead += Integer.parseInt(total.getDead());
	            allHeal += Integer.parseInt(total.getHeal());
	        }
	        request.setAttribute("list", list);
	        request.setAttribute("list_1", list_1);
	        request.setAttribute("list_2", list_2);
	        request.setAttribute("allTotal", allTotal);
	        request.setAttribute("allDead", allDead);
	        request.setAttribute("allHeal", allHeal);
	        request.getRequestDispatcher("worldyq.jsp").forward(request, response);
	    }

}
