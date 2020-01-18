package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.MemberManagementService;
import model.Member;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberUpdate {
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private MemberManagementService service = new MemberManagementService();
	private Member selectUser;

	/**
	 * Create the application.
	 */
	public MemberUpdate(Member selectUser) {
		this.selectUser = selectUser;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0\uC815\uBCF4\uC218\uC815");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 420, 21);
		frame.getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("\uC774\uB984");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label.setBounds(12, 60, 113, 21);
		frame.getContentPane().add(label);

		JLabel lblPw = new JLabel("PW");
		lblPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblPw.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		lblPw.setBounds(12, 91, 113, 21);
		frame.getContentPane().add(lblPw);

		JLabel lblWnth = new JLabel("\uC8FC\uC18C");
		lblWnth.setHorizontalAlignment(SwingConstants.CENTER);
		lblWnth.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		lblWnth.setBounds(12, 122, 113, 21);
		frame.getContentPane().add(lblWnth);

		JLabel label_4 = new JLabel("\uC5F0\uB77D\uCC98");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_4.setBounds(12, 153, 113, 21);
		frame.getContentPane().add(label_4);

		textField = new JTextField(selectUser.getName());
		textField.setBounds(137, 62, 270, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField(selectUser.getPw());
		textField_1.setColumns(10);
		textField_1.setBounds(137, 93, 270, 21);
		frame.getContentPane().add(textField_1);

		textField_2 = new JTextField(selectUser.getAddress());
		textField_2.setColumns(10);
		textField_2.setBounds(137, 124, 270, 21);
		frame.getContentPane().add(textField_2);

		textField_3 = new JTextField(selectUser.getPhone());
		textField_3.setColumns(10);
		textField_3.setBounds(137, 155, 270, 21);
		frame.getContentPane().add(textField_3);

		JButton btnNewButton = new JButton("\uC218\uC815");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String name = textField.getText();
				String pw = textField_1.getText();
				String address = textField_2.getText();
				String phone = textField_3.getText();

				Member editUser = new Member(name, pw, address, phone);
				boolean result = service.editMember(editUser);
				if (result) {
					JOptionPane.showMessageDialog(frame, "¼öÁ¤ ¼º°ø");
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(frame, "¼öÁ¤ ½ÇÆÐ");
				}
			}
		});
		btnNewButton.setBounds(136, 216, 97, 23);
		frame.getContentPane().add(btnNewButton);

		JButton button = new JButton("\uCDE8\uC18C");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
			}
		});
		button.setBounds(245, 216, 97, 23);
		frame.getContentPane().add(button);
	}
}
