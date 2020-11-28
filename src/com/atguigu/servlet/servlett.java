package com.atguigu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.atguigu.dao.impl.dao;
import com.atguigu.dao.impl.mapper;
import com.atguigu.pojo.Province;
import com.google.gson.Gson;

/**
 * Servlet implementation class servlet
 */
public class servlett extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlett() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String method=request.getParameter("method");
	if(method.equals("total")) {
		try {
			total(request,response);

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	else if(method.equals("histroy"))
		try {
			history(request,response);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	else
		try {
			world_dt(request,response);
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

	/**
     * @param request
     * @param response
     */
    private void world_dt(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
   
    	System.out.println("------world----");

        List<Province> list = mapper.getConfirmed();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        response.getWriter().write(json);
    }

    /**
     * @param request
     * @param response
     */
    private void history(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
    	
        List<Province> list = mapper.getWorld();
    	System.out.println("------history----");

        Gson gson = new Gson();
        String json = gson.toJson(list);
        response.getWriter().write(json);
    }

    /**
     * @param request
     * @param response
     */
    private void total(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException {
    
    	System.out.println("------total----");
    	
        List<Province> confirmList = mapper.getConfirmed();
        List<Province> HealList = mapper.getHealed();
        List<Province> DeadList = mapper.getDead();
        int count = 0;
        int DeadCount = 0;
        int HealCount = 0;
        for (Province total : confirmList) {
            count += Integer.parseInt(total.getConfirm());
            DeadCount += Integer.parseInt(total.getDead());
            HealCount += Integer.parseInt(total.getHeal());
        }
        request.setAttribute("connfirmList", confirmList);
        request.setAttribute("healList", HealList);
        request.setAttribute("DeadList", DeadList);
        request.setAttribute("Total", count);
        request.setAttribute("Dead", DeadCount);
        request.setAttribute("Healed", HealCount);
        request.getRequestDispatcher("world.jsp").forward(request, response);
    }
}
