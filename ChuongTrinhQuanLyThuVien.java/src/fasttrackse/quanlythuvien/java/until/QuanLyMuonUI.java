package fasttrackse.quanlythuvien.java.until;

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

public class QuanLyMuonUI extends JFrame {
	private JLabel lblTitle, lbWestTS, lblCodeGD, lblCodeTV, lblCodeSL, lblNM, lblNT, lblMS, lbWestMS;
	private JButton btnqltv, btnqlmt, btnqls, btnqldm, btnkt, btntk, btnSubmit, btnoo;
	private JTextField txtCodeTV, txtCodeGD, txtSL, txtNM, txtNT;
	private DefaultTableModel table = new DefaultTableModel();
	private DefaultListModel fruitsName = new DefaultListModel();
	private JTable tbl;
	// private JList fruitList;
	DateFormat ngay;
	Date date, ngay1;
	private JScrollPane fruitListScrollPane;
	private Border raisedBevel = BorderFactory.createRaisedBevelBorder();
	private Border raisedEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);

	QuanLyThanhVienUI myui = new QuanLyThanhVienUI();
	JPanel pnCenterCon = new JPanel();

	// tạo console
	public void addConTrol() {

		// tạo container và boder chính
		Container con = getContentPane();
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		BorderLayout layout = new BorderLayout();
		layout.setHgap(10);
		layout.setVgap(10);
		pnBorder.setLayout(layout);
		pnBorder.setBackground(Color.gray);
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
		JPanel pnSouth = new JPanel();
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
		JPanel pnWest = new JPanel();
		// pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));
		pnWest.setBackground(Color.orange);
		pnWest.setBorder(raisedBevel);
		pnWest.setPreferredSize(new Dimension(160, 250));

		// panner con
		JPanel pnWestCon = new JPanel();
		pnWestCon.setBackground(Color.WHITE);
		pnWestCon.setPreferredSize(new Dimension(130, 200));
		Border border = BorderFactory.createLineBorder(Color.darkGray);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Mượn trả Sách");

		JPanel pnWestCon1 = new JPanel();
		pnWestCon1.setPreferredSize(new Dimension(110, 30));
		lbWestMS = new JLabel("mượn sách");
		

		JPanel pnWestCon2 = new JPanel();
		pnWestCon2.setPreferredSize(new Dimension(110, 30));
		lbWestTS = new JLabel("Trả sách");
		
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
				new ImageIcon("icon/danhmuc.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
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
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));

		// pnCenter.setPreferredSize(new Dimension(500, 400));
		pnCenter.setBackground(Color.gray);

		// pnCenterCon.setBackground(Color.white);
		Border border1 = BorderFactory.createLineBorder(Color.darkGray);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Nhập Thông Tin");
		pnCenterCon.setBorder(borderTitle1);
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
		lblMS = new JLabel("         Mã sách: ");
		fruitsName = new DefaultListModel();

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
		fruitListScrollPane.setPreferredSize(new Dimension(225,55));
		pnCenterCon3.add(lblMS);
		pnCenterCon3.add(fruitListScrollPane);

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
		pnCenter.add(myui);
		myui.setVisible(false);
		pnBorder.add(pnCenter, BorderLayout.CENTER);

		// thêm vào main
		con.add(pnBorder);
	}

	public void addEvents() {

		btnqldm.addActionListener(btnExitClick);
		btntk.addActionListener(btnThongKeClick);

	}

	ActionListener btnExitClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			pnCenterCon.setVisible(false);
			myui.setVisible(true);
		}
	};

	ActionListener btnThongKeClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			myui.setVisible(false);
			pnCenterCon.setVisible(true);
		}
	};
	// public void addEvents() {
	//
	// btnqltv.addActionListener(btnExitClick);
	// }

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
