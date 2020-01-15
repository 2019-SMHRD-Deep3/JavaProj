package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class D extends JPanel {	// 이달의 추천도서 혹은 통계

	/**
	 * Create the panel.
	 */
	public D() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		String[] combo = {"2020년 1월", "2020년 2월", "2020년 3월"};
		DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(combo);
	    JComboBox comboBox = new JComboBox(comboModel);
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		comboBox.setBounds(323, 10, 200, 31);
		add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(323, 51, 905, 539);
		add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 51, 299, 379);
		add(panel);
		
		JLabel lblNewLabel = new JLabel("\uB3C4\uC11C\uBA85");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 440, 57, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC800\uC790");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 465, 57, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uCD9C\uD310\uC0AC");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 490, 57, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uD55C\uC904\uD3C9");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(12, 515, 57, 15);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(77, 440, 234, 15);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(77, 465, 234, 15);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(77, 490, 234, 15);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(77, 515, 234, 15);
		add(lblNewLabel_7);

	}
}
