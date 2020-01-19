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

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.XChartPanel;

import controller.MemberManagementService;
import model.Book;
import model.Member;

public class D extends JPanel { // �̴��� ��õ���� Ȥ�� ���
	private MemberManagementService service = new MemberManagementService();
	private JPanel panel;
	private JFrame frame;

//	private Member loginUser;

	/**
	 * Create the panel.
	 */
	public D(Member loginUser) {
		
		setBackground(new Color(240, 245, 249));
		setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 245, 249));
		panel_1.setBounds(0, 57, 1240, 560);
		add(panel_1);
		panel_1.add(getChart(loginUser));
		
		
	}

	public XChartPanel getChart(Member loginUser) {

		// �� ��Ʈ �����
		PieChart chart = new PieChartBuilder().width(700).height(500).title("�̴� ���� �뿩�� å ��� Top 5").build();
		// getClass().getSimpleName() Ŭ���� �̸�

		// ��Ʈ ���� ����(RGB)
		Color[] sliceColors = new Color[] { new Color(119, 170, 173), new Color(110, 119, 131),
				new Color(216, 230, 231), new Color(157, 195, 193), new Color(224, 227, 218) };
		chart.getStyler().setSeriesColors(sliceColors);

		
		ArrayList<Book> list = service.bookChart(loginUser.getId());	//
		
		for (int i = 0; i < list.size(); i++) {
			Book b = list.get(i);
			chart.addSeries(b.getTitle(), b.getCnt());
		}
		

		// �Ӽ�(Title, �뿩��)
//		chart.addSeries("1��", 20);
//		chart.addSeries("����", 10);
//		chart.addSeries("���", 75);
//		chart.addSeries("�̳�", 5);
//		chart.addSeries("�ϴ�", 25);

		XChartPanel chartPanel = new XChartPanel(chart);
		chartPanel.setForeground(new Color(240, 245, 249));
		chartPanel.setBackground(new Color(240, 245, 249));

		return chartPanel;
	}

}
