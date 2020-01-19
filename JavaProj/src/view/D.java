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

		// 원 차트 만들기
		PieChart chart = new PieChartBuilder().width(700).height(500).title("이달 많이 대여한 책 목록 Top 5").build();
		// getClass().getSimpleName() 클래스 이름

		// 차트 세부 변경(RGB)
		Color[] sliceColors = new Color[] { new Color(119, 170, 173), new Color(110, 119, 131),
				new Color(216, 230, 231), new Color(157, 195, 193), new Color(224, 227, 218) };
		chart.getStyler().setSeriesColors(sliceColors);

		
		ArrayList<Book> list = service.bookChart(loginUser.getId());	//
		
		for (int i = 0; i < list.size(); i++) {
			Book b = list.get(i);
			chart.addSeries(b.getTitle(), b.getCnt());
		}
		

		// 속성(Title, 대여수)
//		chart.addSeries("1가", 20);
//		chart.addSeries("내가", 10);
//		chart.addSeries("사람", 75);
//		chart.addSeries("이냐", 5);
//		chart.addSeries("하늘", 25);

		XChartPanel chartPanel = new XChartPanel(chart);
		chartPanel.setForeground(new Color(240, 245, 249));
		chartPanel.setBackground(new Color(240, 245, 249));

		return chartPanel;
	}

}
