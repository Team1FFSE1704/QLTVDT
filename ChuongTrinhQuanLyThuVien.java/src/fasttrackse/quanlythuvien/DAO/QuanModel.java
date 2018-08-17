package fasttrackse.quanlythuvien.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;

import fasttrackse.quanlythuvien.entity.Quan;

public class QuanModel {
	Connection conn = null;

	public QuanModel() {

		this.getConnect("localhost", "quanlythuvien", "truongquangminh", "quangminh123456");
		// if (this.getConn() != null) {
		// System.err.println("Kết nối MYSQL thành công");
		// } else {
		// System.err.println("Kết nối MYSQL thất bại");
		// }

	}

	//
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
	
	public ArrayList<Quan> getDSQuan() {
		ArrayList<Quan> dsQuan = new ArrayList<Quan>();

		try {
			String queryString = "SELECT * FROM quan ";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				
				int maQuan = result.getInt("maQuan");
				String tenQuan = result.getString("tenQuan");

				dsQuan.add(new Quan(maQuan, tenQuan));
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "kết nối quan ko thành công ");
		}

		return dsQuan;
	}
}
