package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class B extends JPanel {	// ��������
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public B() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(200, 38, 170, 29);
		add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(382, 38, 315, 29);
		add(textField);
		
		JButton button_1 = new JButton("\uAC80\uC0C9");
		button_1.setBounds(709, 38, 136, 29);
		add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 100, 1028, 490);
		add(scrollPane);
		
		JButton button_2 = new JButton("\uCD94\uAC00");
		button_2.setBounds(57, 124, 97, 23);
		add(button_2);
		
		JButton button_3 = new JButton("\uC218\uC815");
		button_3.setBounds(57, 157, 97, 23);
		add(button_3);
		
		JButton btnNewButton = new JButton("\uC0AD\uC81C");
		btnNewButton.setBounds(57, 190, 97, 23);
		add(btnNewButton);

	}

}
