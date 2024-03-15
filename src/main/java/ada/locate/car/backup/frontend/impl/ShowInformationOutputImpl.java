package ada.locate.car.backup.frontend.impl;

import ada.locate.car.backup.frontend.api.Output;

import javax.swing.*;

public class ShowInformationOutputImpl implements Output {

    @Override
    public void execute(String title, String message) {
        JOptionPane.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }
}
