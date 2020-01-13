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
		frame.setBounds(100, 100, 1024, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menu);
		panel.setBounds(354, 411, 350, 200);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(50, 90, 57, 15);
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PW");
		lblNewLabel_1.setBounds(50, 115, 57, 15);
		lblNewLabel_1.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		JTextField id = new JTextField();
		id.setBounds(119, 87, 175, 21);
		id.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 12));
		panel.add(id);
		id.setColumns(10);
		
		JPasswordField pw = new JPasswordField();
		pw.setBounds(119, 112, 175, 21);
		pw.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 12));
		panel.add(pw);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setBounds(50, 30, 244, 29);
		lblNewLabel_2.setFont(UIManager.getFont("CheckBoxMenuItem.font"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String infoId = id.getText();
				String infoPw = pw.getText();
				// Member °´Ã¼»ý¼º
				Member m = new Member(infoId, infoPw);
				// ·Î±×ÀÎ
				Member loginUser = service.memberLogin(m);
				if(loginUser==null) {
					JOptionPane.showMessageDialog(frame,
						    "·Î±×ÀÎ ½ÇÆÐ");
				}else {
					JOptionPane.showMessageDialog(frame,
						    "·Î±×ÀÎ ¼º°ø");
//					MMMain main = new MMMain(loginUser);
					frame.dispose();
				}
			}
		});
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.setBounds(77, 154, 97, 23);
		panel.add(btnNewButton);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MMJoin join = new MMJoin();
				
			}
		});
		btnSignUp.setBackground(SystemColor.controlHighlight);
		btnSignUp.setBounds(184, 154, 97, 23);
		panel.add(btnSignUp);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1018, 691);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(SystemColor.controlHighlight);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		String imgPath = this.getClass().getResource(".").getPath() + "..//..//img//0004.jpg";
		System.out.println(imgPath);
		lblNewLabel_3.setIcon(new ImageIcon(imgPath));
		lblNewLabel_3.setBounds(0, 0, 1024, 720);
		panel_1.add(lblNewLabel_3);
	}
}
