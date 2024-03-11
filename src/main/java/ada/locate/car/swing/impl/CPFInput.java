package ada.locate.car.swing.impl;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class CPFInput extends JPanel {
    private JFormattedTextField cpfField;
    private JButton submitButton;
    public CPFInput() {
        try {
            MaskFormatter cpfFormatter = new MaskFormatter("###.###.###-##");
            cpfField = new JFormattedTextField(cpfFormatter);
            cpfField.setColumns(12);

            submitButton = new JButton("Submit");

            add(new JLabel("CPF:"));
            add(cpfField);
            add(submitButton);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public JFormattedTextField getCpfField() {
        return cpfField;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }
}
