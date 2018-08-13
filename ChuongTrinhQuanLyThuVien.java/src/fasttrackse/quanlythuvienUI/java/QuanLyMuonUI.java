package fasttrackse.quanlythuvienUI.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

public class QuanLyMuonUI extends JFrame {
	private JLabel lblTitle, lblCodeGD, lblCodeTV, lblCodeSL, lblNM, lblNT, lblMS;
	private JButton btntg, btnnxb, btnadmin, btntl, btnqltv, btnqlmt, btnqls, btnqldm, btnkt, btntk, btnSubmit, btnts,
			btnms, btnT;
	private JTextField txtCodeTV, txtCodeGD, txtSL, txtNM, txtNT;
	private DefaultTableModel table = new DefaultTableModel();
	private JTable tbl;


	
//	private JMonthChooser jmc;
//	private JYearChooser jyc;

	private DateFormat ngay;
	private Date date, ngay1;

	private JScrollPane fruitListScrollPane;
	private Border raisedBevel = BorderFactory.createRaisedBevelBorder();
	private Border raisedEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);

	// các class UI
	ThongKeUI thongKeUI = new ThongKeUI();
	TacGiaUI quanLyDanhMucUI = new TacGiaUI();
	QuanLySachUI quanLySachUI = new QuanLySachUI();
	QuanLyTraUI quanLyTraUI = new QuanLyTraUI();
	QuanLyThanhVienUI quanLyThanhVienUI = new QuanLyThanhVienUI();

	AdminUI admin = new AdminUI();
	TheLoaiUI theloai = new TheLoaiUI();
	NhaXuatBanUI nhaXuatBan = new NhaXuatBanUI();
	// các Jpanel
	JPanel pnCenterCon = new JPanel();
	JPanel pnCenter = new JPanel();
	JPanel pnSouth = new JPanel();
	JPanel pnWest = new JPanel();
	JPanel pnWest1 = new JPanel();

	// Jpanel menu con
	JPanel pnWestCon1;
	JPanel pnWestCon2;
	JPanel pnWestCon3;
	JPanel pnWestCon4;
	JPanel pnWestCon5;
	JPanel pnWestCon6;

	// tạo console
	public void addConTrol() {

		// tạo container và boder chính
		Container con = getContentPane();
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		BorderLayout layout = new BorderLayout();
		layout.setHgap(5);
		layout.setVgap(5);
		pnBorder.setLayout(layout);
		pnBorder.setBackground(Color.LIGHT_GRAY);

		// phần header
		JPanel pnNorth = new JPanel();
		pnNorth.setBorder(raisedEtched);
		pnNorth.setPreferredSize(new Dimension(100, 60));
		pnNorth.setBackground(Color.orange);
		lblTitle = new JLabel("Chương Trình Quản Lý Thư Viện ");
		lblTitle.setForeground(Color.RED);
		Font fontTitle = new Font("Arial", Font.BOLD | Font.ITALIC, 35);
		lblTitle.setFont(fontTitle);
		pnNorth.add(lblTitle);
		pnBorder.add(pnNorth, BorderLayout.NORTH);

		// phần footer màn hình
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));
		pnSouth.setPreferredSize(new Dimension(900, 200));
		// bảng table
		table.addColumn("Mã giao dịch");
		table.addColumn("Tên thành viên");
		table.addColumn("Tên sách");
		table.addColumn("Số lượng");
		table.addColumn("Ngày mượn");
		table.addColumn("Ngày trả");
		table.addColumn("Ghi chú");
		tbl = new JTable(table);
		TableColumnModel columnModel = tbl.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(2);
		columnModel.getColumn(3).setPreferredWidth(4);
		columnModel.getColumn(4).setPreferredWidth(5);
		columnModel.getColumn(5).setPreferredWidth(5);
		columnModel.getColumn(6).setPreferredWidth(6);
		JScrollPane sc = new JScrollPane(tbl);
		pnSouth.add(sc);
		pnBorder.add(pnSouth, BorderLayout.SOUTH);

		// phần bên trái màn hình
		pnWest.setBackground(Color.orange);
		pnWest.setBorder(raisedBevel);
		pnWest.setPreferredSize(new Dimension(170, 250));
		// panner pnWestCon
		JPanel pnWestCon = new JPanel();
		pnWestCon.setBackground(Color.WHITE);
		pnWestCon.setPreferredSize(new Dimension(150, 250));
		Border bordera = BorderFactory.createLineBorder(Color.darkGray);
		TitledBorder borderTitlea = BorderFactory.createTitledBorder(bordera, "Mục chọn");

		pnWestCon1 = new JPanel();
		pnWestCon1.setPreferredSize(new Dimension(130, 30));
		btnms = new JButton("Mượn sách");
		btnms.setPreferredSize(new Dimension(110, 20));

		pnWestCon2 = new JPanel();
		pnWestCon2.setPreferredSize(new Dimension(130, 30));
		btnts = new JButton("Trả sách");
		btnts.setPreferredSize(new Dimension(110, 20));

		pnWestCon3 = new JPanel();
		pnWestCon3.setPreferredSize(new Dimension(130, 30));
		btntg = new JButton("Tác Giả");
		btntg.setPreferredSize(new Dimension(110, 20));

		pnWestCon4 = new JPanel();
		pnWestCon4.setPreferredSize(new Dimension(130, 30));
		btnnxb = new JButton("Nhà xuất bản");
		btnnxb.setPreferredSize(new Dimension(110, 20));

		pnWestCon5 = new JPanel();
		pnWestCon5.setPreferredSize(new Dimension(130, 30));
		btntl = new JButton("Thể loại");
		btntl.setPreferredSize(new Dimension(110, 20));

		pnWestCon6 = new JPanel();
		pnWestCon6.setPreferredSize(new Dimension(130, 30));
		btnadmin = new JButton("Admin");
		btnadmin.setPreferredSize(new Dimension(110, 20));

		pnWestCon.setBorder(borderTitlea);
		pnWestCon1.add(btnms);
		pnWestCon2.add(btnts);
		pnWestCon3.add(btntg);
		pnWestCon4.add(btnnxb);
		pnWestCon5.add(btntl);
		pnWestCon6.add(btnadmin);

		pnWestCon.add(pnWestCon1);
		pnWestCon.add(pnWestCon2);
		pnWestCon.add(pnWestCon3);
		pnWestCon.add(pnWestCon4);
		pnWestCon.add(pnWestCon5);
		pnWestCon.add(pnWestCon6);
		pnWest.add(pnWestCon);
		pnBorder.add(pnWest, BorderLayout.WEST);
		// hết phần bên trái màn hình.

		// phần bên phải và các button chính
		JPanel pnEast = new JPanel();
		pnEast.setBackground(Color.orange);
		pnEast.setBorder(raisedBevel);
		pnEast.setPreferredSize(new Dimension(250, 100));

		// pannel pnEastcon
		JPanel pnEastCon = new JPanel();
		// pnEastCon.setLayout(new BoxLayout(pnEastCon, BoxLayout.Y_AXIS));
		pnEastCon.setBackground(Color.orange);
		pnEastCon.setPreferredSize(new Dimension(200, 320));

		ImageIcon update1 = new ImageIcon(
				new ImageIcon("icon/b.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		btnqltv = new JButton(" Quản lý thành viên", update1);
		btnqltv.setPreferredSize(new Dimension(190, 40));
		btnqltv.setMargin(new Insets(5, 18, 5, 30));

		ImageIcon update2 = new ImageIcon(
				new ImageIcon("icon/qlmuontra.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		btnqlmt = new JButton("Quản lý mượn trả ", update2);
		btnqlmt.setMargin(new Insets(5, 20, 5, 30));

		ImageIcon update3 = new ImageIcon(
				new ImageIcon("icon/sach.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		btnqls = new JButton(" Quản lý sách         ", update3);
		btnqls.setMargin(new Insets(5, 20, 5, 30));

		ImageIcon update4 = new ImageIcon(
				new ImageIcon("icon/danhmuc.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		btnqldm = new JButton("Quản lý danh mục ", update4);
		btnqldm.setMargin(new Insets(5, 20, 5, 30));

		ImageIcon update5 = new ImageIcon(
				new ImageIcon("icon/thongke.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		btntk = new JButton("   Thống kê              ", update5);
		btntk.setPreferredSize(new Dimension(190, 40));
		btntk.setMargin(new Insets(5, 20, 5, 30));

		ImageIcon update6 = new ImageIcon(
				new ImageIcon("icon/exit.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
		btnkt = new JButton("    Kết thúc           ", update6);
		btnkt.setPreferredSize(new Dimension(190, 40));
		btnkt.setMargin(new Insets(5, 20, 5, 30));

		JLabel lbkc = new JLabel("");
		lbkc.setPreferredSize(new Dimension(10, 3));
		JLabel lbkc1 = new JLabel("");
		lbkc1.setPreferredSize(new Dimension(10, 3));
		JLabel lbkc2 = new JLabel("");
		lbkc2.setPreferredSize(new Dimension(10, 3));
		JLabel lbkc3 = new JLabel("");
		lbkc3.setPreferredSize(new Dimension(10, 3));
		JLabel lbkc4 = new JLabel("");
		lbkc4.setPreferredSize(new Dimension(10, 3));
		// JLabel lbkc6 = new JLabel("");
		// lbkc6.setPreferredSize(new Dimension(10, 10));

		// add button vào pnEast
		pnEastCon.add(btnqldm);
		pnEastCon.add(lbkc);
		pnEastCon.add(btnqlmt);
		pnEastCon.add(lbkc1);
		pnEastCon.add(btnqls);
		pnEastCon.add(lbkc2);
		pnEastCon.add(btnqltv);
		pnEastCon.add(lbkc3);
		pnEastCon.add(btntk);
		pnEastCon.add(lbkc4);
		pnEastCon.add(btnkt);

		pnEast.add(pnEastCon);
		pnBorder.add(pnEast, BorderLayout.EAST);

		// phần center chính nhập thông tin mượn sách
		pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		Border border = BorderFactory.createLineBorder(Color.darkGray);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Nhập Thông Tin Ngày Mượn ");
		pnCenterCon.setBorder(borderTitle);

		pnCenterCon.setPreferredSize(new Dimension(630, 330));
		pnCenterCon.setLayout(new BoxLayout(pnCenterCon, BoxLayout.Y_AXIS));
		// text nhập thông tin
		JPanel pnCenterCon1 = new JPanel();
		txtCodeGD = new JTextField(20);
		lblCodeGD = new JLabel("   Mã giao dịch:");
		pnCenterCon1.add(lblCodeGD);
		pnCenterCon1.add(txtCodeGD);

		JPanel pnCenterCon2 = new JPanel();
		txtCodeTV = new JTextField(20);
		lblCodeTV = new JLabel("Mã thành viên:");
		pnCenterCon2.add(lblCodeTV);
		pnCenterCon2.add(txtCodeTV);

		JPanel pnCenterCon3 = new JPanel();
		lblMS = new JLabel("                       Mã sách:");
		DefaultListModel fruitsName = new DefaultListModel();

		fruitsName.addElement("Apple");
		fruitsName.addElement("Grapes");
		fruitsName.addElement("Mango");
		fruitsName.addElement("Peer");

		final JList fruitList = new JList(fruitsName);
		fruitList.setSelectionBackground(Color.RED);
		fruitList.setSelectionForeground(Color.WHITE);

		fruitList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		fruitList.setSelectedIndex(0);
		fruitList.setVisibleRowCount(3);

		fruitListScrollPane = new JScrollPane(fruitList);
		fruitListScrollPane.setPreferredSize(new Dimension(225, 55));

		// button thêm mã sách
		ImageIcon update10 = new ImageIcon(
				new ImageIcon("icon/themmasach.png").getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH));
		btnT = new JButton(update10);
		btnT.setMargin(new Insets(3, 5, 3, 5));

		pnCenterCon3.add(lblMS);
		pnCenterCon3.add(fruitListScrollPane);
		pnCenterCon3.add(btnT);

		JPanel pnCenterCon4 = new JPanel();
		txtSL = new JTextField(20);
		lblCodeSL = new JLabel("       số lượng: ");
		
		
		
		pnCenterCon4.add(lblCodeSL);
		pnCenterCon4.add(txtSL);

		JPanel pnCenterCon5 = new JPanel();
		txtNM = new JTextField(8);
		lblNM = new JLabel("Ngày mượn: ");

		ngay = new SimpleDateFormat("yyyy-MM-dd");
		date = new Date();
		txtNM.setText(ngay.format(date));
		pnCenterCon5.add(lblNM);
		pnCenterCon5.add(txtNM);

		JPanel pnCenterCon6 = new JPanel();
		txtNT = new JTextField(8);
		lblNT = new JLabel("       Ngày trả: ");

		ngay = new SimpleDateFormat("yyyy-MM-dd");
		ngay1 = new Date();
		txtNT.setText(ngay.format(ngay1));

		pnCenterCon6.add(lblNT);
		pnCenterCon6.add(txtNT);

		JPanel lbkc5 = new JPanel();
		btnSubmit = new JButton("Submit");
		lbkc5.add(btnSubmit);

		pnCenterCon.add(pnCenterCon1);
		pnCenterCon.add(pnCenterCon2);
		pnCenterCon.add(pnCenterCon3);
		pnCenterCon.add(pnCenterCon4);
		pnCenterCon.add(pnCenterCon5);
		pnCenterCon.add(pnCenterCon6);
		pnCenterCon.add(lbkc5);
		pnCenter.add(pnCenterCon);
		pnBorder.add(pnCenter, BorderLayout.CENTER);

		// phần add class UI vào panelCenter
		pnCenter.add(quanLyDanhMucUI);
		pnCenter.add(quanLyThanhVienUI);
		pnCenter.add(quanLyTraUI);
		pnCenter.add(quanLySachUI);
		pnCenter.add(thongKeUI);
		// phần quản lý danh mục
		pnCenter.add(nhaXuatBan);
		pnCenter.add(theloai);
		pnCenter.add(admin);

		theloai.setVisible(false);
		nhaXuatBan.setVisible(false);
		admin.setVisible(false);
		// các trang quản lý chính
		thongKeUI.setVisible(false);
		quanLySachUI.setVisible(false);
		quanLyThanhVienUI.setVisible(false);
		quanLyTraUI.setVisible(false);
		quanLyDanhMucUI.setVisible(false);

		// phần menu con quan lý danh mục
		pnWestCon3.setVisible(false);
		pnWestCon4.setVisible(false);
		pnWestCon5.setVisible(false);
		pnWestCon6.setVisible(false);

		// thêm vào main
		con.add(pnBorder);
	}

	ActionListener btnQuanLyDanhMucClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			quanLyDanhMucUI.setVisible(true);
			pnSouth.setVisible(false);
			pnWest.setVisible(true);
			pnCenterCon.setVisible(false);
			thongKeUI.setVisible(false);
			quanLySachUI.setVisible(false);
			quanLyThanhVienUI.setVisible(false);
			quanLyTraUI.setVisible(false);

			theloai.setVisible(false);
			nhaXuatBan.setVisible(false);
			admin.setVisible(false);

			// pnWestCon3.setVisible(true);
			pnWestCon1.setVisible(false);
			pnWestCon2.setVisible(false);
			pnWestCon3.setVisible(true);
			pnWestCon4.setVisible(true);
			pnWestCon5.setVisible(true);
			pnWestCon6.setVisible(true);

			// setEnabled cho các button danhmuc
			btnnxb.setEnabled(true);
			btntl.setEnabled(true);
			btnadmin.setEnabled(true);
			btntg.setEnabled(false);
		}
	};

	ActionListener btnThongKeClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			thongKeUI.setVisible(true);
			pnCenterCon.setVisible(false);
			quanLyTraUI.setVisible(false);
			quanLySachUI.setVisible(false);
			quanLyThanhVienUI.setVisible(false);
			quanLyDanhMucUI.setVisible(false);
			pnSouth.setVisible(false);
			pnWest.setVisible(false);

			theloai.setVisible(false);
			nhaXuatBan.setVisible(false);
			admin.setVisible(false);
		}
	};

	ActionListener btnTraSachClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			quanLyDanhMucUI.setVisible(false);
			quanLyTraUI.setVisible(true);
			pnCenterCon.setVisible(false);
			quanLySachUI.setVisible(false);
			quanLyThanhVienUI.setVisible(false);
			thongKeUI.setVisible(false);
			pnSouth.setVisible(false);
			theloai.setVisible(false);
			nhaXuatBan.setVisible(false);
			admin.setVisible(false);
		}
	};

	ActionListener btnMuonSachClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			quanLyDanhMucUI.setVisible(false);
			pnCenterCon.setVisible(true);
			pnSouth.setVisible(true);
			quanLyTraUI.setVisible(false);
			quanLySachUI.setVisible(false);
			quanLyThanhVienUI.setVisible(false);
			thongKeUI.setVisible(false);

			theloai.setVisible(false);
			nhaXuatBan.setVisible(false);
			admin.setVisible(false);

			pnWestCon1.setVisible(true);
			pnWestCon2.setVisible(true);
			pnWestCon3.setVisible(false);
			pnWestCon4.setVisible(false);
			pnWestCon5.setVisible(false);
			pnWestCon6.setVisible(false);

		}
	};
	ActionListener btnQuanLyThanhVienClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			quanLyThanhVienUI.setVisible(true);
			pnCenterCon.setVisible(false);
			quanLySachUI.setVisible(false);
			pnSouth.setVisible(false);
			pnWest.setVisible(false);
			quanLyDanhMucUI.setVisible(false);
			thongKeUI.setVisible(false);
			quanLyTraUI.setVisible(false);

			theloai.setVisible(false);
			nhaXuatBan.setVisible(false);
			admin.setVisible(false);
		}
	};
	ActionListener btnQuanLyMuonTraClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			pnCenterCon.setVisible(true);
			pnSouth.setVisible(true);
			pnWest.setVisible(true);
			quanLyDanhMucUI.setVisible(false);
			quanLySachUI.setVisible(false);
			quanLyThanhVienUI.setVisible(false);
			quanLyTraUI.setVisible(false);
			thongKeUI.setVisible(false);

			theloai.setVisible(false);
			nhaXuatBan.setVisible(false);
			admin.setVisible(false);

			pnWestCon1.setVisible(true);
			pnWestCon2.setVisible(true);
			pnWestCon3.setVisible(false);
			pnWestCon4.setVisible(false);
			pnWestCon5.setVisible(false);
			pnWestCon6.setVisible(false);
		}
	};
	ActionListener btnQuanLySachClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			quanLySachUI.setVisible(true);
			quanLyDanhMucUI.setVisible(false);
			quanLyThanhVienUI.setVisible(false);
			pnCenterCon.setVisible(false);
			pnSouth.setVisible(false);
			pnWest.setVisible(false);
			thongKeUI.setVisible(false);

			theloai.setVisible(false);
			nhaXuatBan.setVisible(false);
			admin.setVisible(false);
		}
	};
	ActionListener btnExitClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			int ret = JOptionPane.showConfirmDialog(null, "Bạn muốn thoát chương trình", "Thư Viện ",
					JOptionPane.YES_NO_OPTION);
			if (ret == JOptionPane.YES_OPTION) {
				System.exit(0);
			}

		}
	};
	ActionListener btnTacGiaClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			nhaXuatBan.setVisible(false);
			pnCenterCon.setVisible(false);
			pnSouth.setVisible(false);
			theloai.setVisible(false);
			admin.setVisible(false);

			quanLyDanhMucUI.setVisible(true);
			quanLyTraUI.setVisible(false);
			quanLySachUI.setVisible(false);
			quanLyThanhVienUI.setVisible(false);
			thongKeUI.setVisible(false);

			// setEnabled cho các button danhmuc
			btnnxb.setEnabled(true);
			btntl.setEnabled(true);
			btnadmin.setEnabled(true);
			btntg.setEnabled(false);
		}
	};
	ActionListener btnTheLoaiClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			nhaXuatBan.setVisible(false);
			pnCenterCon.setVisible(false);
			theloai.setVisible(true);
			admin.setVisible(false);
			pnSouth.setVisible(false);

			quanLyDanhMucUI.setVisible(false);
			quanLyTraUI.setVisible(false);
			quanLySachUI.setVisible(false);
			quanLyThanhVienUI.setVisible(false);
			thongKeUI.setVisible(false);

			// setEnabled cho các button danhmuc
			btnnxb.setEnabled(true);
			btntl.setEnabled(false);
			btnadmin.setEnabled(true);
			btntg.setEnabled(true);
		}
	};
	ActionListener btnNhaXuatBanClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			nhaXuatBan.setVisible(true);
			pnCenterCon.setVisible(false);
			theloai.setVisible(false);
			pnSouth.setVisible(false);
			admin.setVisible(false);

			quanLyDanhMucUI.setVisible(false);
			quanLyTraUI.setVisible(false);
			quanLySachUI.setVisible(false);
			quanLyThanhVienUI.setVisible(false);
			thongKeUI.setVisible(false);

			// setEnabled cho các button danh muc
			btnnxb.setEnabled(false);
			btntl.setEnabled(true);
			btnadmin.setEnabled(true);
			btntg.setEnabled(true);
		}
	};
	ActionListener btnAdminClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			admin.setVisible(true);
			nhaXuatBan.setVisible(false);
			pnCenterCon.setVisible(false);
			theloai.setVisible(false);
			pnSouth.setVisible(false);

			quanLyDanhMucUI.setVisible(false);
			quanLyTraUI.setVisible(false);
			quanLySachUI.setVisible(false);
			quanLyThanhVienUI.setVisible(false);
			thongKeUI.setVisible(false);

			// setEnabled cho các button danhmuc
			btnnxb.setEnabled(true);
			btntl.setEnabled(true);
			btnadmin.setEnabled(false);
			btntg.setEnabled(true);
		}
	};

	// phần add sự kiện
	public void addEvents() {
		// các menu chính

		btntk.addActionListener(btnThongKeClick);
		btnqldm.addActionListener(btnQuanLyDanhMucClick);
		btnqls.addActionListener(btnQuanLySachClick);
		btnkt.addActionListener(btnExitClick);
		btnqltv.addActionListener(btnQuanLyThanhVienClick);
		btnqlmt.addActionListener(btnQuanLyMuonTraClick);
		// hai menu con mượn trả sách
		btnms.addActionListener(btnMuonSachClick);
		btnts.addActionListener(btnTraSachClick);
		btntg.addActionListener(btnTacGiaClick);
		btnnxb.addActionListener(btnNhaXuatBanClick);
		btnadmin.addActionListener(btnAdminClick);
		btntl.addActionListener(btnTheLoaiClick);

	}

	// phương thức này truy�?n qua main
	public QuanLyMuonUI(String title) {
		super(title);
		addConTrol();
		addEvents();

	}

	// màn hình console
	public void showView() {
		this.setSize(1100, 650);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
