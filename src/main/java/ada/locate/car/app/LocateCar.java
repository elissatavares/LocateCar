package ada.locate.car.app;

import ada.locate.car.controller.api.Controller;
import ada.locate.car.controller.impl.client.CreateClientCNPJControllerImpl;
import ada.locate.car.controller.impl.client.CreateClientCPFControllerImpl;
//import ada.locate.car.controller.impl.vehicle.CreateVehicleControllerImpl;
import ada.locate.car.swing.api.Input;
import ada.locate.car.swing.api.Output;
import ada.locate.car.swing.impl.*;

import javax.swing.*;

public class LocateCar {
    public static void run() {

        Input<Integer> inputOptionInt = new ShowInputOptionsIntImpl();
        Input<String[]> inputMultipleFields = new ShowInputMultipleFieldsImpl();
        Input<String> inputOptionString = new ShowInputOptionsStringImpl();
        Output showInformation = new ShowInformationOutputImpl();

//        Controller createVehicle = new CreateVehicleControllerImpl(inputOptionString, inputMultipleFields, showInformation);
        Controller createClientCNPJ = new CreateClientCPFControllerImpl(inputOptionString, inputMultipleFields, showInformation);

        JFrame frame = CreateFrame.execute();
        frame.setVisible(true);
//        createVehicle.execute();
        createClientCNPJ.execute();

        frame.dispose();
    }
}