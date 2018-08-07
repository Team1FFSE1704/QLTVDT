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

import fasttrackse.quanlythuvien.DAO.NhaXuatBanModel;
import fasttrackse.quanlythuvien.entity.Admin;
import fasttrackse.quanlythuvien.entity.NhaXuatBan;

public class NhaXuatBanUI extends JPanel {
	private DefaultTableModel table = new DefaultTableModel();
	private JTable tbl;
	private JLabel lblCodeNXB, lblNXB;
	private JButton btnreset, btnsua, btnthem, btnxoa;
	private JTextField txtCodeNXB, txtNXB;
	private Border raisedBevel = BorderFactory.createRaisedBevelBorder();

	JPanel pnCenterCon = new JPanel();
	JPanel pnCenter = new JPanel();
	JPanel pnSouth = new JPanel();
	JPanel pnWest = new JPanel();

	public static NhaXuatBanModel nhaXuatBanDAO = new NhaXuatBanModel();
	public static ArrayList<NhaXuatBan> arr = new ArrayList<NhaXuatBan>();

	// houver mouseListener
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

			txtCodeNXB.setEditable(false);
			int row = tbl.getSelectedRow();

			String maNhaXuatBan = (String) tbl.getValueAt(row, 0);
			txtCodeNXB.setText(maNhaXuatBan);

			String tenNhaXuatBan = (String) tbl.getValueAt(row, 1);
			txtNXB.setText(tenNhaXuatBan);

			btnthem.setEnabled(false);
			btnsua.setEnabled(true);
			btnxoa.setEnabled(true);
		}
	};

	// nhập thông tin mới
	ActionListener btnResetClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			txtCodeNXB.setEditable(true);
			btnthem.setEnabled(true);
			btnsua.setEnabled(false);
			btnxoa.setEnabled(false);

			txtCodeNXB.setText("");
			txtNXB.setText("");
		}
	};

	// Sự kiện thêm một phần tử vào database
	ActionListener btnAddClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			if (txtCodeNXB.getText().equals("") || txtNXB.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin !");
			} else {
				btnthem.setEnabled(true);
				btnsua.setEnabled(false);
				btnxoa.setEnabled(false);
				themNhaXuatBan();

			}

		}
	};

	// sửa một phần tử trong database
	ActionListener btnEditClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			if (txtNXB.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin !");
			} else {

				suaNhaXuatBan();

			}
		}
	};

	// xóa một phần tử trong database
	ActionListener btnDeleteClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			xoaNhaXuatBan();
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

	public NhaXuatBanUI() {
		addControl();
		addEvents();
	}

	public void addControl() {
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		pnBorder.setPreferredSize(new Dimension(650, 550));
		BorderLayout layout = new BorderLayout();
		layout.setHgap(5);
		layout.setVgap(5);
		pnBorder.setLayout(layout);
		pnBorder.setBackground(Color.LIGHT_GRAY);

		// phần footer màn hình
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));
		pnSouth.setPreferredSize(new Dimension(820, 235));
		// bảng table
		table.addColumn("Mã nhà xuất bản");
		table.addColumn("Tên nhà xuất bản");
		this.getTable();
		tbl = new JTable(table);
		TableColumnModel columnModel = tbl.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(2);
		// columnModel.getColumn(3).setPreferredWidth(4);
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
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Nhập Thông Tin Nhà Xuất Bản");
		pnCenterCon.setBorder(borderTitle1);

		pnCenterCon.setPreferredSize(new Dimension(650, 300));
		pnCenterCon.setLayout(new BoxLayout(pnCenterCon, BoxLayout.Y_AXIS));
		// text nhập thông tin
		JPanel pnCenterCon1 = new JPanel();
		txtCodeNXB = new JTextField(20);
		lblCodeNXB = new JLabel("   Mã nhà xuất bản:");
		pnCenterCon1.add(lblCodeNXB);
		pnCenterCon1.add(txtCodeNXB);

		JPanel pnCenterCon2 = new JPanel();
		txtNXB = new JTextField(20);
		lblNXB = new JLabel("Tên nhà xuất bản:");
		pnCenterCon2.add(lblNXB);
		pnCenterCon2.add(txtNXB);

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

	public void xoaNhaXuatBan() {
		String maNhaXuatBan = txtCodeNXB.getText();
		int[] rows = tbl.getSelectedRows();
		for (int i = 0; i < rows.length; i++) {
			nhaXuatBanDAO.delete(maNhaXuatBan);
			table.removeRow(rows[i] - i);

		}
	}

	public void themNhaXuatBan() {
		String maNhaXuatBan = txtCodeNXB.getText();
		String tenNhaXuatBan = txtNXB.getText();
		nhaXuatBanDAO.addNXB(new NhaXuatBan(maNhaXuatBan, tenNhaXuatBan));
		table.addRow(new String[] { maNhaXuatBan, tenNhaXuatBan });

	}

	public void suaNhaXuatBan() {
		String maNhaXuatBan = txtCodeNXB.getText();
		String tenNhaXuatBan = txtNXB.getText();
		NhaXuatBan ad = new NhaXuatBan(maNhaXuatBan, tenNhaXuatBan);
		nhaXuatBanDAO.edit(ad);

		int row = tbl.getSelectedRow();
		tbl.setValueAt(maNhaXuatBan, row, 0);
		tbl.setValueAt(tenNhaXuatBan, row, 1);

	}

	public void getTable() {
		arr = nhaXuatBanDAO.getDSNhaXuatBan();
		for (int i = 0; i < arr.size(); i++) {

			table.addRow(new String[] { arr.get(i).getMaNhaXuatBan(), arr.get(i).getTenNhaXuatBan(), });
		}
	}
}
