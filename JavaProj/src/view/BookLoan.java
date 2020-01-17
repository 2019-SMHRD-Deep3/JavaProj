package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.MemberManagementService;
import model.Book;
import model.BookDAO;
import model.Member;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookLoan {
	private JFrame frame;
	private JTextField textField_2;
	private JTextField textField_3;
	private MemberManagementService service = new MemberManagementService();
	private Book selectBook;
	private BookDAO bdao = new BookDAO();
	private JTextField MemberBook;
	private Member m;

	public BookLoan(Book selectBook) {
		this.selectBook = selectBook;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 482, 287);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uB3C4\uC11C \uB300\uCD9C");
		lblNewLabel.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 420, 21);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblWnth = new JLabel("ID");
		lblWnth.setHorizontalAlignment(SwingConstants.CENTER);
		lblWnth.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 19));
		lblWnth.setBounds(12, 68, 113, 27);
		frame.getContentPane().add(lblWnth);

		JTextField memberId = new JTextField();
		memberId.setColumns(10);
		memberId.setBounds(120, 69, 270, 32);
		frame.getContentPane().add(memberId);

		JButton btnNewButton = new JButton("\uB300\uCD9C");
		btnNewButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				String infoId = memberId.getText();
				Member m = new Member(infoId);

				Book b = bdao.updateLoan(selectBook);

				if (MemberBook != null) {
					JOptionPane.showMessageDialog(frame, "¥Î√‚ Ω«∆–");
				} else {
					JOptionPane.showMessageDialog(frame, "¥Î√‚ º∫∞¯");
					frame.dispose();
				}

			}
		});
		btnNewButton.setBounds(189, 190, 102, 32);
		frame.getContentPane().add(btnNewButton);

		JButton button = new JButton("\uCDE8\uC18C");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
			}
		});
		button.setBounds(314, 190, 118, 32);
		frame.getContentPane().add(button);

		JLabel label = new JLabel("\uB300\uCD9C\uB3C4\uC11C");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 19));
		label.setBounds(12, 132, 113, 27);
		frame.getContentPane().add(label);

		MemberBook = new JTextField();
		MemberBook.setColumns(10);
		MemberBook.setBounds(120, 127, 270, 32);
		frame.getContentPane().add(MemberBook);

		JButton btnId = new JButton("ID \uAC80\uC0C9");
		btnId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (memberId.getText() == m.getId())
					MemberBook.setText(m.getMemberBook());
			}
		}

		);
		btnId.setBounds(63, 190, 102, 32);
		frame.getContentPane().add(btnId);
	}
}
