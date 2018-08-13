package fasttrackse.quanlythuvienUI.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import fasttrackse.quanlythuvien.DAO.QuanLySachModel;
import fasttrackse.quanlythuvien.entity.QuanLySach;

public class ThongKeUI extends JPanel {
	private JLabel lblMS, lblpnTitle;
	private JButton btnSubmit;
	private DefaultTableModel table = new DefaultTableModel();
	private JTable tbl;
	private JScrollPane fruitListScrollPane;
	private JComboBox<String> thanhpho = new JComboBox<String>();

	
	private Border raisedEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	private QuanLySachModel quanLySachDAO = new QuanLySachModel();

	private ArrayList<QuanLySach> arr = new ArrayList<QuanLySach>();
	ActionListener btnDeleteClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// xoaSach();
		}
	};

	public ThongKeUI() {
		addControl();
		addEvents();
	}

	public void addEvents() {

	}

	public void addControl() {

		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		BorderLayout layout = new BorderLayout();
		layout.setHgap(5);
		layout.setVgap(5);
		pnBorder.setLayout(layout);
		pnBorder.setBackground(Color.LIGHT_GRAY);

		// phần header
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new BoxLayout(pnNorth, BoxLayout.Y_AXIS));
		pnNorth.setBorder(raisedEtched);
		pnNorth.setPreferredSize(new Dimension(100, 150));
		pnNorth.setBackground(Color.darkGray);

		JPanel pnTitle = new JPanel();
		lblpnTitle = new JLabel(" Thống kê số lượng bạn đọc đã mượn sách ");
		pnTitle.setPreferredSize(new Dimension(300, 10));
		pnTitle.add(lblpnTitle);

		// phần Jlist box+ comboxx
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
		fruitListScrollPane = new JScrollPane(fruitList);
		fruitListScrollPane.setPreferredSize(new Dimension(225, 40));
		pnTong.add(pnNorthCon1);
		pnNorthCon2.add(lblMS);
		pnNorthCon2.add(fruitListScrollPane);
		pnTong.add(pnNorthCon2);
		pnNorthCon.add(pnTong);

		// phần comborboxx
		JPanel pnCob = new JPanel();
		pnCob.setPreferredSize(new Dimension(300, 100));
		// panelcon
		JPanel pnCobcon1 = new JPanel();
		pnCobcon1.setPreferredSize(new Dimension(300, 10));

		JPanel pnCobcon2 = new JPanel();
		JLabel lblCob = new JLabel("Thành phố:");
		arr = quanLySachDAO.getDSQuanLySach();
		for (int i = 0; i < arr.size(); i++) {
			thanhpho.addItem(arr.get(i).getTenSach());
		}
		;
		thanhpho.setPreferredSize(new Dimension(168, 25));
		pnCobcon2.add(lblCob);
		pnCobcon2.add(thanhpho);
		pnCob.add(pnCobcon1);
		pnCob.add(pnCobcon2);
		pnNorthCon.add(pnCob);

		JPanel pnButton = new JPanel();
		pnButton.setPreferredSize(new Dimension(300, 30));

		btnSubmit = new JButton("Submit");
		pnButton.add(btnSubmit);

		// phần add hai phần con heard
		pnNorth.add(pnTitle);
		pnNorth.add(pnNorthCon);
		pnNorth.add(pnButton);
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
