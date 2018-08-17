package fasttrackse.qualythuvien.until;

public class LibaryUntil extends Exception {

	private static final long serialVersionUID = 1L;
	int errorCode;

	public LibaryUntil(int errCode) {
		errorCode = errCode;
	}

	@Override
	public String toString() {
		String msg = "Lỗi không xác định!!!";

		switch (errorCode) {
		case 1:
			msg = "bạn phải nhập vào trường này('lưu ý nhập ko được quá 40 kí tự.')";
			break;
		case 2:
			msg = "bạn chỉ được nhập 1 or 2 or 3 .";
			break;
		case 3:
			msg = "bạn chỉ được nhập số thực . ";
			break;
		case 4:
			msg = "bạn  không được nhập nhỏ hơn 0 ." + "\nnhập lại.";
			break;
		case 5:
			msg = "bạn  không được để trống." + "\nnhập lại.";
			break;
		}
		return msg;
	}

}
