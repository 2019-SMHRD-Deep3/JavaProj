package view;

import java.awt.Color;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;

import model.ExampleChart;

public class PieChart02 implements ExampleChart<PieChart> {
	 
	  public static void main(String[] args) {
	 
	    ExampleChart<PieChart> exampleChart = new PieChart02();
	    PieChart chart = exampleChart.getChart();
	    new SwingWrapper<PieChart>(chart).displayChart();
	  }
	 
	  @Override
	  public PieChart getChart() {
		  
	    // �� ��Ʈ �����
	    PieChart chart = new PieChartBuilder().width(800).height(800).title("å �뿩��").build();
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
	 
	    return chart;
	  }
	 
	}