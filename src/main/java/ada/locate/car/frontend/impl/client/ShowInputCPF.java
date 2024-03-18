package ada.locate.car.frontend.impl.client;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class ShowInputCPF {

    private String title;
    private String description;

    public ShowInputCPF(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String execute() {
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
