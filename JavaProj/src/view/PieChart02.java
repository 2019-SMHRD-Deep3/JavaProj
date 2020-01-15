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
		  
	    // 원 차트 만들기
	    PieChart chart = new PieChartBuilder().width(800).height(800).title("책 대여수").build();
	    // getClass().getSimpleName() 클래스 이름
	 
	    // 차트 세부 변경(RGB)
	    Color[] sliceColors = new Color[] { new Color(255, 153, 000), new Color(204, 102, 000), new Color(153, 051, 000), new Color(255, 153, 102), new Color(255, 102, 000) };
	    chart.getStyler().setSeriesColors(sliceColors);
	 
	    // 속성(Title, 대여수)
	    chart.addSeries("펭수", 35);
	    chart.addSeries("내가", 10);
	    chart.addSeries("사람", 75);
	    chart.addSeries("이냐", 5);
	    chart.addSeries("하늘", 25);
	 
	    return chart;
	  }
	 
	}