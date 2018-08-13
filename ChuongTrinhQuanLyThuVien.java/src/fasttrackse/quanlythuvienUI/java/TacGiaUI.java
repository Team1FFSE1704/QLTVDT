package fasttrackse.quanlythuvienUI.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

public class TacGiaUI extends JPanel {
	private JLabel lblCodetg, lblTg;
	private JButton btnreset, btnsua, btnthem, btnxoa;
	private JTextField txtTg, txtCodetg;
	private DefaultTableModel table = new DefaultTableModel();
	private JTable tbl;

	JPanel pnCenterCon = new JPanel();
	JPanel pnCenter = new JPanel();
	JPanel pnSouth = new JPanel();
	JPanel pnWest = new JPanel();

	public static TacGiaModel tacGiaDAO = new TacGiaModel();
	public static ArrayList<TacGia> arr = new ArrayList<TacGia>();

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

			txtCodetg.setEditable(false);
			int row = tbl.getSelectedRow();

			String maTacGia = (String) tbl.getValueAt(row, 0);
			txtCodetg.setText(maTacGia);

			String tenTacGia = (String) tbl.getValueAt(row, 1);
			txtTg.setText(tenTacGia);

			btnthem.setEnabled(false);
			btnsua.setEnabled(true);
			btnxoa.setEnabled(true);
		}
	};

	// nhập thông tin mới
	ActionListener btnResetClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			txtCodetg.setEditable(true);
			btnthem.setEnabled(true);
			btnsua.setEnabled(false);
			btnxoa.setEnabled(false);

			txtCodetg.setText("");
			txtTg.setText("");
		}
	};

	// Sự kiện thêm một phần tử vào database
	ActionListener btnAddClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			if (txtCodetg.getText().equals("") || txtTg.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin !");
			} else {
				btnthem.setEnabled(true);
				btnsua.setEnabled(false);
				btnxoa.setEnabled(false);
				themTacGia();

			}

		}
	};

	// sửa một phần tử trong database
	ActionListener btnEditClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			if (txtTg.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin !");
			} else {

				suaTacGia();

			}
		}
	};

	// xóa một phần tử trong database
	ActionListener btnDeleteClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			xoaTacGia();
		}
	};

	// phần add sự kiện
	public void addEvents() {
		// các menu chính
		tbl.addMouseListener(tblUserClick);
		btnreset.addActionListener(btnResetClick);
		btnxoa.addActionListener(btnDeleteClick);
		btnthem.addActionListener(btnAddClick);
		btnsua.addActionListener(btnEditClick);

	}

	public TacGiaUI() {
		addControls();
		addEvents();
	}

	public void addControls() {
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
		// columnModel.getColumn(1).setPreferredWidth(10);
		// columnModel.getColumn(4).setPreferredWidth(5);
		// columnModel.getColumn(5).setPreferredWidth(5);
		// columnModel.getColumn(6).setPreferredWidth(6);
		JScrollPane sc = new JScrollPane(tbl);
		tbl.addMouseListener(tblUserClick);

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
		txtTg = new JTextField(20);
		lblTg = new JLabel("Tên tác giả:");
		pnCenterCon2.add(lblTg);
		pnCenterCon2.add(txtTg);

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
		btnsua.setEnabled(false);

		ImageIcon update2 = new ImageIcon(
				new ImageIcon("icon/xoa.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		btnxoa = new JButton("xóa ", update2);
		btnxoa.setMargin(new Insets(5, 10, 5, 10));
		btnxoa.setEnabled(false);

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

	public void xoaTacGia() {
		String maTacGia = txtCodetg.getText();
		int[] rows = tbl.getSelectedRows();
		for (int i = 0; i < rows.length; i++) {
			tacGiaDAO.delete(maTacGia);
			table.removeRow(rows[i] - i);

		}
	}

	public void themTacGia() {
		String maTacGia = txtCodetg.getText();
		String tenTacGia = txtTg.getText();
		tacGiaDAO.add(new TacGia(maTacGia, tenTacGia));
		table.addRow(new String[] { maTacGia, tenTacGia });

	}

	public void suaTacGia() {
		String maTacGia = txtCodetg.getText();
		String tenTacGia = txtTg.getText();
		TacGia ad = new TacGia(maTacGia, tenTacGia);
		tacGiaDAO.edit(ad);

		int row = tbl.getSelectedRow();
		tbl.setValueAt(maTacGia, row, 0);
		tbl.setValueAt(tenTacGia, row, 1);

	}

	public void getTable() {
		arr = tacGiaDAO.getDSTacGia();
		for (int i = 0; i < arr.size(); i++) {

			table.addRow(new String[] { arr.get(i).getMaTacGia(), arr.get(i).getTenTacGia(), });
		}
	}

	

}
