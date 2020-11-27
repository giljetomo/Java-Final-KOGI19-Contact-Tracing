package kogi19.main;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.TextAnchor;

import kogi19.DatabaseHandler.DatabaseHandler;

public class LineChartCases extends JFrame  {
	
	DatabaseHandler dbhandler = null;

	public LineChartCases( String applicationTitle , String chartTitle ) {
	      super(applicationTitle);
	      JFreeChart lineChart = ChartFactory.createLineChart(
	         chartTitle,
	         "Date","Number of Tests",
	         createDataset(),
	         PlotOrientation.VERTICAL,
	         true,true,false);
	         
	      ChartPanel chartPanel = new ChartPanel( lineChart );
	      chartPanel.setPreferredSize( new java.awt.Dimension( 1060 , 667 ) );
	      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	      
	   //   chartPanel.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	      setContentPane(chartPanel);
	   }

	   private DefaultCategoryDataset createDataset( ) {
	      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );

	      
	      dbhandler = DatabaseHandler.getInstance();
	      
	      ArrayList<LineChartData> totalCases = dbhandler.getListOfTotalCases();
	      ArrayList<LineChartData> totalPositiveCases = dbhandler.getListOfPositiveCases();
	      
	      for(LineChartData data : totalCases) {
//		      count, typeOftest, date
	    	  dataset.addValue(Integer.parseInt(data.getCount()), "number of tests", data.getDate());
	      }
	      
	      for(LineChartData data : totalPositiveCases) {
//		      count, typeOftest, date
	    	  dataset.addValue(Integer.parseInt(data.getCount()), "number of positive cases", data.getDate());
	      }

	      
//	      Date d = Date.valueOf("2020-12-10");
//	      dataset.addValue( 15 , "schools", d);
//	      dataset.addValue( 30 , "schools" , "1980" );
//	      dataset.addValue( 60 , "schools" ,  "1990" );
//	      dataset.addValue( 50 , "covid" ,  "2022" );
//	      dataset.addValue( 180 , "covid" , "2000" );
//	      dataset.addValue( 20 , "covid" , "2030" );
//	      dataset.addValue( 120 , "schools" , "2000" );
//	      dataset.addValue( 240 , "schools" , "2010" );
//	      dataset.addValue( 300 , "schools" , "2014" );
//	      dataset.addValue( 20 , "covid" , d );
//	      dataset.addValue( 40 , "covid" , "1980" );
//	      dataset.addValue( 30 , "covid" , "2014" );
	      return dataset;
	   }
}
