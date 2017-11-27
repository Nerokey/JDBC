package com.lsl.operate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ��mysql���ݿ���м򵥵Ĳ�ѯ���ݲ���
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
			//����Statement���
			Statement stmt = con.createStatement();
			//����sql���
			String sql = "select * from students;";
			//ʹ��executeQueryִ��sql��䣬�䷵��ֵΪResultSet��Ԥ�������ʹ��whileѭ������
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
