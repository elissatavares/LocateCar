package ada.locate.car.frontend.impl;

import ada.locate.car.frontend.api.Input;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class CPFInput implements Input<String> {
    @Override
    public String execute(String title, String description) {
        JFormattedTextField inputField = new JFormattedTextField(createFormatter("###.###.###-##"));

        int result = JOptionPane.showConfirmDialog(null, new Object[]{description, inputField}, title, JOptionPane.OK_CANCEL_OPTION);

        return result == JOptionPane.OK_OPTION ? inputField.getText() : null;
    }

    private MaskFormatter createFormatter(String mask) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(mask);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return formatter;
    }

}
