package fasttrackse.team1.qlthuviendientu.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import fasttrackse.team1.qlthuviendientu.dao.QuanLyThuVienDAO;
import fasttrackse.team1.qlthuviendientu.entyti.ThanhVien;
import fasttrackse.team1.qlthuviendientu.entyti.TinhThanh;

public class QuanLyThanhVienUI extends JPanel {
	private JLabel lblCodeMTV, lblHT, lblDC, lblSDT, lblEmail;
	private JButton btnreset, btnsua, btnthem, btnxoa;
	private JTextField txtCodeMTV, txtHT, txtDC, txtP, txtQ, txtTP, txtSDT, txtEmail;
	private DefaultTableModel table = new DefaultTableModel();
	private JTable tbl;
	private JMonthChooser jmc;
	private JYearChooser jyc;
	JComboBox<String> phuong;
	JComboBox<String> quan;
	JComboBox<String> tinh;

	public static QuanLyThuVienDAO thanhVienDAO = new QuanLyThuVienDAO();
	public static ArrayList<ThanhVien> thanhVien = new ArrayList<ThanhVien>();
	public static ArrayList<TinhThanh> tinhThanh = new ArrayList<TinhThanh>();

	MouseListener tblUserClick = new MouseListener() {
		public void mouseReleased(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseClicked(MouseEvent e) {

			int row = tbl.getSelectedRow();

			// String lopSV = (String) tbl.getValueAt(row, 1);
			// classs.setSelectedItem(lopSV);

			String maTV = (String) tbl.getValueAt(row, 0);
			txtCodeMTV.setText(maTV);

			String tenTV = (String) tbl.getValueAt(row, 1);
			txtHT.setText(tenTV);

			String diaChiNha = (String) tbl.getValueAt(row, 2);
			txtDC.setText(diaChiNha);

//			String phuong = (String) tbl.getValueAt(row, 3);
//			txtP.setText(phuong);
//
//			String quan = (String) tbl.getValueAt(row, 4);
//			txtQ.setText(quan);
//
//			String tinh = (String) tbl.getValueAt(row, 5);
//			txtTP.setText(tinh);

			String sdt = (String) tbl.getValueAt(row, 6);
			txtSDT.setText(sdt);

			String email = (String) tbl.getValueAt(row, 7);
			txtEmail.setText(email);

			// String gioiTinhSV = (String) tbl.getValueAt(row, 4);
			// if (gioiTinhSV.equals("Nam")) {
			// gender1.setSelected(true);
			// } else {
			// gender2.setSelected(true);
			// }

		}
	};

	public QuanLyThanhVienUI() {

		// tạo container và boder chính
		JPanel pnBorder = new JPanel();
		pnBorder.setPreferredSize(new Dimension(820, 700));
		pnBorder.setLayout(new BorderLayout());
		pnBorder.setLayout(new BoxLayout(pnBorder, BoxLayout.Y_AXIS));

		// phần trung tâm nhập thông tin
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		pnCenter.setBackground(Color.LIGHT_GRAY);

		JPanel pnCenterCon = new JPanel();
		pnCenterCon.setLayout(new BoxLayout(pnCenterCon, BoxLayout.X_AXIS));
		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Mời Nhập thông tin thành viên");
		pnCenterCon.setBorder(borderTitle);
		// pnCenterCon.setPreferredSize(new Dimension(300, 300));
		pnCenterCon.setBackground(Color.LIGHT_GRAY);

		// text nhập thông tin
		// bên trái màn hình
		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));

		JPanel pnCenterCon1 = new JPanel();
		txtCodeMTV = new JTextField(15);
		lblCodeMTV = new JLabel("*Mã thành viên: ");
		pnCenterCon1.add(lblCodeMTV);
		pnCenterCon1.add(txtCodeMTV);

		JPanel pnCenterCon2 = new JPanel();
		txtHT = new JTextField(15);
		lblHT = new JLabel("        *Họ và tên: ");
		pnCenterCon2.add(lblHT);
		pnCenterCon2.add(txtHT);

		JPanel pnCenterCon6 = new JPanel();
		JLabel lblTinh = new JLabel("*Tỉnh");
		tinh = new JComboBox<String>();
		tinh.addItem("None");
		tinhThanh = thanhVienDAO.getDSTinh();
		for (int i = 0; i < tinhThanh.size(); i++) {
			tinh.addItem(tinhThanh.get(i).getTenTinh());
		}
		pnCenterCon6.add(lblTinh);
		pnCenterCon6.add(tinh);

		JPanel pnCenterCon5 = new JPanel();
		JLabel lblquan = new JLabel("*Quận");
		quan = new JComboBox<String>();
		quan.addItem("None");
		tinhThanh = thanhVienDAO.getDSTinh();
		for (int i = 0; i < tinhThanh.size(); i++) {
			quan.addItem(tinhThanh.get(i).getTenTinh());
		}
		pnCenterCon5.add(lblquan);
		pnCenterCon5.add(quan);

		// bên phải
		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));

		JPanel pnCenterCon4 = new JPanel();
		JLabel lblphuong = new JLabel("*Phường");
		phuong = new JComboBox<String>();
		phuong.addItem("None");
		tinhThanh = thanhVienDAO.getDSTinh();
		for (int i = 0; i < tinhThanh.size(); i++) {
			phuong.addItem(tinhThanh.get(i).getTenTinh());
		}

		pnCenterCon4.add(lblphuong);
		pnCenterCon4.add(phuong);

		JPanel pnCenterCon3 = new JPanel();
		txtDC = new JTextField(15);
		lblDC = new JLabel("     *Địa chỉ nhà: ");
		pnCenterCon3.add(lblDC);
		pnCenterCon3.add(txtDC);

		JPanel pnCenterCon7 = new JPanel();
		txtSDT = new JTextField(15);
		lblSDT = new JLabel("         *Số điện thoại : ");
		pnCenterCon7.add(lblSDT);
		pnCenterCon7.add(txtSDT);

		JPanel pnCenterCon8 = new JPanel();
		txtEmail = new JTextField(15);
		lblEmail = new JLabel("                       *Email : ");
		pnCenterCon8.add(lblEmail);
		pnCenterCon8.add(txtEmail);

		// phần button thêm,sửa,xóa.....
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new BoxLayout(pnButton, BoxLayout.X_AXIS));
		pnButton.setPreferredSize(new Dimension(1000, 50));
		pnButton.setBackground(Color.LIGHT_GRAY);

		ImageIcon update = new ImageIcon(
				new ImageIcon("icon/them.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		btnthem = new JButton("thêm ", update);
		btnthem.setMargin(new Insets(5, 10, 5, 10));

		ImageIcon update1 = new ImageIcon(
				new ImageIcon("icon/sua.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		btnsua = new JButton("sửa ", update1);
		btnsua.setMargin(new Insets(5, 10, 5, 10));

		ImageIcon update2 = new ImageIcon(
				new ImageIcon("icon/xoa.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		btnxoa = new JButton("xóa ", update2);
		btnxoa.setMargin(new Insets(5, 10, 5, 10));

		ImageIcon update3 = new ImageIcon(
				new ImageIcon("icon/reset.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		btnreset = new JButton("reset", update3);
		btnreset.setMargin(new Insets(5, 10, 5, 10));
		JLabel lbkc7 = new JLabel("");
		JLabel lbkc8 = new JLabel("        ");
		JLabel lbkc9 = new JLabel("        ");
		JLabel lbkc10 = new JLabel("        ");

		// add các ô text nhập thông tin
		pnLeft.add(pnCenterCon1);
		pnLeft.add(pnCenterCon2);
		pnLeft.add(pnCenterCon6);
		pnLeft.add(pnCenterCon5);
		pnRight.add(pnCenterCon4);
		pnRight.add(pnCenterCon3);
		pnRight.add(pnCenterCon7);
		pnRight.add(pnCenterCon8);

		// add các buttton them sửa xóa
		// pnButton.add(ro);
		pnButton.add(lbkc7);
		pnButton.add(btnthem);
		pnButton.add(lbkc8);
		pnButton.add(btnsua);
		pnButton.add(lbkc9);
		pnButton.add(btnxoa);
		pnButton.add(lbkc10);
		pnButton.add(btnreset);

		// add và pannerCon
		pnCenterCon.add(pnLeft);
		pnCenterCon.add(pnRight);
		pnCenter.add(pnCenterCon);
		pnCenter.add(pnButton);
		pnBorder.add(pnCenter, BorderLayout.CENTER);
		// hết phần center

		// phần footer màn hình
		JPanel pnSouth = new JPanel();
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));
		pnSouth.setPreferredSize(new Dimension(100, 400));
		// bảng table
		table.addColumn("Mã thành viên");
		table.addColumn("Tên thành viên");
		table.addColumn("Địa chỉ nhà");
		table.addColumn("Phường");
		table.addColumn("Quận");
		table.addColumn("Tỉnh/Thành phố");
		table.addColumn("Điện Thoại");
		table.addColumn("Email");
		this.getTable();
		tbl = new JTable(table);
		TableColumnModel columnModel = tbl.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(110);
		columnModel.getColumn(3).setPreferredWidth(50);
		columnModel.getColumn(4).setPreferredWidth(50);
		JScrollPane sc = new JScrollPane(tbl);
		tbl.addMouseListener(tblUserClick);
		pnSouth.add(sc);
		pnBorder.add(pnSouth, BorderLayout.SOUTH);

		// thêm vào main
		this.add(pnBorder);
	}

	public void getTable() {
		thanhVien = thanhVienDAO.getDSThanhVien();
		for (int i = 0; i < thanhVien.size(); i++) {
			table.addRow(new String[] { thanhVien.get(i).getMaThanhVien(), thanhVien.get(i).getTenThanhVien(),
					thanhVien.get(i).getDiaChiNha(), thanhVien.get(i).getPhuong(), thanhVien.get(i).getQuan(),
					thanhVien.get(i).getTinh(), thanhVien.get(i).getSoDT(), thanhVien.get(i).getEmail() });
		}

	}

}
