package fasttrackse.team1.qlthuviendientu.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class QuanLyThuVienUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JButton btnQlSach;
	private JButton btnQlThanhVien;
	private JButton btnQlMuonTra;// has - a
	private JButton btnThongKe;
	private JButton btnQlDanhMuc;
	private JButton btnThoat;
	
	private JButton btnthem;
	private JButton btnSua;
	private JButton btnXoa;// has - a
	private JButton btnReset;
	
	JComboBox<String> tacGia;
	JComboBox<String> nhaXB;
	JComboBox<String> theLoai;
	
	DefaultTableModel dm;
	JTable tbl;
//	private JLabel lblMaSach;
//	private JTextField txtMaSach;
//	private JLabel lblTenSach;
//	private JTextField txtTenSach;
	public QuanLyThuVienUI(String tieude) {
		super(tieude);
		addControls();
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel pnBorderLayout = new JPanel();
		pnBorderLayout.setLayout(new BorderLayout());

		
		
		
		
		
		JPanel pnNorth = new JPanel();
		pnNorth.setBackground(Color.BLUE);
		pnBorderLayout.add(pnNorth, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Quản lý sinh viên FastTrack SE");
		Font fontTitle = new Font("Arial", Font.BOLD, 20);
		lblTitle.setFont(fontTitle);
		pnNorth.add(lblTitle);
		
		pnNorth.setPreferredSize(new Dimension(0, 50));

		
		
		
		
		
		
		
		
		
		JPanel pnSouth = new JPanel();
		pnSouth.setBackground(Color.RED);
		pnBorderLayout.add(pnSouth, BorderLayout.SOUTH);
		pnSouth.setPreferredSize(new Dimension(0, 100));
		// table
		dm = new DefaultTableModel();
		dm.addColumn("Mã");
		dm.addColumn("Lớp");
		dm.addColumn("Tên");
		dm.addColumn("Tuổi");
		dm.addColumn("Giới Tính");
		//this.getTable();
		tbl = new JTable(dm);
		JScrollPane sc = new JScrollPane(tbl);
		pnSouth.add(sc);
		
		
		
		
		
		
		
		
		
		
		
		
		JPanel pnWest = new JPanel();
		pnWest.setBackground(Color.YELLOW);
		pnBorderLayout.add(pnWest, BorderLayout.WEST);
		pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));
		pnWest.setPreferredSize(new Dimension(140, 0));
		btnthem = new JButton("THÊM");
		btnthem.setForeground(Color.BLUE);
		pnWest.add(btnthem);
		
		
		btnSua = new JButton("SỬA");
		btnSua.setForeground(Color.RED);
		pnWest.add(btnSua);
		
		btnXoa = new JButton("XÓA");
		btnXoa.setForeground(Color.GREEN);
		pnWest.add(btnXoa);
		
		btnReset = new JButton("RESET");
		btnReset.setForeground(Color.GRAY);
		pnWest.add(btnReset);
		
		
		
		
		JPanel pnEast = new JPanel();
		pnEast.setBackground(Color.CYAN);
		pnBorderLayout.add(pnEast, BorderLayout.EAST);
		pnEast.setLayout(new BoxLayout(pnEast, BoxLayout.Y_AXIS));
		
		JLabel lblTitleMenu = new JLabel("Menu");
		Font fontTitleMenu = new Font("Arial", Font.BOLD, 20);
		lblTitleMenu.setFont(fontTitleMenu);
		pnEast.add(lblTitleMenu);
		JLabel pnkc6 = new JLabel("        ");
		pnEast.add(pnkc6);
		
		btnQlSach= new JButton("Quản lý sách");
		btnQlSach.setForeground(Color.BLUE);
		btnQlSach.setMargin(new Insets(10, 30, 10, 30));
		pnEast.add(btnQlSach);
		
		JLabel pnkc = new JLabel("        ");
		pnEast.add(pnkc);
		
		btnQlThanhVien= new JButton("Quản lý bạn đọc");
		btnQlThanhVien.setForeground(Color.BLUE);
		btnQlThanhVien.setMargin(new Insets(10, 23, 10, 20));
		pnEast.add(btnQlThanhVien);
		
		JLabel pnkc2 = new JLabel("        ");
		pnEast.add(pnkc2);
		
		btnQlMuonTra= new JButton("Quản lý mượn trả");
		btnQlMuonTra.setForeground(Color.BLUE);
		btnQlMuonTra.setMargin(new Insets(10, 17, 10, 15));
		pnEast.add(btnQlMuonTra);
		
		JLabel pnkc3 = new JLabel("        ");
		pnEast.add(pnkc3);
		
		btnThongKe= new JButton("Thống Kê");
		btnThongKe.setForeground(Color.BLUE);
		btnThongKe.setMargin(new Insets(10, 40, 10, 40));
		pnEast.add(btnThongKe);
		
		JLabel pnkc4 = new JLabel("        ");
		pnEast.add(pnkc4);
		
		btnQlDanhMuc= new JButton("Quản lý danh mục");
		btnQlDanhMuc.setForeground(Color.BLUE);
		btnQlDanhMuc.setMargin(new Insets(10, 17, 10, 15));
		pnEast.add(btnQlDanhMuc);
		
		JLabel pnkc5 = new JLabel("        ");
		pnEast.add(pnkc5);
		
		btnThoat= new JButton("Thoát");
		btnThoat.setForeground(Color.BLUE);
		btnThoat.setMargin(new Insets(10, 50, 10, 50));
		pnEast.add(btnThoat);
		
		pnEast.setPreferredSize(new Dimension(140, 0));

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Panel Center
		JPanel pnCenter = new JPanel();
		pnBorderLayout.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		
		JTextField maSach = new JTextField(20), tenSach = new JTextField(20);
		JRadioButton small = new JRadioButton("Small"), medium = new JRadioButton("Medium"),
			      large = new JRadioButton("Large");
		pnCenter.setLayout(new GridBagLayout());
	    addItem(pnCenter, new JLabel("Mã sách:"), 0, 0, 1, 1, GridBagConstraints.EAST);
	    addItem(pnCenter, new JLabel("Tên sách:"), 0, 1, 1, 1, GridBagConstraints.EAST);
	    
	 
	    addItem(pnCenter, maSach, 1, 0, 2, 1, GridBagConstraints.WEST);
	    addItem(pnCenter, tenSach, 1, 1, 1, 1, GridBagConstraints.WEST);
	    
	    Box sizeBox = Box.createVerticalBox();
	    ButtonGroup sizeGroup = new ButtonGroup();
	    sizeGroup.add(small);;
	    sizeGroup.add(medium);
	    sizeGroup.add(large);
	    sizeBox.add(small);
	    sizeBox.add(medium);
	    sizeBox.add(large);
	    sizeBox.setBorder(BorderFactory.createTitledBorder("Tác giả"));
	    addItem(pnCenter, sizeBox, 0, 3, 1, 1, GridBagConstraints.NORTH);
	    
	    
	    
	    JLabel lblTacGia = new JLabel("Tác giả");
		tacGia = new JComboBox<String>();
		tacGia.addItem("FFSE 1701");
		tacGia.addItem("FFSE 1702");
		tacGia.addItem("FFSE 1703");
		tacGia.addItem("FFSE 1704");
		tacGia.addItem("FFSE 1801");
		pnCenter.add(lblTacGia);
		pnCenter.add(tacGia);
		
		JLabel lblNXB = new JLabel("Nhà Xuất Bản");
		nhaXB = new JComboBox<String>();
		nhaXB.addItem("FFSE 1701");
		nhaXB.addItem("FFSE 1702");
		nhaXB.addItem("FFSE 1703");
		nhaXB.addItem("FFSE 1704");
		nhaXB.addItem("FFSE 1801");
		pnCenter.add(lblNXB);
		pnCenter.add(nhaXB);
		
//		JLabel lblTheLoai = new JLabel("Tác giả");
//		theLoai = new JComboBox<String>();
//		theLoai.addItem("FFSE 1701");
//		theLoai.addItem("FFSE 1702");
//		theLoai.addItem("FFSE 1703");
//		theLoai.addItem("FFSE 1704");
//		theLoai.addItem("FFSE 1801");
//		pnCenter.add(lblTheLoai);
//		pnCenter.add(theLoai);
		
		con.add(pnBorderLayout);
	}
	private void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
	    GridBagConstraints gc = new GridBagConstraints();
	    gc.gridx = x;
	    gc.gridy = y;
	    gc.gridwidth = width;
	    gc.gridheight = height;
	    gc.weightx = 100.0;
	    gc.weighty = 100.0;
	    gc.insets = new Insets(5, 5, 5, 5);
	    gc.anchor = align;
	    gc.fill = GridBagConstraints.NONE;
	    p.add(c, gc);
	  }
	public void showWindow() {
		this.setSize(800, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
