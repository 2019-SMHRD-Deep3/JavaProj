package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.MemberManagementService;
import model.Member;

public class A extends JPanel {	// 회원정보
	private JTextField textField;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTable table;
	private MemberManagementService service = new MemberManagementService();
	
	/**
	 * Create the panel.
	 * @param loginUser 
	 */
	public A(Member loginUser) {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 100, 1014, 490);
		add(scrollPane);
		
		scrollPane_1 = new JScrollPane();
		scrollPane.setViewportView(scrollPane_1);
		
		String[] columnNames = { "아이디", "이름", "주민등록번호","주소","전화번호","비밀번호" };

		ArrayList<Member> list = service.memberLookup(loginUser.getId());

		Object[][] data = new Object[list.size()][6];

		for (int i = 0; i < list.size(); i++) {
			Member m = list.get(i);
			data[i] = new Object[] { m.getId(), m.getName(), m.getSocialNumber(),
					                 m.getAddress(), m.getPhone(),};
		}

		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);
		
		
		String[] combo = {"이름", "주소", "전화번호"};
		DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(combo);
	      JComboBox comboBox = new JComboBox(comboModel);
		
		comboBox.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox.setBounds(200, 38, 170, 29);
		add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(382, 38, 315, 29);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.setBounds(709, 38, 136, 29);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC218\uC815");
		btnNewButton_1.setBounds(57, 124, 97, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uC0AD\uC81C");
		btnNewButton_2.setBounds(57, 157, 97, 23);
		add(btnNewButton_2);

		
		JLabel name = new JLabel("");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(36, 32, 57, 15);
		add(name);
		
		JLabel lblNewLabel_1 = new JLabel("\uB2D8 \uD658\uC601\uD569\uB2C8\uB2E4.");
		lblNewLabel_1.setBounds(91, 32, 90, 15);
		add(lblNewLabel_1);
		
		JButton btnNewButton_4 = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnNewButton_4.setBounds(57, 57, 97, 23);
		add(btnNewButton_4);

	}
}
