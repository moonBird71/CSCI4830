package observer2;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
   protected List<Observer> observers = new ArrayList<Observer>();

   public void attach(Observer observer) {
      observers.add(observer);
   }

   protected void detach(Observer observer) {
      observers.remove(observer);
   }

   protected void notifyAllObservers() {
      for (Observer observer : observers) {
         observer.update();
      }
   }

   public abstract List<Integer> getState();

   public abstract void setState(List<Integer> state);
}
