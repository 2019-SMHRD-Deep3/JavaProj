package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.MemberManagementService;
import model.Book;
import model.BookDAO;

public class C extends JPanel { // 연체관리
	private JTextField textField;
	private MemberManagementService service = new MemberManagementService();
	private JTable table;
	private Book b;
	private BookDAO bdao;
	private DefaultTableModel defaultTableModel = new DefaultTableModel();

	public C() {
		setBackground(Color.WHITE);
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 100, 1014, 490);
		add(scrollPane);

		String[] columnNames = { "제목", "작가", "대출일", "반납예정일", "연체여부", "ISBN" };
		ArrayList<Book> list = service.CLookup();

		Object[][] data = new Object[list.size()][6];
		for (int i = 0; i < list.size(); i++) {
			b = list.get(i);
			data[i] = new Object[] { b.getTitle(), b.getAuthor(), b.getLoanDate(), b.getReturnDate(), b.getIsOverdue(),
					b.getIsbn() };
		}
		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);

		defaultTableModel.setDataVector(data, columnNames);
		table = new JTable(defaultTableModel);
		scrollPane.setViewportView(table);

		String[] combo = { "", "제목", "작가" };
		DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(combo);
		JComboBox comboBox = new JComboBox(comboModel);
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
						data[i] = new Object[] { b.getTitle(), b.getAuthor(), b.getIsbn(), b.getPublisher(),
								b.getGenre() };
					}

					defaultTableModel.setDataVector(data, columnNames);
				} else if (j == 2) {
					ArrayList<Book> list = service.findAuthor(textField.getText());

					Object[][] data = new Object[list.size()][5];

					for (int i = 0; i < list.size(); i++) {
						Book b = list.get(i);
						data[i] = new Object[] { b.getTitle(), b.getAuthor(), b.getIsbn(), b.getPublisher(),
								b.getGenre() };
					}

					defaultTableModel.setDataVector(data, columnNames);

				}

			}

		});
		button_1.setBounds(709, 38, 136, 29);

		add(button_1);

		JButton button_2 = new JButton("\uB300\uCD9C\uD558\uAE30");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(table, "대출할 책을 선택해주세요.");
				}
				TableModel data = table.getModel();

				String title = (String) data.getValueAt(row, 0);
				long isbn = (long) data.getValueAt(row, 5);
				String author = (String) data.getValueAt(row, 1);
				Date loanDate = (Date) data.getValueAt(row, 2);

				if (loanDate == null) {

					Book selectBook = new Book(title, author, isbn);
					BookLoan frame = new BookLoan(selectBook);

				} else {
					JOptionPane.showMessageDialog(table, "이미 대여된 책입니다.");
				}

				try {
					OutputStream output = new FileOutputStream("D:\\BookIsbn.txt");
					String str = String.valueOf(isbn);
					byte[] by = str.getBytes();
					output.write(by);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

			}

		});
		button_2.setBounds(30, 124, 124, 23);

		add(button_2);

		JButton button_3 = new JButton("\uBC18\uB0A9\uD558\uAE30");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(table, "반납할 책을 선택해주세요.");
				}
				TableModel data = table.getModel();

				String title = (String) data.getValueAt(row, 0);
				String author = (String) data.getValueAt(row, 1);
				Date loanDate = (Date) data.getValueAt(row, 2);
				Date returnDate = (Date) data.getValueAt(row, 3);
				String isOverdue = (String) data.getValueAt(row, 4);
				long isbn = (long) data.getValueAt(row, 5);

				Book selectBook = new Book(loanDate, returnDate, isOverdue, isbn);

				try {
					OutputStream output = new FileOutputStream("D:\\returnIsbn.txt");
					String str = String.valueOf(isbn);
					byte[] by = str.getBytes();
					output.write(by);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				service.cReturn(selectBook);

				if (selectBook != null) {
					JOptionPane.showMessageDialog(table, "반납 성공");
					
				}
			}
		});
		button_3.setBounds(30, 190, 124, 23);
		add(button_3);

		JButton btnNewButton = new JButton("\uC5F0\uCCB4\uB3C4\uC11C \uBCF4\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(166, 96, 659, 490);
				add(scrollPane);

				String[] columnNames = { "제목", "작가", "대출일", "반납예정일", "연체여부" };
				ArrayList<Book> list = service.ccLookup();
				int cnt = 0;

				for (int i = 0; i < list.size(); i++) {
					b = list.get(i);
					if ("y".equals(b.getIsOverdue())) {
						cnt++;
						;
					}
				}
				int j = 0;
				Object[][] data = new Object[cnt][5];
				for (int i = 0; i < list.size(); i++) {
					b = list.get(i);
					if ("y".equals(b.getIsOverdue())) {
						data[j] = new Object[] { b.getTitle(), b.getAuthor(), b.getLoanDate(), b.getReturnDate(),
								b.getIsOverdue() };
						j++;
					}
				}
				defaultTableModel.setDataVector(data, columnNames);
			}
		});
		btnNewButton.setBounds(30, 223, 124, 23);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uAE30\uAC04 \uC5F0\uC7A5");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				if (row == -1) {
					JOptionPane.showMessageDialog(table, "연장할 책을 선택해주세요.");
				}
				TableModel data = table.getModel();

				String title = (String) data.getValueAt(row, 0);
				String author = (String) data.getValueAt(row, 1);
				Date loanDate = (Date) data.getValueAt(row, 2);
				Date returnDate = (Date) data.getValueAt(row, 3);
				String isOverdue = (String) data.getValueAt(row, 4);
				long isbn = (long) data.getValueAt(row, 5);

				Book selectBook = new Book(loanDate, returnDate, isOverdue, isbn);

				try {
					OutputStream output = new FileOutputStream("D:\\extensionIsbn.txt");
					String str = String.valueOf(isbn);
					byte[] by = str.getBytes();
					output.write(by);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				service.cExtension(selectBook);
			}
		});
		btnNewButton_1.setBounds(30, 256, 124, 23);
		add(btnNewButton_1);

		JButton button = new JButton("\uCD08\uAE30\uD654");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object[][] data = new Object[list.size()][6];
				for (int i = 0; i < list.size(); i++) {
					b = list.get(i);
					data[i] = new Object[] { b.getTitle(), b.getAuthor(), b.getLoanDate(), b.getReturnDate(),
							b.getIsOverdue(), b.getIsbn() };
				}
				table = new JTable(data, columnNames);
				scrollPane.setViewportView(table);

				defaultTableModel.setDataVector(data, columnNames);
				table = new JTable(defaultTableModel);
				scrollPane.setViewportView(table);
			}
		});
		button.setBounds(30, 289, 124, 23);
		add(button);

		JButton btnNewButton_2 = new JButton("\uB300\uCD9C\uB3C4\uC11C \uBCF4\uAE30");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(166, 96, 659, 490);
				add(scrollPane);

				String[] columnNames = { "제목", "작가", "대출일", "반납예정일", "연체여부" };
				ArrayList<Book> list = service.ccLookup();
				int cnt = 0;

				for (int i = 0; i < list.size(); i++) {
					b = list.get(i);
					if (b.getLoanDate() != null) {
						cnt++;
					}
				}
				int j = 0;
				Object[][] data = new Object[cnt][5];
				for (int i = 0; i < list.size(); i++) {
					b = list.get(i);
					if (b.getLoanDate() != null) {
						data[j] = new Object[] { b.getTitle(), b.getAuthor(), b.getLoanDate(), b.getReturnDate(),
								b.getIsOverdue() };
						j++;
					}
				}

				defaultTableModel.setDataVector(data, columnNames);
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(30, 157, 124, 23);
		add(btnNewButton_2);

	}
}