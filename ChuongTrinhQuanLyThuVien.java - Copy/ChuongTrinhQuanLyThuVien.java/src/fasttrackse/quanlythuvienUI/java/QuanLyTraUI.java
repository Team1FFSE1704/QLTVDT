package fasttrackse.quanlythuvienUI.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
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

public class QuanLyTraUI extends JPanel {
	private JLabel lblCodeGD1, lblCodeTV1, lblCodeSL1, lblNT1, lblMS1, lbWestMS1;
	private JTextField txtCodeTV1, txtCodeGD1, txtSL1, txtNT1;
	private JButton btnSubmit1;

	private DefaultTableModel table = new DefaultTableModel();
	private JTable tbl;

	private DateFormat ngay1;
	private Date date1, ngay2;
	private JScrollPane fruitListScrollPane1;
	private Border raisedBevel = BorderFactory.createRaisedBevelBorder();
	private Border raisedEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	private JMonthChooser jmc;
	private JYearChooser jyc;

	public QuanLyTraUI() {
		// boder chính

		// phần center chính nhập thông tin mượn sách
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		pnBorder.setPreferredSize(new Dimension(650, 550));
		
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		// pnCenter.setBackground(Color.gray);
		Border border1 = BorderFactory.createLineBorder(Color.darkGray);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Nhập Thông Tin Ngày Trả");

		JPanel pnCenterCon = new JPanel();
		pnCenterCon.setBorder(borderTitle1);
		pnCenterCon.setPreferredSize(new Dimension(655, 340));
		pnCenterCon.setLayout(new BoxLayout(pnCenterCon, BoxLayout.Y_AXIS));
		// text nhập thông tin
		JPanel pnCenterCon1 = new JPanel();
		txtCodeGD1 = new JTextField(20);
		lblCodeGD1 = new JLabel("   Mã giao dịch:");
		pnCenterCon1.add(lblCodeGD1);
		pnCenterCon1.add(txtCodeGD1);

		JPanel pnCenterCon2 = new JPanel();
		txtCodeTV1 = new JTextField(20);
		lblCodeTV1 = new JLabel("Mã thành viên:");
		pnCenterCon2.add(lblCodeTV1);
		pnCenterCon2.add(txtCodeTV1);

		JPanel pnCenterCon3 = new JPanel();
		lblMS1 = new JLabel("         Mã sách: ");
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

		fruitListScrollPane1 = new JScrollPane(fruitList);
		fruitListScrollPane1.setPreferredSize(new Dimension(225, 55));
		pnCenterCon3.add(lblMS1);
		pnCenterCon3.add(fruitListScrollPane1);

		JPanel pnCenterCon4 = new JPanel();
		txtSL1 = new JTextField(20);
		lblCodeSL1 = new JLabel("       số lượng: ");
		pnCenterCon4.add(lblCodeSL1);
		pnCenterCon4.add(txtSL1);

		JPanel pnCenterCon6 = new JPanel();
		txtNT1 = new JTextField(8);
		lblNT1 = new JLabel("       Ngày trả: ");
		ngay1 = new SimpleDateFormat("yyyy-MM-dd");
		ngay2 = new Date();
		txtNT1.setText(ngay1.format(ngay2));
		pnCenterCon6.add(lblNT1);
		pnCenterCon6.add(txtNT1);

		JPanel lbkc5 = new JPanel();
		btnSubmit1 = new JButton("Submit");
		lbkc5.add(btnSubmit1);

		pnCenterCon.add(pnCenterCon1);
		pnCenterCon.add(pnCenterCon2);
		pnCenterCon.add(pnCenterCon3);
		pnCenterCon.add(pnCenterCon4);
		pnCenterCon.add(pnCenterCon6);
		pnCenterCon.add(lbkc5);

		pnCenter.add(pnCenterCon);
		pnBorder.add(pnCenter, BorderLayout.CENTER);

		// phần footer màn hình
		JPanel pnSouth = new JPanel();
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));
		pnSouth.setPreferredSize(new Dimension(900, 200));
		// bảng table
		table.addColumn("Mã giao dịch");
		table.addColumn("Tên thành viên");
		table.addColumn("Tên sách");
		table.addColumn("Số lượng");
		table.addColumn("Ngày trả");
		table.addColumn("Ghi chú");
		tbl = new JTable(table);
		TableColumnModel columnModel = tbl.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(2);
		columnModel.getColumn(3).setPreferredWidth(4);
		// columnModel.getColumn(4).setPreferredWidth(5);
		// columnModel.getColumn(5).setPreferredWidth(5);
		// columnModel.getColumn(6).setPreferredWidth(6);
		JScrollPane sc = new JScrollPane(tbl);
		pnSouth.add(sc);
		pnBorder.add(pnSouth, BorderLayout.SOUTH);

		// thêm vào main
		this.add(pnBorder);
	}

}
