package com.liangx.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liangx.bean.User;
import com.liangx.service.UserDao;
import com.liangx.service.impl.UserDaoImpl;
import com.liangx.util.StringUtil;

public class UserAddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("error_msg");
		session.removeAttribute("succ_msg");
		req.setCharacterEncoding("UTF-8");
		resp.setHeader("content-type", "text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8"); 
		String userName = req.getParameter("userName");
		String userPass = req.getParameter("userPass");
		
		
		System.out.println("------------userName:" + userName + "-----userPass:" + userPass);
		User user = new User();
		if(StringUtil.isEmpty(userName)) {
			session.setAttribute("error_msg", "注册用户名不能为空！");
//			resp.sendRedirect("register.jsp");
			req.getRequestDispatcher("/page/register.jsp").forward(req, resp);
			return;
		}
		if(StringUtil.isEmpty(userPass)) {
			session.setAttribute("error_msg", "注册用户密码不能为空！");
//			resp.sendRedirect("register.jsp");
			req.getRequestDispatcher("/page/register.jsp").forward(req, resp);
			return;
		}
		user.setUserName(userName);
		user.setUserPass(userPass);
		UserDao uDao = new UserDaoImpl();
		uDao.addUser(user);
//		resp.sendRedirect("login.jsp");
		req.getRequestDispatcher("/page/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
