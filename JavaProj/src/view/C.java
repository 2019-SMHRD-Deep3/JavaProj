package view;

import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.MemberManagementService;
import model.Book;

public class C extends JPanel { // 연체관리
	private JTextField textField;
	private MemberManagementService service = new MemberManagementService();
	private JTable table;
	private Book b;

	/**
	 * Create the panel.
	 */
	public C() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		String[] combo = { "ISBN", "제목", "작가", "대출", "연체", "회원이름", "ID" };
		DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(combo);
		JComboBox comboBox = new JComboBox(comboModel);
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
		scrollPane.setBounds(166, 96, 659, 490);
		add(scrollPane);

		String[] columnNames = { "제목", "작가", "대출일", "반납예정일", "연체여부" };
		ArrayList<Book> list = service.bookLookup();

		Object[][] data = new Object[list.size()][5];
		for (int i = 0; i < list.size(); i++) {
			b = list.get(i);
			data[i] = new Object[] { b.getTitle(), b.getAuthor(), b.getLoanDate(), b.getReturnDate(),
					b.getIsOverdue() };
		}
		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);

		JButton button_2 = new JButton("\uB300\uCD9C");
		button_2.setBounds(57, 124, 97, 23);
		add(button_2);

		JButton button_3 = new JButton("\uBC18\uB0A9");
		button_3.setBounds(57, 157, 97, 23);
		add(button_3);

		JButton btnNewButton = new JButton("\uC5F0\uCCB4");
		btnNewButton.setBounds(57, 190, 97, 23);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uC5F0\uC7A5");
		btnNewButton_1.setBounds(57, 223, 97, 23);
		add(btnNewButton_1);

	}

}
