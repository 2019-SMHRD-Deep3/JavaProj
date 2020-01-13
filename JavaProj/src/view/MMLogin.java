package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Font;

public class MMLogin {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MMLogin window = new MMLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MMLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
<<<<<<< HEAD
		frame.setResizable(false);
		frame.setBounds(100, 100, 1024, 720);
=======
		frame.setBounds(100, 100, 513, 360);
>>>>>>> branch 'master' of https://github.com/fruitfuls2/JavaProj.git
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(354, 411, 350, 200);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(50, 90, 57, 15);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PW");
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(50, 115, 57, 15);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 12));
		textField.setBounds(119, 87, 175, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 12));
		passwordField.setBounds(119, 112, 175, 21);
		panel.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("\uB3C4\uC11C\uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8 \uB85C\uADF8\uC778");
		lblNewLabel_2.setFont(UIManager.getFont("CheckBoxMenuItem.font"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(50, 30, 244, 29);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 12));
		btnNewButton.setBounds(80, 155, 97, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 12));
		btnNewButton_1.setBounds(183, 155, 97, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1018, 691);
		frame.getContentPane().add(panel_1);
	}
}
