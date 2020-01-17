package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.MemberManagementService;
import model.Book;
import model.Member;

public class B extends JPanel { // 도서명부
	private JTextField textField;
	private JScrollPane scrollPane;
	private MemberManagementService service = new MemberManagementService();
	private JTable table;
	private DefaultTableModel defaultTableModel = new DefaultTableModel();

	/** 
	 * Create the panel.
	 */
	public B() {
		setBackground(new Color(229, 222, 211));
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 100, 1014, 490);
		add(scrollPane);

		String[] columnNames = { "제목", "ISBN", "작가", "출판사", "장르" };

		ArrayList<Book> list = service.mainLookup(); // 도서 메인 전체보기 3

		Object[][] data = new Object[list.size()][5];

		for (int i = 0; i < list.size(); i++) {
			Book b = list.get(i);
			data[i] = new Object[] { b.getTitle(), b.getIsbn(), b.getAuthor(), b.getPublisher(), b.getGenre() };
		}
		
		defaultTableModel.setDataVector(data, columnNames);
		table = new JTable(defaultTableModel);
		scrollPane.setViewportView(table);

		JButton button = new JButton("\uCD08\uAE30\uD654"); // 초기화 버튼
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Book> list = service.mainLookup();

				Object[][] data = new Object[list.size()][5];

				for (int i = 0; i < list.size(); i++) {
					Book b = list.get(i);
					data[i] = new Object[] { b.getTitle(), b.getIsbn(), b.getAuthor(), b.getPublisher(), b.getGenre() };
				}

				defaultTableModel.setDataVector(data, columnNames);
			}
		});

		button.setBounds(57, 190, 97, 23);
		add(button);

		String CBmenu_1[] = { "", "제목", "ISBN", "작가", "출판사" };
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
