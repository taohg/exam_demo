package com.liangx.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liangx.bean.User;
import com.liangx.service.UserDao;
import com.liangx.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public int addUser(User user) {
		String execSql = "insert into em_user(user_name, user_pass, user_address) values (?, ?, ?)";
		Connection conn = DBUtil.getConn();
		PreparedStatement ptmt = null;
		int cnt=-1;
		try {
			conn.setAutoCommit(false);
			ptmt = conn.prepareStatement(execSql);
			ptmt.setString(1, user.getUserName());
			ptmt.setString(2, user.getUserPass());
			ptmt.setString(3, user.getUserAddress());
			cnt = ptmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ptmt != null)
					ptmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBUtil.closeConn(conn);
		}
		if(cnt > 0)
			System.out.println("新增用户成功！！");
		return cnt;
	}

	@Override
	public User getUser(String userName) {
		String execSql = "select user_name, user_pass, user_address from em_user where user_name = ?";
		Connection conn = DBUtil.getConn();
		PreparedStatement ptmt = null;
		ResultSet rst = null;
		User user = new User();
		
		try {
			ptmt = conn.prepareStatement(execSql);
			ptmt.setString(1, userName);
			rst = ptmt.executeQuery();
			
			while(rst.next()) {
				user.setUserName(rst.getString("user_name"));
				user.setUserPass(rst.getString("user_pass"));
				user.setUserAddress(rst.getString("user_address"));
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rst != null)
					rst.close();
				if(ptmt != null)
					ptmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBUtil.closeConn(conn);
		}
		System.out.println("查询的用户信息" + user);
		return user;
	}

	@Override
	public List getAllUser() {
		String execSql = "select user_name, user_pass, user_address from em_user";
		Connection conn = DBUtil.getConn();
		PreparedStatement ptmt = null;
		ResultSet rst = null;
		List list = new ArrayList();
		User user = null;
		
		try {
			ptmt = conn.prepareStatement(execSql);
			rst = ptmt.executeQuery();
			while(rst.next()) {
				user = new User();
				user.setUserName(rst.getString("user_name"));
				user.setUserPass(rst.getString("user_pass"));
				user.setUserAddress(rst.getString("user_address"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rst != null)
					rst.close();
				if(ptmt != null)
					ptmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBUtil.closeConn(conn);
		}
		return null;
	}

}
