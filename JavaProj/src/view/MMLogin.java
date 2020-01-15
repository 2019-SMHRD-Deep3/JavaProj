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
import javax.swing.UIManager;

import controller.MemberManagementService;
import model.Member;
import java.awt.Color;
import javax.swing.SpringLayout;

public class MMLogin {
	private MemberManagementService service = new MemberManagementService();
	private JFrame frame;

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
		frame.setResizable(false);
		frame.setBounds(100, 100, 1280, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(229, 222, 211));
		panel.setBounds(470, 474, 350, 200);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 67, 90, 30);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		String imgPath = this.getClass().getResource(".").getPath() + "..//..//img//btn003.png";
		
		panel.setLayout(null);
		lblNewLabel.setIcon(new ImageIcon(imgPath));
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 100, 90, 30);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//btn004.png";		
		lblNewLabel_1.setIcon(new ImageIcon(imgPath));
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		JTextField id = new JTextField();
		id.setBounds(119, 70, 207, 23);
		id.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 12));
		panel.add(id);
		id.setColumns(10);
		
		JPasswordField pw = new JPasswordField();
		pw.setBounds(119, 103, 207, 23);
		pw.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 12));
		panel.add(pw);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setBounds(0, 10, 350, 45);
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(184, 140, 90, 30);
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MMJoin join = new MMJoin();
			}
		});
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//btn002.png";		
		lblNewLabel_4.setIcon(new ImageIcon(imgPath));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(77, 140, 90, 30);
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String infoId = id.getText();
				String infoPw = pw.getText();
				Member m = new Member(infoId, infoPw);
				Member loginUser = service.memberLogin(m);
				if(loginUser==null) {
					JOptionPane.showMessageDialog(frame,
						    "·Î±×ÀÎ ½ÇÆÐ");
				}else {
					JOptionPane.showMessageDialog(frame,
						    "·Î±×ÀÎ ¼º°ø");
					MMMain main = new MMMain(loginUser);
					frame.dispose();
				}
				
			}
		});
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//btn001.png";		
		lblNewLabel_6.setIcon(new ImageIcon(imgPath));
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_3 = new JLabel("");
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//0004.jpg";		
		lblNewLabel_3.setIcon(new ImageIcon(imgPath));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 0, 1280, 871);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
