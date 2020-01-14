package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class A extends JPanel {	// 회원정보
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public A() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 100, 1028, 490);
		add(scrollPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(200, 38, 170, 29);
		add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(382, 38, 315, 29);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.setBounds(709, 38, 136, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC218\uC815");
		btnNewButton_1.setBounds(57, 124, 97, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uC0AD\uC81C");
		btnNewButton_2.setBounds(57, 157, 97, 23);
		add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("\uC774\uBCF4\uB78C");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(36, 32, 57, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uB2D8 \uD658\uC601\uD569\uB2C8\uB2E4.");
		lblNewLabel_1.setBounds(91, 32, 90, 15);
		add(lblNewLabel_1);
		
		JButton btnNewButton_4 = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnNewButton_4.setBounds(57, 57, 97, 23);
		add(btnNewButton_4);

	}
}
