package simpleMVC2;

import java.util.Random;

public class Model {
   private int data1, data2, data3;

   public Model(int data1, int data2, int data3) {
      this.data1 = data1;
      this.data2 = data2;
      this.data3 = data3;
   }

   public void changeState(View[] views) {
      random();
      for (View iView : views) {
         iView.notify(this);
      }
   }
   
   public int getData1() {
      return data1;
   }

   public void setData1(int data1) {
      this.data1 = data1;
   }

   public int getData2() {
      return data2;
   }

   public void setData2(int data2) {
      this.data2 = data2;
   }

   public int getData3() {
      return data3;
   }

   public void setData3(int data3) {
      this.data3 = data3;
   }
   
   void random() {
      Random rand = new Random();
      data1 = rand.nextInt(50) + 10;
      data2 = rand.nextInt(50) + 10;
      data3 = rand.nextInt(50) + 10;
   }
}
