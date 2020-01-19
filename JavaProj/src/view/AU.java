package view;

import javax.swing.JPanel;

import controller.MemberManagementService;
import model.Member;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AU extends JPanel {	// »∏ø¯¡§∫∏ ¡ﬂ ¿⁄Ω≈¿« µ•¿Ã≈Õ »Æ¿Œ∏∏ ∞°¥… (æ∆¿Ãµ, ∆–Ω∫øˆµÂ, ¿Ã∏ß, ¡÷πŒπ¯»£, ¡÷º“, ø¨∂Ù√≥)
	
	private MemberManagementService service = new MemberManagementService();
	private Member loginUser;
	/**
	 * Create the panel.
	 */
	public AU(Member loginUser) {
		this.loginUser = loginUser;
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 15));
		lblId.setBounds(75, 75, 100, 31);
		add(lblId);
		
		JLabel id = new JLabel("");
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 15));
		id.setBounds(175, 75, 200, 31);
		add(id);
		id.setText(loginUser.getId());
		
		JLabel lblPw = new JLabel("\uC804\uD654\uBC88\uD638");
		lblPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblPw.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 15));
		lblPw.setBounds(75, 125, 100, 31);
		add(lblPw);
		
		JLabel pw = new JLabel("");
		pw.setHorizontalAlignment(SwingConstants.CENTER);
		pw.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 15));
		pw.setBounds(175, 125, 200, 31);
		add(pw);
		pw.setText(loginUser.getPw());
		
		JLabel label_4 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 15));
		label_4.setBounds(75, 175, 100, 31);
		add(label_4);
		
		JLabel name = new JLabel("");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 15));
		name.setBounds(175, 175, 200, 31);
		add(name);
		name.setText(loginUser.getName());
		
		JLabel label_6 = new JLabel("\uC774\uB984");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 15));
		label_6.setBounds(75, 225, 100, 31);
		add(label_6);
		
		JLabel socialNumber = new JLabel("");
		socialNumber.setHorizontalAlignment(SwingConstants.CENTER);
		socialNumber.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 15));
		socialNumber.setBounds(175, 225, 200, 31);
		add(socialNumber);
		socialNumber.setText(loginUser.getSocialNumber());
		
		JLabel label_8 = new JLabel("\uC8FC\uC18C");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 15));
		label_8.setBounds(75, 278, 100, 31);
		add(label_8);
		
		JLabel phoneNumber = new JLabel("");
		phoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		phoneNumber.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 15));
		phoneNumber.setBounds(175, 278, 200, 31);
		add(phoneNumber);
		phoneNumber.setText(loginUser.getPhone());
		
		JLabel label_10 = new JLabel("\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 15));
		label_10.setBounds(75, 328, 100, 31);
		add(label_10);
		
		JLabel address = new JLabel("");
		address.setHorizontalAlignment(SwingConstants.CENTER);
		address.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 15));
		address.setBounds(175, 328, 200, 31);
		add(address);
		address.setText(loginUser.getAddress());

	}

}
