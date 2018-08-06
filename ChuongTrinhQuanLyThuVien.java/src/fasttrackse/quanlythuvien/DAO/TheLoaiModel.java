package fasttrackse.quanlythuvien.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.Driver;

import fasttrackse.quanlythuvien.entity.NhaXuatBan;
import fasttrackse.quanlythuvien.entity.TheLoai;

public class TheLoaiModel {
	Connection conn = null;

	public TheLoaiModel() {
		this.getConnect("localhost", "quanlythuvien", "truongquangminh", "quangminh123456");
//		if (this.getConn() != null) {
//			System.err.println("Kết nối MYSQL thành công");
//		} else {
//			System.err.println("Kết nối MYSQL thất bại");
//		}
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

	public ArrayList<TheLoai> getDSTheLoai() {
		ArrayList<TheLoai> dsTheLoai = new ArrayList<TheLoai>();

		try {
			String queryString = "SELECT * FROM theloaisach";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				String maTheLoai = result.getString("matheloai");
				String tenTheLoai = result.getString("theloaisach");

				dsTheLoai.add(new TheLoai(maTheLoai, tenTheLoai));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsTheLoai;
	}
}
