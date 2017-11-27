package com.lsl.operate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 对mysql数据库进行简单的查询数据操作
 * @author Nerokey
 *
 */
public class SelectDemo {

	public static void main(String[] args) {
		
		Connection con = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "";

		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			//创建Statement语句
			Statement stmt = con.createStatement();
			//定义sql语句
			String sql = "select * from students;";
			//使用executeQuery执行sql语句，其返回值为ResultSet的预定义对象，使用while循环遍历
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("sid\tsname\tsex");
			System.out.println("-------------------");
			while(rs.next()){
				int no = rs.getInt(1);
				String name = rs.getString("sname");
				String sex = rs.getString("sex");
				System.out.println(no+"\t"+name+"\t"+sex);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
