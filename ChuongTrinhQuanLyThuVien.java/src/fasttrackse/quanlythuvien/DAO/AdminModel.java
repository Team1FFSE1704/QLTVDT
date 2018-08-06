package fasttrackse.quanlythuvien.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.Driver;

import fasttrackse.quanlythuvien.entity.Admin;

public class AdminModel {
	Connection conn = null;

	public AdminModel() {
		this.getConnect("localhost", "quanlythuvien", "truongquangminh", "quangminh123456");
		if (this.getConn() != null) {
			System.err.println("Kết nối MYSQL thành công");
		} else {
			System.err.println("Kết nối MYSQL thất bại");
		}
	}

	public void stopConnect() {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public void getConnect(String strServer, String strDatabase, String strUser, String strPwd) {

		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase
				+ "?useUnicode=true&characterEncoding=utf-8";
		Properties pro = new Properties();
		pro.put("user", strUser);
		pro.put("password", strPwd);
		try {
			com.mysql.jdbc.Driver driver = new Driver();
			conn = driver.connect(strConnect, pro);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public ArrayList<Admin> getDSAdmin() {
		ArrayList<Admin> dsAdmin= new ArrayList<Admin>();

		try {
			String queryString = "SELECT * FROM admin";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				String tenAdmin= result.getString("username");
				

				dsAdmin.add(new Admin( tenAdmin));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsAdmin;
	}
}
