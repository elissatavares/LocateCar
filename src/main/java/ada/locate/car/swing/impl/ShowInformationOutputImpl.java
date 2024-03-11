package ada.locate.car.swing.impl;

import ada.locate.car.swing.api.Output;

import javax.swing.*;

public class ShowInformationOutputImpl implements Output {

    @Override
    public void execute(String message, String title) {
        JOptionPane.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }
}