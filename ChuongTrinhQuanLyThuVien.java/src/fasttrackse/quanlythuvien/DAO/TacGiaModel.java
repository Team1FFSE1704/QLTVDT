package fasttrackse.quanlythuvien.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;

import fasttrackse.quanlythuvien.entity.TacGia;

public class TacGiaModel {
	Connection conn = null;

	public TacGiaModel() {
		//this.getConnect("localhost", "quanlythuvien", "truongquangminh", "quangminh123456"	 );
		this.getConnect("localhost", "team1_qlthuvien", "team1qltvdt", "team1qltvdt");
//		if (this.getConn() != null) {
//			System.err.println("Kết nối MYSQL thành công");
//		} else {
//			System.err.println("Kết nối MYSQL thất bại");
//		}
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

	public ArrayList<TacGia> getDSTacGia() {
		ArrayList<TacGia> dsTacGia = new ArrayList<TacGia>();

		try {
			String queryString = "SELECT * FROM tacgia";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				String maTacGia = result.getString("matacgia");
				String tenTacGia = result.getString("tentacgia");

				dsTacGia.add(new TacGia(maTacGia, tenTacGia));
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "kết nối ko thành công ");
		}

		return dsTacGia;
	}
	
	//xóa một phần tử trong database
	public void delete(String maTacGia) {
		try {
			String queryString = "delete from tacgia where matacgia=?";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, maTacGia);

			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Bạn đã xóa thành công ");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// thêm phần tử vào database
		public void edit(TacGia tg) {
			try {
				String queryString = "UPDATE tacgia SET tentacgia=? WHERE matacgia=?";
				PreparedStatement statement = conn.prepareStatement(queryString);

				statement.setString(1, tg.getTenTacGia());
				statement.setString(2, tg.getMaTacGia());
				int x = statement.executeUpdate();
				if (x > 0) {
					JOptionPane.showMessageDialog(null, "Bạn đã update thành công ");
				} else {
					System.out.println("chưa được");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		// thêm một phần tử vào database
		public void add(TacGia tg) {
			try {
				String queryString = "insert into tacgia(matacgia,tentacgia) values(?,?)";
				PreparedStatement statement = conn.prepareStatement(queryString);
				statement.setString(1, tg.getMaTacGia());
				statement.setString(2, tg.getTenTacGia());

				int x = statement.executeUpdate();
				if (x > 0) {
					JOptionPane.showMessageDialog(null, "Bạn đã thêm thành công ");
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
}
