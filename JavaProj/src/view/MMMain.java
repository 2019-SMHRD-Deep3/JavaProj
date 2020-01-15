package view;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.MemberManagementService;
import model.Member;

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
		
		if (loginUser.getId().equals("admin")) {
			DFirst d1Panel = new DFirst();
			cardPanel.add(d1Panel, "d1");
			
			A aPanel = new A(loginUser);
			cardPanel.add(aPanel, "a");
			
			B bPanel = new B();
			cardPanel.add(bPanel, "b");
			
			C cPanel = new C();
			cardPanel.add(cPanel, "c");
			
			D dPanel = new D();
			cardPanel.add(dPanel, "d");
		} else {
			AU auPanel = new AU(loginUser);
			cardPanel.add(auPanel, "a");
			
			BU buPanel = new BU();
			cardPanel.add(buPanel, "b");
			
			CU cuPanel = new CU();
			cardPanel.add(cuPanel, "c");
			
			D dPanel = new D();
			cardPanel.add(dPanel, "d");
		}
		
		
		
		
		
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uAD00\uB9AC");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "a");
			}
		});
		btnNewButton.setBounds(335, 47, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uB3C4\uC11C");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "b");
			}
		});
		btnNewButton_1.setBounds(444, 47, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uC5F0\uCCB4 \uB300\uCD9C");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "c");
			}
		});
		btnNewButton_2.setBounds(553, 47, 97, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\uD1B5\uACC4");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "d");
			}
		});
		btnNewButton_3.setBounds(662, 47, 97, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton button = new JButton("\uBA54\uC778");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "d1");
			}
		});
		button.setBounds(226, 47, 97, 23);
		frame.getContentPane().add(button);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(759, 23, 125, 75);
		frame.getContentPane().add(label);
		
		JLabel id = new JLabel("ooo");
		id.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setBounds(896, 51, 57, 15);
		frame.getContentPane().add(id);
		id.setText(loginUser.getName());
		
		JLabel lblNewLabel_2 = new JLabel("\uB2D8 \uD658\uC601\uD569\uB2C8\uB2E4.");
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(965, 51, 170, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton button_1 = new JButton("\uB85C\uADF8\uC544\uC6C3");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginUser = null;
				JOptionPane.showMessageDialog(frame, "·Î±×¾Æ¿ô µÇ¾ú½À´Ï´Ù.");
//				frame.dispose();
			}
		});
		button_1.setBounds(1147, 47, 97, 23);
		frame.getContentPane().add(button_1);
		
		
		
		
		
		
		
		
	}
}
