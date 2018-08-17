package fasttrackse.quanlythuvien.entity;

public class Quan {
	private int maQuan;
	private String tenQuan;

	public Quan(int maQuan, String tenQuan) {
		super();
		this.maQuan = maQuan;
		this.tenQuan = tenQuan;
	}

	public int getMaQuan() {
		return maQuan;
	}

	public void setMaQuan(int maQuan) {
		this.maQuan = maQuan;
	}

	public String getTenQuan() {
		return tenQuan;
	}

	public void setTenQuan(String tenQuan) {
		this.tenQuan = tenQuan;
	}
}
