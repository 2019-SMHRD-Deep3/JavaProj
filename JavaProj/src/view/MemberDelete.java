package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import controller.MemberManagementService;
import model.Member;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class MemberDelete {

	private JFrame frame;
	private JTextField id;
	private JPasswordField pw;
	private MemberManagementService service = new MemberManagementService();
	private Member deleteUser;


	public MemberDelete(Member deleteUser) {
		this.deleteUser = deleteUser;
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
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 15));
		lblId.setBounds(12, 60, 113, 21);
		frame.getContentPane().add(lblId);
		
		id = new JTextField(deleteUser.getId());
		id.setColumns(10);
		id.setBounds(137, 62, 270, 21);
		frame.getContentPane().add(id);
		
		pw = new JPasswordField(deleteUser.getPw());
		pw.setBounds(137, 93, 270, 21);
		frame.getContentPane().add(pw);
		
		JLabel label_1 = new JLabel("PW");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 15));
		label_1.setBounds(12, 91, 113, 21);
		frame.getContentPane().add(label_1);
		
		JButton button = new JButton("\uC0AD\uC81C");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String deleteId = id.getText();
							
				Member deleteUser = new Member(deleteId);
				boolean result = service.delMember(deleteUser);
				if (result) {
					JOptionPane.showMessageDialog(frame, "ªË¡¶ º∫∞¯");
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(frame, "√• π›≥≥ »ƒ ªË¡¶«ÿ¡÷ººø‰.");
				}
			
			}
		});
		button.setBounds(136, 216, 97, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\uCDE8\uC18C");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		button_1.setBounds(245, 216, 97, 23);
		frame.getContentPane().add(button_1);
		
		JLabel label_2 = new JLabel("\uD68C\uC6D0\uC0AD\uC81C");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 15));
		label_2.setBounds(12, 10, 420, 21);
		frame.getContentPane().add(label_2);
		
		JLabel lblNewLabel = new JLabel("\uBCF5\uAD6C \uB418\uC9C0 \uC54A\uC2B5\uB2C8\uB2E4.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(132, 136, 162, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\uC2E0\uC911\uD558\uAC8C \uC120\uD0DD\uD574\uC8FC\uC138\uC694.");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(137, 167, 157, 21);
		frame.getContentPane().add(label);
		
		
		
		
	}
}
