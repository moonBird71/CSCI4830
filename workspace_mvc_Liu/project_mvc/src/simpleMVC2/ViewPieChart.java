package simpleMVC2;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

public class ViewPieChart extends View {
   JFrame framePieChart;
   JButton buttonPie;
   DefaultPieDataset dataContainerPie = new DefaultPieDataset();

   public ViewPieChart() {
      initDataset();
      framePieChart = new JFrame("Pie Chart");
      framePieChart.getContentPane().setLayout(new BorderLayout());
      JFreeChart chart = createPieChart();
      ChartPanel chartPanel = new ChartPanel(chart);
      chartPanel.setPreferredSize(new Dimension(500, 270));
      framePieChart.getContentPane().add(chartPanel, BorderLayout.CENTER);
      buttonPie = new JButton("Button");
      framePieChart.getContentPane().add(buttonPie, BorderLayout.SOUTH);
      framePieChart.pack();
      framePieChart.setVisible(true);
   }

   JFreeChart createPieChart() {
      JFreeChart chart = ChartFactory.createPieChart3D("Pie Chart", dataContainerPie, true, true, false);
      PiePlot3D plot = (PiePlot3D) chart.getPlot();
      plot.setStartAngle(290);
      plot.setDirection(Rotation.CLOCKWISE);
      plot.setForegroundAlpha(0.5f);
      return chart;
   }

   void initDataset() {
      dataContainerPie.setValue("data 1", 20);
      dataContainerPie.setValue("data 2", 30);
      dataContainerPie.setValue("data 3", 50);
   }

   @Override
   public void notify(Model model) {
      dataContainerPie.clear();
      dataContainerPie.setValue("data 1", model.getData1());
      dataContainerPie.setValue("data 2", model.getData2());
      dataContainerPie.setValue("data 3", model.getData3());
   }

   @Override
   public JButton getButton() {
      return buttonPie;
   }
}
