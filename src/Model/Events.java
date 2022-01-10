package Model;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class Events {

    public void textKeyPress(KeyEvent evt) {

        char ch = evt.getKeyChar();
        if ((ch < 'a' || ch > 'z') && (ch < 'A' || ch > 'Z')
                && (ch!= (char) KeyEvent.VK_BACK_SPACE) && (ch != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }

    public void numberKeyPress(KeyEvent evt) {

        char ch = evt.getKeyChar();
        if ((ch < '0' || ch > '9') && (ch != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }

    public void numberDecimalKeyPress(KeyEvent evt, JTextField textField) {

        char ch = evt.getKeyChar();
        if ((ch < '0' || ch > '9') && textField.getText().contains(".") && (ch != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        } else if ((ch < '0' || ch > '9') && (ch != '.') && (ch != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }
}
