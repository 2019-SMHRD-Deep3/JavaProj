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

public class D extends JPanel { // 이달의 추천도서 혹은 통계
	private MemberManagementService service = new MemberManagementService();
	private JPanel panel;
	private JFrame frame;
	private Book b;

	/**
	 * Create the panel.
	 */
	public D(Member loginUser) {
		
		setBackground(new Color(229, 222, 211));
		setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(229, 222, 211));
		panel_1.setBounds(0, 57, 1240, 560);
		add(panel_1);
		panel_1.add(getChart());
		
		
	}

	public XChartPanel getChart() {

		// 원 차트 만들기
		PieChart chart = new PieChartBuilder().width(700).height(500).title("이달의 많은 대여 책 목록").build();
		// getClass().getSimpleName() 클래스 이름

		// 차트 세부 변경(RGB)
		Color[] sliceColors = new Color[] { new Color(255, 153, 000), new Color(204, 102, 000),
				new Color(153, 051, 000), new Color(255, 153, 102), new Color(255, 102, 000) };
		chart.getStyler().setSeriesColors(sliceColors);

		
//		ArrayList<Book> list = service.bookChart();
//		
//		for (int i = 0; i < list.size(); i++) {
//			b = list.get(i);
//			chart.addSeries(b.getTitle(), b.getCnt());
//		}

		// 속성(Title, 대여수)
		chart.addSeries("1가", 20);
		chart.addSeries("내가", 10);
		chart.addSeries("사람", 75);
		chart.addSeries("이냐", 5);
		chart.addSeries("하늘", 25);

		XChartPanel chartPanel = new XChartPanel(chart);
		chartPanel.setForeground(new Color(229, 222, 211));
		chartPanel.setBackground(new Color(229, 222, 211));

		return chartPanel;
	}

}
