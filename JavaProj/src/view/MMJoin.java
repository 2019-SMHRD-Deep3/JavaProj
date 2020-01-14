package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class MMJoin {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField_1;

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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(314, 164, 396, 402);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(50, 41, 290, 32);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(24, 103, 84, 15);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("PW");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(24, 134, 84, 15);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("NAME");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(24, 190, 84, 15);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Social Number");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(24, 215, 84, 15);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Phone");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(24, 240, 84, 15);
		panel.add(lblNewLabel_5);

		textField = new JTextField();
		textField.setBounds(120, 100, 116, 21);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(120, 187, 220, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(120, 156, 220, 21);
		panel.add(passwordField);

		textField_2 = new JTextField();
		textField_2.setBounds(120, 212, 220, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(120, 237, 220, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JButton btnNewButton = new JButton("ID Check");
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.setFont(new Font("±¼¸²", Font.PLAIN, 10));
		btnNewButton.setBounds(250, 99, 90, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.setBackground(SystemColor.controlHighlight);
		btnNewButton_1.setBounds(92, 325, 97, 23);
		panel.add(btnNewButton_1);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(120, 131, 220, 21);
		panel.add(passwordField_1);

		JLabel lblConfirmPw = new JLabel("Confirm PW");
		lblConfirmPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmPw.setBounds(24, 159, 84, 15);
		panel.add(lblConfirmPw);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(SystemColor.controlHighlight);
		btnCancel.setBounds(211, 325, 97, 23);
		panel.add(btnCancel);

		JLabel lblNewLabel_6 = new JLabel("New label");
		String imgPath = this.getClass().getResource(".").getPath() + "..//..//img//0004.jpg";
		System.out.println(imgPath);
		lblNewLabel_6.setIcon(new ImageIcon(imgPath));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(0, 0, 1024, 720);
		frame.getContentPane().add(lblNewLabel_6);
	}

}
