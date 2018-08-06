package fasttrackse.team1.qlthuviendientu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.Driver;

import fasttrackse.team1.qlthuviendientu.entyti.ThanhVien;
import fasttrackse.team1.qlthuviendientu.entyti.TinhThanh;

public class QuanLyThuVienDAO {
	Connection conn = null;

	// kết nối database
	public QuanLyThuVienDAO() {
		this.getConnect("localhost", "team1_qlthuvien", "team1qltvdt", "team1qltvdt");
	}

	// ngắt kết nối database
	public void disConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
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

	//danh sách thành viên
	public ArrayList<ThanhVien> getDSThanhVien() {
		ArrayList<ThanhVien> dsTV = new ArrayList<ThanhVien>();

		try {
			String queryString = "SELECT thanhvien.MaThanhVien, thanhvien.HoTenThanhVien, thanhvien.DiaChi, phuong.tenphuong, quan.tenquan, tinh_thanhpho.tentinh, thanhvien.SDT, thanhvien.Mail \r\n"
					+ "FROM thanhvien\r\n" + "INNER JOIN phuong\r\n"
					+ "ON (thanhvien.Phuong = phuong.maphuong and thanhvien.quan = phuong.quan and thanhvien.tp = phuong.thanhpho)\r\n"
					+ "INNER JOIN quan\r\n" + "ON (thanhvien.Quan = quan.maquan and thanhvien.TP = quan.thanhpho)\r\n"
					+ "INNER JOIN tinh_thanhpho\r\n" + "ON thanhvien.TP = tinh_thanhpho.matinh";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				
				String maTV = result.getString("MaThanhVien");
				String tenTV = result.getString("HoTenThanhVien");
				String soNha = result.getString("DiaChi");
				String phuong = result.getString("tenphuong");
				String quan = result.getString("tenquan");
				String tinh = result.getString("tentinh");
				String sdt = result.getString("SDT");
				String email = result.getString("Mail");

				dsTV.add(new ThanhVien(maTV, tenTV, soNha, phuong,  quan, tinh,
						sdt,  email));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsTV;
	}
	
	//lấy danh sách tỉnh thành
	public ArrayList<TinhThanh> getDSTinh() {
		ArrayList<TinhThanh> dsTinhThanh = new ArrayList<TinhThanh>();

		try {
			String queryString = "SELECT * FROM tinh_thanhpho";
			PreparedStatement statement = conn.prepareStatement(queryString);

			ResultSet result = statement.executeQuery();

			while (result.next()) {
				
				int maTinh = result.getInt("matinh");
				String tenTinh = result.getString("tentinh");
				

				dsTinhThanh.add(new TinhThanh(maTinh,tenTinh));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsTinhThanh;
	}
}
