package fasttrackse.quanlythuvienUI.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import fasttrackse.quanlythuvien.DAO.TacGiaModel;
import fasttrackse.quanlythuvien.entity.TacGia;

public class QuanLyDanhMucUI extends JPanel {
	private JLabel lblCodetg, lblttg;
	private JButton btnreset, btnsua, btnthem, btnxoa;
	private JTextField txtttg, txtCodetg;
	private DefaultTableModel table = new DefaultTableModel();
	private JTable tbl;
	private Border raisedBevel = BorderFactory.createRaisedBevelBorder();

	JPanel pnCenterCon = new JPanel();
	JPanel pnCenter = new JPanel();
	JPanel pnSouth = new JPanel();
	JPanel pnWest = new JPanel();

	public static TacGiaModel tacGiaDAO = new TacGiaModel();
	public static ArrayList<TacGia> arr = new ArrayList<TacGia>();

	public QuanLyDanhMucUI() {
		// Container con = getContentPane();
		JPanel pnBorder = new JPanel();
		pnBorder.setPreferredSize(new Dimension(650, 550));
		pnBorder.setLayout(new BorderLayout());
		BorderLayout layout = new BorderLayout();
		layout.setHgap(5);
		layout.setVgap(5);
		pnBorder.setLayout(layout);
		pnBorder.setBackground(Color.LIGHT_GRAY);

		// phần footer màn hình
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));
		pnSouth.setPreferredSize(new Dimension(820, 235));
		// bảng table
		table.addColumn("Mã tác giả");
		table.addColumn("Tên tác giả");
		// table.addColumn("");
		// table.addColumn("Số lượng");
		// table.addColumn("Ngày mượn");
		// table.addColumn("Ngày trả");
		// table.addColumn("Ghi chú");
		this.getTable();
		tbl = new JTable(table);
		TableColumnModel columnModel = tbl.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(2);
		//columnModel.getColumn(1).setPreferredWidth(10);
		// columnModel.getColumn(4).setPreferredWidth(5);
		// columnModel.getColumn(5).setPreferredWidth(5);
		// columnModel.getColumn(6).setPreferredWidth(6);
		JScrollPane sc = new JScrollPane(tbl);
		pnSouth.add(sc);
		pnBorder.add(pnSouth, BorderLayout.SOUTH);

		// phần center chính nhập thông tin mượn sách
		pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		Border border1 = BorderFactory.createLineBorder(Color.darkGray);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Nhập Thông Tin Tác Giả");
		pnCenterCon.setBorder(borderTitle1);

		pnCenterCon.setPreferredSize(new Dimension(650, 300));
		pnCenterCon.setLayout(new BoxLayout(pnCenterCon, BoxLayout.Y_AXIS));
		// text nhập thông tin
		JPanel pnCenterCon1 = new JPanel();
		txtCodetg = new JTextField(20);
		lblCodetg = new JLabel("   Mã tác giả:");
		pnCenterCon1.add(lblCodetg);
		pnCenterCon1.add(txtCodetg);

		JPanel pnCenterCon2 = new JPanel();
		txtttg = new JTextField(20);
		lblttg = new JLabel("Tên tác giả:");
		pnCenterCon2.add(lblttg);
		pnCenterCon2.add(txtttg);

		// phần button thêm,sửa,xóa.....
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new BoxLayout(pnButton, BoxLayout.X_AXIS));
		pnButton.setPreferredSize(new Dimension(1000, 80));
		// pnButton.setBackground(Color.LIGHT_GRAY);

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

		// pnButton.add(ro);
		pnButton.add(lbkc7);
		pnButton.add(btnthem);
		pnButton.add(lbkc8);
		pnButton.add(btnsua);
		pnButton.add(lbkc9);
		pnButton.add(btnxoa);
		pnButton.add(lbkc10);
		pnButton.add(btnreset);

		pnCenterCon.add(pnCenterCon1);
		pnCenterCon.add(pnCenterCon2);
		pnCenterCon.add(pnButton);
		pnCenter.add(pnCenterCon);
		pnBorder.add(pnCenter, BorderLayout.CENTER);

		this.add(pnBorder);
	}

	public void getTable() {
		arr = tacGiaDAO.getDSTacGia();
		for (int i = 0; i < arr.size(); i++) {

			table.addRow(new String[] { arr.get(i).getMaTacGia(), arr.get(i).getTenTacGia(), });
		}
	}
	// public void xoaSinhVien() {
	// String maTacGia = txtCodetg.getText();
	// int[] rows = tbl.getSelectedRows();
	// for (int i = 0; i < rows.length; i++) {
	// tacGiaDAO.delete(maTacGia);
	// table.removeRow(rows[i] - i);
	//
	// }
	// }

}