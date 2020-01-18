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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
<<<<<<< HEAD
import javax.swing.table.TableModel;
=======
>>>>>>> branch 'master' of https://github.com/fruitfuls2/JavaProj.git

import controller.MemberManagementService;
import model.Book;
import model.Member;
import oracle.net.aso.p;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class B extends JPanel { // �������
	private JTextField textField;
	private JScrollPane scrollPane;
	private MemberManagementService service = new MemberManagementService();
	private JTable table;
	private DefaultTableModel defaultTableModel = new DefaultTableModel();

<<<<<<< HEAD
	/**
=======
	/** 
>>>>>>> branch 'master' of https://github.com/fruitfuls2/JavaProj.git
	 * Create the panel.
	 */
	public B(Member loginUser) {
		setBackground(new Color(229, 222, 211));
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 100, 1014, 490);
		add(scrollPane);

<<<<<<< HEAD
		String[] columnNames = { "����", "�۰�", "ISBN", "���ǻ�", "�帣" };
=======
		String[] columnNames = { "����", "ISBN", "�۰�", "���ǻ�", "�帣" };
>>>>>>> branch 'master' of https://github.com/fruitfuls2/JavaProj.git

<<<<<<< HEAD
		ArrayList<Book> list = service.bookLookup(loginUser.getId());
=======
		ArrayList<Book> list = service.mainLookup(); // ���� ���� ��ü���� 3
>>>>>>> branch 'master' of https://github.com/fruitfuls2/JavaProj.git

		Object[][] data = new Object[list.size()][5];

		for (int i = 0; i < list.size(); i++) {
			Book b = list.get(i);
<<<<<<< HEAD
			data[i] = new Object[] { b.getTitle(), b.getAuthor(), b.getIsbn(), b.getPublisher(), b.getGenre() };
=======
			data[i] = new Object[] { b.getTitle(), b.getIsbn(), b.getAuthor(), b.getPublisher(), b.getGenre() };
>>>>>>> branch 'master' of https://github.com/fruitfuls2/JavaProj.git
		}
<<<<<<< HEAD
		table = new JTable(data, columnNames);
=======
		
		defaultTableModel.setDataVector(data, columnNames);
		table = new JTable(defaultTableModel);
>>>>>>> branch 'master' of https://github.com/fruitfuls2/JavaProj.git
		scrollPane.setViewportView(table);

<<<<<<< HEAD
		defaultTableModel.setDataVector(data, columnNames); // �����͸� �������� ���� ����.
		table = new JTable(defaultTableModel); // �����͸� ���� ���� ����.
		scrollPane.setViewportView(table); // ȭ�鿡 ������ ������

		String CBmenu_1[] = { " ", "����", "�۰�", "���ǻ�" };
=======
		JButton button = new JButton("\uCD08\uAE30\uD654"); // �ʱ�ȭ ��ư
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

		String CBmenu_1[] = { "", "����", "ISBN", "�۰�", "���ǻ�" };
>>>>>>> branch 'master' of https://github.com/fruitfuls2/JavaProj.git
		// �޺��ڽ� (�޴�)
		JComboBox comboBox = new JComboBox(CBmenu_1);

		comboBox.setBounds(200, 38, 170, 29);
		add(comboBox);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(382, 38, 315, 29);
		add(textField);

		JButton button_1 = new JButton("\uAC80\uC0C9");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int j = comboBox.getSelectedIndex();
				if (j == 1) {
					ArrayList<Book> list = service.findTitle(textField.getText());
					
					Object[][] data = new Object[list.size()][5];

					for (int i = 0; i < list.size(); i++) {
						Book b = list.get(i);
						data[i] = new Object[] { b.getTitle(), b.getAuthor(), b.getIsbn(), b.getPublisher(), b.getGenre() };
					}

					defaultTableModel.setDataVector(data, columnNames);
				}else if (j == 2) {
                    ArrayList<Book> list = service.findAuthor(textField.getText());
					
					Object[][] data = new Object[list.size()][5];

					for (int i = 0; i < list.size(); i++) {
						Book b = list.get(i);
						data[i] = new Object[] { b.getTitle(), b.getAuthor(), b.getIsbn(), b.getPublisher(), b.getGenre() };
					}

					defaultTableModel.setDataVector(data, columnNames);
					
				}else if (j == 3) {
                    ArrayList<Book> list = service.findPublisher(textField.getText());
					
					Object[][] data = new Object[list.size()][5];

					for (int i = 0; i < list.size(); i++) {
						Book b = list.get(i);
						data[i] = new Object[] { b.getTitle(), b.getAuthor(), b.getIsbn(), b.getPublisher(), b.getGenre() };
					}

					defaultTableModel.setDataVector(data, columnNames);
					
				}
				
			}
		});
		button_1.setBounds(709, 38, 136, 29);
		add(button_1);

		JButton button_2 = new JButton("\uCD94\uAC00");
		button_2.setBounds(57, 124, 97, 23);
		add(button_2);

		JButton button_3 = new JButton("\uC218\uC815");
		button_3.addMouseListener(new MouseAdapter() { // ����
			@Override
			public void mouseClicked(MouseEvent e) {
				 int row = table.getSelectedRow();
					if(row < 0) {
						JOptionPane.showMessageDialog(table,
							    "���� �� å�� �������ּ���.");
					}
					TableModel data = table.getModel();
					System.out.println(row);
					
					String title = (String) data.getValueAt(row, 0);
					String author = (String) data.getValueAt(row, 1);
					Long isbn = (long) data.getValueAt(row, 2);
					String publisher = (String) data.getValueAt(row, 3);
					String genre = (String) data.getValueAt(row, 4);

					Book selectBook = new Book(title, author, isbn, publisher, genre);

					BookUpdate frame = new BookUpdate(selectBook);
			}
		});
		button_3.setBounds(57, 157, 97, 23);
		add(button_3);

		JButton btnNewButton = new JButton("\uC0AD\uC81C");
		btnNewButton.setBounds(57, 190, 97, 23);
		add(btnNewButton);

		JButton button = new JButton("\uCD08\uAE30\uD654");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //�ʱ�ȭ
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Book> list = service.bookLookup(loginUser.getId());

				Object[][] data = new Object[list.size()][5];

				for (int i = 0; i < list.size(); i++) {
					Book b = list.get(i);
					data[i] = new Object[] { b.getTitle(), b.getAuthor(), b.getIsbn(), b.getPublisher(), b.getGenre() };
				}

				defaultTableModel.setDataVector(data, columnNames);
			}
		});
		button.setBounds(57, 223, 97, 23);
		add(button);

	}
}
