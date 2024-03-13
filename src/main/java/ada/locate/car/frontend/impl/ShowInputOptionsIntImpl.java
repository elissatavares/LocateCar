package ada.locate.car.frontend.impl;

import ada.locate.car.frontend.api.Input;

import javax.swing.*;

public class ShowInputOptionsIntImpl implements Input<Integer> {
    @Override
    public Integer execute(String title, String menu) {
        String[] options = menu.split("\n");

        int selectedOption = JOptionPane.showOptionDialog(null, menu,
                title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                options, options[0]);

        return selectedOption == JOptionPane.CLOSED_OPTION ? null : selectedOption + 1;
    }
}
