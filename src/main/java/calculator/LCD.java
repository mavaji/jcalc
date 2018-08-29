package calculator;

import java.awt.*;

/**
 * @author Vahid Mavaji
 * @version 1.0 2002
 */
public class LCD {
    private TextField lcd;
    private String string = "";
    private double number = 0;
    private double temp = 0;
    private char sign = ' ';
    private char lastsign = ' ';
    private double memory = 0;
    private int m = 0;

    LCD(Calculator parent) {
        lcd = new TextField(" ");
        lcd.setEditable(false);
        lcd.setText("0");
        parent.add("North", lcd);
    }

    public void setString(String s) {
        string = s;
    }

    public String getString() {
        return string;
    }

    public void process(String arg) {
        if (arg.equals("0")
                || arg.equals("1")
                || arg.equals("2")
                || arg.equals("3")
                || arg.equals("4")
                || arg.equals("5")
                || arg.equals("6")
                || arg.equals("7")
                || arg.equals("8")
                || arg.equals("9")
                || arg.equals(".")) {
            if (sign == ' ') {
                if (m != 1) {
                    string += arg;
                } else {
                    string = arg;
                    m = 0;
                }
            } else {
                string = arg;
                sign = ' ';
            }
            lcd.setText(string);
        } else if (arg.equals("+")
                || arg.equals("-")
                || arg.equals("*")
                || arg.equals("÷")
                || arg.equals("=")
                || arg.equals("M+")
                || arg.equals("M-")) {
            if (sign == ' ') {
                number = atoi(string);
                switch (lastsign) {
                    case '+':
                        temp += number;
                        break;
                    case '-':
                        temp -= number;
                        break;
                    case '*':
                        temp *= number;
                        break;
                    case '÷':
                        temp /= number;
                        break;

                    default:
                        temp = number;
                        break;
                }

                string = String.valueOf(temp);
                lcd.setText(string);
            }
            if (arg.equals("=") || arg.equals("M+") || arg.equals("M-")) {
                sign = 'e';
                lastsign = ' ';
                if (arg.equals("M+")) {
                    memory += temp;
                }
                if (arg.equals("M-")) {
                    memory -= temp;
                }
            } else {
                sign = lastsign = arg.charAt(0);
            }
        } else if (arg.equals("MR")) {
            string = String.valueOf(memory);
            lcd.setText(string);
            sign = ' ';
            m = 1;
        } else if (arg.equals("AC") || arg.equals("C")) {
            string = "";
            number = 0;
            temp = 0;
            sign = ' ';
            lastsign = ' ';
            lcd.setText("0");
            if (arg.equals("AC")) {
                memory = 0;
            }
        } else if (arg.equals("EXIT")) {
            System.exit(0);
        }
    }

    public double atoi(String s) {
        int p = 0;
        double n = 0;
        double d = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case '0':
                    d = 0;
                    break;
                case '1':
                    d = 1;
                    break;
                case '2':
                    d = 2;
                    break;
                case '3':
                    d = 3;
                    break;
                case '4':
                    d = 4;
                    break;
                case '5':
                    d = 5;
                    break;
                case '6':
                    d = 6;
                    break;
                case '7':
                    d = 7;
                    break;
                case '8':
                    d = 8;
                    break;
                case '9':
                    d = 9;
                    break;
                case '.':
                    n = n * Math.pow(10, -p);
                    p = 0;
                    continue;

            }

            n += d * Math.pow(10, p);
            p++;
        }
        return n;
    }

}
