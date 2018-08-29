package calculator;

import java.awt.*;
import java.util.Date;

/**
 * @author Vahid Mavaji
 * @version 1.0 2002
 */
public class TimeBox extends Dialog {
    Date d = new Date();
    TextField p = new TextField("");

    public TimeBox(Frame parent, String arg, boolean state) {
        super(parent, arg, state);
        setBounds(200, 200, 100, 60);
        p.setEditable(false);
        add(p);
        Time time = new Time(p, d.toString());
        time.start();
        setVisible(true);
    }

    public boolean handleEvent(Event evt) {
        if (evt.id == Event.WINDOW_DESTROY && evt.target == this) {
            dispose();
        } else {
            return super.handleEvent(evt);
        }
        return true;
    }
}