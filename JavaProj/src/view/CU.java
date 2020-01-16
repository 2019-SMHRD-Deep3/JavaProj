package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class CU extends JPanel {	// ¿⁄Ω≈¿« ø¨√º ¥Î√‚ ¡§∫∏∏∏ ∫∏∞Ì, 1»∏ √ﬂ∞° ø¨¿Â(+2¡÷) ∞°¥…

	/**
	 * Create the panel.
	 */
	public CU() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel label = new JLabel("\uB3C4\uC11C\uBA85");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 15));
		label.setBounds(75, 75, 100, 31);
		add(label);
		
		JLabel label_1 = new JLabel("\uC800\uC790");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 15));
		label_1.setBounds(75, 125, 100, 31);
		add(label_1);
		
		JLabel label_2 = new JLabel("\uCD9C\uD310\uC0AC");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 15));
		label_2.setBounds(75, 175, 100, 31);
		add(label_2);
		
		JLabel label_3 = new JLabel("\uB300\uCD9C\uAE30\uD55C");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 15));
		label_3.setBounds(75, 225, 100, 31);
		add(label_3);
		
		JLabel loan = new JLabel("");
		loan.setHorizontalAlignment(SwingConstants.CENTER);
		loan.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 15));
		loan.setBounds(175, 225, 200, 31);
		add(loan);
		
		JLabel b_publisher = new JLabel("");
		b_publisher.setHorizontalAlignment(SwingConstants.CENTER);
		b_publisher.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 15));
		b_publisher.setBounds(175, 175, 200, 31);
		add(b_publisher);
		
		JLabel b_author = new JLabel("");
		b_author.setHorizontalAlignment(SwingConstants.CENTER);
		b_author.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 15));
		b_author.setBounds(175, 125, 200, 31);
		add(b_author);
		
		JLabel b_title = new JLabel("");
		b_title.setHorizontalAlignment(SwingConstants.CENTER);
		b_title.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 15));
		b_title.setBounds(175, 75, 200, 31);
		add(b_title);

	}

}
