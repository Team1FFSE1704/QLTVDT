package fasttrackse.quanlythuvien.entity;

public class QuanLySach {
	private String maSach;
	private String tenSach;
	private String tacGia;
	private String nhaXuatBan;
	private String theLoai;
	private String namXuatBan;
	private String soLuong;

	public QuanLySach(String maSach, String tenSach, String tacGia, String nhaXuatBan, String theLoai,
			String namXuatBan, String soLuong) {

		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.nhaXuatBan = nhaXuatBan;
		this.theLoai = theLoai;
		this.namXuatBan = namXuatBan;
		this.soLuong = soLuong;

	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public String getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamSanXuat(String namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public String getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(String soLuong) {
		this.soLuong = soLuong;
	}

}
