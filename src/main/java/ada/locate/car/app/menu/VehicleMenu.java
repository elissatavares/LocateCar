package ada.locate.car.app.menu;

import ada.locate.car.app.messages.MessagesVehicle;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.frontend.api.Input;

public class VehicleMenu implements Menu {
    private final Input<String> inputOptionString;
    private final Controller createVehicle;
    private final Controller updateVehicle;
    private final Controller deleteVehicle;

    public VehicleMenu(Input<String> inputOptionString, Controller createVehicle, Controller updateVehicle, Controller deleteVehicle) {
        this.inputOptionString = inputOptionString;
        this.createVehicle = createVehicle;
        this.updateVehicle = updateVehicle;
        this.deleteVehicle = deleteVehicle;
    }


    @Override
    public void run() {
        String option = inputOptionString.execute(MessagesVehicle.MENU_VEHICLE.get(), MessagesVehicle.OPTION_VEHICLE.get());

        if (option.isEmpty()) {
            return;
        }
        switch (option.toLowerCase().trim()) {
            case "create" -> createVehicle.execute();
            case "update" -> updateVehicle.execute();
            case "delete" -> deleteVehicle.execute();
        }
    }
}
