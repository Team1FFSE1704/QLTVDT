package fasttrackse.quanlythuvien.java.until;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

public class QuanLyDanhMucUI {
		
	
	
	public void addEvents() {
		// tbl.addMouseListener(tblUserClick);
		// btnexit.addActionListener(btnExitClick);
		// btnadd.addActionListener( btAddClick );
		// btndelete.addActionListener( btdeleteClick );
		// btnedit.addActionListener( bteditClick );
		// btnimport.addActionListener(btimportClick);
	}

	// public ChuongTrinhQuanLySinhVienUI(String title) {
	// super(title);
	// addConTrol();
	// addEvents();
	// }
	ActionListener btnExitClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			System.exit(0);

		}
	};
	ActionListener btAddClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// themSinhVien();

		}
	};
	ActionListener btdeleteClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// xoaSinhVien();

		}
	};
	ActionListener bteditClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// suaSinhVien();

		}
	};
	ActionListener btimportClick = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			// nhapSinhVien();
			JOptionPane.showMessageDialog(null, "Bạn muốn nhập thông tin");

		}
	};
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

			// int row = tbl.getSelectedRow();
			// String lopSV = (String) tbl.getValueAt(row, 1);
			// txtCode.setText(lopSV);
			// String maSV = (String) tbl.getValueAt(row, 0);
			// txtCode.setText(maSV);
			//
			// String tenSinhVien = (String) tbl.getValueAt(row, 2);
			// txtUser.setText(tenSinhVien);
			//
			// String tuoiSinhVien = (String) tbl.getValueAt(row, 3);
			// txtArg.setText(tuoiSinhVien);
		}
	};

//	public void themSinhVien() {
//		String tenSinhVien = txtUser.getText();
//		String maSinhVien = txtCode.getText();
//		String lopSinhVien = cbo.getSelectedItem().toString();
//		String tuoiSinhVien = txtArg.getText();
//
//		table.addRow(new String[] { maSinhVien, lopSinhVien, tenSinhVien, tuoiSinhVien });
//	}
//	public void xoaSinhVien() {
//		
//		int[] rows = tbl.getSelectedRows();
//		   for(int i=0;i<rows.length;i++){
//		     table.removeRow(rows[i]-i);
//		     
//		   }
//	}
//	public void suaSinhVien() {
//		String tenSinhVien = txtUser.getText();
//		String maSinhVien = txtCode.getText();
//		String lopSinhVien = cbo.getSelectedItem().toString();
//		String tuoiSinhVien = txtArg.getText();
//		int row = tbl.getSelectedRow();
//		tbl.setValueAt(maSinhVien,row, 0);
//		tbl.setValueAt(lopSinhVien,row, 1);
//		tbl.setValueAt(tenSinhVien,row, 2);
//		tbl.setValueAt(tuoiSinhVien,row, 3);
//	
//	}
//	public void nhapSinhVien() {
//		txtCode.setText("");
//		txtUser.setText("");
//		txtArg.setText("");
//	}

}
