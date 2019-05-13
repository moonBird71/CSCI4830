package simpleMVC1;

import javax.swing.SwingUtilities;

/*
 * MVCMain.java
 */
public class MVCMain {
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            Model model = new Model(1);
            Controller controller = new Controller(model, //
                  new View[] { new View(1, "#Group"), //
                        new View(5, "#Members per group"), // 
                        new View(10, "#Items per group member") });
            controller.control();
         }
      });
   }
}
