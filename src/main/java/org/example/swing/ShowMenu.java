package org.example.swing;

import javax.swing.*;

public class ShowMenu implements Input<Integer>{
    @Override
    public Integer execute(String title, String menu) {
        String menuOptions = menu + "\nEXIT";
        String[] options = menuOptions.split("\n");

        int selectedOption = JOptionPane.showOptionDialog(null, menu,
                title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                options, options[0]);

        return selectedOption == options.length - 1 ? -1 : selectedOption + 1;
    }
}
