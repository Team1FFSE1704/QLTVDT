package fasttrackse.team1.qlthuviendientu.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ThongKeUI extends JPanel {
	private JLabel lblTitle, lbWestTS, lblCodeGD, lblCodeTV, lblCodeSL, lblNM, lblNT, lblMS, lbWestMS;
	private JButton btnqltv, btnqlmt, btnqls, btnqldm, btnkt, btntk, btnSubmit, btnts, btnms;
	private JTextField txtCodeTV, txtCodeGD, txtSL, txtNM, txtNT;
	private DefaultTableModel table = new DefaultTableModel();
	private JTable tbl;
	private JScrollPane fruitListScrollPane;
	private JComboBox<String> cbo = new JComboBox<String>();

	private Border raisedBevel = BorderFactory.createRaisedBevelBorder();
	private Border raisedEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);

	public ThongKeUI() {

		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		BorderLayout layout = new BorderLayout();
		layout.setHgap(10);
		layout.setVgap(5);
		pnBorder.setLayout(layout);
		pnBorder.setBackground(Color.gray);
		
		// phần header
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new BoxLayout(pnNorth, BoxLayout.Y_AXIS));
		pnNorth.setBorder(raisedEtched);
		pnNorth.setPreferredSize(new Dimension(100, 150));
		pnNorth.setBackground(Color.BLACK);

		// phần Jlist box+ comboxx
		JPanel pnNorthCon = new JPanel();
		pnNorthCon.setBackground(Color.red);
		pnNorthCon.setPreferredSize(new Dimension(300, 50));
		pnNorthCon.setLayout(new BoxLayout(pnNorthCon, BoxLayout.X_AXIS));
		
		//phần  Jlisst
		JPanel pnTong =new JPanel();
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
		//panelcon
		JPanel pnCobcon1 = new JPanel();
		pnCobcon1.setPreferredSize(new Dimension(300, 10));
		
		JPanel pnCobcon2 = new JPanel();
		JLabel lblCob = new JLabel("Thành phố:");
		cbo.addItem("FFSE1701");
		cbo.addItem("FFSE1702");
		cbo.addItem("FFSE1703");
		cbo.addItem("FFSE1704");
		pnCobcon2.add(lblCob);
		pnCobcon2.add(cbo);
		pnCob.add(pnCobcon1);
		pnCob.add(pnCobcon2);
		pnNorthCon.add(pnCob);
		
		JPanel pnButton = new JPanel();
		pnButton.setPreferredSize(new Dimension(300, 30));
		
		btnSubmit = new JButton("Submit");
		pnButton.add(btnSubmit);
		
		//phần add hai phần con heard
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
