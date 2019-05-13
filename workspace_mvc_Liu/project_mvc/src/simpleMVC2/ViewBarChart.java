package simpleMVC2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class ViewBarChart extends View {
   JFrame frameBarChart;
   JButton buttonBar;
   DefaultCategoryDataset dataContainerBar = new DefaultCategoryDataset();

   public ViewBarChart() {
      initDataSet();
      frameBarChart = new JFrame("Bar Chart");
      frameBarChart.getContentPane().setLayout(new BorderLayout());
      JFreeChart chart = createChart();
      ChartPanel chartPanel = new ChartPanel(chart, false);
      chartPanel.setPreferredSize(new Dimension(500, 270));
      frameBarChart.getContentPane().add(chartPanel, BorderLayout.CENTER);
      buttonBar = new JButton("Button");
      frameBarChart.getContentPane().add(buttonBar, BorderLayout.SOUTH);
      frameBarChart.pack();
      frameBarChart.setVisible(true);
   }

   JFreeChart createChart() {
      JFreeChart chart = ChartFactory.createBarChart("Bar Chart", "", "Value", dataContainerBar, PlotOrientation.VERTICAL, true, true, false);
      chart.setBackgroundPaint(Color.white);
      CategoryPlot plot = (CategoryPlot) chart.getPlot();
      plot.setBackgroundPaint(Color.lightGray);
      plot.setDomainGridlinePaint(Color.white);
      plot.setDomainGridlinesVisible(true);
      plot.setRangeGridlinePaint(Color.white);
      final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
      rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
      BarRenderer renderer = (BarRenderer) plot.getRenderer();
      renderer.setDrawBarOutline(false);
      CategoryAxis domainAxis = plot.getDomainAxis();
      domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0));
      return chart;
   }

   private void initDataSet() {
      dataContainerBar.addValue(20, "data 1", "");
      dataContainerBar.addValue(30, "data 2", "");
      dataContainerBar.addValue(50, "data 3", "");
   }

   @Override
   public void notify(Model model) {
      dataContainerBar.clear();
      dataContainerBar.addValue(model.getData1(), "data 1", "");
      dataContainerBar.addValue(model.getData2(), "data 2", "");
      dataContainerBar.addValue(model.getData3(), "data 3", "");
   }

   @Override
   public JButton getButton() {
      return buttonBar;
   }
}
