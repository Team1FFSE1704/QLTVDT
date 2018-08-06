package fasttrackse.team1.qlthuviendientu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;

import fasttrackse.team1.qlthuviendientu.entyti.TacGia;

public class TacGiaDAO {
//	Connection conn = null;
//
//	// kết nối database
//	public TacGiaDAO() {
//		this.getConnect("localhost", "team1_qlthuvien", "team1qltvdt", "team1qltvdt");
//	}
//
//	// ngắt kết nối database
//	public void disConnection() {
//		if (conn != null) {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//
//				e.printStackTrace();
//			}
//		}
//	}
//
//	public Connection getConn() {
//		return conn;
//	}
//
//	public void setConn(Connection conn) {
//		this.conn = conn;
//	}
//
//	public void getConnect(String strServer, String strDatabase, String strUser, String strPwd) {
//
//		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase
//				+ "?useUnicode=true&characterEncoding=utf-8";
//		Properties pro = new Properties();
//		pro.put("user", strUser);
//		pro.put("password", strPwd);
//		try {
//			com.mysql.jdbc.Driver driver = new Driver();
//			conn = driver.connect(strConnect, pro);
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//
//	}
//	
//	
//	public ArrayList<TacGia> getDSTacGia() {
//		ArrayList<TacGia> dsTacGia = new ArrayList<TacGia>();
//
//		try {
//			String queryString = "SELECT * FROM tacgia";
//			PreparedStatement statement = conn.prepareStatement(queryString);
//
//			ResultSet result = statement.executeQuery();
//
//			while (result.next()) {
//
//				String maTacGia = result.getString("matacgia");
//				String tenTacGia = result.getString("tentacgia");
//
//				dsTacGia.add(new TacGia(maTacGia, tenTacGia));
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			JOptionPane.showMessageDialog(null, "kết nối ko thành công ");
//		}
//
//		return dsTacGia;
//	}
//	
//	
//	public void delete(String maTacGia) {
//		try {
//			String queryString = "delete from tacgia where matacgia=?";
//			PreparedStatement statement = conn.prepareStatement(queryString);
//			statement.setString(1, maTacGia);
//
//			int x = statement.executeUpdate();
//			if (x > 0) {
//				JOptionPane.showMessageDialog(null, "Bạn đã xóa thành công ");
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}
}
