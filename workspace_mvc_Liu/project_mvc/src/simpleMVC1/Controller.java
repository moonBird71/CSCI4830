package simpleMVC1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Controller.java
 */
public class Controller {
   private Model model;
   private View[] views;

   public Controller(Model model, View[] views) {
      this.model = model;
      this.views = views;
   }

   public void control() {
      // The listener interface definition for receiving user events.
      ActionListener actionListener = new ActionListener() {
         public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getActionCommand().equals("Button Increase Data")) {
               changeStateIncData();
            } else if (actionEvent.getActionCommand().equals("Button Decrease Data")) {
               changeStateDecData();
            }
         }
      };
      // Add an ActionListener to the button to receive the user's button event.
      for (View iView : views) {
         iView.getButtonIncData().addActionListener(actionListener);
         iView.getButtonDecData().addActionListener(actionListener);
      }
   }

   void changeStateIncData() {
      model.changeStateIncData(views);
   }

   void changeStateDecData() {
      model.changeStateDecData(views);
   }
}
