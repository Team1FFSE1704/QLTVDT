package fasttrackse.quanlythuvien.entity;

public class TheLoai {
	private String MaTheLoai;
	private String tenTheLoai;

	public TheLoai(String maTheLoai, String tenTheLoai) {

		this.MaTheLoai = maTheLoai;
		this.tenTheLoai = tenTheLoai;
	}

	public String getMaTheLoai() {
		return MaTheLoai;
	}

	public void setMaTheLoai(String maTheLoai) {
		MaTheLoai = maTheLoai;
	}

	public String getTenTheLoai() {
		return tenTheLoai;
	}

	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}
}
