package com.lsl.operate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ��mysql���ݿ���м򵥵��޸����ݲ���
 * @author Nerokey
 *
 */
public class EditDemo {

	public static void main(String[] args) {

		Connection con = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "";

		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			//����Statement���
			Statement stmt = con.createStatement();
			//����sql���
			String sql = "update students set sex='m' where sid=3;";
			//ʹ��executeUpdate��ִ��sql��䣬�䷵��ֵΪ��Ӱ�������
			int n = stmt.executeUpdate(sql);
			System.out.println(n);
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
