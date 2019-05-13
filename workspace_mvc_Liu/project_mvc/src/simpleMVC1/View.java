package simpleMVC1;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * View.java
 */
public class View {
   private JFrame  frame;
   private JLabel  label;
   private JButton buttonIncData, buttonDecData;
   private Integer initValue;

   public View(int id, String title) {
      // initial value for data model.
      initValue = Integer.valueOf(id);

      frame = new JFrame(title);
      frame.getContentPane().setLayout(new BorderLayout());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(250, 200 + id * 20);
      frame.setVisible(true);

      label = new JLabel(String.valueOf(id));
      label.setFont(new Font("Serif", Font.PLAIN, 100));
      frame.getContentPane().add(label, BorderLayout.CENTER);

      buttonIncData = new JButton("Button Increase Data");
      frame.getContentPane().add(buttonIncData, BorderLayout.NORTH);
      buttonDecData = new JButton("Button Decrease Data");
      frame.getContentPane().add(buttonDecData, BorderLayout.SOUTH);
   }

   public JButton getButtonIncData() {
      return buttonIncData;
   }

   public JButton getButtonDecData() {
      return buttonDecData;
   }

   public void notify(Model model) {
      int sum = initValue * model.queryState();
      label.setText(String.valueOf(sum));
   }
}
