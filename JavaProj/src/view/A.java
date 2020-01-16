package view;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controller.MemberManagementService;
import model.Member;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class A extends JPanel { // 회원정보
	private JTextField textField;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTable table;
	private MemberManagementService service = new MemberManagementService();
	private DefaultTableModel defaultTableModel = new DefaultTableModel();
	/**
	 * Create the panel.
	 * 
	 * @param loginUser
	 */ 
	public A(Member loginUser) {
		setBackground(Color.WHITE);
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 100, 1014, 490);
		add(scrollPane);

		String[] columnNames = { "아이디", "이름", "주민등록번호", "주소", "전화번호", "비밀번호" };

		ArrayList<Member> list = service.memberLookup(loginUser.getId());

		Object[][] data = new Object[list.size()][6];

		for (int i = 0; i < list.size(); i++) {
			Member m = list.get(i);
			data[i] = new Object[] { m.getId(), m.getName(), m.getSocialNumber(), m.getAddress(), m.getPhone(),
					m.getPw() };
		}

		defaultTableModel.setDataVector(data, columnNames); // 데이터를 가져오는 모델을 만듦.
		table = new JTable(defaultTableModel); //데이터를 가진 변수 생성.
		scrollPane.setViewportView(table);  // 화면에 데이터 보여줌
		
		String[] combo = { "  ", "이름", "주소", "전화번호" };
		DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(combo);
		JComboBox comboBox = new JComboBox(comboModel);

		comboBox.setBounds(200, 38, 170, 29);
		add(comboBox);

		textField = new JTextField();
		textField.setBounds(382, 38, 315, 29);
		add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int j = comboBox.getSelectedIndex();
				if (j == 1) {
					ArrayList<Member> list = service.findName(textField.getText());

					Object[][] data = new Object[list.size()][6];

					for (int i = 0; i < list.size(); i++) {
						Member m = list.get(i);
						data[i] = new Object[] { m.getId(), m.getName(), m.getSocialNumber(), m.getAddress(),
								m.getPhone(), m.getPw()};
					}

					defaultTableModel.setDataVector(data, columnNames);

				} else if (j == 2) {
					ArrayList<Member> list = service.findAddress(textField.getText());

					Object[][] data = new Object[list.size()][6];

					for (int i = 0; i < list.size(); i++) {
						Member m = list.get(i);
						data[i] = new Object[] { m.getId(), m.getName(), m.getSocialNumber(), m.getAddress(),
								m.getPhone(), m.getPw()};
					}

					defaultTableModel.setDataVector(data, columnNames);

				} else if (j == 3) {
					ArrayList<Member> list = service.findPhone(textField.getText());

					Object[][] data = new Object[list.size()][6];

					for (int i = 0; i < list.size(); i++) {
						Member m = list.get(i);
						data[i] = new Object[] { m.getId(), m.getName(), m.getSocialNumber(), m.getAddress(),
								m.getPhone(), m.getPw()};
					}

					defaultTableModel.setDataVector(data, columnNames);
				}

			}
		});
		btnNewButton.setBounds(709, 38, 136, 29);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uC218\uC815");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row_index = table.getSelectedRow();
				// defaultTableModel.getValueAt(0, 0); // 테이블에서 값을 가져올수있다.
				MemberUpdate mu = new MemberUpdate();
			}
		});
		btnNewButton_1.setBounds(57, 124, 97, 23);
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\uC0AD\uC81C");
		btnNewButton_2.setBounds(57, 157, 97, 23);
		add(btnNewButton_2);
		
		JButton button = new JButton("\uCD08\uAE30\uD654");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Member> list = service.memberLookup(loginUser.getId());

				Object[][] data = new Object[list.size()][6];

				for (int i = 0; i < list.size(); i++) {
					Member m = list.get(i);
					data[i] = new Object[] { m.getId(), m.getName(), m.getSocialNumber(), m.getAddress(), m.getPhone(),
							m.getPw() };
				}

				defaultTableModel.setDataVector(data, columnNames);
			}
		});

		button.setBounds(57, 190, 97, 23);
		add(button);

		btnNewButton.setBounds(709, 38, 136, 29);
		add(btnNewButton);


	}
}