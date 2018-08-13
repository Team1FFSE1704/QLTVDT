package fasttrackse.quanlythuvien.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;

import fasttrackse.quanlythuvien.entity.QuanLySach;

public class QuanLySachModel {
	Connection conn = null;

	public QuanLySachModel() {
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

	public ArrayList<QuanLySach> getDSQuanLySach() {
		ArrayList<QuanLySach> dsSach = new ArrayList<QuanLySach>();

		try {
			String queryString = "SELECT quanlysach.masach, quanlysach.tensach, tacgia.tentacgia, theloaisach.theloaisach, nxb.tenNXB, quanlysach.namXB, quanlysach.soluong\r\n"
					+ "FROM quanlysach\r\n" + "INNER JOIN tacgia\r\n" + "on quanlysach.tacgia = tacgia.matacgia\r\n"
					+ "INNER JOIN theloaisach\r\n" + "ON quanlysach.theloai = theloaisach.matheloai\r\n"
					+ "INNER JOIN nxb\r\n" + "on quanlysach.NXB = nxb.maNXB";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				String maSach = result.getString("masach");
				String tenSach = result.getString("tensach");
				String tacGia = result.getString("tacgia.tentacgia");
				String nhaXuatBan = result.getString("nxb.tenNXB");
				String theLoai = result.getString("theloaisach.theloaisach");
				String namXuatBan = result.getString("namXB");
				String soLuong = result.getString("soluong");

				dsSach.add(new QuanLySach(maSach, tenSach, tacGia, nhaXuatBan, theLoai, namXuatBan, soLuong));
			}

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "kết nối ko thành công ");
		}

		return dsSach;
	}

	// xóa một phần tử trong database
	public void delete(String maSach) {
		try {
			String queryString = "delete from quanlysach where masach=?";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, maSach);

			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Bạn đã xóa thành công ");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Sửa phần tử vào database
	public void edit(QuanLySach qls) {
		try {
			String queryString = "UPDATE quanlysach SET tensach=?, tacgia=?, NXB=? , theloai=?, namXB=?, soluong=?   WHERE masach=?";
			PreparedStatement statement = conn.prepareStatement(queryString);

			statement.setString(1, qls.getTenSach());
			statement.setString(2, qls.getTacGia());
			statement.setString(3, qls.getNhaXuatBan());
			statement.setString(4, qls.getTheLoai());
			statement.setString(5, qls.getNamXuatBan());
			statement.setString(6, qls.getSoLuong());

			statement.setString(7, qls.getMaSach());
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
	public void add(QuanLySach qls) {
		try {
			String queryString = "insert into quanlysach(masach,tensach,tacgia,NXB,theloai,namXB,soluong) values(?,?,?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, qls.getMaSach());
			statement.setString(2, qls.getTenSach());
			statement.setString(3, qls.getTacGia());
			statement.setString(4, qls.getNhaXuatBan());
			statement.setString(5, qls.getTheLoai());
			statement.setString(6, qls.getNamXuatBan());
			statement.setString(7, qls.getSoLuong());

			int x = statement.executeUpdate();
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Bạn đã thêm thành công ");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
