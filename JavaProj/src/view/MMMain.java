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
import javax.swing.ImageIcon;
import java.awt.Color;

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
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 1280, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel cardPanel = new JPanel();
		cardPanel.setBounds(0, 165, 1274, 606);
		frame.getContentPane().add(cardPanel);
		cardLayout = new CardLayout(0, 0);
		cardPanel.setLayout(cardLayout);
		
//		if (loginUser.getId().equals("admin")) {
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
//		} else {
			AU auPanel = new AU(loginUser);
			cardPanel.add(auPanel, "au");
			
			BU buPanel = new BU();
			cardPanel.add(buPanel, "bu");
			
			CU cuPanel = new CU();
			cardPanel.add(cuPanel, "cu");
		
		JLabel id = new JLabel("ooo");
		id.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setBounds(970, 62, 152, 15);
		frame.getContentPane().add(id);
		id.setText(loginUser.getName());
		
		JLabel lblNewLabel_2 = new JLabel("\uB2D8 \uD658\uC601\uD569\uB2C8\uB2E4.");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(970, 106, 152, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("stat");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "d");
			}
		});
		String imgPath = this.getClass().getResource(".").getPath() + "..//..//img//icon001.png";
		lblNewLabel.setIcon(new ImageIcon(imgPath));
		lblNewLabel.setBounds(790, 19, 128, 128);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_1 = new JLabel("member");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "a");
			}
		});
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//icon004.png";
		label_1.setIcon(new ImageIcon(imgPath));
		label_1.setBounds(370, 19, 128, 128);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("home");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cardLayout.show(cardPanel, "d1");
			}
		});
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//icon007.png";
		label_2.setIcon(new ImageIcon(imgPath));
		label_2.setBounds(230, 19, 128, 128);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("book");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "b");
			}
		});
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//icon003.png";
		label_3.setIcon(new ImageIcon(imgPath));
		label_3.setBounds(510, 19, 128, 128);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("loan");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "c");
			}
		});
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//icon005.png";
		label_4.setIcon(new ImageIcon(imgPath));
		label_4.setBounds(650, 19, 128, 128);
		frame.getContentPane().add(label_4);
		
		JLabel label = new JLabel("logout");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginUser = null;
				JOptionPane.showMessageDialog(frame, "·Î±×¾Æ¿ô µÇ¾ú½À´Ï´Ù.");
			}
		});
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//icon006.png";
		label.setIcon(new ImageIcon(imgPath));
		label.setBounds(1134, 27, 128, 128);
		frame.getContentPane().add(label);
		
		
		
		
		
		
		
		
	}
}
