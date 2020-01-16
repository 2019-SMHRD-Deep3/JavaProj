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

public class MemberDelete {

	private JFrame frame;
	private JTextField id;
	private JTextField pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberDelete window = new MemberDelete();
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
	public MemberDelete() {
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
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		lblId.setBounds(12, 60, 113, 21);
		frame.getContentPane().add(lblId);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(137, 62, 270, 21);
		frame.getContentPane().add(id);
		
		JLabel label_1 = new JLabel("PW");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_1.setBounds(12, 91, 113, 21);
		frame.getContentPane().add(label_1);
		
		pw = new JTextField();
		pw.setColumns(10);
		pw.setBounds(137, 93, 270, 21);
		frame.getContentPane().add(pw);
		
		JButton button = new JButton("\uC0AD\uC81C");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
		
		JLabel label_2 = new JLabel("\uD68C\uC6D0\uC0AD\uC81C");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 15));
		label_2.setBounds(12, 10, 420, 21);
		frame.getContentPane().add(label_2);
		
		
	}
}
