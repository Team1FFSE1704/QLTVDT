package fasttrackse.quanlythuvien.java.until;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class QuanLyThuVienUI extends JFrame {
	JLabel lblTitle;
	JButton btnqltv, btnqlmt, btnqls, btnqldm, btnexit, btntk;
	JTextField txtCodeS, txtCodeTV, txtCodeGD;
	DefaultTableModel table = new DefaultTableModel();
	JTable tbl;

	public void addConTrol() {

		// tạo container
		Container con = getContentPane();

		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());

		// phần header
		JPanel pnNorth = new JPanel();
		pnNorth.setBackground(Color.CYAN);
		pnNorth.setPreferredSize(new Dimension(100, 60));

		lblTitle = new JLabel("Chương Trình Quản Lý Thư Viện ");
		lblTitle.setForeground(Color.RED);
		Font fontTitle = new Font("Arial", Font.BOLD, 30);
		lblTitle.setFont(fontTitle);
		pnNorth.add(lblTitle);
		pnBorder.add(pnNorth, BorderLayout.NORTH);

		// phần footer màn hình
		JPanel pnSouth = new JPanel();
		pnSouth.setPreferredSize(new Dimension(1000, 200));
		pnSouth.setBackground(Color.PINK);
		
		// bảng table
		table.addColumn("Mã giao dịnh");
		table.addColumn("Tên thành viên");
		table.addColumn("Tên sách");
		table.addColumn("Số lượng");
		table.addColumn("Ngày mượn");
		table.addColumn("Ngày trả");
		table.addColumn("Ghi chú");
		tbl = new JTable(table);

		TableColumnModel columnModel = tbl.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(1);
		columnModel.getColumn(1).setPreferredWidth(1);
		columnModel.getColumn(3).setPreferredWidth(1);
		columnModel.getColumn(4).setPreferredWidth(1);

		JScrollPane sc = new JScrollPane(tbl);
		sc.setPreferredSize(new Dimension(1100, 300));
		pnBorder.add(pnSouth, BorderLayout.SOUTH);
		

		// phần bên trái màn hình
		JPanel pnWest = new JPanel();
		pnWest.setBackground(Color.orange);
		pnWest.setPreferredSize(new Dimension(200, 10));
		pnBorder.add(pnWest, BorderLayout.WEST);

		// phần bên phải và các button chính
		JPanel pnEast = new JPanel();
		
		pnEast.setBackground(Color.lightGray);
		pnEast.setPreferredSize(new Dimension(250, 50));
		pnEast.setLayout(new BoxLayout(pnEast, BoxLayout.Y_AXIS));

		btnqltv = new JButton("Quản lý thành viên ");
		btnqltv.setMargin(new Insets(10, 43, 10, 10));
		btnqltv.setForeground(Color.RED);

		btnqlmt = new JButton("Quản lý mượn trả ");
		btnqlmt.setMargin(new Insets(10, 43, 10, 10));
		btnqlmt.setForeground(Color.GREEN);

		btnqls = new JButton("Quản lý sách  ");
		btnqls.setMargin(new Insets(10, 50, 10, 50));
		btnqls.setForeground(Color.PINK);

		btnqldm = new JButton("Quản lý danh mục ");
		btnqldm.setMargin(new Insets(10, 43, 10, 43));
		btnqldm.setForeground(Color.BLUE);

		btntk = new JButton("Thông kê ");
		btntk.setMargin(new Insets(10, 43, 10, 43));
		btntk.setForeground(Color.BLUE);

		btnexit = new JButton("Kết thúc ");
		btnexit.setMargin(new Insets(10, 60, 10, 60));
		btnexit.setForeground(Color.ORANGE);
		JLabel lbkc = new JLabel("        ");
		JLabel lbkc1 = new JLabel("        ");
		JLabel lbkc2 = new JLabel("        ");
		JLabel lbkc3 = new JLabel("        ");
		JLabel lbkc4 = new JLabel("        ");

		// add button vào panner
		pnEast.add(btnqltv);
		pnEast.add(lbkc);
		pnEast.add(btnqlmt);
		pnEast.add(lbkc1);
		pnEast.add(btnqls);
		pnEast.add(lbkc2);
		pnEast.add(btnqldm);
		pnEast.add(lbkc3);
		pnEast.add(btntk);
		pnEast.add(lbkc4);
		pnEast.add(btnexit);
		getContentPane().add(pnBorder);
		pnBorder.add(pnEast, BorderLayout.EAST);

		// phần chính
		JPanel pnCenter = new JPanel();
		pnCenter.setBackground(Color.GREEN);
		pnCenter.setPreferredSize(new Dimension(500, 100));
		
		JPanel pnCenterCon = new JPanel();
		pnCenterCon.setBackground(Color.yellow);
		pnCenterCon.setLayout(new BoxLayout(pnCenterCon, BoxLayout.Y_AXIS));
		// text nhập thông tin
		txtCodeGD = new JTextField(20);
		JLabel lblCodeGD = new JLabel("Mã giao dịch:");
		pnCenterCon.add(lblCodeGD);
		pnCenterCon.add(txtCodeGD);

		txtCodeTV = new JTextField(20);
		JLabel lblCode = new JLabel("Mã thành viên:");
		pnCenterCon.add(lblCode);
		pnCenterCon.add(txtCodeTV);

		txtCodeS = new JTextField(20);
		JLabel lblCodeS = new JLabel("Mã quyển sách:");
		pnCenterCon.add(lblCodeS);
		pnCenterCon.add(txtCodeS);
		
		pnCenter.add(pnCenterCon);
		pnBorder.add(pnCenter, BorderLayout.CENTER);

		// thêm vào
		pnSouth.add(sc);
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

	public QuanLyThuVienUI(String title) {
		super(title);
		addConTrol();
		// addEvents();
	}

	public void showView() {
		this.setSize(1200, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
