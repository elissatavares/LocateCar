package ada.locate.car.app;

import ada.locate.car.controller.api.Controller;
// import ada.locate.car.controller.impl.client.CreateClientCNPJ;
import ada.locate.car.controller.impl.vehicle.CreateVehicleControllerImpl;
import ada.locate.car.controller.impl.client.CreateClientCPFControllerImpl;
//import ada.locate.car.controller.impl.vehicle.CreateVehicleControllerImpl;
import ada.locate.car.infra.data.base.ClientCPFBase;
import ada.locate.car.infra.data.base.VehicleBase;
import ada.locate.car.infra.repository.ClientCPFRepository;
import ada.locate.car.infra.repository.VehicleRepository;
import ada.locate.car.infra.repository.api.Repository;
import ada.locate.car.model.ClientCPF;
import ada.locate.car.model.Vehicle;
import ada.locate.car.swing.api.Input;
import ada.locate.car.swing.api.Output;
import ada.locate.car.swing.impl.*;

import javax.swing.*;

public class LocateCar {
    public static void run() {

        Repository<ClientCPF> clientCPFRepository = new ClientCPFRepository(ClientCPFBase.getInstance());
        Repository<Vehicle> vehicleRepository = new VehicleRepository(VehicleBase.getInstance());

        Input<Integer> inputOptionInt = new ShowInputOptionsIntImpl();
        Input<String[]> inputMultipleFields = new ShowInputMultipleFieldsImpl();
        Input<String> inputOptionString = new ShowInputOptionsStringImpl();
        Input<String> inputCPF = new CPFInput();
        Output showInformation = new ShowInformationOutputImpl();

        Controller createVehicle = new CreateVehicleControllerImpl(inputOptionString, inputMultipleFields, showInformation);
        Controller createClientCPF = new CreateClientCPFControllerImpl(inputMultipleFields, showInformation, inputCPF);

        JFrame frame = CreateFrame.execute();
        frame.setVisible(true);

        createVehicle.execute();
        createClientCPF.execute();
        frame.dispose();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
