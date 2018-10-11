package fasttrackse.quanlythuvien.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;

import fasttrackse.quanlythuvien.entity.Quan;
import fasttrackse.quanlythuvien.entity.ThanhVien;

public class QuanLyThanhVienDAO {

	Connection conn = null;

	public QuanLyThanhVienDAO() {

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

	// danh sách thành viên
	public ArrayList<ThanhVien> getDSThanhVien() {
		ArrayList<ThanhVien> dsTV = new ArrayList<ThanhVien>();

		try {
			String queryString = "SELECT thanhvien.MaThanhVien, thanhvien.HoTenThanhVien, thanhvien.DiaChi, phuong.tenphuong, quan.tenquan, tinh_thanhpho.tentinh, thanhvien.SDT, thanhvien.Mail \r\n"
					+ "FROM thanhvien\r\n" + "INNER JOIN phuong\r\n"
					+ "ON (thanhvien.Phuong = phuong.maphuong and thanhvien.quan = phuong.quan and thanhvien.tp = phuong.thanhpho)\r\n"
					+ "INNER JOIN quan\r\n" + "ON (thanhvien.Quan = quan.maquan and thanhvien.TP = quan.thanhpho)\r\n"
					+ "INNER JOIN tinh_thanhpho\r\n" + "ON thanhvien.TP = tinh_thanhpho.matinh";
			java.sql.PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				String maTV = result.getString("MaThanhVien");
				String tenTV = result.getString("HoTenThanhVien");
				String soNha = result.getString("thanhvien.DiaChi");
				String phuong = result.getString("tenphuong");
				String quan = result.getString("tenquan");
				String tinh = result.getString("tentinh");
				String sdt = result.getString("SDT");
				String email = result.getString("Mail");

				dsTV.add(new ThanhVien(maTV, tenTV, soNha, phuong, quan, tinh, sdt, email));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsTV;
	}

	// tìm theo quận
	public ArrayList<ThanhVien> getDSSearchQuan(String SearchQuan) {
		ArrayList<ThanhVien> dsSearchQuan = new ArrayList<ThanhVien>();

		try {
			String queryString = "SELECT thanhvien.MaThanhVien, thanhvien.HoTenThanhVien, thanhvien.DiaChi, phuong.tenphuong, quan.tenquan, tinh_thanhpho.tentinh, thanhvien.SDT, thanhvien.Mail \r\n"
					+ "FROM thanhvien\r\n" + "INNER JOIN phuong\r\n"
					+ "ON (thanhvien.Phuong = phuong.maphuong and thanhvien.quan = phuong.quan and thanhvien.tp = phuong.thanhpho)\r\n"
					+ "INNER JOIN quan\r\n" + "ON (thanhvien.Quan = quan.maquan and thanhvien.TP = quan.thanhpho)\r\n"
					+ "INNER JOIN tinh_thanhpho\r\n"
					+ "ON thanhvien.TP = tinh_thanhpho.matinh WHERE quan.tenquan LIKE ?";
			java.sql.PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, "%" + SearchQuan + "%");
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				String maTV = result.getString("MaThanhVien");
				String tenTV = result.getString("HoTenThanhVien");
				String soNha = result.getString("thanhvien.DiaChi");
				String phuong = result.getString("tenphuong");
				String quan = result.getString("tenquan");
				String tinh = result.getString("tentinh");
				String sdt = result.getString("SDT");
				String email = result.getString("Mail");

				dsSearchQuan.add(new ThanhVien(maTV, tenTV, soNha, phuong, quan, tinh, sdt, email));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsSearchQuan;
	}

	// tìm theo mã thành viên
	public ArrayList<ThanhVien> getDSSearchThanhVien(String SearchMaThanhVien) {
		ArrayList<ThanhVien> dsSearchMaThanhVien = new ArrayList<ThanhVien>();

		try {
			String queryString = "SELECT thanhvien.MaThanhVien, thanhvien.HoTenThanhVien, thanhvien.DiaChi, phuong.tenphuong, quan.tenquan, tinh_thanhpho.tentinh, thanhvien.SDT, thanhvien.Mail \r\n"
					+ "FROM thanhvien\r\n" + "INNER JOIN phuong\r\n"
					+ "ON (thanhvien.Phuong = phuong.maphuong and thanhvien.quan = phuong.quan and thanhvien.tp = phuong.thanhpho)\r\n"
					+ "INNER JOIN quan\r\n" + "ON (thanhvien.Quan = quan.maquan and thanhvien.TP = quan.thanhpho)\r\n"
					+ "INNER JOIN tinh_thanhpho\r\n"
					+ "ON thanhvien.TP = tinh_thanhpho.matinh WHERE thanhvien.MaThanhVien LIKE ?";
			java.sql.PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(1, "%" + SearchMaThanhVien + "%");

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				String maTV = result.getString("MaThanhVien");
				String tenTV = result.getString("HoTenThanhVien");
				String soNha = result.getString("thanhvien.DiaChi");
				String phuong = result.getString("tenphuong");
				String quan = result.getString("tenquan");
				String tinh = result.getString("tentinh");
				String sdt = result.getString("SDT");
				String email = result.getString("Mail");

				dsSearchMaThanhVien.add(new ThanhVien(maTV, tenTV, soNha, phuong, quan, tinh, sdt, email));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsSearchMaThanhVien;
	}

	// tìm theo mã thành viên và quận
	public ArrayList<ThanhVien> getDSSearchTK(String SearchMaThanhVien, String SearchQuan) {
		ArrayList<ThanhVien> dsSearchTK = new ArrayList<ThanhVien>();

		try {
			String queryString = "SELECT thanhvien.MaThanhVien, thanhvien.HoTenThanhVien, thanhvien.DiaChi, phuong.tenphuong, quan.tenquan, tinh_thanhpho.tentinh, thanhvien.SDT, thanhvien.Mail \r\n"
					+ "FROM thanhvien\r\n" + "INNER JOIN phuong\r\n"
					+ "ON (thanhvien.Phuong = phuong.maphuong and thanhvien.quan = phuong.quan and thanhvien.tp = phuong.thanhpho)\r\n"
					+ "INNER JOIN quan\r\n" + "ON (thanhvien.Quan = quan.maquan and thanhvien.TP = quan.thanhpho)\r\n"
					+ "INNER JOIN tinh_thanhpho\r\n"
					+ "ON thanhvien.TP = tinh_thanhpho.matinh WHERE quan.tenquan LIKE ? AND thanhvien.MaThanhVien LIKE ?";
			java.sql.PreparedStatement statement = conn.prepareStatement(queryString);
			statement.setString(2, "%" + SearchMaThanhVien + "%");
			statement.setString(1, "%" + SearchQuan + "%");

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				String maTV = result.getString("MaThanhVien");
				String tenTV = result.getString("HoTenThanhVien");
				String soNha = result.getString("thanhvien.DiaChi");
				String phuong = result.getString("tenphuong");
				String quan = result.getString("tenquan");
				String tinh = result.getString("tentinh");
				String sdt = result.getString("SDT");
				String email = result.getString("Mail");

				dsSearchTK.add(new ThanhVien(maTV, tenTV, soNha, phuong, quan, tinh, sdt, email));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsSearchTK;
	}

}
