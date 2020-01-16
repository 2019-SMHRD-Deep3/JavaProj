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

public class BookDelete {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookDelete window = new BookDelete();
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
	public BookDelete() {
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
		
		JLabel label = new JLabel("\uB3C4\uC11C \uC0AD\uC81C");
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
		
		JButton button = new JButton("\uC0AD\uC81C");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frame,
					    "»èÁ¦ ¼º°ø");
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
