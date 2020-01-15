package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.MemberManagementService;
import model.Member;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class MMMain {
	private MemberManagementService service = new MemberManagementService();
	private JFrame frame;
	private Member loginUser;
	private CardLayout cardLayout;
	private JPanel cardPanel;

	/**
	 * Create the application.
	 */
	
	public MMMain(Member loginUser) {
		this.loginUser = loginUser;
		initialize();
		frame.setVisible(true);
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1280, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel cardPanel = new JPanel();
		cardPanel.setBounds(0, 120, 1274, 651);
		frame.getContentPane().add(cardPanel);
		cardLayout = new CardLayout(0, 0);
		cardPanel.setLayout(cardLayout);
		
		DFirst d1Panel = new DFirst();
		cardPanel.add(d1Panel, "d1");
		
		JLabel lblNewLabel = new JLabel("\uC774\uB2EC\uC758 \uCD94\uCC9C\uB3C4\uC11C");
		lblNewLabel.setFont(new Font("���� ���� Semilight", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(317, 46, 313, 42);
		d1Panel.add(lblNewLabel);
		
		A aPanel = new A(loginUser);
		cardPanel.add(aPanel, "a");
		
		B bPanel = new B();
		cardPanel.add(bPanel, "b");
		
		C cPanel = new C();
		cardPanel.add(cPanel, "c");
		
		D dPanel = new D();
		cardPanel.add(dPanel, "d");
		
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uAD00\uB9AC");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "a");
			}
		});
		btnNewButton.setBounds(255, 47, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uB3C4\uC11C");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "b");
			}
		});
		btnNewButton_1.setBounds(364, 47, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uC5F0\uCCB4 \uB300\uCD9C");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "c");
			}
		});
		btnNewButton_2.setBounds(473, 47, 97, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\uD1B5\uACC4");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "d");
			}
		});
		btnNewButton_3.setBounds(582, 47, 97, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton button = new JButton("\uBA54\uC778");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "d1");
			}
		});
		button.setBounds(146, 47, 97, 23);
		frame.getContentPane().add(button);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(759, 23, 125, 75);
		frame.getContentPane().add(label);
		
		
		
		
		
		
		
		
	}
}
