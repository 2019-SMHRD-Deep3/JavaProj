package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class BU extends JPanel {
	private JTextField textField;	// 도서 목록 검색만 가능(추가, 삭제, 수정 등 불가)

	/**
	 * Create the panel.
	 */
	public BU() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 100, 1014, 490);
		add(scrollPane);
		
		JComboBox comboBox = new JComboBox(new Object[]{});
		comboBox.setBounds(200, 38, 170, 29);
		add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(382, 38, 315, 29);
		add(textField);
		
		JButton button = new JButton("\uAC80\uC0C9");
		button.setBounds(709, 38, 136, 29);
		add(button);

	}
}
