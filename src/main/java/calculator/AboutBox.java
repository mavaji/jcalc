package calculator;

import java.awt.*;

/**
 * @author Vahid Mavaji
 * @version 1.0 2002
 */
public class AboutBox extends Dialog {
    AboutBox(Frame parent, String arg, boolean state) {
        super(parent, arg, state);
        setLayout(new FlowLayout());
        add(new Label("Java Based Calculator!"));
        add(new Label("Written BY Vahid Mavaji."));
        add(new Label("July 2002."));
        reshape(200, 200, 200, 130);
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