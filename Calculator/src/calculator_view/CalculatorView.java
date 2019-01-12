package calculator_view;

import calculator_logic.Calculator;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.Color.ORANGE;

public class CalculatorView implements InitializeView {
    private ButtonListener buttonListener;
    private ButtonGroup buttonGroup;
    private JFrame frame;
    private JLabel result;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JButton calculate;
    private JButton clear;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    private JRadioButton radioButton6;


    public CalculatorView() {
        initialize();


    }

    @Override
    public void initialize() {
        this.buttonListener = new ButtonListener();
        initializeFrame();
        initializeLabels();
        initializeTextFields();
        initializeButtons();
        initializeRadioButtons();


    }

    public JFrame getFrame() {
        return frame;
    }


    @Override
    public void initializeFrame() {
        this.frame = new JFrame();
        frame.setBounds(100, 100, 832, 421);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Calculator");
        frame.getContentPane().setBackground(ORANGE);
        frame.getContentPane().setLayout(null);


    }

    @Override
    public void initializeLabels() {
        this.result = new JLabel();
        result.setBounds(0, 29, 298, 20);
        result.setOpaque(true);
        frame.getContentPane().add(result);

        this.label1 = new JLabel("Резултат");
        this.label1.setBounds(10, 4, 99, 14);
        frame.getContentPane().add(this.label1);

        this.label2 = new JLabel("");
        this.label2.setBounds(0, 71, 298, 14);
        frame.getContentPane().add(this.label2);

        this.label3 = new JLabel("");
        this.label3.setBounds(0, 135, 298, 14);
        frame.getContentPane().add(this.label3);


    }

    @Override
    public void initializeTextFields() {
        this.textField1 = new JTextField();
        this.textField1.setBounds(0, 104, 99, 20);
        this.frame.getContentPane().add(this.textField1);
        this.textField1.setColumns(10);

        this.textField2 = new JTextField();
        this.textField2.setBounds(0, 169, 99, 20);
        this.frame.getContentPane().add(this.textField2);
        this.textField2.setColumns(10);


    }

    @Override
    public void initializeButtons() {

        this.calculate = new JButton("Изчисли!");
        this.calculate.setBounds(0, 227, 99, 23);
        this.frame.getContentPane().add(this.calculate);
        calculate.setEnabled(false);
        this.calculate.addActionListener(this.buttonListener);

        this.clear = new JButton("Изтрий!");
        this.clear.setBounds(0, 261, 99, 23);
        this.frame.getContentPane().add(this.clear);
        this.clear.addActionListener(this.buttonListener);


    }

    @Override
    public void initializeRadioButtons() {
        this.buttonGroup = new ButtonGroup();

        this.radioButton1 = new JRadioButton();
        this.radioButton1.setText("Коефициент на рентабилност на приходите от продажби");
        this.radioButton1.setBounds(348, 7, 397, 23);
        this.frame.getContentPane().add(this.radioButton1);
        this.radioButton1.addActionListener(this.buttonListener);

        this.radioButton2 = new JRadioButton("Коефициент на рентабилност на собствения капитал");
        this.radioButton2.setBounds(348, 29, 397, 23);
        this.frame.getContentPane().add(this.radioButton2);
        this.radioButton2.addActionListener(this.buttonListener);

        this.radioButton3 = new JRadioButton("Коефициент на рентабилност на активите");
        this.radioButton3.setBounds(348, 52, 397, 23);
        frame.getContentPane().add(this.radioButton3);
        this.radioButton3.addActionListener(this.buttonListener);

        this.radioButton4 = new JRadioButton("Коефициент на приходите от обичайна дейност");
        this.radioButton4.setBounds(348, 75, 397, 23);
        this.frame.getContentPane().add(this.radioButton4);
        this.radioButton4.addActionListener(this.buttonListener);

        this.radioButton5 = new JRadioButton("Коефициент на финансова автономност");
        this.radioButton5.setBounds(348, 101, 397, 23);
        this.frame.getContentPane().add(this.radioButton5);
        this.radioButton5.addActionListener(this.buttonListener);

        this.radioButton6 = new JRadioButton("Нетен паричен поток");
        this.radioButton6.setBounds(348, 126, 397, 23);
        frame.getContentPane().add(this.radioButton6);
        this.radioButton6.addActionListener(this.buttonListener);


        buttonGroup.add(this.radioButton1);
        buttonGroup.add(this.radioButton2);
        buttonGroup.add(this.radioButton3);
        buttonGroup.add(this.radioButton4);
        buttonGroup.add(this.radioButton5);
        buttonGroup.add(this.radioButton6);


    }

    private class ButtonListener implements ActionListener {

        private Calculator calculator;
        private static final String OPERATOR_SUBTRACTION = "-";
        private static final String OPERATOR_DIVISION = "/";


        private void clear() {
            result.setText("");
            textField1.setText("");
            textField2.setText("");

        }

        private void calculate() {
            double digitA = Float.parseFloat(textField1.getText());
            double digitB = Float.parseFloat(textField2.getText());

            if (radioButton6.isSelected()) {
                calculator = new Calculator(digitA, digitB, OPERATOR_SUBTRACTION);
                result.setText(String.valueOf(calculator.calculateResult()));
            } else {
                calculator = new Calculator(digitA, digitB, OPERATOR_DIVISION);
                result.setText(String.valueOf(calculator.calculateResult()));

            }
        }

        private void setLabelsText(String text1, String text2) {
            calculate.setEnabled(true);
            label2.setText(text1);
            label3.setText(text2);
        }


        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource().equals(radioButton1)) {
                clear();
                setLabelsText("Финансов резултат от продажби", "Нетен размер на приходите от продажби");
            }

            if (e.getSource().equals(radioButton2)) {
                clear();
                setLabelsText("Балансова печалба/загуба", "Собствен капитал");
            }

            if (e.getSource().equals(radioButton3)) {
                clear();
                setLabelsText("Финансов резултат преди разходи за лихви", "Балансова стойност на активите");
            }

            if (e.getSource().equals(radioButton4)) {
                clear();
                setLabelsText("Разходи за обичайна дейност", "Приходи от обичайна дейност");
            }

            if (e.getSource().equals(radioButton5)) {
                clear();
                setLabelsText("Собствен капитал", "Обща сума на пасивите");
            }

            if (e.getSource().equals(radioButton6)) {
                clear();
                setLabelsText("Входящ паричен поток", "Изходящ паричен поток");
            }

            if (e.getSource().equals(calculate)) {
                calculate();
            }
            if (e.getSource().equals(clear)) {
                clear();
            }
        }

    }


}
