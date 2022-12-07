package javafxapplication;

import java.awt.Component;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class FXMLDocumentController implements Initializable {

    static {
        // Установка формата вывода для java.util.logging.SimpleFormatter
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "%1$tF %1$tT [%4$-7s] %3$s - %5$s %n");
    }
    // Объявление логировцика типа org.apache.log4j.Logger
    static org.apache.log4j.Logger log4j = org.apache.log4j.Logger.getLogger(FXMLDocumentController.class);
    
    @FXML
    private Button button_Math;
    @FXML
    private Label label_a;
    @FXML
    private Label label_b;
    @FXML
    private Label label_x;
    @FXML
    private Label label_otvet;
    @FXML
    private TextField textField_A;
    @FXML
    private TextField textField_B;
    @FXML
    private TextField textField_X;
    @FXML
    private Button button_Clear;
    @FXML
    private Button button_Exit;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void buttonMathAction(ActionEvent event) {
        
        log4j.info("Start log4j");
        log4j.info("Hi Logger info!");
        log4j.warn("Warrning!");
        log4j.error("Error!");
        log4j.fatal("Fatal error!");
        
        org.apache.log4j.LogManager.shutdown();
        
        double a, b, x, y;
        try {
            a = Double.parseDouble(textField_A.getText());
            b = Double.parseDouble(textField_B.getText());
            x = Double.parseDouble(textField_X.getText());
        } catch (Exception ex) {
            Toolkit.getDefaultToolkit().beep();
            Component rootPane = null;
            JOptionPane.showMessageDialog(rootPane, "Ошибка введенных данных!", "Ошибка ввода",
                    JOptionPane.ERROR_MESSAGE);
            textField_A.requestFocus();
            label_otvet.setText("В введенных значениях допущены ошибки");
            textField_A.setText("");
            textField_B.setText("");
            textField_X.setText("");
            return;
        }
        if (x > 6) {
            y = (6 * x * x - a * b) / (2 * x * x);
        } else {
            y = 4 * (x + a * a + b * b);
        }
        if (!(Double.isNaN(y)) && (!Double.isInfinite(y))) {
            label_otvet.setText("Ответ: " + String.format("%.2f", y));
        } else {
            label_otvet.setText("Нет ответа");
        }
    }

    @FXML
    private void buttonClearAction(ActionEvent event) {
        label_otvet.setText("Ответ: ");
        textField_A.setText("");
        textField_B.setText("");
        textField_X.setText("");
    }

    @FXML
    private void buttonExitAction(ActionEvent event) {
        System.exit(0);
    }

}
