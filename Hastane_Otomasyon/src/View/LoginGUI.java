package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import Helper.*;
import Model.BasHekim;

public class LoginGUI extends JFrame {

	private JPanel w_pane;
	private JTextField fld_HastaTc;
	private JTextField fld_HastaSifre;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField fld_yonetimTc;
	private JPasswordField fld_yonetimSifre;
	private DBConnection conn = new DBConnection();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setResizable(false);
		setTitle("Hastane Otomasyon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 450);
		w_pane = new JPanel();
		w_pane.setBackground(Color.WHITE);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);
		
		JLabel lbl_logo = new JLabel(new ImageIcon(getClass().getResource("indir1.png")));
		lbl_logo.setBounds(200, 8, 130, 125);
		w_pane.add(lbl_logo);
		
		JLabel lblNewLabel = new JLabel("Hastane Y\u00F6netim Sistemine Ho\u015Fgeldiniz");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		lblNewLabel.setBounds(55, 145, 410, 30);
		w_pane.add(lblNewLabel);
		
		JTabbedPane w_tabbpane = new JTabbedPane(JTabbedPane.TOP);
		w_tabbpane.setBounds(10, 186, 494, 218);
		w_pane.add(w_tabbpane);
		
		JPanel w_hastaLogin = new JPanel();
		w_hastaLogin.setBackground(Color.WHITE);
		w_hastaLogin.setForeground(Color.WHITE);
		w_tabbpane.addTab("Hasta Giriþ", null, w_hastaLogin, null);
		w_hastaLogin.setLayout(null);
		
		JLabel lblTcKimlikNo = new JLabel("TC Kimlik NO :");
		lblTcKimlikNo.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		lblTcKimlikNo.setBounds(10, 11, 160, 30);
		w_hastaLogin.add(lblTcKimlikNo);
		
		JLabel lblifre = new JLabel("\u015Eifre :");
		lblifre.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		lblifre.setBounds(10, 52, 70, 30);
		w_hastaLogin.add(lblifre);
		
		fld_HastaTc = new JTextField();
		fld_HastaTc.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		fld_HastaTc.setBounds(160, 15, 270, 30);
		w_hastaLogin.add(fld_HastaTc);
		fld_HastaTc.setColumns(10);
		
		fld_HastaSifre = new JTextField();
		fld_HastaSifre.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		fld_HastaSifre.setColumns(10);
		fld_HastaSifre.setBounds(160, 55, 270, 30);
		w_hastaLogin.add(fld_HastaSifre);
		
		JButton btn_kayitol = new JButton("KAYIT OL");
		btn_kayitol.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		btn_kayitol.setBounds(10, 100, 195, 50);
		w_hastaLogin.add(btn_kayitol);
		
		JButton btn_HastaLogin = new JButton("G\u0130R\u0130\u015E YAP");
		btn_HastaLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_HastaLogin.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		btn_HastaLogin.setBounds(235, 100, 195, 50);
		w_hastaLogin.add(btn_HastaLogin);
		
		JPanel w_yetkiliLogin = new JPanel();
		w_yetkiliLogin.setBackground(Color.WHITE);
		w_yetkiliLogin.setForeground(Color.WHITE);
		w_tabbpane.addTab("Yetkili Giriþ", null, w_yetkiliLogin, null);
		w_yetkiliLogin.setLayout(null);
		
		JLabel lblTcKimlikNo_1 = new JLabel("TC Kimlik NO :");
		lblTcKimlikNo_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		lblTcKimlikNo_1.setBounds(10, 11, 160, 30);
		w_yetkiliLogin.add(lblTcKimlikNo_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(160, 15, 270, 30);
		w_yetkiliLogin.add(textField);
		
		JLabel lblifre_1 = new JLabel("\u015Eifre :");
		lblifre_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		lblifre_1.setBounds(10, 52, 70, 30);
		w_yetkiliLogin.add(lblifre_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(160, 55, 270, 30);
		w_yetkiliLogin.add(textField_1);
		
		JButton btn_YetkiliLogin = new JButton("G\u0130R\u0130\u015E YAP");
		btn_YetkiliLogin.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		btn_YetkiliLogin.setBounds(10, 100, 420, 50);
		w_yetkiliLogin.add(btn_YetkiliLogin);
		
		JPanel w_yonetimLogin = new JPanel();
		w_yonetimLogin.setForeground(Color.WHITE);
		w_yonetimLogin.setBackground(Color.WHITE);
		w_tabbpane.addTab("Yönetim Giriþ", null, w_yonetimLogin, null);
		w_yonetimLogin.setLayout(null);
		
		JLabel lblTcKimlikNo_2 = new JLabel("TC Kimlik NO :");
		lblTcKimlikNo_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		lblTcKimlikNo_2.setBounds(10, 11, 160, 30);
		w_yonetimLogin.add(lblTcKimlikNo_2);
		
		fld_yonetimTc = new JTextField();
		fld_yonetimTc.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 15));
		fld_yonetimTc.setColumns(10);
		fld_yonetimTc.setBounds(160, 15, 270, 30);
		w_yonetimLogin.add(fld_yonetimTc);
		
		JLabel lblifre_2 = new JLabel("\u015Eifre :");
		lblifre_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		lblifre_2.setBounds(10, 52, 70, 30);
		w_yonetimLogin.add(lblifre_2);
		
		JButton btn_yonetimLogin = new JButton("G\u0130R\u0130\u015E YAP");
		btn_yonetimLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (fld_yonetimTc.getText().length() == 0 || fld_yonetimSifre.getText().length() == 0 ) {
				Helper.shwMsg("fill") ;
				} else {
					try {
						Connection con = conn.connDb();
						Statement st = con.createStatement(); 
						// girilen deðer veritabanýnda varmý kontrolü.
						ResultSet rs = st.executeQuery("SELECT * FROM user");
						while (rs.next()) { // bütün userlarý kontrol ediyorum.
							if (fld_yonetimTc.getText().equals(rs.getString("tc_no")) && fld_yonetimSifre.getText().equals(rs.getString("password"))) {
							BasHekim bhekim = new BasHekim();
							bhekim.setId(rs.getInt("id"));
							bhekim.setPassword(rs.getString("password"));
							bhekim.setTc_no(rs.getString("tc_no"));
							bhekim.setName(rs.getString("name"));
							bhekim.setType(rs.getString("type"));
							BasHekimGUI bGUI = new BasHekimGUI(bhekim);
							bGUI.setVisible(true);
							dispose();
							}
							
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btn_yonetimLogin.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		btn_yonetimLogin.setBounds(10, 100, 420, 50);
		w_yonetimLogin.add(btn_yonetimLogin);
		
		fld_yonetimSifre = new JPasswordField();
		fld_yonetimSifre.setBounds(160, 55, 270, 30);
		w_yonetimLogin.add(fld_yonetimSifre);
	}
}
