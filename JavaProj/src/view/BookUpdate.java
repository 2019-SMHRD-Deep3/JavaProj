package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import controller.MemberManagementService;
import model.Book;
import model.Member;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class BookUpdate {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private MemberManagementService service = new MemberManagementService();
	private Book selectBook;
	private JButton button;

	public BookUpdate(Book selectBook) {
		this.selectBook = selectBook;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("\uB3C4\uC11C \uC218\uC815");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label.setBounds(12, 10, 420, 21);
		frame.getContentPane().add(label);

		JLabel lblIsbn = new JLabel("\uC81C\uBAA9");
		lblIsbn.setHorizontalAlignment(SwingConstants.CENTER);
		lblIsbn.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		lblIsbn.setBounds(22, 53, 113, 21);
		frame.getContentPane().add(lblIsbn);

		textField = new JTextField(selectBook.getTitle());
		textField.setColumns(10);
		textField.setBounds(137, 53, 270, 21);
		frame.getContentPane().add(textField);

		JLabel lblIsbn_1 = new JLabel("\uC791\uAC00");
		lblIsbn_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblIsbn_1.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		lblIsbn_1.setBounds(22, 84, 113, 21);
		frame.getContentPane().add(lblIsbn_1);

		textField_1 = new JTextField(selectBook.getAuthor());
		textField_1.setColumns(10);
		textField_1.setBounds(137, 84, 270, 21);
		frame.getContentPane().add(textField_1);

		JLabel lblIsbn_2 = new JLabel("ISBN");
		lblIsbn_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblIsbn_2.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		lblIsbn_2.setBounds(22, 113, 113, 21);
		frame.getContentPane().add(lblIsbn_2);

		textField_2 = new JTextField(Long.toString(selectBook.getIsbn()));
		textField_2.setColumns(10);
		textField_2.setBounds(137, 115, 270, 21);
		frame.getContentPane().add(textField_2);

		JLabel label_4 = new JLabel("\uCD9C\uD310\uC0AC");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_4.setBounds(22, 146, 113, 21);
		frame.getContentPane().add(label_4);

		textField_3 = new JTextField(selectBook.getPublisher());
		textField_3.setColumns(10);
		textField_3.setBounds(137, 146, 270, 21);
		frame.getContentPane().add(textField_3);

		textField_4 = new JTextField(selectBook.getGenre());
		textField_4.setColumns(10);
		textField_4.setBounds(137, 177, 270, 21);
		frame.getContentPane().add(textField_4);

		JLabel label_1 = new JLabel("\uC7A5\uB974");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_1.setBounds(22, 175, 113, 21);
		frame.getContentPane().add(label_1);

		button = new JButton("\uC218\uC815");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String title = textField.getText();
				String author = textField_1.getText();
				long isbn = Long.parseLong(textField_2.getText());
				String publisher = textField_3.getText();
				String genre = textField_4.getText();

				Book book = new Book(title, author, isbn, publisher, genre);
				boolean result = service.editBook(book);
				if (result) {
					JOptionPane.showMessageDialog(frame, "¼öÁ¤ ¼º°ø");
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(frame, "¼öÁ¤ ½ÇÆÐ");
				}
			}
		});
		button.setBounds(137, 226, 97, 23);
		frame.getContentPane().add(button);

		JButton button_1 = new JButton("\uCDE8\uC18C");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		button_1.setBounds(252, 226, 97, 23);
		frame.getContentPane().add(button_1);

	}

}
