package com.atguigu.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.dao.impl.dao;
import com.atguigu.pojo.Province;
import com.google.gson.Gson;

/**
 * Servlet implementation class data
 */
public class data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public data() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			total(request,response);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
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
