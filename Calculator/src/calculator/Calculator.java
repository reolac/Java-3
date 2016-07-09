package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Creates the User Interface, and ActionListeners for the Calculator and
 * displays them on the screen, this class calls upon Logic.java to do the
 * arithmetic for each of the buttons and actions
 *
 * @author Michael
 * @since 13/11/2014
 * @version 3.23
 */
public class Calculator {

    private static double number;
    private static double memory;

    private static String clipBoard;

    /**
     * Flag to know if the clipBoard is empty or not
     */
    public static boolean pasteFlag = false;

    /**
     * Flag to know if digit grouping is currently selected or not
     */
    public static boolean digitFlag = false;

    /**
     * Creates the JFrame, JPanels, JButtons, JTextField, JMenu and
     * ActionListeners and attaches them respectively.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(225, 325);
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JButton backspace = new JButton("Backspace");
        backspace.setFont(new Font("Arial", Font.BOLD, 10));
        backspace.setForeground(Color.RED);
        final JButton ce = new JButton("CE");
        ce.setFont(new Font("Arial", Font.BOLD, 10));
        ce.setForeground(Color.RED);
        final JButton c = new JButton("C");
        c.setFont(new Font("Arial", Font.BOLD, 10));
        c.setForeground(Color.RED);

        final JButton mc = new JButton("MC");
        mc.setFont(new Font("Arial", Font.BOLD, 10));
        mc.setForeground(Color.RED);
        final JButton mr = new JButton("MR");
        mr.setFont(new Font("Arial", Font.BOLD, 10));
        mr.setForeground(Color.RED);
        final JButton ms = new JButton("MS");
        ms.setFont(new Font("Arial", Font.BOLD, 10));
        ms.setForeground(Color.RED);
        final JButton mplus = new JButton("M+");
        mplus.setFont(new Font("Arial", Font.BOLD, 10));
        mplus.setForeground(Color.RED);

        final JButton seven = new JButton("7");
        seven.setFont(new Font("Arial", Font.BOLD, 10));
        seven.setForeground(Color.BLUE);
        final JButton eight = new JButton("8");
        eight.setFont(new Font("Arial", Font.BOLD, 10));
        eight.setForeground(Color.BLUE);
        final JButton nine = new JButton("9");
        nine.setFont(new Font("Arial", Font.BOLD, 10));
        nine.setForeground(Color.BLUE);
        final JButton divide = new JButton("/");
        divide.setFont(new Font("Arial", Font.BOLD, 10));
        divide.setForeground(Color.RED);
        final JButton sqrt = new JButton("sqrt");
        sqrt.setFont(new Font("Arial", Font.BOLD, 10));
        sqrt.setForeground(Color.BLUE);

        final JButton four = new JButton("4");
        four.setFont(new Font("Arial", Font.BOLD, 10));
        four.setForeground(Color.BLUE);
        final JButton five = new JButton("5");
        five.setFont(new Font("Arial", Font.BOLD, 10));
        five.setForeground(Color.BLUE);
        final JButton six = new JButton("6");
        six.setFont(new Font("Arial", Font.BOLD, 10));
        six.setForeground(Color.BLUE);
        final JButton times = new JButton("*");
        times.setFont(new Font("Arial", Font.BOLD, 10));
        times.setForeground(Color.RED);
        final JButton percent = new JButton("%");
        percent.setFont(new Font("Arial", Font.BOLD, 10));
        percent.setForeground(Color.BLUE);

        final JButton one = new JButton("1");
        one.setFont(new Font("Arial", Font.BOLD, 10));
        one.setForeground(Color.BLUE);
        final JButton two = new JButton("2");
        two.setFont(new Font("Arial", Font.BOLD, 10));
        two.setForeground(Color.BLUE);
        final JButton three = new JButton("3");
        three.setFont(new Font("Arial", Font.BOLD, 10));
        three.setForeground(Color.BLUE);
        final JButton minus = new JButton("-");
        minus.setFont(new Font("Arial", Font.BOLD, 10));
        minus.setForeground(Color.RED);
        final JButton reciprocal = new JButton("1/x");
        reciprocal.setFont(new Font("Arial", Font.BOLD, 10));
        reciprocal.setForeground(Color.BLUE);

        final JButton zero = new JButton("0");
        zero.setFont(new Font("Arial", Font.BOLD, 10));
        zero.setForeground(Color.BLUE);
        final JButton invert = new JButton("+/-");
        invert.setFont(new Font("Arial", Font.BOLD, 10));
        invert.setForeground(Color.BLUE);
        final JButton decimal = new JButton(".");
        decimal.setFont(new Font("Arial", Font.BOLD, 10));
        decimal.setForeground(Color.BLUE);
        final JButton plus = new JButton("+");
        plus.setFont(new Font("Arial", Font.BOLD, 10));
        plus.setForeground(Color.RED);
        final JButton equals = new JButton("=");
        equals.setFont(new Font("Arial", Font.BOLD, 10));
        equals.setForeground(Color.BLUE);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1, 3));
        topPanel.add(backspace);
        topPanel.add(ce);
        topPanel.add(c);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(4, 1));
        leftPanel.add(mc);
        leftPanel.add(mr);
        leftPanel.add(ms);
        leftPanel.add(mplus);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(4, 5));
        rightPanel.add(seven);
        rightPanel.add(eight);
        rightPanel.add(nine);
        rightPanel.add(divide);
        rightPanel.add(sqrt);
        rightPanel.add(four);
        rightPanel.add(five);
        rightPanel.add(six);
        rightPanel.add(times);
        rightPanel.add(percent);
        rightPanel.add(one);
        rightPanel.add(two);
        rightPanel.add(three);
        rightPanel.add(minus);
        rightPanel.add(reciprocal);
        rightPanel.add(zero);
        rightPanel.add(invert);
        rightPanel.add(decimal);
        rightPanel.add(plus);
        rightPanel.add(equals);

        JMenuBar menuBar = new JMenuBar();

        JMenu edit = new JMenu("Edit");
        JMenu view = new JMenu("View");
        JMenu help = new JMenu("Help");
        final JMenuItem copy = new JMenuItem("Copy");
        final JMenuItem paste = new JMenuItem("Paste");
        JMenuItem standard = new JMenuItem("Standard");
        JMenuItem scientific = new JMenuItem("Scientific");
        final JMenuItem digitGrouping = new JMenuItem("Digit grouping");
        final JMenuItem helpTopics = new JMenuItem("Help Topics");
        final JMenuItem aboutCalculator = new JMenuItem("About Calculator");
        edit.add(copy);
        edit.add(paste);
        paste.setEnabled(false);

        view.add(standard);
        view.add(scientific);
        view.addSeparator();
        view.add(digitGrouping);
        help.add(helpTopics);
        help.addSeparator();
        help.add(aboutCalculator);
        menuBar.add(edit);
        menuBar.add(view);
        menuBar.add(help);

        frame.setJMenuBar(menuBar);

        JPanel field = new JPanel();
        field.setLayout(new GridLayout(1, 1));
        final JTextField textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        field.add(textField, BorderLayout.NORTH);

        JPanel buttons = new JPanel();

        buttons.add(leftPanel);
        buttons.add(rightPanel);

        frame.add(buttons, BorderLayout.SOUTH);
        frame.add(topPanel, BorderLayout.EAST);

        frame.add(field, BorderLayout.NORTH);
        class ButtonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {

                if (event.getSource() == zero) {
                    number = Logic.getNumber(0);

                    if (number % 1 == 0) {
                        textField.setText(String.valueOf((int) number));
                    } else {
                        textField.setText(String.valueOf(number));
                    }

                }
                if (event.getSource() == one) {
                    number = Logic.getNumber(1);

                    if (number % 1 == 0) {
                        textField.setText(String.valueOf((int) number));
                    } else {
                        textField.setText(String.valueOf(number));
                    }

                }
                if (event.getSource() == two) {
                    number = Logic.getNumber(2);

                    if (number % 1 == 0) {
                        textField.setText(String.valueOf((int) number));
                    } else {
                        textField.setText(String.valueOf(number));
                    }

                }
                if (event.getSource() == three) {
                    number = Logic.getNumber(3);

                    if (number % 1 == 0) {
                        textField.setText(String.valueOf((int) number));
                    } else {
                        textField.setText(String.valueOf(number));
                    }

                }
                if (event.getSource() == four) {
                    number = Logic.getNumber(4);

                    if (number % 1 == 0) {
                        textField.setText(String.valueOf((int) number));
                    } else {
                        textField.setText(String.valueOf(number));
                    }

                }
                if (event.getSource() == five) {
                    number = Logic.getNumber(5);

                    if (number % 1 == 0) {
                        textField.setText(String.valueOf((int) number));
                    } else {
                        textField.setText(String.valueOf(number));
                    }

                }
                if (event.getSource() == six) {
                    number = Logic.getNumber(6);

                    if (number % 1 == 0) {
                        textField.setText(String.valueOf((int) number));
                    } else {
                        textField.setText(String.valueOf(number));
                    }

                }
                if (event.getSource() == seven) {
                    number = Logic.getNumber(7);

                    if (number % 1 == 0) {
                        textField.setText(String.valueOf((int) number));
                    } else {
                        textField.setText(String.valueOf(number));
                    }

                }
                if (event.getSource() == eight) {
                    number = Logic.getNumber(8);

                    if (number % 1 == 0) {
                        textField.setText(String.valueOf((int) number));
                    } else {
                        textField.setText(String.valueOf(number));
                    }

                }
                if (event.getSource() == nine) {
                    number = Logic.getNumber(9);

                    if (number % 1 == 0) {
                        textField.setText(String.valueOf((int) number));
                    } else {
                        textField.setText(String.valueOf(number));
                    }

                }

                if (event.getSource() == invert) {
                    number = Logic.invertNumber(number);

                    if (number % 1 == 0) {
                        textField.setText(String.valueOf((int) number));
                    } else {
                        textField.setText(String.valueOf(number));
                    }

                }

                if (event.getSource() == decimal && Logic.decimalFlag == false) {
                    Logic.decimalFlag = true;
                    if (number % 1 == 0) {
                        textField.setText(String.valueOf((int) number));
                    } else {
                        textField.setText(String.valueOf(number));
                    }

                }
                if (event.getSource() == plus) {
                    number = Logic.plus(number);
                    Logic.total = 0;
                    Logic.size = 0;

                    if (number % 1 == 0) {
                        textField.setText(String.valueOf((int) number));
                    } else {
                        textField.setText(String.valueOf(number));
                    }

                }
                if (event.getSource() == minus) {
                    number = Logic.minus(number);
                    Logic.total = 0;
                    Logic.size = 0;

                    if (number % 1 == 0) {
                        textField.setText(String.valueOf((int) number));
                    } else {
                        textField.setText(String.valueOf(number));
                    }

                }

                if (event.getSource() == times) {
                    number = Logic.times(number);
                    Logic.total = 0;
                    Logic.size = 0;

                    if (number % 1 == 0) {
                        textField.setText(String.valueOf((int) number));
                    } else {
                        textField.setText(String.valueOf(number));
                    }

                }

                if (event.getSource() == divide) {

                    number = Logic.divide(number);

                    Logic.total = 0;
                    Logic.size = 0;

                    if (number % 1 == 0) {
                        textField.setText(String.valueOf((int) number));
                    } else {
                        textField.setText(String.valueOf(number));
                    }

                }
                if (event.getSource() == sqrt) {
                    number = Logic.sqrt(number);

                    Logic.total = 0;
                    Logic.size = 0;

                    if (number % 1 == 0) {
                        textField.setText(String.valueOf((int) number));
                    } else {
                        textField.setText(String.valueOf(number));
                    }
                }

                if (event.getSource() == percent) {
                    number = Logic.percent(number);

                    Logic.total = 0;
                    Logic.size = 0;

                    if (number % 1 == 0) {
                        textField.setText(String.valueOf((int) number));
                    } else {
                        textField.setText(String.valueOf(number));
                    }
                }

                if (event.getSource() == reciprocal) {
                    number = Logic.reciprocal(number);

                    Logic.total = 0;
                    Logic.size = 0;

                    if (number % 1 == 0) {
                        textField.setText(String.valueOf((int) number));
                    } else {
                        textField.setText(String.valueOf(number));
                    }
                }
                if (event.getSource() == equals) {
                    number = Logic.equals(number);

                    Logic.total = 0;
                    Logic.size = 0;

                    if (number % 1 == 0) {
                        textField.setText(String.valueOf((int) number));
                    } else {
                        textField.setText(String.valueOf(number));
                    }
                }

                if (event.getSource() == copy) {
                    clipBoard = textField.getText();

                    if (pasteFlag == false) {
                        paste.setEnabled(false);
                    } else {
                        System.out.println(clipBoard);
                        paste.setEnabled(true);
                    }
                }

                if (event.getSource() == copy) {
                    clipBoard = textField.getText();

                    if (pasteFlag == false) {
                        paste.setEnabled(false);
                    } else {
                        paste.setEnabled(true);
                    }
                }

                if (event.getSource() == paste) {
                    textField.setText(clipBoard);
                    number = Double.parseDouble(clipBoard);

                    if (pasteFlag == false) {

                        paste.setEnabled(false);
                    } else {
                        paste.setEnabled(true);

                    }

                }

                if (event.getSource() == backspace) {
                    if (number % 1 == 0) {
                        number = Logic.backSpace(number);
                        textField.setText(String.valueOf((int) number));
                    } else {
                        System.out.println("DECIMAL");
                        number = Logic.backSpace(number);
                        textField.setText(String.valueOf(number));
                    }
                }

                if (event.getSource() == ce) {
                    {
                        number = Logic.reset(number);
                        textField.setText(String.valueOf((int) (number)));
                    }
                }

                if (event.getSource() == c) {
                    {
                        Logic.reset(number);
                        Logic.op1 = 0;
                        number = 0;
                        Logic.total = 0;
                        textField.setText(String.valueOf((int) (number)));
                    }
                }

                if (event.getSource() == mc) {
                    {
                        memory = 0;
                        if (number % 1 == 0) {
                            textField.setText(String.valueOf((int) number));
                        } else {
                            textField.setText(String.valueOf(number));
                        }
                    }
                }

                if (event.getSource() == mr) {
                    {
                        number = memory;
                        Logic.total = memory;
                        if (number % 1 == 0) {
                            textField.setText(String.valueOf((int) number));
                        } else {
                            textField.setText(String.valueOf(number));
                        }
                    }
                }
                if (event.getSource() == ms) {
                    {
                        memory = number;
                        if (number % 1 == 0) {
                            textField.setText(String.valueOf((int) number));
                        } else {
                            textField.setText(String.valueOf(number));
                        }
                    }
                }

                if (event.getSource() == mplus) {
                    {
                        memory = memory + number;
                        if (number % 1 == 0) {
                            textField.setText(String.valueOf((int) number));
                        } else {
                            textField.setText(String.valueOf(number));
                        }
                    }
                }

                if (event.getSource() == digitGrouping) {
                    {
                        String formatted;
                        if (digitFlag == false) {
                            if (number % 1 == 0) {
                                formatted = String.format("%,d", (int) number);
                            } else {
                                formatted = String.format("%,d", number);
                            }

                            textField.setText(formatted);

                            digitFlag = true;
                        } else {
                            if (number % 1 == 0) {
                                textField.setText(String.valueOf((int) number));
                            } else {
                                textField.setText(String.valueOf(number));
                            }
                            digitFlag = false;
                        }
                    }
                }

                if (event.getSource() == aboutCalculator) {
                    JDialog about = new JDialog();
                    JLabel label1 = new JLabel("<html>Java Calculator<br>By Michael Smith<br>Version 3.23<br>12/11/2014<br>Created for educational purposes"
                            + "</html>");

                    about.setTitle("About Calculator");

                    about.setLocationRelativeTo(c);
                    about.add(label1);

                    about.pack();
                    about.setVisible(true);
                }
                if (event.getSource() == helpTopics) {

                    BufferedReader in = null;
                    try {
                        JDialog help = new JDialog();

                        help.setTitle("Help Topics");

                        help.setLocationRelativeTo(c);

                        help.setVisible(true);
                        JTextArea text = new JTextArea();
                        text.setEditable(false);
                        help.add(text);

                        in = new BufferedReader(new FileReader("helpTopics.txt"));
                        String line = in.readLine();
                        while (line != null) {
                            text.append(line + "\n");
                            help.add(text);
                            line = in.readLine();

                        }
                        help.pack();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            in.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Calculator.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }

        ActionListener listener = new ButtonListener();
        zero.addActionListener(listener);
        one.addActionListener(listener);
        two.addActionListener(listener);
        three.addActionListener(listener);
        four.addActionListener(listener);
        five.addActionListener(listener);
        six.addActionListener(listener);
        seven.addActionListener(listener);
        eight.addActionListener(listener);
        nine.addActionListener(listener);

        equals.addActionListener(listener);

        invert.addActionListener(listener);
        decimal.addActionListener(listener);

        plus.addActionListener(listener);
        minus.addActionListener(listener);
        times.addActionListener(listener);
        divide.addActionListener(listener);

        sqrt.addActionListener(listener);
        percent.addActionListener(listener);
        reciprocal.addActionListener(listener);

        backspace.addActionListener(listener);
        ce.addActionListener(listener);
        c.addActionListener(listener);

        mc.addActionListener(listener);
        mr.addActionListener(listener);
        ms.addActionListener(listener);
        mplus.addActionListener(listener);

        digitGrouping.addActionListener(listener);

        helpTopics.addActionListener(listener);
        aboutCalculator.addActionListener(listener);

        copy.addActionListener(listener);
        paste.addActionListener(listener);
        frame.pack();

        frame.setVisible(true);
    }
}
