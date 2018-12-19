import calculator_view.CalculatorView;
import java.awt.*;

public class Main {
    /*
     * Start App. Created by Todor Kamenov
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CalculatorView calculator = new CalculatorView();
                calculator.getFrame().setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Catch Exception!!!");
            }
        });
    }

}
