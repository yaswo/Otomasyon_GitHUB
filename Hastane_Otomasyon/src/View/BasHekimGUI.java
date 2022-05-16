package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Model.BasHekim;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BasHekimGUI extends JFrame {
	static BasHekim bashekim = new BasHekim();
	private JPanel w_pane;
	private JTextField fld_dName;
	private JTextField fld_dTcno;
	private JTextField fld_dPass;
	private JTextField fld_doctorID;
	private JTable table_doctor;
	private DefaultTableModel doctorModel = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BasHekimGUI frame = new BasHekimGUI(bashekim);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BasHekimGUI(BasHekim bashekim) {
		setTitle("Hastane Y\u00F6netim Sistemi");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		w_pane = new JPanel();
		w_pane.setForeground(Color.WHITE);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ho\u015Fgeldiniz Say\u0131n " + bashekim.getName());
		lblNewLabel.setBounds(8, 34, 490, 25);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		w_pane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u00C7IKI\u015E YAP");
		btnNewButton.setBounds(614, 9, 110, 25);
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		w_pane.add(btnNewButton);
		
		JTabbedPane w_tab = new JTabbedPane(JTabbedPane.TOP);
		w_tab.setBounds(40, 70, 660, 360);
		w_pane.add(w_tab);
		
		JPanel w_yonetim = new JPanel();
		w_yonetim.setBackground(Color.WHITE);
		w_tab.addTab("Hastane Yönetimi", null, w_yonetim, null);
		w_yonetim.setLayout(null);
		
		JLabel Label = new JLabel("Ad Soyad");
		Label.setBounds(500, 3, 150, 20);
		Label.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		Label.setBackground(Color.WHITE);
		w_yonetim.add(Label);
		
		fld_dName = new JTextField();
		fld_dName.setBounds(500, 25, 150, 25);
		w_yonetim.add(fld_dName);
		fld_dName.setColumns(10);
		
		JLabel Label_1 = new JLabel("T.C. No");
		Label_1.setBounds(500, 55, 150, 20);
		Label_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		Label_1.setBackground(Color.WHITE);
		w_yonetim.add(Label_1);
		
		fld_dTcno = new JTextField();
		fld_dTcno.setBounds(500, 75, 150, 25);
		fld_dTcno.setColumns(10);
		w_yonetim.add(fld_dTcno);
		
		JLabel Label_2 = new JLabel("\u015Eifre");
		Label_2.setBounds(500, 105, 150, 20);
		Label_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		Label_2.setBackground(Color.WHITE);
		w_yonetim.add(Label_2);
		
		fld_dPass = new JTextField();
		fld_dPass.setBounds(500, 125, 150, 25);
		fld_dPass.setColumns(10);
		w_yonetim.add(fld_dPass);
		
		JButton btn_addDoctor = new JButton("EKLE");
		btn_addDoctor.setBounds(500, 170, 150, 30);
		btn_addDoctor.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		w_yonetim.add(btn_addDoctor);
		
		JLabel lblKullancID = new JLabel("Kullan\u0131c\u0131 ID");
		lblKullancID.setHorizontalAlignment(SwingConstants.LEFT);
		lblKullancID.setBounds(500, 210, 150, 25);
		lblKullancID.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblKullancID.setBackground(Color.WHITE);
		w_yonetim.add(lblKullancID);
		
		fld_doctorID = new JTextField();
		fld_doctorID.setBounds(500, 235, 150, 25);
		fld_doctorID.setColumns(10);
		w_yonetim.add(fld_doctorID);
		
		JButton btn_delDoctor = new JButton("S\u0130L");
		btn_delDoctor.setBounds(500, 280, 150, 30);
		btn_delDoctor.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		w_yonetim.add(btn_delDoctor);
		
		JScrollPane w_scrollDoctor = new JScrollPane();
		w_scrollDoctor.setBounds(10, 3, 480, 318);
		w_yonetim.add(w_scrollDoctor);
		
		table_doctor = new JTable();
		w_scrollDoctor.setViewportView(table_doctor);
	}
}
