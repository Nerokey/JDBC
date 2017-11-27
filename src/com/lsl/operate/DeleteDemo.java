package com.lsl.operate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ��mysql���ݿ���м򵥵�ɾ�����ݲ���
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
			//����Statement���
			Statement stmt = con.createStatement();
			//����sql���
			String sql = "delete from students where sid=4;";
			//ʹ��executeUpdate��ִ��sql��䣬�䷵��ֵΪ��Ӱ�������
			int n = stmt.executeUpdate(sql);
			if(n != 0){
				System.out.println("�ɹ�ɾ��"+n+"��ѧ��");
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
