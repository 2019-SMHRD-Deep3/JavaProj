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
import java.nio.ByteBuffer;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import controller.MemberManagementService;
import model.Book;

public class C extends JPanel { // 연체관리
	private JTextField textField;
	private MemberManagementService service = new MemberManagementService();
	private JTable table;
	private Book b;

	public C() {
		setBackground(Color.WHITE);
		setLayout(null);

		String[] combo = { "제목", "작가" };
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

		String[] columnNames = { "제목", "작가", "ISBN" };
		ArrayList<Book> list = service.CLookup();

		Object[][] data = new Object[list.size()][3];
		for (int i = 0; i < list.size(); i++) {
			b = list.get(i);
			data[i] = new Object[] { b.getTitle(), b.getAuthor(), b.getIsbn() };
		}
		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);

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
				long isbn = (long) data.getValueAt(row, 2);
				String author = (String) data.getValueAt(row, 1);

				Book selectBook = new Book(title, author, isbn);

				BookLoan frame = new BookLoan(selectBook);

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
		button_2.setBounds(41, 124, 113, 23);

		add(button_2);

		JButton button_3 = new JButton("\uBC18\uB0A9\uD558\uAE30");
		button_3.setBounds(41, 190, 113, 23);
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
					if (b.getIsOverdue().equals("y")) {
						cnt++;
					}
				}
				int j = 0;
				Object[][] data = new Object[cnt][5];
				for (int i = 0; i < list.size(); i++) {
					b = list.get(i);
					if (b.getIsOverdue().equals("y")) {
						data[j] = new Object[] { b.getTitle(), b.getAuthor(), b.getLoanDate(), b.getReturnDate(),
								b.getIsOverdue() };
						j++;
					}
				}

				table = new JTable(data, columnNames);
				scrollPane.setViewportView(table);

			}
		});
		btnNewButton.setBounds(41, 223, 113, 23);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uAE30\uAC04 \uC5F0\uC7A5");
		btnNewButton_1.setBounds(41, 256, 113, 23);
		add(btnNewButton_1);

		JButton button = new JButton("\uCD08\uAE30\uD654");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Object[][] data = new Object[list.size()][3];
				for (int i = 0; i < list.size(); i++) {
					b = list.get(i);
					data[i] = new Object[] { b.getTitle(), b.getAuthor(), b.getIsbn() };
				}
				table = new JTable(data, columnNames);
				scrollPane.setViewportView(table);
			}
		});
		button.setBounds(41, 289, 113, 23);
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

				table = new JTable(data, columnNames);
				scrollPane.setViewportView(table);
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(41, 157, 113, 23);
		add(btnNewButton_2);

	}
}
