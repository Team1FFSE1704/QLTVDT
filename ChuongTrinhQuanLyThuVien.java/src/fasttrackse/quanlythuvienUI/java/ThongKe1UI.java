package fasttrackse.quanlythuvienUI.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
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

public class ThongKe1UI extends JPanel {
	private JLabel lblnxb, lbltl, lbltg, lblpnTitle;
	private DefaultTableModel table = new DefaultTableModel();
	private JTable tbl;
	private JButton btnSubmit, btnTC;
	private String seach, searchTheLoai, searchNhaXuatBan, searchTacGia;

	private Border raisedEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	private JComboBox<String> tacGia, nhaXuatBan, theLoai;

	private TacGiaModel tacgiaDAO = new TacGiaModel();
	private NhaXuatBanModel nhaxuatbanDAO = new NhaXuatBanModel();
	private TheLoaiModel theloaiDAO = new TheLoaiModel();
	private QuanLySachModel quanLySachDAO = new QuanLySachModel();

	private ArrayList<QuanLySach> arrQLS = new ArrayList<QuanLySach>();
	private ArrayList<NhaXuatBan> arrNXB = new ArrayList<NhaXuatBan>();
	private ArrayList<TacGia> arrTG = new ArrayList<TacGia>();
	private ArrayList<TheLoai> arrTL = new ArrayList<TheLoai>();

	// Sự kiện tìm kiếm theo thể loại
	ActionListener btnSeachClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			seach();
		}

	};
	ActionListener btnTatCaClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			getTable();
		}

	};

	public ThongKe1UI() {
		addControl();
		addEvents();
	}

	public void addEvents() {
		btnSubmit.addActionListener(btnSeachClick);
		btnTC.addActionListener(btnTatCaClick);

	}

	public void addControl() {
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		pnBorder.setPreferredSize(new Dimension(650, 650));
		pnBorder.setBackground(Color.LIGHT_GRAY);

		// phần header
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new BoxLayout(pnNorth, BoxLayout.Y_AXIS));
		pnNorth.setBorder(raisedEtched);
		// pnNorth.setPreferredSize(new Dimension(100, 45));
		pnNorth.setBackground(Color.darkGray);

		JPanel pnTrong = new JPanel();
		// pnTrong.setPreferredSize(new Dimension(100, 15));
		// pnTrong.setBackground(Color.red);

		lblpnTitle = new JLabel(" Thống kê số lượng sách ");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblpnTitle.setFont(fontTitle);
		pnTrong.add(lblpnTitle);

		JPanel pnTong = new JPanel();
		pnTong.setPreferredSize(new Dimension(100, 30));

		JPanel pnnhaXuatBan = new JPanel();
		lblnxb = new JLabel("*Nhà xuất bản :");
		nhaXuatBan = new JComboBox<>();
		arrNXB = nhaxuatbanDAO.getDSNhaXuatBan();
		for (int i = 0; i < arrNXB.size(); i++) {
			nhaXuatBan.addItem(arrNXB.get(i).getTenNhaXuatBan());
		}
		;
		nhaXuatBan.setPreferredSize(new Dimension(130, 25));
		pnnhaXuatBan.add(lblnxb);
		pnnhaXuatBan.add(nhaXuatBan);

		JPanel pnTheLoai = new JPanel();
		lbltl = new JLabel("Thể loại:");
		theLoai = new JComboBox<>();
		arrTL = theloaiDAO.getDSTheLoai();
		for (int i = 0; i < arrTL.size(); i++) {
			theLoai.addItem(arrTL.get(i).getTenTheLoai());
		}
		;
		theLoai.setPreferredSize(new Dimension(130, 25));
		pnTheLoai.add(lbltl);
		pnTheLoai.add(theLoai);

		JPanel pnTacGia = new JPanel();
		lbltg = new JLabel("Tác giả:");
		tacGia = new JComboBox<>();
		arrTG = tacgiaDAO.getDSTacGia();
		for (int i = 0; i < arrTG.size(); i++) {
			tacGia.addItem(arrTG.get(i).getTenTacGia());
		}
		;
		tacGia.setPreferredSize(new Dimension(130, 25));

		pnTacGia.add(lbltg);
		pnTacGia.add(tacGia);

		JPanel pnButton = new JPanel();
		pnButton.setPreferredSize(new Dimension(300, 30));
		btnSubmit = new JButton("Submit");
		btnTC = new JButton("Tất cả");
		pnButton.add(btnSubmit);
		pnButton.add(btnTC);

		pnTong.add(pnTheLoai);
		pnTong.add(pnnhaXuatBan);
		pnTong.add(pnTacGia);

		pnNorth.add(pnTrong);
		pnNorth.add(pnTong);
		pnNorth.add(pnButton);

		pnBorder.add(pnNorth, BorderLayout.CENTER);

		// phần footer màn hình
		JPanel pnSouth = new JPanel();
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));
		pnSouth.setPreferredSize(new Dimension(820, 420));
		// bảng table

		table.addColumn("Mã sách");
		table.addColumn("Tên sách");
		table.addColumn("Tổng số lượng sách");
		table.addColumn("Tồn kho");
		this.getTable();
		tbl = new JTable(table);
		TableColumnModel columnModel = tbl.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(10);

		JScrollPane sc = new JScrollPane(tbl);
		pnSouth.add(sc);
		pnBorder.add(pnSouth, BorderLayout.SOUTH);
		this.add(pnBorder);
	}

	public void getTable() {
		table.setRowCount(0);
		arrTG.clear();
		arrQLS = quanLySachDAO.getDSQuanLySach();

		for (int i = 0; i < arrQLS.size(); i++) {
			table.addRow(new String[] { arrQLS.get(i).getMaSach(), arrQLS.get(i).getTenSach(),
					arrQLS.get(i).getSoLuong(), arrQLS.get(i).getTonKho() });

		}

	}

	public void seach() {
		table.setRowCount(0);

		if (tacGia.getSelectedIndex() != 0 && nhaXuatBan.getSelectedIndex() == 0 && theLoai.getSelectedIndex() == 0) {

			seach = tacGia.getSelectedItem().toString();
			arrQLS = quanLySachDAO.getDSQuanLySachTG(seach);

			for (int i = 0; i < arrQLS.size(); i++) {
				table.addRow(new String[] { arrQLS.get(i).getMaSach(), arrQLS.get(i).getTenSach(),
						arrQLS.get(i).getSoLuong(), arrQLS.get(i).getTonKho() });

			}
		}
		if (tacGia.getSelectedIndex() == 0 && nhaXuatBan.getSelectedIndex() != 0 && theLoai.getSelectedIndex() == 0) {
			seach = nhaXuatBan.getSelectedItem().toString();
			arrQLS = quanLySachDAO.getDSQuanLySachNXB(seach);

			for (int i = 0; i < arrQLS.size(); i++) {
				table.addRow(new String[] { arrQLS.get(i).getMaSach(), arrQLS.get(i).getTenSach(),
						arrQLS.get(i).getSoLuong(), arrQLS.get(i).getTonKho() });

			}

		}
		if (tacGia.getSelectedIndex() == 0 && nhaXuatBan.getSelectedIndex() == 0 && theLoai.getSelectedIndex() != 0) {
			seach = theLoai.getSelectedItem().toString();
			arrQLS = quanLySachDAO.getDSQuanLySachTL(seach);

			for (int i = 0; i < arrQLS.size(); i++) {
				table.addRow(new String[] { arrQLS.get(i).getMaSach(), arrQLS.get(i).getTenSach(),
						arrQLS.get(i).getSoLuong(), arrQLS.get(i).getTonKho() });

			}
		}
		if (tacGia.getSelectedIndex() != 0 && nhaXuatBan.getSelectedIndex() != 0 && theLoai.getSelectedIndex() != 0)

		{
			searchTheLoai = theLoai.getSelectedItem().toString();
			searchTacGia = tacGia.getSelectedItem().toString();
			searchNhaXuatBan = nhaXuatBan.getSelectedItem().toString();
			arrQLS = quanLySachDAO.getDSQuanLySachTK(searchNhaXuatBan, searchTheLoai, searchTacGia);

			for (int i = 0; i < arrQLS.size(); i++) {
				table.addRow(new String[] { arrQLS.get(i).getMaSach(), arrQLS.get(i).getTenSach(),
						arrQLS.get(i).getSoLuong(), arrQLS.get(i).getTonKho() });

			}
		}
	}
}
