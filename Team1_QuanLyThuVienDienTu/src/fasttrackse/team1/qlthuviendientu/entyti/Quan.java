package fasttrackse.team1.qlthuviendientu.entyti;

public class Quan {
	private int maTinh;
	private int maQuan;
	private String tenQuan;

	public Quan(int maTinh, int maQuan, String tenQuan) {
		super();
		this.maTinh = maTinh;
		this.maQuan = maQuan;
		this.tenQuan = tenQuan;
	}

	public int getMaTinh() {
		return maTinh;
	}

	public void setMaTinh(int maTinh) {
		this.maTinh = maTinh;
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
