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

import fasttrackse.quanlythuvien.DAO.TheLoaiModel;
import fasttrackse.quanlythuvien.entity.NhaXuatBan;
import fasttrackse.quanlythuvien.entity.TheLoai;

public class TheLoaiUI extends JPanel {
	private DefaultTableModel table = new DefaultTableModel();
	private JTable tbl;
	private JLabel lblCodeTL, lblTL;
	private JButton btnreset, btnsua, btnthem, btnxoa;
	private JTextField txtCodeTL, txtTL;
	private Border raisedBevel = BorderFactory.createRaisedBevelBorder();

	JPanel pnCenterCon = new JPanel();
	JPanel pnCenter = new JPanel();
	JPanel pnSouth = new JPanel();
	JPanel pnWest = new JPanel();

	public static TheLoaiModel theLoaiDAO = new TheLoaiModel();
	public static ArrayList<TheLoai> arr = new ArrayList<TheLoai>();

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

			txtCodeTL.setEditable(false);
			int row = tbl.getSelectedRow();

			String maTheLoai = (String) tbl.getValueAt(row, 0);
			txtCodeTL.setText(maTheLoai);

			String tenTheLoai = (String) tbl.getValueAt(row, 1);
			txtTL.setText(tenTheLoai);

			btnthem.setEnabled(false);
			btnsua.setEnabled(true);
			btnxoa.setEnabled(true);
		}
	};

	// nhập thông tin mới
	ActionListener btnResetClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			txtCodeTL.setEditable(true);
			btnthem.setEnabled(true);
			btnsua.setEnabled(false);
			btnxoa.setEnabled(false);

			txtCodeTL.setText("");
			txtTL.setText("");
		}
	};

	// Sự kiện thêm một phần tử vào database
	ActionListener btnAddClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			// tạo một biến để kiểm tra ban đầu bằng 0;
			int ktTonTaiMaTheLoai = 0;
			int ktTonTaiTenTheLoai = 0;

			// kiểm tra ô jtext
			String ktMaTheLoai = txtCodeTL.getText();
			String ktTenTheLoai = txtTL.getText();

			// đếm trong bộ nhớ có bao nhiêu phần tử
			int maTheLoai = ktMaTheLoai.length();
			int tenTheLoai = ktTenTheLoai.length();

			// bắt lỗi mã và tên tác giả nếu trùng thì bắt nhập lại tên và mã khác
			for (int i = 0; i < arr.size(); i++) {
				if (ktMaTheLoai.equals(arr.get(i).getMaTheLoai())) {
					ktTonTaiMaTheLoai = 1;
				} else if (ktTenTheLoai.equals(arr.get(i).getTenTheLoai())) {
					ktTonTaiTenTheLoai = 1;
				}
			}

			// hiển thị thông báo
			if (ktMaTheLoai.isEmpty() || ktTenTheLoai.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin! ");
			} else if (ktTonTaiMaTheLoai == 1) {
				JOptionPane.showMessageDialog(null, "Mã thể loại đã bị trùng vui lòng nhập lại! ");

			} else if (ktTonTaiTenTheLoai == 1) {
				JOptionPane.showMessageDialog(null, "Tên thể loại đã bị trùng vui lòng nhập lại tên thể loại! ");

			} else {
				btnthem.setEnabled(true);
				btnsua.setEnabled(false);
				btnxoa.setEnabled(false);
				themTheLoai();
			}

		}
	};

	// sửa một phần tử trong database
	ActionListener btnEditClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			// tạo một biến để kiểm tra ban đầu bằng 0;
			int ktTonTaiTenTheLoai = 0;

			// kiểm tra ô jtext
			String ktTenTheLoai = txtTL.getText();

			// đếm trong bộ nhớ có bao nhiêu phần tử
			int tenTheLoai = ktTenTheLoai.length();

			// bắt lỗi mã và tên tác giả nếu trùng thì bắt nhập lại tên và mã khác
			for (int i = 0; i < arr.size(); i++) {
				if (ktTenTheLoai.equals(arr.get(i).getTenTheLoai())) {
					ktTonTaiTenTheLoai = 1;
				}
			}

			// hiển thị thông báo
			if (ktTenTheLoai.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin! ");
			} else if (ktTonTaiTenTheLoai == 1) {
				JOptionPane.showMessageDialog(null, "Tên thể loại đã bị trùng vui lòng nhập lại tên thể loại! ");

			} else {
				btnthem.setEnabled(true);
				btnsua.setEnabled(false);
				btnxoa.setEnabled(false);
				themTheLoai();
			}
		}
	};

	// xóa một phần tử trong database
	ActionListener btnDeleteClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int ret = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa thông tin thể loại sách này ", "Thư Viện ",
					JOptionPane.YES_NO_OPTION);
			if (ret == JOptionPane.YES_OPTION) {
				xoaTheLoai();
			}
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

	public TheLoaiUI() {
		addControl();
		addEvents();
	}

	public void addControl() {
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
		table.addColumn("Mã thể loại");
		table.addColumn("Tên thể loại");
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
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Nhập Thông Tin Địa Chỉ");
		pnCenterCon.setBorder(borderTitle1);

		pnCenterCon.setPreferredSize(new Dimension(650, 300));
		pnCenterCon.setLayout(new BoxLayout(pnCenterCon, BoxLayout.Y_AXIS));
		// text nhập thông tin
		JPanel pnCenterCon1 = new JPanel();
		txtCodeTL = new JTextField(20);
		lblCodeTL = new JLabel("Mã thể loại:");
		pnCenterCon1.add(lblCodeTL);
		pnCenterCon1.add(txtCodeTL);

		JPanel pnCenterCon2 = new JPanel();
		txtTL = new JTextField(20);
		lblTL = new JLabel("Tên thể loại:");
		pnCenterCon2.add(lblTL);
		pnCenterCon2.add(txtTL);

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

	public void xoaTheLoai() {
		String maTheLoai = txtCodeTL.getText();
		int[] rows = tbl.getSelectedRows();
		for (int i = 0; i < rows.length; i++) {
			theLoaiDAO.delete(maTheLoai);
			table.removeRow(rows[i] - i);

		}
	}

	public void themTheLoai() {
		String maTheLoai = txtCodeTL.getText();
		String tenTheLoai = txtTL.getText();
		theLoaiDAO.add(new TheLoai(maTheLoai, tenTheLoai));
		table.addRow(new String[] { maTheLoai, tenTheLoai });

	}

	public void suaTheLoai() {
		String maTheLoai = txtCodeTL.getText();
		String tenTheLoai = txtTL.getText();
		TheLoai ad = new TheLoai(maTheLoai, tenTheLoai);
		theLoaiDAO.edit(ad);

		int row = tbl.getSelectedRow();
		tbl.setValueAt(maTheLoai, row, 0);
		tbl.setValueAt(tenTheLoai, row, 1);

	}

	public void getTable() {
		arr = theLoaiDAO.getDSTheLoai();
		for (int i = 0; i < arr.size(); i++) {

			table.addRow(new String[] { arr.get(i).getMaTheLoai(), arr.get(i).getTenTheLoai(), });
		}
	}

}
