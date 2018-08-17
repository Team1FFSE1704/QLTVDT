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

import fasttrackse.quanlythuvien.DAO.AdminModel;
import fasttrackse.quanlythuvien.entity.Admin;

public class AdminUI extends JPanel {

	private DefaultTableModel table = new DefaultTableModel();
	private JTable tbl;
	private JLabel lblAD, lblPW;
	private JButton btnreset, btnsua, btnthem, btnxoa;
	private JTextField txtPW, txtAD;
	private Border raisedBevel = BorderFactory.createRaisedBevelBorder();

	JPanel pnCenterCon = new JPanel();
	JPanel pnCenter = new JPanel();
	JPanel pnSouth = new JPanel();
	JPanel pnWest = new JPanel();

	public static AdminModel adminDAO = new AdminModel();
	public static ArrayList<Admin> arr = new ArrayList<Admin>();

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

			txtAD.setEditable(false);
			int row = tbl.getSelectedRow();

			String maTacGia = (String) tbl.getValueAt(row, 0);
			txtAD.setText(maTacGia);

			String tenTacGia = (String) tbl.getValueAt(row, 1);
			txtPW.setText(tenTacGia);

			btnthem.setEnabled(false);
			btnsua.setEnabled(true);
			btnxoa.setEnabled(true);
		}
	};

	public AdminUI() {
		addContros();
		addEvents();
	}

	// nhập thông tin mới
	ActionListener btnResetClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			txtAD.setEditable(true);
			btnthem.setEnabled(true);
			btnsua.setEnabled(false);
			btnxoa.setEnabled(false);

			txtAD.setText("");
			txtPW.setText("");
		}
	};

	// Sự kiện thêm một phần tử vào database
	ActionListener btnAddClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			// tạo một biến để kiểm tra ban đầu bằng 0;
			int ktTonTaiTenAdmin = 0;

			// kiểm tra ô jtext
			String ktTenAdmin = txtAD.getText();
			String ktPassWord = txtPW.getText();
			
			// đếm trong bộ nhớ có bao nhiêu phần tử
			int tenAdmin = ktTenAdmin.length();

			// bắt lỗi mã và tên tác giả nếu trùng thì bắt nhập lại tên 
			for (int i = 0; i < arr.size(); i++) {
				if (ktTenAdmin.equals(arr.get(i).getTenAdmin())) {
					ktTonTaiTenAdmin = 1;
				}
			}

			// hiển thị thông báo
			if (ktTenAdmin.isEmpty() || ktPassWord.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin! ");
			}else if (ktTonTaiTenAdmin == 1) {
				JOptionPane.showMessageDialog(null, "Tên admin đã bị trùng vui lòng nhập lại tên admin! ");

			} else {
				btnthem.setEnabled(true);
				btnsua.setEnabled(false);
				btnxoa.setEnabled(false);
				themAdmin();
			}

		}
	};

	// sửa một phần tử trong database
	ActionListener btnEditClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			if (txtPW.getText().isEmpty()) {
				String msg = "Bạn chưa nhập đầy đủ thông tin ! ";
				JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
			} else {

				suaAdmin();

			}
		}
	};

	// xóa một phần tử trong database
	ActionListener btnDeleteClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int ret = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa thông tin Admin này ", "Thư Viện ",
					JOptionPane.YES_NO_OPTION);
			if (ret == JOptionPane.YES_OPTION) {
				xoaAdmin();
			}
		}
	};

	// phần add sự kiện
	public void addEvents() {
		// các menu chính
		btnreset.addActionListener(btnResetClick);
		btnxoa.addActionListener(btnDeleteClick);
		btnthem.addActionListener(btnAddClick);
		btnsua.addActionListener(btnEditClick);

	}

	public void addContros() {
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

		table.addColumn("Tên admin");
		table.addColumn("Password");
		this.getTable();
		tbl = new JTable(table);
		TableColumnModel columnModel = tbl.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(2);
		// columnModel.getColumn(3).setPreferredWidth(4);
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
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Nhập Thông Tin Admin");
		pnCenterCon.setBorder(borderTitle1);

		pnCenterCon.setPreferredSize(new Dimension(650, 300));
		pnCenterCon.setLayout(new BoxLayout(pnCenterCon, BoxLayout.Y_AXIS));
		// text nhập thông tin

		JPanel pnCenterCon2 = new JPanel();
		txtAD = new JTextField(20);
		lblAD = new JLabel("Tên admin:");
		pnCenterCon2.add(lblAD);
		pnCenterCon2.add(txtAD);

		JPanel pnCenterCon3 = new JPanel();
		txtPW = new JTextField(20);
		lblPW = new JLabel("Password:");
		pnCenterCon3.add(lblPW);
		pnCenterCon3.add(txtPW);

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

		pnCenterCon.add(pnCenterCon2);
		pnCenterCon.add(pnCenterCon3);
		pnCenterCon.add(pnButton);
		pnCenter.add(pnCenterCon);
		pnBorder.add(pnCenter, BorderLayout.CENTER);

		this.add(pnBorder);
	}

	public void xoaAdmin() {
		String maAdmin = txtAD.getText();
		int[] rows = tbl.getSelectedRows();
		for (int i = 0; i < rows.length; i++) {
			adminDAO.delete(maAdmin);
			table.removeRow(rows[i] - i);

		}
	}

	public void themAdmin() {
		String tenAdmin = txtAD.getText();
		String passWord = txtPW.getText();
		adminDAO.add(new Admin(tenAdmin, passWord));
		table.addRow(new String[] { tenAdmin, passWord });

	}

	public void suaAdmin() {
		String tenAdmin = txtAD.getText();
		String passWord = txtPW.getText();
		Admin ad = new Admin(tenAdmin, passWord);
		adminDAO.edit(ad);

		int row = tbl.getSelectedRow();
		tbl.setValueAt(tenAdmin, row, 0);
		tbl.setValueAt(passWord, row, 1);

	}

	public void getTable() {
		arr = adminDAO.getDSAdmin();
		for (int i = 0; i < arr.size(); i++) {

			table.addRow(new String[] { arr.get(i).getTenAdmin(), arr.get(i).getPassWord() });
		}
	}

}
