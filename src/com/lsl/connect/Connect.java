package com.lsl.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ʹ��jdbc����mysql���ݿ�
 * @author Nerokey
 *
 */
public class Connect {

	public static void main(String[] args) {
		
		Connection con = null;
		//����class�ļ�����������
		String driver = "com.mysql.jdbc.Driver";
		//��Ҫ���ӵ�mysql���ݿ��URL
		String url = "jdbc:mysql://localhost:3306/test";
		//���ӵ��û���
		String user = "root";
		//�û���������
		String password = "";
		
		try{
			Class.forName(driver);  //ʹ��Class.forName()��������
			con = DriverManager.getConnection(url, user, password);   //��������
			if(con != null){
				System.out.println("���ӳɹ���");
			}
			else{
				System.out.println("����ʧ�ܣ�");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			//finally������ͷ�����
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
