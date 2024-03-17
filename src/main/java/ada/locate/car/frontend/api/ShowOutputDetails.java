package ada.locate.car.frontend.api;

import javax.swing.*;

public abstract class ShowOutputDetails {
    protected String title;

    public ShowOutputDetails(String title) {
        this.title = title;
    }

    public void execute(String message) {
        JOptionPane.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }
}
