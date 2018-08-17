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
import javax.swing.JComboBox;
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
import fasttrackse.quanlythuvien.DAO.QuanLySachModel;
import fasttrackse.quanlythuvien.DAO.TacGiaModel;
import fasttrackse.quanlythuvien.DAO.TheLoaiModel;
import fasttrackse.quanlythuvien.entity.NhaXuatBan;
import fasttrackse.quanlythuvien.entity.QuanLySach;
import fasttrackse.quanlythuvien.entity.TacGia;
import fasttrackse.quanlythuvien.entity.TheLoai;

public class QuanLySachUI extends JPanel {
	private JLabel lblCodeS, lblTS, lblTG, lblNSX, lblNXB, lblSL, lblTL;
	private JButton btnreset, btnsua, btnthem, btnxoa;
	private JTextField txtCodeS, txtTS, txtNXB, txtSL;
	private DefaultTableModel table = new DefaultTableModel();
	private JTable tbl;
	private JComboBox<String> tacGia, nhaXuatBan, theLoai;

	// private DateFormat year;
	// private Date nam;

	private NhaXuatBanModel listNXB = new NhaXuatBanModel();
	private TacGiaModel listTG = new TacGiaModel();
	private TheLoaiModel listTL = new TheLoaiModel();
	private QuanLySachModel quanLySachDAO = new QuanLySachModel();

	private ArrayList<NhaXuatBan> arrNXB = new ArrayList<NhaXuatBan>();
	private ArrayList<TacGia> arrTG = new ArrayList<TacGia>();
	private ArrayList<TheLoai> arrTL = new ArrayList<TheLoai>();
	private ArrayList<QuanLySach> arr = new ArrayList<QuanLySach>();

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

			txtCodeS.setEditable(false);
			int row = tbl.getSelectedRow();

			String maSach = (String) tbl.getValueAt(row, 0);
			txtCodeS.setText(maSach);

			String tenSach = (String) tbl.getValueAt(row, 1);
			txtTS.setText(tenSach);

			String tenTacGia = (String) tbl.getValueAt(row, 2);
			tacGia.setSelectedItem(tenTacGia);

			String tennhaXuatBan = (String) tbl.getValueAt(row, 3);
			nhaXuatBan.setSelectedItem(tennhaXuatBan);

			String namXuatBan = (String) tbl.getValueAt(row, 4);
			txtNXB.setText(namXuatBan);

			String soLuong = (String) tbl.getValueAt(row, 6);
			txtSL.setText(soLuong);

			String tentheLoai = (String) tbl.getValueAt(row, 5);
			theLoai.setSelectedItem(tentheLoai);

			btnthem.setEnabled(false);
			btnsua.setEnabled(true);
			btnxoa.setEnabled(true);
		}
	};

	// nhập thông tin mới
	ActionListener btnResetClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			txtCodeS.setEditable(true);
			btnthem.setEnabled(true);
			btnsua.setEnabled(false);
			btnxoa.setEnabled(false);

			txtCodeS.setText("");
			txtTS.setText("");
			txtNXB.setText("");
			txtSL.setText("");
			tacGia.setSelectedIndex(0);
			theLoai.setSelectedIndex(0);
			nhaXuatBan.setSelectedIndex(0);
		}
	};

	// Sự kiện thêm một phần tử vào database
	ActionListener btnAddClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int ktNamXuatBan = 0;
			int ktSoLuong = 0;
			int ktTonTaiMaSach = 0;
			int ktTonTaiTenSach = 0;

			String ktMaSach = txtCodeS.getText();
			String ktTenSach = txtTS.getText();
			String ktNXB = txtNXB.getText();
			String ktSL = txtSL.getText();

			ktMaSach.length();
			ktTenSach.length();

			// bắt lỗi mã sách và tên sách đã tồn tại hay chưa nếu tên sách trùng thì chỉ
			// cộng số lượng lên .
			for (int i = 0; i < arr.size(); i++) {
				if (ktMaSach.equals(arr.get(i).getMaSach())) {
					ktTonTaiMaSach = 1;
				} else if (ktTenSach.equals(arr.get(i).getTenSach())) {

					ktTonTaiTenSach = 1;
				}
			}
			// bắt lỗi không cho nhập chữ trong năm xuất bản
			try {
				@SuppressWarnings("unused")
				Double namXuatBan = Double.parseDouble(txtNXB.getText());

			} catch (Exception ex) {
				ktNamXuatBan = 1;

			}

			// bắt lỗi ko cho nhập chữ trong ô số lượng
			try {

				@SuppressWarnings("unused")
				Double soLuong = Double.parseDouble(txtSL.getText());
			} catch (Exception ex) {

				ktSoLuong = 1;
			}
			if (ktMaSach.isEmpty() || ktTenSach.isEmpty() || ktNXB.isEmpty() || ktSL.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin! ");
			} else if (tacGia.getSelectedItem().toString().equals("chọn tác giả")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn tác giả! ");
			} else if (theLoai.getSelectedItem().toString().equals("chọn thể loại")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn thể loại! ");
			} else if (nhaXuatBan.getSelectedItem().toString().equals("chọn nhà xuất bản")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhà xuất bản! ");
			} else if (ktNamXuatBan == 1) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng năm xuất bản(VD: 2018)!");
			} else if (ktSoLuong == 1) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng số lượng!");

			} else if (ktTonTaiMaSach == 1) {
				JOptionPane.showMessageDialog(null, "Mã đã bị trùng vui lòng đổi lại mã sách!");

			} else if (ktTonTaiTenSach == 1) {
				JOptionPane.showMessageDialog(null, "Tên sách đã bị trùng vui lòng đổi lại tên sách!");
			} else {
				themSach();
			}

		}
	};

	// sửa một phần tử trong database
	ActionListener btnEditClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//
			int ktNamXuatBan = 0;
			int ktSoLuong = 0;
			int ktTonTaiTenSach = 0;

			String ktTenSach = txtTS.getText();
			String ktNXB = txtNXB.getText();
			String ktSL = txtSL.getText();

			ktTenSach.length();

			// bắt lỗi mã sách và tên sách đã tồn tại hay chưa nếu tên sách trùng thì chỉ
			// cộng số lượng lên .
			for (int i = 0; i < arr.size(); i++) {
				if (ktTenSach.equals(arr.get(i).getTenSach())) {

					ktTonTaiTenSach = 1;
				}
			}
			// bắt lỗi không cho nhập chữ trong năm xuất bản
			try {
				@SuppressWarnings("unused")
				Double namXuatBan = Double.parseDouble(txtNXB.getText());

			} catch (Exception ex) {
				ktNamXuatBan = 1;

			}

			// bắt lỗi ko cho nhập chữ trong ô số lượng
			try {

				@SuppressWarnings("unused")
				Double soLuong = Double.parseDouble(txtSL.getText());
			} catch (Exception ex) {

				ktSoLuong = 1;
			}
			if (ktTenSach.isEmpty() || ktNXB.isEmpty() || ktSL.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin! ");
			} else if (tacGia.getSelectedItem().toString().equals("chọn tác giả")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn tác giả! ");
			} else if (theLoai.getSelectedItem().toString().equals("chọn thể loại")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn thể loại! ");
			} else if (nhaXuatBan.getSelectedItem().toString().equals("chọn nhà xuất bản")) {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhà xuất bản! ");
			} else if (ktNamXuatBan == 1) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng năm xuất bản(VD: 2018)!");
			} else if (ktSoLuong == 1) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng số lượng!");

			} else if (ktTonTaiTenSach == 1) {
				JOptionPane.showMessageDialog(null, "Tên sách đã bị trùng vui lòng đổi lại tên sách!");
			} else {
				themSach();
			}

		}
	};

	// xóa một phần tử trong database
	ActionListener btnDeleteClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int ret = JOptionPane.showConfirmDialog(null, "Bạn muốn xóa thông tin quyển sách này ", "Thư Viện ",
					JOptionPane.YES_NO_OPTION);
			if (ret == JOptionPane.YES_OPTION) {
				xoaSach();
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

	public QuanLySachUI() {
		addControl();
		addEvents();
	}

	public void addControl() {
		// tạo container và boder chính
		JPanel pnBorder = new JPanel();
		pnBorder.setPreferredSize(new Dimension(820, 700));
		pnBorder.setLayout(new BorderLayout());
		pnBorder.setLayout(new BoxLayout(pnBorder, BoxLayout.Y_AXIS));

		// phần trung tâm nhập thông tin
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		pnCenter.setBackground(Color.LIGHT_GRAY);

		JPanel pnCenterCon = new JPanel();
		pnCenterCon.setLayout(new BoxLayout(pnCenterCon, BoxLayout.X_AXIS));
		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Mời Nhập thông tin sách");
		pnCenterCon.setBorder(borderTitle);
		// pnCenterCon.setPreferredSize(new Dimension(300, 300));
		pnCenterCon.setBackground(Color.LIGHT_GRAY);

		// text nhập thông tin
		// bên trái màn hình
		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
		JPanel pnCenterCon1 = new JPanel();
		txtCodeS = new JTextField(15);
		lblCodeS = new JLabel("        *Mã sách:");
		pnCenterCon1.add(lblCodeS);
		pnCenterCon1.add(txtCodeS);

		JPanel pnCenterCon2 = new JPanel();
		txtTS = new JTextField(15);
		lblTS = new JLabel("        *Tên sách:");
		pnCenterCon2.add(lblTS);
		pnCenterCon2.add(txtTS);

		JPanel pnCenterCon3 = new JPanel();
		lblTG = new JLabel("            *Tác giả:");
		tacGia = new JComboBox<>();
		arrTG = listTG.getDSTacGia();
		for (int i = 0; i < arrTG.size(); i++) {
			tacGia.addItem(arrTG.get(i).getTenTacGia());
		}
		;

		tacGia.setPreferredSize(new Dimension(168, 25));
		pnCenterCon3.add(lblTG);
		pnCenterCon3.add(tacGia);

		JPanel pnCenterCon4 = new JPanel();
		lblNXB = new JLabel("*Nhà xuất bản :");
		nhaXuatBan = new JComboBox<>();
		arrNXB = listNXB.getDSNhaXuatBan();
		for (int i = 0; i < arrNXB.size(); i++) {
			nhaXuatBan.addItem(arrNXB.get(i).getTenNhaXuatBan());
		}
		;
		nhaXuatBan.setPreferredSize(new Dimension(168, 25));
		pnCenterCon4.add(lblNXB);
		pnCenterCon4.add(nhaXuatBan);

		// bên phải
		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
		JPanel pnCenterCon5 = new JPanel();
		txtNXB = new JTextField(15);
		lblNSX = new JLabel(" *Năm xuất bản:");
		// year = new SimpleDateFormat("yyyy");
		// nam = new Date();
		// txtNXB.setText(year.format(nam));
		pnCenterCon5.add(lblNSX);
		pnCenterCon5.add(txtNXB);

		JPanel pnCenterCon6 = new JPanel();
		txtSL = new JTextField(15);
		lblSL = new JLabel("        *Số Lượng :");
		pnCenterCon6.add(lblSL);
		pnCenterCon6.add(txtSL);

		JPanel pnCenterCon7 = new JPanel();
		lblTL = new JLabel("             *Thể loại :");
		theLoai = new JComboBox<String>();
		arrTL = listTL.getDSTheLoai();
		for (int i = 0; i < arrTL.size(); i++) {
			theLoai.addItem(arrTL.get(i).getTenTheLoai());
		}
		;
		theLoai.setPreferredSize(new Dimension(168, 25));
		pnCenterCon7.add(lblTL);
		pnCenterCon7.add(theLoai);

		// phần button thêm,sửa,xóa.....
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new BoxLayout(pnButton, BoxLayout.X_AXIS));
		pnButton.setPreferredSize(new Dimension(1000, 50));
		pnButton.setBackground(Color.LIGHT_GRAY);

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

		// add các ô text nhập thông tin
		pnLeft.add(pnCenterCon1);
		pnLeft.add(pnCenterCon2);
		pnLeft.add(pnCenterCon3);
		pnLeft.add(pnCenterCon4);
		pnRight.add(pnCenterCon5);
		pnRight.add(pnCenterCon7);
		pnRight.add(pnCenterCon6);
		// pnRight.add(pnCenterCon8);

		// add các buttton them sửa xóa
		// pnButton.add(ro);
		pnButton.add(lbkc7);
		pnButton.add(btnthem);
		pnButton.add(lbkc8);
		pnButton.add(btnsua);
		pnButton.add(lbkc9);
		pnButton.add(btnxoa);
		pnButton.add(lbkc10);
		pnButton.add(btnreset);

		// add và pannerCon
		pnCenterCon.add(pnLeft);
		pnCenterCon.add(pnRight);
		pnCenter.add(pnCenterCon);
		pnCenter.add(pnButton);
		pnBorder.add(pnCenter, BorderLayout.CENTER);
		// hết phần center

		// phần footer màn hình
		JPanel pnSouth = new JPanel();
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));
		// bảng table
		table.addColumn("Mã sách");
		table.addColumn("Tên quyển sách");
		table.addColumn("Tác giả");
		table.addColumn("Nhà xuất bản");
		table.addColumn("Năm xuất bản");
		table.addColumn("Thể Loại");
		table.addColumn("Số Lượng");

		this.getTable();
		tbl = new JTable(table);
		TableColumnModel columnModel = tbl.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(110);
		columnModel.getColumn(5).setPreferredWidth(150);
		columnModel.getColumn(6).setPreferredWidth(40);
		JScrollPane sc = new JScrollPane(tbl);
		pnSouth.add(sc);
		pnBorder.add(pnSouth, BorderLayout.SOUTH);

		// thêm vào main
		this.add(pnBorder);
	}

	public void xoaSach() {
		String maSach = txtCodeS.getText();
		int[] rows = tbl.getSelectedRows();
		for (int i = 0; i < rows.length; i++) {
			quanLySachDAO.delete(maSach);
			table.removeRow(rows[i] - i);

		}

	}

	public void themSach() {
		String maSach = txtCodeS.getText();
		String tenSach = txtTS.getText();

		String TG = tacGia.getSelectedItem().toString();
		int vtTG = tacGia.getSelectedIndex();
		String idTG = String.valueOf(vtTG);

		String NXB = nhaXuatBan.getSelectedItem().toString();
		int vtNXB = nhaXuatBan.getSelectedIndex();
		String idNXB = String.valueOf(vtNXB);

		String TL = theLoai.getSelectedItem().toString();
		int vtTL = theLoai.getSelectedIndex();
		String idTL = String.valueOf(vtTL);

		String namXuatBan = txtNXB.getText();
		String soLuong = txtSL.getText();
		String tonKho = txtSL.getText();

		quanLySachDAO.add(new QuanLySach(maSach, tenSach, idTG, idNXB, idTL, namXuatBan, soLuong, tonKho));
		table.addRow(new String[] { maSach, tenSach, TG, NXB, namXuatBan, TL, soLuong });

	}

	public void suaSach() {
		String maSach = txtCodeS.getText();
		String tenSach = txtTS.getText();

		String TG = tacGia.getSelectedItem().toString();
		int vtTG = tacGia.getSelectedIndex();
		String idTG = String.valueOf(vtTG);

		String NXB = nhaXuatBan.getSelectedItem().toString();
		int vtNXB = nhaXuatBan.getSelectedIndex();
		String idNXB = String.valueOf(vtNXB);

		String TL = theLoai.getSelectedItem().toString();
		int vtTL = theLoai.getSelectedIndex();
		String idTL = String.valueOf(vtTL);

		String namXuatBan = txtNXB.getText();

		String soLuong = txtSL.getText();
		String tonKho = txtSL.getText();

		QuanLySach qls = new QuanLySach(maSach, tenSach, idTG, idNXB, idTL, namXuatBan, soLuong, tonKho);
		quanLySachDAO.edit(qls);

		int row = tbl.getSelectedRow();
		tbl.setValueAt(maSach, row, 0);
		tbl.setValueAt(tenSach, row, 1);
		tbl.setValueAt(TG, row, 2);
		tbl.setValueAt(NXB, row, 3);
		tbl.setValueAt(namXuatBan, row, 4);
		tbl.setValueAt(TL, row, 5);
		tbl.setValueAt(soLuong, row, 6);

	}

	public void getTable() {
		arr = quanLySachDAO.getDSQuanLySach();

		for (int i = 0; i < arr.size(); i++)
			table.addRow(new String[] { arr.get(i).getMaSach(), arr.get(i).getTenSach(), arr.get(i).getTacGia(),
					arr.get(i).getNhaXuatBan(), arr.get(i).getNamXuatBan(), arr.get(i).getTheLoai(),
					arr.get(i).getSoLuong() });
	}
}
