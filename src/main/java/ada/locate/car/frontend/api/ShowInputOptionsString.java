package ada.locate.car.frontend.api;

import javax.swing.*;

public abstract class ShowInputOptionsString {
    protected String title;
    protected String description;

    public ShowInputOptionsString(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String execute() {
        String[] options = description.split("\n");

        int selectedOption = JOptionPane.showOptionDialog(null, description,
                title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                options, options[0]);
        return selectedOption == JOptionPane.CLOSED_OPTION ? "" : options[selectedOption];
    }
}
