package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.MemberManagementService;
import model.Book;
import model.Member;

public class B extends JPanel {	// 도서명부
	private JTextField textField;
	private JScrollPane scrollPane;
	private MemberManagementService service = new MemberManagementService();
	private JTable table;
	/**
	 * Create the panel.
	 */
	public B() {
		setBackground(new Color(229, 222, 211));
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 100, 1014, 490);
		add(scrollPane);		
		
		
		
		String[] columnNames = { "제목", "ISBN", "작가","출판사","대출일","회수일" };

		ArrayList<Book> list = service.bookLookup();

		Object[][] data = new Object[list.size()][6];

		for (int i = 0; i < list.size(); i++) {
			Book b = list.get(i);
			data[i] = new Object[] { b.getTitle(), b.getIsbn(), b.getAuthor(),
					                 b.getPublisher(), b.getLoanDate(),b.getReturnDate()};
		}
		table = new JTable(data,columnNames);
		scrollPane.setViewportView(table);
		
		String CBmenu_1[]= {"제목","ISBN","작가","출판사"};
		// 콤보박스 (메뉴)
		JComboBox comboBox = new JComboBox(CBmenu_1);


		comboBox.setBounds(200, 38, 170, 29);
		add(comboBox);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(382, 38, 315, 29);
		add(textField);
		
		JButton button_1 = new JButton("\uAC80\uC0C9");
		button_1.setBounds(709, 38, 136, 29);
		add(button_1);
		
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
