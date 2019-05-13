package simpleMVC2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
   Model model;
   View[] views;

   public Controller(Model model, View[] views) {
      this.model = model;
      this.views = views;
   }
   
   public void control() {
      ActionListener actionListener = new ActionListener() {
         public void actionPerformed(ActionEvent actionEvent) {
            changeState();
         }
      };

      // Adds an ActionListener to the button to receive the user's button event.
      for (View iView : views) {
         iView.getButton().addActionListener(actionListener);
      }
   }

   private void changeState() {
      model.changeState(views);
   }   
}
