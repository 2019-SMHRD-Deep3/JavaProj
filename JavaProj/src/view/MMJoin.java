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
		frame.setBounds(100, 100, 1024, 720);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(314, 164, 396, 402);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(50, 41, 290, 32);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(24, 109, 84, 15);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("PW");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(24, 134, 84, 15);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("NAME");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(24, 159, 84, 15);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Social Number");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(24, 184, 84, 15);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Phone");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(24, 234, 84, 15);
		panel.add(lblNewLabel_5);

		id = new JTextField();
		id.setBounds(120, 106, 220, 21);
		panel.add(id);
		id.setColumns(10);

		name = new JTextField();
		name.setBounds(120, 156, 220, 21);
		panel.add(name);
		name.setColumns(10);

		socialNumber = new JTextField();
		socialNumber.setBounds(120, 181, 220, 21);
		panel.add(socialNumber);
		socialNumber.setColumns(10);

		phone = new JTextField();
		phone.setBounds(120, 231, 220, 21);
		panel.add(phone);
		phone.setColumns(10);

		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
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
		btnNewButton_1.setBackground(SystemColor.controlHighlight);
		btnNewButton_1.setBounds(92, 325, 97, 23);
		panel.add(btnNewButton_1);

		pw = new JPasswordField();
		pw.setBounds(120, 131, 220, 21);
		panel.add(pw);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBackground(SystemColor.controlHighlight);
		btnCancel.setBounds(211, 325, 97, 23);
		panel.add(btnCancel);

		JLabel lblNewLabel_7 = new JLabel("Address");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(24, 209, 84, 15);
		panel.add(lblNewLabel_7);

		address = new JTextField();
		address.setBounds(120, 206, 220, 21);
		panel.add(address);
		address.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("New label");
		String imgPath = this.getClass().getResource(".").getPath() + "..//..//img//0004.jpg";
		System.out.println(imgPath);
		lblNewLabel_6.setIcon(new ImageIcon(imgPath));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(0, 0, 1280, 720);
		frame.getContentPane().add(lblNewLabel_6);
	}

}
