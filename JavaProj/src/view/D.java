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

public class D extends JPanel  { // �̴��� ��õ���� Ȥ�� ���
	private MemberManagementService service = new MemberManagementService();
	private Member loginUser;
	private JPanel panel;
	private JFrame frame;

	/**
	 * Create the panel.
	 */
	public D() {
		setBackground(new Color(229, 222, 211));
		setLayout(null);

		String[] combo = { "(������ ���� �� ��)", "2020�� 1��", "2020�� 2��" };
		DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(combo);
		JComboBox comboBox = new JComboBox(comboModel);
		
		comboBox.setBackground(new Color(229, 222, 211));
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int j = comboBox.getSelectedIndex();
				if (j == 1) {
					
					
					
				}
			}
		});
		comboBox.setBounds(12, 10, 200, 31);
		add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(229, 222, 211));
		panel_1.setBounds(0, 57, 1240, 560);
		add(panel_1);

		panel_1.add(getChart());
		
		
	}
	
	public XChartPanel getChart() {
		  
	    // �� ��Ʈ �����
	    PieChart chart = new PieChartBuilder().width(700).height(500).title("�̴��� ���� �뿩 å ���").build();
	    // getClass().getSimpleName() Ŭ���� �̸�
	 
	    // ��Ʈ ���� ����(RGB)
	    Color[] sliceColors = new Color[] { new Color(255, 153, 000), new Color(204, 102, 000), new Color(153, 051, 000), new Color(255, 153, 102), new Color(255, 102, 000) };
	    chart.getStyler().setSeriesColors(sliceColors);
	 
	    // �Ӽ�(Title, �뿩��)
	    chart.addSeries("���", 35);
	    chart.addSeries("����", 10);
	    chart.addSeries("���", 75);
	    chart.addSeries("�̳�", 5);
	    chart.addSeries("�ϴ�", 25);
	 
	    XChartPanel chartPanel = new XChartPanel(chart);
	    chartPanel.setBackground(new Color(229, 222, 211));
	    return chartPanel;
	  }
}


