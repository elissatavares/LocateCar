package ada.locate.car.frontend.api;

import javax.swing.*;

public abstract class ShowInputOnlyField {
    protected final String title;
    protected final String description;

    public ShowInputOnlyField(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String execute() {
        JTextField inputField = new JTextField(1);

        int result = JOptionPane.showConfirmDialog(null, new Object[]{description, inputField}, title, JOptionPane.OK_CANCEL_OPTION);

        return result == JOptionPane.OK_OPTION ? inputField.getText() : null;
    }
}
