package calculator;

import java.awt.*;

/**
 * @author Vahid Mavaji
 * @version 1.0 2002
 */
public class Calculator extends Frame {
    private Button[] buttons = new Button[25];
    LCD t = new LCD(this);

    public Calculator() {
        setTitle("Calculator.");

        MenuBar mbr = new MenuBar();
        Menu mn = new Menu("Help");
        mn.add(new MenuItem("About"));
        mn.addSeparator();
        mn.add(new MenuItem("Time"));
        mbr.add(mn);
        setMenuBar(mbr);

        String[] labels = {"÷", "MR", "M-", "M+", "EXIT",
                "\u221A", "7", "8", "9", "÷",
                "%", "4", "5", "6", "*",
                "C", "1", "2", "3", "-",
                "AC", "0", ".", "=", "+"};


        for (int i = 0; i <= 24; i++) {
            buttons[i] = new Button(labels[i]);
        }

        Panel p = new Panel();
        p.setLayout(new GridLayout(5, 5));
        for (int i = 0; i <= 24; i++) {
            p.add(buttons[i]);
        }
        add("Center", p);
    }

    public boolean handleEvent(Event evt) {
        if (evt.id == Event.WINDOW_DESTROY && evt.target == this) {
            System.exit(0);
        }
        return super.handleEvent(evt);
    }

    public boolean action(Event evt, Object arg) {
        if (evt.target instanceof Button) {
            t.process((String) arg);
        } else if (evt.target instanceof MenuItem) {
            if (arg.equals("About")) {
                AboutBox dlg = new AboutBox(this, "About...", true);
                dlg.show();
            } else if (arg.equals("Time")) {
                new TimeBox(this, "Time...", false);
            }
        } else {
            return super.action(evt, arg);
        }
        return true;
    }

    public static void main(String args[]) {
        Frame f = new Calculator();
        f.setBounds(150, 150, 300, 230);
        f.setVisible(true);
    }
}






