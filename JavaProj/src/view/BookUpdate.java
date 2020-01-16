package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookUpdate window = new BookUpdate();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookUpdate() {
		initialize();
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
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setHorizontalAlignment(SwingConstants.CENTER);
		lblIsbn.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		lblIsbn.setBounds(12, 60, 113, 21);
		frame.getContentPane().add(lblIsbn);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(137, 62, 270, 21);
		frame.getContentPane().add(textField);
		
		JLabel label_2 = new JLabel("\uB3C4\uC11C\uBA85");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_2.setBounds(12, 91, 113, 21);
		frame.getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(137, 93, 270, 21);
		frame.getContentPane().add(textField_1);
		
		JLabel label_3 = new JLabel("\uC791\uAC00");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_3.setBounds(12, 122, 113, 21);
		frame.getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(137, 124, 270, 21);
		frame.getContentPane().add(textField_2);
		
		JLabel label_4 = new JLabel("\uCD9C\uD310\uC0AC");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_4.setBounds(12, 153, 113, 21);
		frame.getContentPane().add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(137, 155, 270, 21);
		frame.getContentPane().add(textField_3);
		
		JButton button = new JButton("\uC218\uC815");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame,
					    "¼öÁ¤ ¼º°ø");
			}
		});
		button.setBounds(136, 216, 97, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\uCDE8\uC18C");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		button_1.setBounds(245, 216, 97, 23);
		frame.getContentPane().add(button_1);
	}

}
