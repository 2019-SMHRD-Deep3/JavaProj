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
		frame.setBounds(100, 100, 1280, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(229, 222, 211));
		panel.setBounds(469, 536, 350, 200);
		frame.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lblNewLabel = new JLabel("");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -104, SpringLayout.SOUTH, panel);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		String imgPath = this.getClass().getResource(".").getPath() + "..//..//img//btn003.png";
		System.out.println(imgPath);
		lblNewLabel.setIcon(new ImageIcon(imgPath));
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 4, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//btn004.png";
		System.out.println(imgPath);
		lblNewLabel_1.setIcon(new ImageIcon(imgPath));
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		JTextField id = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, id);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -12, SpringLayout.WEST, id);
		sl_panel.putConstraint(SpringLayout.WEST, id, 119, SpringLayout.WEST, panel);
		id.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 12));
		panel.add(id);
		id.setColumns(10);
		
		JPasswordField pw = new JPasswordField();
		sl_panel.putConstraint(SpringLayout.SOUTH, id, -17, SpringLayout.NORTH, pw);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1, -12, SpringLayout.WEST, pw);
		sl_panel.putConstraint(SpringLayout.WEST, pw, 119, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, id, 0, SpringLayout.EAST, pw);
		sl_panel.putConstraint(SpringLayout.EAST, pw, -24, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, pw, 107, SpringLayout.NORTH, panel);
		pw.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 12));
		panel.add(pw);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		sl_panel.putConstraint(SpringLayout.NORTH, id, 12, SpringLayout.SOUTH, lblNewLabel_2);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 10, SpringLayout.NORTH, panel);
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//btn011.png";
		System.out.println(imgPath);
		lblNewLabel_2.setIcon(new ImageIcon(imgPath));
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 55, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_2, 350, SpringLayout.WEST, panel);
		lblNewLabel_2.setFont(UIManager.getFont("CheckBoxMenuItem.font"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		sl_panel.putConstraint(SpringLayout.SOUTH, pw, -10, SpringLayout.NORTH, lblNewLabel_4);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 140, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_4, 184, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, 189, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_4, 301, SpringLayout.WEST, panel);
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MMJoin join = new MMJoin();
			}
		});
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//btn002.png";
		System.out.println(imgPath);
		lblNewLabel_4.setIcon(new ImageIcon(imgPath));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -6, SpringLayout.NORTH, lblNewLabel_6);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 140, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_6, 77, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, 189, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_6, 172, SpringLayout.WEST, panel);
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
		System.out.println(imgPath);
		lblNewLabel_6.setIcon(new ImageIcon(imgPath));
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_3 = new JLabel("");
		imgPath = this.getClass().getResource(".").getPath() + "..//..//img//0004.jpg";
		System.out.println(imgPath);
		lblNewLabel_3.setIcon(new ImageIcon(imgPath));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 0, 1280, 871);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
