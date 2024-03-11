package ada.locate.car.app.menu;

import ada.locate.car.app.messages.MessagesVehicle;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.swing.api.Input;

public class VehicleMenu implements Menu {
    private final Input<Integer> inputOptionInt;
    private final Controller createVehicle;

    public VehicleMenu(Input<Integer> inputOptionInt, Controller createVehicle) {
        this.inputOptionInt = inputOptionInt;
        this.createVehicle = createVehicle;
    }

    @Override
    public void run() {
        //recebe a escolha de uma das opções específicas do menu de vehicle
        Integer option = inputOptionInt.execute(MessagesVehicle.MENU_VEHICLE.get(), MessagesVehicle.OPTION_VEHICLE.get());
        if (option == null) {
            return;
        }
        switch (option) {
            case 1 -> createVehicle.execute();
//            case 2 -> delete.execute();
//            case 3 -> searchByModel();
//            case 4 -> searchByPlate.execute();
        }
    }
}
