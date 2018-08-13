package fasttrackse.quanlythuvienUI.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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

import fasttrackse.quanlythuvien.DAO.NhaXuatBanModel;
import fasttrackse.quanlythuvien.DAO.TacGiaModel;
import fasttrackse.quanlythuvien.DAO.TheLoaiModel;
import fasttrackse.quanlythuvien.entity.NhaXuatBan;
import fasttrackse.quanlythuvien.entity.TacGia;
import fasttrackse.quanlythuvien.entity.TheLoai;

public class ThongKe1UI extends JPanel {
	private JLabel lblnxb, lbltl, lbltg;
	private DefaultTableModel table = new DefaultTableModel();
	private JTable tbl;

	private Border raisedEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	private JComboBox<String> tacGia, nhaXuatBan, theLoai;

	private TacGiaModel tacgiaDAO = new TacGiaModel();
	private NhaXuatBanModel nhaxuatbanDAO = new NhaXuatBanModel();
	private TheLoaiModel theloaiDAO = new TheLoaiModel();

	private ArrayList<NhaXuatBan> arrNXB = new ArrayList<NhaXuatBan>();
	private ArrayList<TacGia> arrTG = new ArrayList<TacGia>();
	private ArrayList<TheLoai> arrTL = new ArrayList<TheLoai>();

	public ThongKe1UI() {
		addControl();
	}

	public void addEvents() {

	}

	public void addControl() {
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		pnBorder.setPreferredSize(new Dimension(650, 650));
//		BorderLayout layout = new BorderLayout();
//		layout.setHgap(5);
//		layout.setVgap(5);
//		pnBorder.setLayout(layout);
		pnBorder.setBackground(Color.LIGHT_GRAY);

		// phần header
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new BoxLayout(pnNorth, BoxLayout.X_AXIS));
		pnNorth.setBorder(raisedEtched);
		pnNorth.setPreferredSize(new Dimension(100, 80));
		pnNorth.setBackground(Color.BLACK);

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

		pnNorth.add(pnTheLoai);
		pnNorth.add(pnnhaXuatBan);
		pnNorth.add(pnTacGia);
		pnBorder.add(pnNorth, BorderLayout.NORTH);

		// phần footer màn hình
		JPanel pnSouth = new JPanel();
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));
		pnSouth.setPreferredSize(new Dimension(820, 420));
		// bảng table
		
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
