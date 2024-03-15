package ada.locate.car.backup.frontend.impl;

import ada.locate.car.backup.frontend.api.Input;

import javax.swing.*;

public class ShowInputOptionsStringImpl implements Input<String> {
    @Override
    public String execute(String title, String menu) {
        String[] options = menu.split("\n");

        int selectedOption = JOptionPane.showOptionDialog(null, menu,
                title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                options, options[0]);
        return selectedOption == JOptionPane.CLOSED_OPTION ? "" : options[selectedOption];
    }
}

