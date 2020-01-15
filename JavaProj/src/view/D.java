package view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import controller.MemberManagementService;
import model.Book;
import model.Member;
import java.awt.Font;

public class D extends JPanel {	// ÀÌ´ÞÀÇ ÃßÃµµµ¼­ È¤Àº Åë°è
	private MemberManagementService service = new MemberManagementService();
	private Member loginUser;
	/**
	 * Create the panel.
	 */
	public D() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		String[] combo = {"(¼±ÅÃÇÒ ¿¬µµ ¹× ¿ù)", "2020³â 1¿ù", "2020³â 2¿ù"};
		DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(combo);
	    JComboBox comboBox = new JComboBox(comboModel);
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		comboBox.setBounds(97, 36, 200, 31);
		add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(150, 125, 300, 400);
		add(panel);
		
		JLabel lblNewLabel = new JLabel("\uB3C4\uC11C\uBA85");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(500, 150, 100, 31);
		add(lblNewLabel);
		
		JLabel label = new JLabel("\uC800  \uC790");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label.setBounds(500, 200, 100, 31);
		add(label);
		
		JLabel label_1 = new JLabel("\uCD9C\uD310\uC0AC");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_1.setBounds(500, 250, 100, 31);
		add(label_1);
		
		JLabel label_2 = new JLabel("\uC7A5  \uB974");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_2.setBounds(500, 300, 100, 31);
		add(label_2);
		
		JLabel label_3 = new JLabel("ISBN");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_3.setBounds(500, 350, 100, 31);
		add(label_3);
		
		JLabel bookTitle = new JLabel("");
		bookTitle.setHorizontalAlignment(SwingConstants.CENTER);
		bookTitle.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		bookTitle.setBounds(600, 150, 200, 31);
//		panel.getContentPane().add(name);
//		name.setText(loginUser.getName());
		add(bookTitle);
		
		JLabel bookAuthor = new JLabel("");
		bookAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		bookAuthor.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		bookAuthor.setBounds(600, 200, 200, 31);
		add(bookAuthor);
		
		JLabel bookPublisher = new JLabel("");
		bookPublisher.setHorizontalAlignment(SwingConstants.CENTER);
		bookPublisher.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		bookPublisher.setBounds(600, 250, 200, 31);
		add(bookPublisher);
		
		JLabel bookGenre = new JLabel("");
		bookGenre.setHorizontalAlignment(SwingConstants.CENTER);
		bookGenre.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		bookGenre.setBounds(600, 300, 200, 31);
		add(bookGenre);
		
		JLabel bookIsbn = new JLabel("");
		bookIsbn.setHorizontalAlignment(SwingConstants.CENTER);
		bookIsbn.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		bookIsbn.setBounds(600, 350, 200, 31);
		add(bookIsbn);
		
		String[] columnNames = { "Ã¥ÀÌ¸§", "ÀúÀÚ", "ÃâÆÇ»ç", "ISBN" };

		ArrayList<Book> list = service.bookLookup();

		Object[][] data = new Object[list.size()][3];

		for (int i = 0; i < list.size(); i++) {
			Book b = list.get(i);
			data[i] = new Object[] { b.getTitle(), b.getAuthor(), b.getPublisher(), b.getIsbn() };
		}

	}
}
