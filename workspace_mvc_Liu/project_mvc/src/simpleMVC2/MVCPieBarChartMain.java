package simpleMVC2;

public class MVCPieBarChartMain {
   public static void main(String[] args) {
      Model model = new Model(20, 30, 50);
      Controller controller = new Controller(model, //
            new View[] { new ViewBarChart(), new ViewPieChart() });
      controller.control();
   }
}
