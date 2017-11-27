package com.lsl.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 使用jdbc连接mysql数据库
 * @author Nerokey
 *
 */
public class Connect {

	public static void main(String[] args) {
		
		Connection con = null;
		//驱动class文件的完整包名
		String driver = "com.mysql.jdbc.Driver";
		//需要连接的mysql数据库的URL
		String url = "jdbc:mysql://localhost:3306/test";
		//连接的用户名
		String user = "root";
		//用户名的密码
		String password = "";
		
		try{
			Class.forName(driver);  //使用Class.forName()加载驱动
			con = DriverManager.getConnection(url, user, password);   //建立连接
			if(con != null){
				System.out.println("连接成功！");
			}
			else{
				System.out.println("连接失败！");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			//finally语句中释放连接
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
