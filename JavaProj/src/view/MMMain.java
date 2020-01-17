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
import javax.swing.UIManager;

public class MMMain {
	private MemberManagementService service = new MemberManagementService();
	private JFrame frame;
	private Member loginUser;
	private CardLayout cardLayout;
	private JPanel cardPanel;

	public MMMain(Member loginUser) {
		this.loginUser = loginUser;
		initialize();
		frame.setVisible(true);
	}

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


//      if (loginUser.getId().equals("admin")) {
		DFirst d1Panel = new DFirst();
		cardPanel.add(d1Panel, "d1");

		A aPanel = new A(loginUser);
		cardPanel.add(aPanel, "a");

		B bPanel = new B(loginUser);
		cardPanel.add(bPanel, "b");

		C cPanel = new C();
		cardPanel.add(cPanel, "c");

		D dPanel = new D();
		cardPanel.add(dPanel, "d");

//		} else {
//			DFirst d1Panel = new DFirst();
//			cardPanel.add(d1Panel, "d1");

		AU auPanel = new AU(loginUser);
		cardPanel.add(auPanel, "au");

		BU buPanel = new BU();
		cardPanel.add(buPanel, "bu");

		CU cuPanel = new CU();
		cardPanel.add(cuPanel, "cu");

//      }


		JLabel id = new JLabel("ooo");
		id.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setBounds(1092, 100, 152, 15);
		frame.getContentPane().add(id);
		id.setText(loginUser.getName());

		JLabel lblNewLabel_2 = new JLabel("\uB2D8 \uD658\uC601\uD569\uB2C8\uB2E4.");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(1092, 125, 152, 15);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "d");
			}
		});
		String imgPath = this.getClass().getResource(".").getPath() + "..//..//img//icon001.png";
		lblNewLabel.setIcon(new ImageIcon(imgPath));
		lblNewLabel.setBounds(861, 30, 100, 100);
		frame.getContentPane().add(lblNewLabel);

		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "a");
			}
		});
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//icon004.png";
		label_1.setIcon(new ImageIcon(imgPath));
		label_1.setBounds(471, 30, 100, 100);
		frame.getContentPane().add(label_1);

		JLabel lblHome = new JLabel("");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cardLayout.show(cardPanel, "d1");
			}
		});
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//icon007.png";
		lblHome.setIcon(new ImageIcon(imgPath));
		lblHome.setBounds(341, 30, 100, 100);
		frame.getContentPane().add(lblHome);

		JLabel label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "b");
			}
		});
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//icon003.png";
		label_3.setIcon(new ImageIcon(imgPath));
		label_3.setBounds(601, 30, 100, 100);
		frame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "c");
			}
		});
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//icon005.png";
		label_4.setIcon(new ImageIcon(imgPath));
		label_4.setBounds(731, 30, 100, 100);
		frame.getContentPane().add(label_4);

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginUser = null;
				JOptionPane.showMessageDialog(frame, "·Î±×¾Æ¿ô µÇ¾ú½À´Ï´Ù.");
				frame.dispose();
				MMLogin Login = new MMLogin();

			}
		});
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//icon006.png";
		label.setIcon(new ImageIcon(imgPath));
		label.setBounds(1137, 32, 64, 64);
		frame.getContentPane().add(label);

		JLabel lblNewLabel_1 = new JLabel("");
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//main0002.png";
		lblNewLabel_1.setIcon(new ImageIcon(imgPath));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(30, 10, 150, 130);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblHome_1 = new JLabel("\uD648");
		lblHome_1.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		lblHome_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome_1.setBounds(341, 120, 100, 15);
		frame.getContentPane().add(lblHome_1);

		JLabel lblMember = new JLabel("\uD68C\uC6D0\uC815\uBCF4");
		lblMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblMember.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		lblMember.setBounds(471, 120, 100, 15);
		frame.getContentPane().add(lblMember);

		JLabel lblBook = new JLabel("\uB3C4\uC11C");
		lblBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblBook.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		lblBook.setBounds(601, 120, 100, 15);
		frame.getContentPane().add(lblBook);

		JLabel label_2 = new JLabel("\uB300\uC5EC.\uC5F0\uCCB4.\uC5F0\uC7A5");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 12));
		label_2.setBounds(731, 120, 100, 15);
		frame.getContentPane().add(label_2);

		JLabel label_5 = new JLabel("\uD1B5\uACC4");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_5.setBounds(861, 120, 100, 15);
		frame.getContentPane().add(label_5);

		JLabel lblNewLabel_3 = new JLabel("Readers are Leaders");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(30, 120, 150, 15);
		frame.getContentPane().add(lblNewLabel_3);

	}
}