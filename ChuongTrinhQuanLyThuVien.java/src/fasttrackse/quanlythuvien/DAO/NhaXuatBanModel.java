package fasttrackse.quanlythuvien.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;

import fasttrackse.quanlythuvien.entity.NhaXuatBan;

public class NhaXuatBanModel {
	Connection conn = null;

	public NhaXuatBanModel() {
		this.getConnect("localhost", "quanlythuvien", "truongquangminh", "quangminh123456");

		// if (this.getConn() != null) {
		// System.err.println("Kết nối MYSQL thành công");
		// } else {
		// System.err.println("Kết nối MYSQL thất bại");
		// }
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

	// show thông tin trong database
	public ArrayList<NhaXuatBan> getDSNhaXuatBan() {
		ArrayList<NhaXuatBan> dsNhaXuatBan = new ArrayList<NhaXuatBan>();

		try {
			String queryString = "SELECT * FROM nxb";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				String maNhaXuatBan = result.getString("maNXB");
				String tenNhaXuatBan = result.getString("tenNXB");

				dsNhaXuatBan.add(new NhaXuatBan(maNhaXuatBan, tenNhaXuatBan));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsNhaXuatBan;
	}

	// xóa phần tử trong database
	public void delete(String id) {
		try {
			String queryString = "delete from nxb where maNXB=?";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, id);

			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Bạn đã xóa thành công ");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// thêm phần tử vào database
	public void edit(NhaXuatBan nxb) {
		try {
			String queryString = "UPDATE nxb SET  tenNXB=? WHERE maNXB=?";
			PreparedStatement statement = conn.prepareStatement(queryString);

			statement.setString(1, nxb.getTenNhaXuatBan());
			statement.setString(2, nxb.getMaNhaXuatBan());
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
	public void addNXB(NhaXuatBan nxb) {
		try {
			String queryString = "insert into nxb(maNXB,tenNXB) values(?,?)";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, nxb.getMaNhaXuatBan());
			statement.setString(2, nxb.getTenNhaXuatBan());

			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Bạn đã thêm thành công ");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}