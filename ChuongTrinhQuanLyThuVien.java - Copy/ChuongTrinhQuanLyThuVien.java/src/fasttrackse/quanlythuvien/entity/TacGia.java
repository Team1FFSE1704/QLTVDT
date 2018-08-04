package fasttrackse.quanlythuvien.entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class TacGia {
	Connection conn = null;

	public  TacGia() {
		this.getConnect("localhost", "quanlythuvien", "quanlythuvien", "123456");
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

		String strConnect = "jdbc:mysql://" + strServer + "/" + strDatabase+ "?useUnicode=true&characterEncoding=utf-8";
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

}
