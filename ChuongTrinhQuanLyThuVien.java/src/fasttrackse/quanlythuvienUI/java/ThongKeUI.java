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
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import fasttrackse.quanlythuvien.DAO.QuanLySachModel;
import fasttrackse.quanlythuvien.DAO.QuanLyThanhVienDAO;
import fasttrackse.quanlythuvien.DAO.QuanModel;
import fasttrackse.quanlythuvien.entity.Quan;
import fasttrackse.quanlythuvien.entity.ThanhVien;

public class ThongKeUI extends JPanel {
	private JLabel lblMS, lblpnTitle;
	private JButton btnSubmit;
	private DefaultTableModel table = new DefaultTableModel();
	private JTable tbl;
	private JComboBox<String> quan;
	private Border raisedEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	private QuanLySachModel quanLySachDAO = new QuanLySachModel();
	private JTextField txtTV;
	private String searchQuan, SearchMaThanhVien;
	private QuanModel quanDAO = new QuanModel();
	private QuanLyThanhVienDAO thanhVienDAO = new QuanLyThanhVienDAO();
	private ArrayList<ThanhVien> arr = new ArrayList<ThanhVien>();
	private ArrayList<Quan> arrQuan = new ArrayList<Quan>();

	ActionListener btnSeachClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			seach();
		}
	};

	public ThongKeUI() {
		addControl();
		addEvents();
	}

	public void addEvents() {
		btnSubmit.addActionListener(btnSeachClick);
	}

	public void addControl() {

		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		pnBorder.setPreferredSize(new Dimension(650, 650));
		BorderLayout layout = new BorderLayout();
		layout.setHgap(5);
		layout.setVgap(5);
		pnBorder.setLayout(layout);
		pnBorder.setBackground(Color.LIGHT_GRAY);

		// phần center
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		pnCenter.setBorder(raisedEtched);
		pnCenter.setPreferredSize(new Dimension(100, 70));
		pnCenter.setBackground(Color.darkGray);

		JPanel pnTitle = new JPanel();
		lblpnTitle = new JLabel(" Thống kê số lượng bạn đọc đã mượn sách ");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblpnTitle.setFont(fontTitle);
		pnTitle.add(lblpnTitle);

		// comboxx
		JPanel pnNorthCon = new JPanel();
		pnNorthCon.setBackground(Color.red);
		pnNorthCon.setPreferredSize(new Dimension(300, 50));
		pnNorthCon.setLayout(new BoxLayout(pnNorthCon, BoxLayout.X_AXIS));

		// phần Jlisst
		JPanel pnTong = new JPanel();
		pnTong.setPreferredSize(new Dimension(300, 60));
		JPanel pnNorthCon1 = new JPanel();
		pnNorthCon1.setPreferredSize(new Dimension(300, 10));

		JPanel pnNorthCon2 = new JPanel();
		lblMS = new JLabel("         Mã thành viên: ");
		txtTV = new JTextField(10);
		pnTong.add(pnNorthCon1);
		pnNorthCon2.add(lblMS);
		pnNorthCon2.add(txtTV);
		pnTong.add(pnNorthCon2);
		pnNorthCon.add(pnTong);

		// phần comborboxx
		JPanel pnCob = new JPanel();
		pnCob.setPreferredSize(new Dimension(300, 100));
		// panelcon
		JPanel pnCobcon1 = new JPanel();
		pnCobcon1.setPreferredSize(new Dimension(300, 10));

		JPanel pnCobcon2 = new JPanel();
		JLabel lblCob = new JLabel("Quận:");
		quan = new JComboBox<String>();
		arrQuan = quanDAO.getDSQuan();
		for (int i = 0; i < arrQuan.size(); i++) {
			quan.addItem(arrQuan.get(i).getTenQuan());
		}
		;
		quan.setPreferredSize(new Dimension(168, 25));
		pnCobcon2.add(lblCob);
		pnCobcon2.add(quan);
		pnCob.add(pnCobcon1);
		pnCob.add(pnCobcon2);
		pnNorthCon.add(pnCob);

		JPanel pnButton = new JPanel();
		pnButton.setPreferredSize(new Dimension(300, 30));
		btnSubmit = new JButton("Submit");
		pnButton.add(btnSubmit);

		// phần add hai phần con heard
		pnCenter.add(pnTitle);
		pnCenter.add(pnNorthCon);
		pnCenter.add(pnButton);
		pnBorder.add(pnCenter, BorderLayout.CENTER);

		// phần footer màn hình
		JPanel pnSouth = new JPanel();
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));
		pnSouth.setPreferredSize(new Dimension(820, 420));
		// bảng table

		table.addColumn("Mã thành viên");
		table.addColumn("Họ tên");
		table.addColumn("Số điện thoại");
		table.addColumn("Số sách đã mượn");
		this.getTable();
		tbl = new JTable(table);
		TableColumnModel columnModel = tbl.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(10);
		columnModel.getColumn(1).setPreferredWidth(30);
		// columnModel.getColumn(4).setPreferredWidth(5);
		// columnModel.getColumn(5).setPreferredWidth(5);

		JScrollPane sc = new JScrollPane(tbl);
		pnSouth.add(sc);
		pnBorder.add(pnSouth, BorderLayout.SOUTH);
		this.add(pnBorder);
	}

	// show thông tin của thnahf viên đang mượn
	public void getTable() {
		arr = thanhVienDAO.getDSThanhVien();
		for (int i = 0; i < arr.size(); i++) {
			table.addRow(
					new String[] { arr.get(i).getMaThanhVien(), arr.get(i).getTenThanhVien(), arr.get(i).getSoDT() });
		}
	}

	public void seach() {
		table.setRowCount(0);

		int count = txtTV.getText().length();

		if (quan.getSelectedIndex() != 1 && count == 0) {
			searchQuan = quan.getSelectedItem().toString();
			arr = thanhVienDAO.getDSSearchQuan(searchQuan);
			for (int i = 0; i < arr.size(); i++) {
				table.addRow(new String[] { arr.get(i).getMaThanhVien(), arr.get(i).getTenThanhVien(),
						arr.get(i).getSoDT() });
			}
		}
		if (quan.getSelectedIndex() == 0 && count > 0) {
			SearchMaThanhVien = quan.getSelectedItem().toString();
			arr = thanhVienDAO.getDSSearchThanhVien(SearchMaThanhVien);
			for (int i = 0; i < arr.size(); i++) {
				table.addRow(new String[] { arr.get(i).getMaThanhVien(), arr.get(i).getTenThanhVien(),
						arr.get(i).getSoDT() });
			}
		}
		if (quan.getSelectedIndex() != 1 && count > 0) {
			searchQuan = quan.getSelectedItem().toString();
			SearchMaThanhVien = txtTV.getText();
			arr = thanhVienDAO.getDSSearchTK(SearchMaThanhVien, searchQuan);
			for (int i = 0; i < arr.size(); i++) {
				table.addRow(new String[] { arr.get(i).getMaThanhVien(), arr.get(i).getTenThanhVien(),
						arr.get(i).getSoDT() });
			}
		}

	}

}
