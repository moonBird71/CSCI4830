package simpleMVC2;

import javax.swing.JButton;

public abstract class View {
   public abstract void notify(Model model);
   public abstract JButton getButton();
}
