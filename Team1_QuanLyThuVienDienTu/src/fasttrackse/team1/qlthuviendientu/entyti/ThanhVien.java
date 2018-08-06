package fasttrackse.team1.qlthuviendientu.entyti;

public class ThanhVien {
private String maThanhVien;
private String tenThanhVien;
private String diaChiNha;
private String phuong;
private String quan;
private String tinh;
private String soDT;
private String email;


public ThanhVien(String maThanhVien, String tenThanhVien, String diaChiNha, String phuong, String quan, String tinh,
		String soDT, String email) {
	super();
	this.maThanhVien = maThanhVien;
	this.tenThanhVien = tenThanhVien;
	this.diaChiNha = diaChiNha;
	this.phuong = phuong;
	this.quan = quan;
	this.tinh = tinh;
	this.soDT = soDT;
	this.email = email;
}
public String getMaThanhVien() {
	return maThanhVien;
}
public void setMaThanhVien(String maThanhVien) {
	this.maThanhVien = maThanhVien;
}
public String getTenThanhVien() {
	return tenThanhVien;
}
public void setTenThanhVien(String tenThanhVien) {
	this.tenThanhVien = tenThanhVien;
}
public String getDiaChiNha() {
	return diaChiNha;
}
public void setDiaChiNha(String diaChiNha) {
	this.diaChiNha = diaChiNha;
}
public String getPhuong() {
	return phuong;
}
public void setPhuong(String phuong) {
	this.phuong = phuong;
}
public String getQuan() {
	return quan;
}
public void setQuan(String quan) {
	this.quan = quan;
}
public String getTinh() {
	return tinh;
}
public void setTinh(String tinh) {
	this.tinh = tinh;
}
public String getSoDT() {
	return soDT;
}
public void setSoDT(String soDT) {
	this.soDT = soDT;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}
