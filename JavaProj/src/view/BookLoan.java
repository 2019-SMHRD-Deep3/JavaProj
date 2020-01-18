package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.MemberManagementService;
import model.Book;
import model.BookDAO;
import model.Member;
import model.MemberDAO;

public class BookLoan {
	private JFrame frame;
	private JTextField textField_2;
	private JTextField textField_3;
	private MemberManagementService service = new MemberManagementService();
	private Book selectBook;
	private BookDAO bdao = new BookDAO();
	private JTextField MemberBook;
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "hr";
	private String password = "hr";
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	private MemberDAO dao = new MemberDAO();

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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String infoId = memberId.getText();

				try {
					OutputStream output = new FileOutputStream("D:\\MemberId.txt");
					String str = infoId;
					byte[] by = str.getBytes();
					output.write(by);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				Member m = new Member(infoId);
				Book b = bdao.updateLoan(selectBook);

				if (MemberBook != null) {
					JOptionPane.showMessageDialog(frame, "¥Î√‚ º∫∞¯");
				} else {
					JOptionPane.showMessageDialog(frame, "¥Î√‚ Ω«∆–");
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
				int i = 0;
				int j = 0;

				ArrayList<Member> list = service.bkLookup(memberId.getText());
				ArrayList<Member> allList = service.bkAllLookup();
				Object[][] data = new Object[list.size()][3];
				Object[][] allData = new Object[allList.size()][3];

				for (i = 0; i < list.size(); i++) {
					Member m = list.get(i);
					data[i] = new Object[] { m.getId(), m.getPw(), m.getMemberBook() };
				}
				for (int k = 0; k < list.size(); k++) {
					if (data[k][0] != null) {
						MemberBook.setText((String) data[k][2]);
					}
				}
				for (j = 0; j < allList.size(); j++) {
					Member m2 = allList.get(j);
					allData[j] = new Object[] { m2.getId(), m2.getPw(), m2.getMemberBook() };
				}

				boolean is = false;
				for (int k = 0; k < allData.length; k++) {
					if (memberId.getText().equals(allData[k][0])) {
						is = true;
						break;
					}
				}
				if (i == 0 && is == false) {
					JOptionPane.showMessageDialog(frame, "æ¯¥¬ ID¿‘¥œ¥Ÿ.");
					frame.dispose();
				}
			}
		});
		btnId.setBounds(63, 190, 102, 32);
		frame.getContentPane().add(btnId);
	}
}