//package fasttrackse.quanlythuvienUI.java;
//
//import java.awt.BorderLayout;
//import java.awt.CardLayout;
//import java.awt.Color;
//import java.awt.Container;
//import java.awt.Dimension;
//import java.awt.Image;
//import java.awt.Insets;
//
//import javax.swing.BorderFactory;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.border.Border;
//
//public class QuanLyThuVien extends JFrame {
//	private JButton btnqltv, btnqlmt, btnqls, btnqldm, btnkt, btntk;
//	private Border raisedBevel = BorderFactory.createRaisedBevelBorder();
//	
//	public QuanLyThuVien() {
//		addControl();
//	}
//
//	public void addControl() {
//		Container con = getContentPane();
//		CardLayout cl = new CardLayout();
//		JPanel pnCenter = new JPanel();
//		pnCenter.setLayout(cl);
//		ThongKeUI thongKeUI = new ThongKeUI();
//		QuanLyDanhMucUI quanLyDanhMucUI = new QuanLyDanhMucUI();
//		QuanLySachUI quanLySachUI = new QuanLySachUI();
//		QuanLyTraUI quanLyTraUI = new QuanLyTraUI();
//		QuanLyThanhVienUI quanLyThanhVienUI = new QuanLyThanhVienUI();
//
//		pnCenter.add(quanLyThanhVienUI, "1");
//		pnCenter.add(quanLyDanhMucUI, "2");
//		pnCenter.add(quanLySachUI, "3");
//		pnCenter.add(quanLyTraUI, "4");
//		pnCenter.add(thongKeUI, "5");
//		cl.show(pnCenter, "1");
//		con.add(pnCenter);
//		
//		// phần bên phải và các button chính
//		JPanel pnEast = new JPanel();
//		pnEast.setBackground(Color.orange);
//		pnEast.setBorder(raisedBevel);
//		pnEast.setPreferredSize(new Dimension(250, 100));
//
//		// pannel pnEastcon
//		JPanel pnEastCon = new JPanel();
//		// pnEastCon.setLayout(new BoxLayout(pnEastCon, BoxLayout.Y_AXIS));
//		pnEastCon.setBackground(Color.orange);
//		pnEastCon.setPreferredSize(new Dimension(200, 320));
//
//		ImageIcon update1 = new ImageIcon(
//				new ImageIcon("icon/b.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
//		btnqltv = new JButton(" Quản lý thành viên", update1);
//		btnqltv.setPreferredSize(new Dimension(190, 40));
//		btnqltv.setMargin(new Insets(5, 18, 5, 30));
//
//		ImageIcon update2 = new ImageIcon(
//				new ImageIcon("icon/qlmuontra.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
//		btnqlmt = new JButton("Quản lý mượn trả ", update2);
//		btnqlmt.setMargin(new Insets(5, 20, 5, 30));
//
//		ImageIcon update3 = new ImageIcon(
//				new ImageIcon("icon/sach.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
//		btnqls = new JButton(" Quản lý sách         ", update3);
//		btnqls.setMargin(new Insets(5, 20, 5, 30));
//
//		ImageIcon update4 = new ImageIcon(
//				new ImageIcon("icon/danhmuc.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
//		btnqldm = new JButton("Quản lý danh mục ", update4);
//		btnqldm.setMargin(new Insets(5, 20, 5, 30));
//
//		ImageIcon update5 = new ImageIcon(
//				new ImageIcon("icon/thongke.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
//		btntk = new JButton("   Thống kê              ", update5);
//		btntk.setPreferredSize(new Dimension(190, 40));
//		btntk.setMargin(new Insets(5, 20, 5, 30));
//
//		ImageIcon update6 = new ImageIcon(
//				new ImageIcon("icon/exit.jpg").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
//		btnkt = new JButton("    Kết thúc           ", update6);
//		btnkt.setPreferredSize(new Dimension(190, 40));
//		btnkt.setMargin(new Insets(5, 20, 5, 30));
//
//		JLabel lbkc = new JLabel("");
//		lbkc.setPreferredSize(new Dimension(10, 3));
//		JLabel lbkc1 = new JLabel("");
//		lbkc1.setPreferredSize(new Dimension(10, 3));
//		JLabel lbkc2 = new JLabel("");
//		lbkc2.setPreferredSize(new Dimension(10, 3));
//		JLabel lbkc3 = new JLabel("");
//		lbkc3.setPreferredSize(new Dimension(10, 3));
//		JLabel lbkc4 = new JLabel("");
//		lbkc4.setPreferredSize(new Dimension(10, 3));
//		// JLabel lbkc6 = new JLabel("");
//		// lbkc6.setPreferredSize(new Dimension(10, 10));
//
//		// add button vào pnEast
//		pnEastCon.add(btnqldm);
//		pnEastCon.add(lbkc);
//		pnEastCon.add(btnqlmt);
//		pnEastCon.add(lbkc1);
//		pnEastCon.add(btnqls);
//		pnEastCon.add(lbkc2);
//		pnEastCon.add(btnqltv);
//		pnEastCon.add(lbkc3);
//		pnEastCon.add(btntk);
//		pnEastCon.add(lbkc4);
//		pnEastCon.add(btnkt);
//
//		pnEast.add(pnEastCon);
//		con.add(pnEast);
//		//CardLayout.add(pnEast, BorderLayout.EAST);
//	}
//
//	// màn hình console
////	public void showView() {
////		this.setSize(1100, 650);
////		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
////		this.setLocationRelativeTo(null);
////		this.setVisible(true);
////	}
//
//}
