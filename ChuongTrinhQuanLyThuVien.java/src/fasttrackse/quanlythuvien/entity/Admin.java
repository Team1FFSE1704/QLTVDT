package fasttrackse.quanlythuvien.entity;

public class Admin {

	private String tenAdmin;
	private String passWord;

	public Admin(String tenAdmin, String passWord) {
		
		this.tenAdmin = tenAdmin;
		this.passWord = passWord;
	}

	public Admin(String tenAdmin) {

		this.tenAdmin = tenAdmin;
	}

	public String getTenAdmin() {
		return tenAdmin;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	

}
