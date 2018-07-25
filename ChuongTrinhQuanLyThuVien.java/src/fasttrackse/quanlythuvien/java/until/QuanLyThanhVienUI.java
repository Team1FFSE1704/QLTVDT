package fasttrackse.quanlythuvien.java.until;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

public class QuanLyThanhVienUI extends  JPanel{
	private JLabel lblTitle, lblCodeMTV, lblHT, lblDC, lblP, lblQ, lblTP, lblSDT, lblEmail;
	private JButton btnqltv, btnqlmt, btnqls, btnqldm, btnkt, btntk,btnreset,btnsua,btnthem,btnxoa;
	private JTextField txtCodeMTV, txtHT, txtDC, txtP, txtQ, txtTP, txtSDT, txtEmail;
	private DefaultTableModel table = new DefaultTableModel();
	private JTable tbl;
	private Border raisedBevel = BorderFactory.createRaisedBevelBorder();
	private Border raisedEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	JMonthChooser jmc; 
	JYearChooser jyc;

	public QuanLyThanhVienUI() {
		// tạo container và boder chính
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());

		// phần header
		JPanel pnNorth = new JPanel();
		pnNorth.setBorder(raisedEtched);
		pnNorth.setPreferredSize(new Dimension(100, 60));
		lblTitle = new JLabel("Chương Trình Quản Lý Thư Viện Thành Viên");
		pnNorth.setBackground(Color.ORANGE);
		lblTitle.setForeground(Color.RED);
		Font fontTitle = new Font("Monospaced", Font.BOLD | Font.ITALIC, 35);
		lblTitle.setFont(fontTitle);
		pnNorth.add(lblTitle);
		pnBorder.add(pnNorth, BorderLayout.NORTH);

		// phần footer màn hình
		JPanel pnSouth = new JPanel();
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.Y_AXIS));
		pnSouth.setPreferredSize(new Dimension(900, 200));
		pnSouth.setBackground(Color.white);
		// bảng table
		table.addColumn("Mã thành viên");
		table.addColumn("Tên thành viên");
		table.addColumn("Địa chỉ nhà");
		table.addColumn("Phường");
		table.addColumn("Quận");
		table.addColumn("Tỉnh/Thành phố");
		table.addColumn("Điện Thoại");
		table.addColumn("Email");
		tbl = new JTable(table);
		TableColumnModel columnModel = tbl.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(30);
		columnModel.getColumn(1).setPreferredWidth(110);
		columnModel.getColumn(3).setPreferredWidth(50);
		columnModel.getColumn(4).setPreferredWidth(50);
		JScrollPane sc = new JScrollPane(tbl);
		pnSouth.add(sc);
		pnBorder.add(pnSouth, BorderLayout.SOUTH);

		// phần bên phải và các button chính
		JPanel pnEast = new JPanel();
		pnEast.setBorder(raisedBevel);
		pnEast.setPreferredSize(new Dimension(250, 50));
		pnEast.setBackground(Color.ORANGE);
		// pannel con pnEastCon
		JPanel pnEastCon = new JPanel();
		pnEastCon.setLayout(new BoxLayout(pnEastCon, BoxLayout.Y_AXIS));
		btnqltv = new JButton("Quản lý thành viên ");
		btnqltv.setPreferredSize(new Dimension(170, 40));

		btnqlmt = new JButton("Quản lý mượn trả ");
		btnqlmt.setPreferredSize(new Dimension(170, 40));

		btnqls = new JButton("Quản lý sách  ");
		btnqls.setPreferredSize(new Dimension(170, 40));

		btnqldm = new JButton("Quản lý danh mục ");
		btnqldm.setPreferredSize(new Dimension(170, 40));

		btntk = new JButton("Thông kê ");
		btntk.setPreferredSize(new Dimension(170, 40));

		btnkt = new JButton("Kết thúc");
		btnkt.setPreferredSize(new Dimension(171, 40));

		JLabel lbkc = new JLabel("        ");
		JLabel lbkc1 = new JLabel("        ");
		JLabel lbkc2 = new JLabel("        ");
		JLabel lbkc3 = new JLabel("        ");
		JLabel lbkc4 = new JLabel("        ");
		JLabel lbkc6 = new JLabel("       ");

		// add button vào pnEast
		pnEast.add(btnqltv);
		pnEast.add(lbkc);
		pnEast.add(btnqlmt);
		pnEast.add(lbkc1);
		pnEast.add(btnqls);
		pnEast.add(lbkc2);
		pnEast.add(btnqldm);
		pnEast.add(lbkc3);
		pnEast.add(btntk);
		pnEast.add(lbkc4);
		pnEast.add(btnkt);
		pnEast.add(lbkc6);

		pnEast.add(pnEastCon);
		pnBorder.add(pnEast, BorderLayout.EAST);

		// phần trung tâm nhập thông tin
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		pnCenter.setBackground(Color.LIGHT_GRAY);

		JPanel pnCenterCon = new JPanel();
		pnCenterCon.setLayout(new BoxLayout(pnCenterCon, BoxLayout.X_AXIS));
		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Mời Nhập thông tin thành viên");
		pnCenterCon.setBorder(borderTitle);
		pnCenterCon.setPreferredSize(new Dimension(800, 150));
		pnCenterCon.setBackground(Color.LIGHT_GRAY);

		// text nhập thông tin
		// bên trái màn hình
		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
		JPanel pnCenterCon1 = new JPanel();
		txtCodeMTV = new JTextField(15);
		lblCodeMTV = new JLabel("*Mã thành viên: ");
		pnCenterCon1.add(lblCodeMTV);
		pnCenterCon1.add(txtCodeMTV);

		JPanel pnCenterCon2 = new JPanel();
		txtHT = new JTextField(15);
		lblHT = new JLabel("        *Họ và tên: ");
		pnCenterCon2.add(lblHT);
		pnCenterCon2.add(txtHT);

		JPanel pnCenterCon3 = new JPanel();
		txtDC = new JTextField(15);
		lblDC = new JLabel("     *Địa chỉ nhà: ");
		pnCenterCon3.add(lblDC);
		pnCenterCon3.add(txtDC);

		JPanel pnCenterCon4 = new JPanel();
		txtP = new JTextField(15);
		lblP = new JLabel("           *Phường: ");
		pnCenterCon4.add(lblP);
		pnCenterCon4.add(txtP);

		// bên phải
		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
		JPanel pnCenterCon5 = new JPanel();
		txtQ = new JTextField(15);
		lblQ = new JLabel("                       *Quận : ");
		pnCenterCon5.add(lblQ);
		pnCenterCon5.add(txtQ);

		JPanel pnCenterCon6 = new JPanel();
		txtTP = new JTextField(15);
		lblTP = new JLabel("     *Tỉnh/Thành phố : ");
		pnCenterCon6.add(lblTP);
		pnCenterCon6.add(txtTP);

		JPanel pnCenterCon7 = new JPanel();
		txtSDT = new JTextField(15);
		lblSDT = new JLabel("         *Số điện thoại : ");
		pnCenterCon7.add(lblSDT);
		pnCenterCon7.add(txtSDT);

		JPanel pnCenterCon8 = new JPanel();
		txtEmail = new JTextField(15);
		lblEmail = new JLabel("                       *Email : ");
		pnCenterCon8.add(lblEmail);
		pnCenterCon8.add(txtEmail);

		//phần button thêm,sửa,xóa.....
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new BoxLayout(pnButton, BoxLayout.X_AXIS));
		pnButton.setPreferredSize(new Dimension(1000, 50));
		pnButton.setBackground(Color.LIGHT_GRAY);

		ImageIcon update = new ImageIcon(
				new ImageIcon("icon/them.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		btnthem = new JButton("thêm ",update);
		btnthem.setMargin(new Insets(5,10,5,10));
		
		ImageIcon update1 = new ImageIcon(
				new ImageIcon("icon/sua.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		btnsua = new JButton("sửa ",update1);
		btnsua.setMargin(new Insets(5,10,5,10));
		
		ImageIcon update2 = new ImageIcon(
				new ImageIcon("icon/xoa.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		btnxoa = new JButton("xóa ",update2);
		btnxoa.setMargin(new Insets(5,10,5,10));
		
		ImageIcon update3 = new ImageIcon(
				new ImageIcon("icon/reset.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		btnreset = new JButton("reset",update3);
		btnreset.setMargin(new Insets(5,10,5,10));
		JLabel lbkc7 = new JLabel("");
		JLabel lbkc8 = new JLabel("        ");
		JLabel lbkc9 = new JLabel("        ");
		JLabel lbkc10 = new JLabel("        ");
		
		//add các ô text nhập thông tin
		pnLeft.add(pnCenterCon1);
		pnLeft.add(pnCenterCon2);
		pnLeft.add(pnCenterCon3);
		pnLeft.add(pnCenterCon4);
		pnRight.add(pnCenterCon5);
		pnRight.add(pnCenterCon6);
		pnRight.add(pnCenterCon7);
		pnRight.add(pnCenterCon8);
		
		//add các buttton them sửa xóa
	//	pnButton.add(ro);
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

		// thêm vào main
		this.add(pnBorder);
	}
	
	
}
