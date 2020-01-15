package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.MemberManagementService;
import model.Member;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.DropMode;
import javax.swing.SpringLayout;

public class MMJoin {
	MemberManagementService service = new MemberManagementService();
	private JFrame frame;
	private JPasswordField pw;
	private JTextField name;
	private JTextField socialNumber;
	private JTextField phone;
	private JTextField address;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MMJoin window = new MMJoin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 * 
	 */
	public MMJoin() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1280, 740);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(229, 222, 211));
		panel.setBounds(453, 277, 396, 402);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setBounds(0, 41, 396, 32);
		lblNewLabel.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1.setBounds(24, 106, 84, 27);
		String imgPath = this.getClass().getResource(".").getPath() + "..//..//img//btn003.png";
		lblNewLabel_1.setIcon(new ImageIcon(imgPath));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setBounds(24, 131, 84, 27);
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//btn004.png";
		lblNewLabel_2.setIcon(new ImageIcon(imgPath));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_3.setBounds(24, 156, 84, 27);
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//btn008.png";
		lblNewLabel_3.setIcon(new ImageIcon(imgPath));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(24, 180, 84, 27);
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//btn006.png";
		lblNewLabel_4.setIcon(new ImageIcon(imgPath));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(24, 231, 84, 28);
		lblNewLabel_5.setVerticalAlignment(SwingConstants.TOP);
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//btn005.png";
		lblNewLabel_5.setIcon(new ImageIcon(imgPath));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_5);

		id = new JTextField();
		id.setBounds(120, 106, 240, 21);
		panel.add(id);
		id.setColumns(10);

		name = new JTextField();
		name.setBounds(120, 156, 240, 21);
		panel.add(name);
		name.setColumns(10);

		socialNumber = new JTextField();
		socialNumber.setBounds(120, 181, 240, 21);
		panel.add(socialNumber);
		socialNumber.setColumns(10);

		phone = new JTextField();
		phone.setBounds(120, 231, 240, 21);
		panel.add(phone);
		phone.setColumns(10);

		pw = new JPasswordField();
		pw.setBounds(120, 131, 240, 21);
		panel.add(pw);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(24, 206, 84, 28);
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//btn007.png";
		lblNewLabel_7.setIcon(new ImageIcon(imgPath));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_7);

		address = new JTextField();
		address.setBounds(120, 206, 240, 21);
		panel.add(address);
		address.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(100, 300, 90, 30);
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String infoId = id.getText();
				String infoPw = pw.getText();
				String infoName = name.getText();
				String infoSocialNumber = socialNumber.getText();
				String infoAddress = address.getText();
				String infoPhone = phone.getText();

				Member m = new Member(infoId, infoPw, infoName, infoSocialNumber, infoAddress, infoPhone);

				boolean result = service.memberJoin(m);
				if (result) {
					JOptionPane.showMessageDialog(frame, "회원 가입 성공");
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(frame, "회원 가입 실패");
				}
			}
		});
		lblNewLabel_8.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//btn009.png";
		lblNewLabel_8.setIcon(new ImageIcon(imgPath));
		panel.add(lblNewLabel_8);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		label.setBounds(220, 300, 90, 30);
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//btn010.png";
		label.setIcon(new ImageIcon(imgPath));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);

		JLabel lblNewLabel_6 = new JLabel("New label");
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//0004.jpg";
		lblNewLabel_6.setIcon(new ImageIcon(imgPath));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(0, 0, 1280, 871);
		frame.getContentPane().add(lblNewLabel_6);
	}
}
