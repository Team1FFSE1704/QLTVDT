package fasttrackse.quanlythuvien.java.until;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class QuanLyMuonUI extends JFrame {
	private JLabel lblTitle, lbWestMS, lbWestTS, lblCodeGD, lblCodeTV, lblCodeSL, lblNM, lblNT, lblMS;
	private JButton btnqltv, btnqlmt, btnqls, btnqldm, btnkt, btntk, btnSubmit, btnoo;
	private JTextField txtCodeTV, txtCodeGD, txtSL, txtNM, txtNT;
	private DefaultTableModel table = new DefaultTableModel();
	private JTable tbl;
	private JList jl;
	DateFormat ngay;
	Date date, ngay1;
	private JScrollPane scjl;
	private Border raisedBevel = BorderFactory.createRaisedBevelBorder();
	private Border raisedEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);

	// tạo console
	public void addConTrol() {

		// tạo container và boder chính
		Container con = getContentPane();
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());

		// phần header
		JPanel pnNorth = new JPanel();
		pnNorth.setBorder(raisedEtched);
		pnNorth.setPreferredSize(new Dimension(100, 60));
		lblTitle = new JLabel("Chương Trình Quản Lý Thư Viện ");
		lblTitle.setForeground(Color.RED);
		pnNorth.setBackground(Color.orange);
		Font fontTitle = new Font("Arial", Font.BOLD, 30);
		lblTitle.setFont(fontTitle);
		pnNorth.add(lblTitle);
		pnBorder.add(pnNorth, BorderLayout.NORTH);

		// phần footer màn hình
		JPanel pnSouth = new JPanel();
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));
		pnSouth.setPreferredSize(new Dimension(900, 200));
		pnSouth.setBackground(Color.white);
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
		JPanel pnWest = new JPanel();
		pnWest.setBorder(raisedBevel);
		pnWest.setBackground(Color.orange);
		pnWest.setPreferredSize(new Dimension(150, 10));

		// panner con
		JPanel pnWestCon = new JPanel();
		pnWestCon.setBackground(Color.WHITE);
		pnWestCon.setPreferredSize(new Dimension(130, 200));
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Mượn trả Sách");

		JPanel pnWestCon1 = new JPanel();
		lbWestMS = new JLabel("mượn sách");
		ImageIcon update7 = new ImageIcon(
				new ImageIcon("icon/muontra.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		JLabel lblIconUpdate7 = new JLabel(update7);
		lbWestMS.add(lblIconUpdate7);

		JPanel pnWestCon2 = new JPanel();
		lbWestTS = new JLabel("Trả sách");
		ImageIcon update8 = new ImageIcon(
				new ImageIcon("icon/.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		JLabel lblIconUpdate8 = new JLabel(update8);
		lbWestTS.add(lblIconUpdate8);
		pnWestCon.setBorder(borderTitle);
		pnWestCon1.add(lbWestMS);
		pnWestCon2.add(lbWestTS);

		pnWestCon.add(pnWestCon1);
		pnWestCon.add(pnWestCon2);
		pnWest.add(pnWestCon);
		pnBorder.add(pnWest, BorderLayout.WEST);
		// hết phần bên trái màn hình

		// phần bên phải và các button chính
		JPanel pnEast = new JPanel();
		pnEast.setBorder(raisedBevel);
		pnEast.setBackground(Color.ORANGE);
		pnEast.setPreferredSize(new Dimension(250, 50));
		// pannel con
		JPanel pnEastCon = new JPanel();
		pnEastCon.setLayout(new BoxLayout(pnEastCon, BoxLayout.Y_AXIS));
		btnqltv = new JButton("Quản lý thành viên ");
		btnqltv.setPreferredSize(new Dimension(190, 40));
		btnqltv.setForeground(Color.RED);
		ImageIcon update1 = new ImageIcon(
				new ImageIcon("icon/b.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		JLabel lblIconUpdate1 = new JLabel(update1);
		btnqltv.add(lblIconUpdate1);

		btnqlmt = new JButton("Quản lý mượn trả ");
		btnqlmt.setPreferredSize(new Dimension(190, 40));
		btnqlmt.setForeground(Color.GREEN);
		ImageIcon update2 = new ImageIcon(
				new ImageIcon("icon/danhmuc.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		JLabel lblIconUpdate2 = new JLabel(update2);
		btnqlmt.add(lblIconUpdate2);

		btnqls = new JButton("Quản lý sách  ");
		btnqls.setPreferredSize(new Dimension(190, 40));
		btnqls.setForeground(Color.PINK);
		ImageIcon update3 = new ImageIcon(
				new ImageIcon("icon/sach.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		JLabel lblIconUpdate3 = new JLabel(update3);
		btnqls.add(lblIconUpdate3);

		btnqldm = new JButton("Quản lý danh mục ");
		btnqldm.setPreferredSize(new Dimension(190, 40));
		btnqldm.setForeground(Color.BLUE);
		ImageIcon update4 = new ImageIcon(
				new ImageIcon("icon/danhmuc.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		JLabel lblIconUpdate4 = new JLabel(update4);
		btnqldm.add(lblIconUpdate4);

		btntk = new JButton("Thông kê ");
		btntk.setPreferredSize(new Dimension(190, 40));
		btntk.setForeground(Color.ORANGE);
		ImageIcon update5 = new ImageIcon(
				new ImageIcon("icon/thongke.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		JLabel lblIconUpdate5 = new JLabel(update5);
		btntk.add(lblIconUpdate5);

		btnkt = new JButton("Kết thúc");
		btnkt.setPreferredSize(new Dimension(190, 40));
		btnkt.setForeground(Color.ORANGE);
		ImageIcon update6 = new ImageIcon(
				new ImageIcon("icon/exit.jpg").getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH));
		JLabel lblIconUpdate6 = new JLabel(update6);
		btnkt.add(lblIconUpdate6);

		JLabel lbkc = new JLabel("        ");
		lbkc.setPreferredSize(new Dimension(10, 50));
		JLabel lbkc1 = new JLabel("        ");
		lbkc1.setPreferredSize(new Dimension(10, 50));
		JLabel lbkc2 = new JLabel("        ");
		lbkc2.setPreferredSize(new Dimension(10, 50));
		JLabel lbkc3 = new JLabel("        ");
		lbkc3.setPreferredSize(new Dimension(10, 50));
		JLabel lbkc4 = new JLabel("        ");
		lbkc4.setPreferredSize(new Dimension(10, 50));
		JLabel lbkc6 = new JLabel("       ");
		lbkc6.setPreferredSize(new Dimension(10, 50));

		// add button vào pnEast
		pnEast.add(btnqldm);
		pnEast.add(lbkc);
		pnEast.add(btnqlmt);
		pnEast.add(lbkc1);
		pnEast.add(btnqls);
		pnEast.add(lbkc2);
		pnEast.add(btnqltv);
		pnEast.add(lbkc3);
		pnEast.add(btntk);
		pnEast.add(lbkc4);
		pnEast.add(btnkt);
		pnEast.add(lbkc6);

		pnEast.add(pnEastCon);
		pnBorder.add(pnEast, BorderLayout.EAST);

		// phần center chính nhập thông tin mượn sách
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		pnCenter.setBackground(Color.white);
		pnCenter.setPreferredSize(new Dimension(500, 100));

		JPanel pnCenterCon = new JPanel();
		Border border1 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Nhập Thông Tin");
		pnCenterCon.setBorder(borderTitle1);
		pnCenterCon.setPreferredSize(new Dimension(600, 340));
		pnCenterCon.setBackground(Color.lightGray);
		pnCenterCon.setLayout(new BoxLayout(pnCenterCon, BoxLayout.Y_AXIS));
		// text nhập thông tin
		JPanel pnCenterCon1 = new JPanel();
		txtCodeGD = new JTextField(20);
		lblCodeGD = new JLabel("Mã giao dịch: ");
		pnCenterCon1.add(lblCodeGD);
		pnCenterCon1.add(txtCodeGD);

		JPanel pnCenterCon2 = new JPanel();
		txtCodeTV = new JTextField(20);
		lblCodeTV = new JLabel("Mã thành viên:");
		pnCenterCon2.add(lblCodeTV);
		pnCenterCon2.add(txtCodeTV);

		JPanel pnCenterCon3 = new JPanel();
		lblMS = new JLabel("Mã sách: ");
		pnCenterCon3.setLayout(new BoxLayout(pnCenterCon3, BoxLayout.X_AXIS));
		//
		// Person[] list = { new Person("1", "Đỗ Công Thành"), new Person("2", "Nguyễn
		// Văn Hùng"),
		// new Person("3", "Trần Duy Thanh"), new Person("4", "Đoàn Ái Nương"), new
		// Person("10", "Đào Cẩm Hằng") };
		//
		// jl = new JList(list);
		// jl.setSelectionBackground(Color.RED);
		// jl.setSelectionForeground(Color.WHITE);
		// scjl = new JScrollPane(jl, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		// JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		// pnCenterCon7.add(lblSL);
		JPanel pnCenterCon7 = new JPanel();
		pnCenterCon7.setPreferredSize(new Dimension(20, 30));
		btnoo = new JButton("@");
		pnCenterCon7.add(lblMS);
		// pnCenterCon3.add(scjl);
		pnCenterCon7.add(btnoo);
		pnCenterCon3.add(pnCenterCon7);

		JPanel pnCenterCon4 = new JPanel();
		txtSL = new JTextField(20);
		lblCodeSL = new JLabel("số lượng:      ");
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

		QuanLyThanhVienUI myui = new QuanLyThanhVienUI();
		pnCenter.add(myui, "1");

		pnCenter.add(pnCenterCon);
		pnBorder.add(pnCenter, BorderLayout.CENTER);

		// thêm vào main
		con.add(pnBorder);
	}

	// public void addEvents() {
	//
	// tbl.addMouseListener(tblUserClick);
	// btnexit.addActionListener(btnExitClick);
	// btnadd.addActionListener(btAddClick);
	// btndelete.addActionListener(btdeleteClick);
	// btnedit.addActionListener(bteditClick);
	// btnimport.addActionListener(btimportClick);
	// btnseach.addActionListener(btnSeachClick);
	//
	// }

	ActionListener btnExitClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "làm sao đây "
					+ "");

		
		}
	};

	public void addEvents() {

		btnqltv.addActionListener(btnExitClick);
	}

	// phương thức này truyền qua main
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
