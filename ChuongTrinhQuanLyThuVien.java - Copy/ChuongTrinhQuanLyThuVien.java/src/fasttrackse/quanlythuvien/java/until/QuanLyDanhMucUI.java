package fasttrackse.quanlythuvien.java.until;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class QuanLyDanhMucUI extends JPanel {
	private static final String EXIT_ON_CLOSE = null;
	private JLabel lblTitle, lbWestTS, lblCodeGD, lblCodeTV, lblCodeSL, lblNM, lblNT, lblMS, lbWestMS;
	private JButton btntg, btnnxb, btnqh, btntp, btnkt, btntk, btnSubmit, btnts, btnms;
	private JTextField txtCodeTV, txtCodeGD, txtSL, txtNM, txtNT;
	private DefaultTableModel table = new DefaultTableModel();
	private JTable tbl;
	private DateFormat ngay;
	private Date date, ngay1;
	private JScrollPane fruitListScrollPane;
	private Border raisedBevel = BorderFactory.createRaisedBevelBorder();

	JPanel pnCenterCon = new JPanel();
	JPanel pnCenter = new JPanel();
	JPanel pnSouth = new JPanel();
	JPanel pnWest = new JPanel();

	public QuanLyDanhMucUI() {
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());

		// phần footer màn hình
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));
		pnSouth.setPreferredSize(new Dimension(820, 200));
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
		pnWestCon.setPreferredSize(new Dimension(150, 200));
		Border border = BorderFactory.createLineBorder(Color.darkGray);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Mượn trả Sách");

		JPanel pnWestCon1 = new JPanel();
		pnWestCon1.setPreferredSize(new Dimension(130, 30));
		btntg = new JButton("Tác Giả");
		btntg.setPreferredSize(new Dimension(110, 20));

		JPanel pnWestCon2 = new JPanel();
		pnWestCon2.setPreferredSize(new Dimension(130, 30));
		btnnxb = new JButton("Nhà xuất bản");
		btnnxb.setPreferredSize(new Dimension(110, 20));

		JPanel pnWestCon3 = new JPanel();
		pnWestCon3.setPreferredSize(new Dimension(130, 30));
		btntp = new JButton("Thành phố");
		btntp.setPreferredSize(new Dimension(110, 20));

		JPanel pnWestCon4 = new JPanel();
		pnWestCon4.setPreferredSize(new Dimension(130, 30));
		btnqh = new JButton("Quận/huyện");
		btnqh.setPreferredSize(new Dimension(110, 20));

		pnWestCon.setBorder(borderTitle);
		pnWestCon1.add(btntg);
		pnWestCon2.add(btnnxb);
		pnWestCon3.add(btntp);
		pnWestCon4.add(btnqh);

		pnWestCon.add(pnWestCon1);
		pnWestCon.add(pnWestCon2);
		pnWestCon.add(pnWestCon3);
		pnWestCon.add(pnWestCon4);
		pnWest.add(pnWestCon);
		pnBorder.add(pnWest, BorderLayout.WEST);
		// hết phần bên trái màn hình

		// phần center chính nhập thông tin mượn sách
		pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		Border border1 = BorderFactory.createLineBorder(Color.darkGray);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Nhập Thông Tin");
		pnCenterCon.setBorder(borderTitle1);

		pnCenterCon.setPreferredSize(new Dimension(650, 330));
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
		pnBorder.add(pnCenter, BorderLayout.CENTER);

		this.add(pnBorder);
	}

	
	

	
}
