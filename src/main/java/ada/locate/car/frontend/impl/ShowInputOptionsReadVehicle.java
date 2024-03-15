package ada.locate.car.frontend.impl;

import ada.locate.car.app.messages.MessagesVehicle;
import ada.locate.car.frontend.api.Input;

import javax.swing.*;

public class ShowInputOptionsReadVehicle implements Input<String> {
    @Override
    public String execute() {
        String title = MessagesVehicle.MENU_READ_VEHICLE.get();
        String menu = MessagesVehicle.OPTION_READ.get();
        String[] options = menu.split("\n");

        int selectedOption = JOptionPane.showOptionDialog(null, menu,
                title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                options, options[0]);
        return selectedOption == JOptionPane.CLOSED_OPTION ? "" : options[selectedOption];
    }
}
