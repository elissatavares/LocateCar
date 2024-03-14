package ada.locate.car.app;

import ada.locate.car.app.menu.ClientMenu;
import ada.locate.car.app.menu.Menu;
import ada.locate.car.app.messages.MessagesApp;
import ada.locate.car.app.menu.VehicleMenu;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.controller.impl.client.*;
import ada.locate.car.controller.impl.vehicle.CreateVehicleControllerImpl;
import ada.locate.car.controller.impl.vehicle.DeleteVehicleControllerImpl;
import ada.locate.car.controller.impl.vehicle.UpdateVehicleControllerImpl;
import ada.locate.car.core.model.Client;
import ada.locate.car.core.model.Vehicle;
import ada.locate.car.core.usecase.*;
import ada.locate.car.infra.api.Repository;
import ada.locate.car.infra.dto.ClientDTO;
import ada.locate.car.infra.dto.VehicleDTO;
import ada.locate.car.infra.repository.ClientRepository;
import ada.locate.car.infra.repository.VehicleRepository;
import ada.locate.car.service.client.CreateClientService;
import ada.locate.car.service.client.DeleteClientService;
import ada.locate.car.service.client.UpdateClientService;
import ada.locate.car.service.vehicle.CreateVehicleService;
import ada.locate.car.service.vehicle.DeleteVehicleService;
import ada.locate.car.service.vehicle.UpdateVehicleService;
import ada.locate.car.frontend.api.Input;
import ada.locate.car.frontend.api.Output;
import ada.locate.car.frontend.impl.*;

import javax.swing.*;

public class LocateCar {
    public static void run() {
        Repository<Client> clientRepository = ClientRepository.getInstance();
        Repository<Vehicle> vehicleRepository = VehicleRepository.getInstance();


        Input<Integer> inputOptionInt = new ShowInputOptionsIntImpl();
        Input<String[]> inputMultipleFields = new ShowInputMultipleFieldsImpl();
        Input<String> inputOnlyField = new ShowInputOnlyFieldImpl();
        Input<String> inputOptionString = new ShowInputOptionsStringImpl();

        Input<String> inputCPF = new CPFInput();
        Input<String> inputCNPJ = new CNPJInput();

        Output showInformation = new ShowInformationOutputImpl();


        CreateVehicle createVehicleService = new CreateVehicleService(vehicleRepository);
        UpdateVehicle updateVehicleService = new UpdateVehicleService(vehicleRepository);
        DeleteVehicle deleteVehicleService = new DeleteVehicleService(vehicleRepository);

        CreateClient createClientService = new CreateClientService(clientRepository);
        UpdateClient updateClientService = new UpdateClientService(clientRepository);
        DeleteClient deleteClientService = new DeleteClientService(clientRepository);
//        UpdateClient updateClientService = new UpdateClientService();

        Controller createVehicle = new CreateVehicleControllerImpl(inputOptionString, inputMultipleFields, showInformation, createVehicleService);
        Controller updateVehicle = new UpdateVehicleControllerImpl(inputMultipleFields, showInformation, updateVehicleService);
        Controller deleteVehicle = new DeleteVehicleControllerImpl(inputOnlyField, showInformation, deleteVehicleService);

        Controller createClientCPF = new CreateClientCPFControllerImpl(inputMultipleFields, showInformation, inputCPF, createClientService);
        Controller createClientCNPJ = new CreateClientCNPJControllerImpl(inputMultipleFields, showInformation, inputCNPJ, createClientService);
        Controller deleteClientCPF = new DeleteClientCPFControllerImpl(inputOnlyField, showInformation, deleteClientService);

        Controller updatedClientCPF = new UpdateClientCPFControllerImpl(inputMultipleFields, showInformation, updateClientService);
        Controller updatedClientCNPJ = new UpdateClientCNPJControllerImpl(inputMultipleFields, showInformation, updateClientService);


        Menu vehicleMenu = new VehicleMenu(inputOptionString, createVehicle, updateVehicle, deleteVehicle);
        Menu clientMenu = new ClientMenu(inputOptionString, createClientCPF,updatedClientCPF, createClientCNPJ, updatedClientCNPJ);

        JFrame frame = CreateFrame.execute();
        frame.setVisible(true);

        String option;
        do {
            //main menu
            //recebe de quem se trata a edição
            option = inputOptionString.execute(MessagesApp.MAIN_MENU.get(), MessagesApp.MAIN_OPTIONS_MENU.get());

            if(!option.isEmpty()){
                //direciona para o menu com as opções específicas de Client, Vehicle ou Alocation
                switch (option){
                    case "Client" -> clientMenu.run();
                    case "Vehicle" -> vehicleMenu.run();
                    //Alocation
                    // case 3 -> AlocationMenu.run();
                }
            }
        } while (!option.isEmpty());

        frame.dispose();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
