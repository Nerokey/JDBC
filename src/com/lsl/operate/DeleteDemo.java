package com.lsl.operate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 对mysql数据库进行简单的删除数据操作
 * @author Nerokey
 *
 */
public class DeleteDemo {

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
			String sql = "delete from students where sid=4;";
			//使用executeUpdate来执行sql语句，其返回值为受影响的行数
			int n = stmt.executeUpdate(sql);
			if(n != 0){
				System.out.println("成功删除"+n+"个学生");
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
