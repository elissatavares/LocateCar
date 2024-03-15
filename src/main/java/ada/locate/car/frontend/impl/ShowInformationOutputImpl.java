package ada.locate.car.frontend.impl;

import ada.locate.car.frontend.api.Output;

import javax.swing.*;

public class ShowInformationOutputImpl implements Output {

    @Override
    public void execute(String title, String message) {
        JOptionPane.showConfirmDialog(null, message, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }
}
