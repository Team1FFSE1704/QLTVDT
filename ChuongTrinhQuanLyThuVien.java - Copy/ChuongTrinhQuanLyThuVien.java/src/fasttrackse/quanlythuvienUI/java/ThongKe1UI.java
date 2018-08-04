package fasttrackse.quanlythuvienUI.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ThongKe1UI extends JPanel {
	private JLabel lblnxb, lbltl, lbltg, lblCodeTV, lblCodeSL, lblNM, lblNT, lblMS, lbWestMS;
	// private JButton btnqltv, btnqlmt, btnqls, btnqldm, btnkt, btntk, btnSubmit,
	// btnts, btnms;
	private JTextField txtnxb, txttl, txttg, txtNM, txtNT;
	private DefaultTableModel table = new DefaultTableModel();
	private JTable tbl;
	// private JScrollPane fruitListScrollPane;
	// private JComboBox<String> cbo = new JComboBox<String>();

	// private Border raisedBevel = BorderFactory.createRaisedBevelBorder();
	private Border raisedEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);

	public ThongKe1UI() {
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		BorderLayout layout = new BorderLayout();
		layout.setHgap(5);
		layout.setVgap(5);
		pnBorder.setLayout(layout);
		pnBorder.setBackground(Color.LIGHT_GRAY);

		// phần header
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new BoxLayout(pnNorth, BoxLayout.X_AXIS));
		pnNorth.setBorder(raisedEtched);
		pnNorth.setPreferredSize(new Dimension(100, 80));
		pnNorth.setBackground(Color.BLACK);

		JPanel pnnhaXuatBan = new JPanel();
		txtnxb = new JTextField(10);
		lblnxb = new JLabel("Nhà xuất bản:");
		pnnhaXuatBan.add(lblnxb);
		pnnhaXuatBan.add(txtnxb);
		pnNorth.add(pnnhaXuatBan);

		JPanel pnTheLoai = new JPanel();
		txttl = new JTextField(10);
		lbltl = new JLabel("Thể loại:");
		pnTheLoai.add(lbltl);
		pnTheLoai.add(txttl);
		pnNorth.add(pnTheLoai);
		
		JPanel pnTacGia = new JPanel();
		txttg = new JTextField(10);
		lbltg = new JLabel("Tác giả:");
		pnTacGia.add(lbltg);
		pnTacGia.add(txttg);
		pnNorth.add(pnTacGia);
		
		pnBorder.add(pnNorth, BorderLayout.NORTH);

		// phần footer màn hình
		JPanel pnSouth = new JPanel();
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));
		pnSouth.setPreferredSize(new Dimension(820, 420));
		// bảng table
		table.addColumn("Stt");
		table.addColumn("Mã giao dịch");
		table.addColumn("Mã thành viên");
		table.addColumn("Họ tên");
		table.addColumn("Số điện thoại");
		table.addColumn("Số sách đã mượn");
		tbl = new JTable(table);
		TableColumnModel columnModel = tbl.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(10);
		// columnModel.getColumn(3).setPreferredWidth(4);
		// columnModel.getColumn(4).setPreferredWidth(5);
		// columnModel.getColumn(5).setPreferredWidth(5);

		JScrollPane sc = new JScrollPane(tbl);
		pnSouth.add(sc);
		pnBorder.add(pnSouth, BorderLayout.SOUTH);
		this.add(pnBorder);
	}
}
