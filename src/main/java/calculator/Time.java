package calculator;

import java.awt.*;
import java.util.Date;

/**
 * @author Vahid Mavaji
 * @version 1.0 2002
 */
public class Time extends Thread {
    Date d;
    TextField t;

    Time(TextField p, String arg) {
        t = new TextField(arg);
        t = p;
    }

    public void run() {
        while (true) {
            draw();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public void draw() {
        d = new Date();
        String s = new String(d.toString());
        s = "     " + s.substring(10, 19);
        t.setText(s);
    }
}