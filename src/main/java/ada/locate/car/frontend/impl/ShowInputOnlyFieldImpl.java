package ada.locate.car.frontend.impl;

import ada.locate.car.frontend.api.Input;

import javax.swing.*;

public class ShowInputOnlyFieldImpl implements Input<String> {

    @Override
    public String execute(String title, String description) {
        JTextField inputField = new JTextField(1);

        int result = JOptionPane.showConfirmDialog(null, new Object[]{description, inputField}, title, JOptionPane.OK_CANCEL_OPTION);

        return result == JOptionPane.OK_OPTION ? inputField.getText() : null;
    }
}