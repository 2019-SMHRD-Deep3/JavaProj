package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.MemberManagementService;
import model.Book;
import model.Member;

public class D extends JPanel  { // �̴��� ��õ���� Ȥ�� ���
	private MemberManagementService service = new MemberManagementService();
	private Member loginUser;
	private JPanel panel;
	private JFrame frame;

	/**
	 * Create the panel.
	 */
	public D() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		String[] combo = { "(������ ���� �� ��)", "2020�� 1��", "2020�� 2��" };
		DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(combo);
		JComboBox comboBox = new JComboBox(comboModel);
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		comboBox.setBounds(12, 10, 200, 31);
		add(comboBox);

		
		
		
	}
}


