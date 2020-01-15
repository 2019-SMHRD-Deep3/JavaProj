package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class DFirst extends JPanel {

	/**
	 * Create the panel.
	 */
	public DFirst() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(142, 125, 342, 365);
		add(panel);
		
		JLabel label = new JLabel("\uB3C4\uC11C\uBA85");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label.setBounds(496, 161, 100, 31);
		add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_1.setBounds(608, 161, 200, 31);
		add(label_1);
		
		JLabel label_2 = new JLabel("\uC800  \uC790");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_2.setBounds(496, 202, 100, 31);
		add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_3.setBounds(608, 202, 200, 31);
		add(label_3);
		
		JLabel label_4 = new JLabel("\uCD9C\uD310\uC0AC");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_4.setBounds(496, 243, 100, 31);
		add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_5.setBounds(608, 243, 200, 31);
		add(label_5);
		
		JLabel label_6 = new JLabel("\uC7A5  \uB974");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_6.setBounds(496, 284, 100, 31);
		add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_7.setBounds(608, 284, 200, 31);
		add(label_7);
		
		JLabel label_8 = new JLabel("ISBN");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_8.setBounds(496, 325, 100, 31);
		add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_9.setBounds(608, 325, 200, 31);
		add(label_9);

	}

}
