package fasttrackse.quanlythuvien.java.until;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;

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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

public class QuanLySachUI extends JPanel {
	private JLabel lblCodeMTV1, lblHT1, lblDC1, lblP1, lblQ1, lblTP1, lblSDT1, lblEmail1;
	private JButton btnreset1, btnsua1, btnthem1, btnxoa1;
	private JTextField txtCodeMTV1, txtHT1, txtDC1, txtP1, txtQ1, txtTP1, txtSDT1, txtEmail1;
	private DefaultTableModel table = new DefaultTableModel();
	private JTable tbl;
	private JMonthChooser jmc;
	private JYearChooser jyc;

	public QuanLySachUI() {
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
		txtCodeMTV1 = new JTextField(15);
		lblCodeMTV1 = new JLabel("        *Mã sách:");
		pnCenterCon1.add(lblCodeMTV1);
		pnCenterCon1.add(txtCodeMTV1);

		JPanel pnCenterCon2 = new JPanel();
		txtHT1 = new JTextField(15);
		lblHT1 = new JLabel("        *Tên sách:");
		pnCenterCon2.add(lblHT1);
		pnCenterCon2.add(txtHT1);

		JPanel pnCenterCon3 = new JPanel();
		txtDC1 = new JTextField(15);
		lblDC1 = new JLabel("            *Tác giả:");
		pnCenterCon3.add(lblDC1);
		pnCenterCon3.add(txtDC1);

		JPanel pnCenterCon4 = new JPanel();
		txtP1 = new JTextField(15);
		lblP1 = new JLabel("*Nhà sản xuất :");
		pnCenterCon4.add(lblP1);
		pnCenterCon4.add(txtP1);

		// bên phải
		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
		JPanel pnCenterCon5 = new JPanel();
		txtQ1 = new JTextField(15);
		lblQ1 = new JLabel(" *Năm sản xuất :");
		pnCenterCon5.add(lblQ1);
		pnCenterCon5.add(txtQ1);

		JPanel pnCenterCon6 = new JPanel();
		txtTP1 = new JTextField(15);
		lblTP1 = new JLabel("        *Số Lượng :");
		pnCenterCon6.add(lblTP1);
		pnCenterCon6.add(txtTP1);

		JPanel pnCenterCon7 = new JPanel();
		txtSDT1 = new JTextField(15);
		lblSDT1 = new JLabel("             *Thể loại :");
		pnCenterCon7.add(lblSDT1);
		pnCenterCon7.add(txtSDT1);

		JPanel pnCenterCon8 = new JPanel();
		txtEmail1 = new JTextField(15);
		lblEmail1 = new JLabel("              *Ghi chú :");
		pnCenterCon8.add(lblEmail1);
		pnCenterCon8.add(txtEmail1);

		// phần button thêm,sửa,xóa.....
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new BoxLayout(pnButton, BoxLayout.X_AXIS));
		pnButton.setPreferredSize(new Dimension(1000, 50));
		pnButton.setBackground(Color.LIGHT_GRAY);

		ImageIcon update = new ImageIcon(
				new ImageIcon("icon/them.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		btnthem1 = new JButton("thêm ", update);
		btnthem1.setMargin(new Insets(5, 10, 5, 10));

		ImageIcon update1 = new ImageIcon(
				new ImageIcon("icon/sua.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		btnsua1 = new JButton("sửa ", update1);
		btnsua1.setMargin(new Insets(5, 10, 5, 10));

		ImageIcon update2 = new ImageIcon(
				new ImageIcon("icon/xoa.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		btnxoa1 = new JButton("xóa ", update2);
		btnxoa1.setMargin(new Insets(5, 10, 5, 10));

		ImageIcon update3 = new ImageIcon(
				new ImageIcon("icon/reset.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		btnreset1 = new JButton("reset", update3);
		btnreset1.setMargin(new Insets(5, 10, 5, 10));
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
		pnRight.add(pnCenterCon6);
		pnRight.add(pnCenterCon7);
		pnRight.add(pnCenterCon8);

		// add các buttton them sửa xóa
		// pnButton.add(ro);
		pnButton.add(lbkc7);
		pnButton.add(btnthem1);
		pnButton.add(lbkc8);
		pnButton.add(btnsua1);
		pnButton.add(lbkc9);
		pnButton.add(btnxoa1);
		pnButton.add(lbkc10);
		pnButton.add(btnreset1);

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
		table.addColumn("Ghi chú");
		tbl = new JTable(table);
		TableColumnModel columnModel = tbl.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(110);
		// columnModel.getColumn(3).setPreferredWidth(50);
		// columnModel.getColumn(4).setPreferredWidth(50);
		JScrollPane sc = new JScrollPane(tbl);
		pnSouth.add(sc);
		pnBorder.add(pnSouth, BorderLayout.SOUTH);

		// thêm vào main
		this.add(pnBorder);
	}
}
