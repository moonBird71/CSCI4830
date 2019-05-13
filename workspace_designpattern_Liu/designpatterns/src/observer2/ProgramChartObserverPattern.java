package observer2;

public class ProgramChartObserverPattern {
   public static void main(String[] args) {
      ConcreteSubject subject = new ConcreteSubject();
      new ObserverPieChart(subject);
      new ObserverBarChart(subject);
   }
}
