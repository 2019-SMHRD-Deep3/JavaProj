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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.MemberManagementService;
import model.Member;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class A extends JPanel { // 회원정보
	private JTextField textField;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTable table;
	private MemberManagementService service = new MemberManagementService();
	private DefaultTableModel defaultTableModel = new DefaultTableModel();

	/**
	 * 1 Create the panel
	 * 
	 * @param loginUser
	 */
	public A(Member loginUser) {
		setBackground(new Color(201, 214, 222));
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 100, 1014, 490);
		add(scrollPane);

		String[] columnNames = { "아이디", "이름" , "주민등록번호", "주소", "전화번호", "비밀번호",};

		ArrayList<Member> list = service.memberLookup(loginUser.getId());

		Object[][] data = new Object[list.size()][6];

		for (int i = 0; i < list.size(); i++) {
			Member m = list.get(i);
			data[i] = new Object[] { m.getId(), m.getName(), m.getSocialNumber(), m.getAddress(), m.getPhone(),
					m.getPw() };
		}

		defaultTableModel.setDataVector(data, columnNames); // 데이터를 가져오는 모델을 만듦.
		table = new JTable(defaultTableModel); // 데이터를 가진 변수 생성.
		scrollPane.setViewportView(table); // 화면에 데이터 보여줌

		String[] combo = { "  ", "이름", "주소", "전화번호" };
		DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(combo);
		JComboBox comboBox = new JComboBox(comboModel);
		comboBox.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 13));
		comboBox.setBackground(Color.WHITE);

		comboBox.setBounds(200, 38, 170, 29);
		add(comboBox);

		textField = new JTextField();
		textField.setBounds(382, 38, 315, 29);
		add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		btnNewButton.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(240, 245, 249));
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
								m.getPhone(), m.getPw() };
					}

					defaultTableModel.setDataVector(data, columnNames);

				} else if (j == 2) {
					ArrayList<Member> list = service.findAddress(textField.getText());

					Object[][] data = new Object[list.size()][6];

					for (int i = 0; i < list.size(); i++) {
						Member m = list.get(i);
						data[i] = new Object[] { m.getId(), m.getName(), m.getSocialNumber(), m.getAddress(),
								m.getPhone(), m.getPw() };
					}

					defaultTableModel.setDataVector(data, columnNames);

				} else if (j == 3) {
					ArrayList<Member> list = service.findPhone(textField.getText());

					Object[][] data = new Object[list.size()][6];

					for (int i = 0; i < list.size(); i++) {
						Member m = list.get(i);
						data[i] = new Object[] { m.getId(), m.getName(), m.getSocialNumber(), m.getAddress(),
								m.getPhone(), m.getPw() };
					}

					defaultTableModel.setDataVector(data, columnNames);
				}

			}
		});
		btnNewButton.setBounds(709, 38, 136, 29);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uC218\uC815");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		btnNewButton_1.setBackground(new Color(240, 245, 249));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if (row < 0) {
					JOptionPane.showMessageDialog(table, "수정 할 회원을 선택해주세요.");
				}
				TableModel data = table.getModel();

				String name = (String) data.getValueAt(row, 1);
				String pw = (String) data.getValueAt(row, 5);
				String address = (String) data.getValueAt(row, 3);
				String phone = (String) data.getValueAt(row, 4);

				Member selectUser = new Member(name, pw, address, phone);

				MemberUpdate frame = new MemberUpdate(selectUser);
				// defaultTableModel.getValueAt(0, 0); // 테이블에서 값을 가져올수있다.

			}
		});
		btnNewButton_1.setBounds(57, 124, 97, 23);
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\uC0AD\uC81C");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		btnNewButton_2.setBackground(new Color(240, 245, 249));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if (row < 0) {
					JOptionPane.showMessageDialog(table, "삭제 할 회원을 선택해주세요.");
				}
				TableModel data = table.getModel();
				String id = (String) data.getValueAt(row, 0);
				String pw = (String) data.getValueAt(row, 5);

				Member deleteUser = new Member(id, pw);

				MemberDelete frame = new MemberDelete(deleteUser);
			}
		});
		btnNewButton_2.setBounds(57, 157, 97, 23);
		add(btnNewButton_2);

		JButton button = new JButton("\uCD08\uAE30\uD654");
		button.setFont(new Font("맑은 고딕 Semilight", Font.PLAIN, 12));
		button.setBackground(new Color(240, 245, 249));
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