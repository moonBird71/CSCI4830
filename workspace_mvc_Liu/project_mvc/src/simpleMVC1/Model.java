package simpleMVC1;

/*
 * Model.java
 */
public class Model {
   private int data;

   public Model(int data) {
      this.data = data;
   }

   public int queryState() {
      return data;
   }

   public void changeStateIncData(View[] views) {
      data++;
      for (View iView : views) {
         iView.notify(this);
      }
   }

   public void changeStateDecData(View[] views) {
      data--;
      for (View iView : views) {
         iView.notify(this);
      }
   }
}
