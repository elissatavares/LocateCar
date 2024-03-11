package ada.locate.car.swing.impl;

import ada.locate.car.swing.api.Input;

import javax.swing.*;

public class ShowInputOptionsStringImpl implements Input<String> {
    @Override
    public String execute(String title, String menu) {
        String[] options = menu.split("\n");

        int selectedOption = JOptionPane.showOptionDialog(null, menu,
                title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                options, options[0]);

        return selectedOption == -1 ? null : options[selectedOption];
    }
}

