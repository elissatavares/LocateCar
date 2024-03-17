package ada.locate.car.frontend.api;

import javax.swing.*;

public abstract class ShowInputMultipleFields {
    protected String title;
    protected String description;
    public ShowInputMultipleFields(String title, String description) {
        this.title = title;
        this.description = description;
    }
    public String[] execute() {
        String[] fieldNames = description.split("\n");
        String[] inputs = new String[fieldNames.length];

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        for (String fieldName : fieldNames) {
            JPanel fieldPanel = new JPanel();
            JLabel label = new JLabel(fieldName);
            JTextField textField = new JTextField(20);
            fieldPanel.add(label);
            fieldPanel.add(textField);
            panel.add(fieldPanel);
        }

        int result = JOptionPane.showConfirmDialog(null, panel, title, JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            for (int i = 0; i < fieldNames.length; i++) {
                inputs[i] = ((JTextField) ((JPanel) panel.getComponent(i)).getComponent(1)).getText();
            }
            return inputs;
        }
        return null;
    }
}
