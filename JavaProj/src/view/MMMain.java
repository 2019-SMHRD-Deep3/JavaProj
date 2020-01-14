package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.MemberManagementService;
import model.Member;

public class MMMain {
	private MemberManagementService service = new MemberManagementService();
	private JFrame frame;
	private Member loginUser;

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
		frame.setBounds(100, 100, 1024, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	}
}
