package ada.locate.car.app;

import ada.locate.car.app.config.vehicle.front.FrontConfigVehicle;

import ada.locate.car.app.menu.Menu;
import ada.locate.car.app.messages.MessagesApp;
import ada.locate.car.app.menu.VehicleMenu;
import ada.locate.car.app.config.vehicle.VehicleControllerConfig;
import ada.locate.car.app.config.vehicle.VehicleControllerImplConfig;
import ada.locate.car.app.config.vehicle.VehicleMenuConfig;
import ada.locate.car.app.config.vehicle.VehicleServiceConfig;
import ada.locate.car.app.messages.MessagesVehicle;

import ada.locate.car.controller.impl.vehicle.CreateVehicleControllerImpl;
import ada.locate.car.controller.impl.vehicle.DeleteVehicleControllerImpl;
import ada.locate.car.controller.impl.vehicle.ReadVehicleControllerImpl;
import ada.locate.car.controller.impl.vehicle.UpdateVehicleControllerImpl;
import ada.locate.car.core.model.Vehicle;

import ada.locate.car.frontend.impl.*;
import ada.locate.car.infra.api.Repository;
import ada.locate.car.infra.repository.VehicleRepository;
import ada.locate.car.service.vehicle.CreateVehicleService;
import ada.locate.car.service.vehicle.DeleteVehicleService;
import ada.locate.car.service.vehicle.ReadVehicleService;
import ada.locate.car.service.vehicle.UpdateVehicleService;

public class LocateCar {
    public static void run() {
        //Repository<Client> clientRepository = ClientRepository.getInstance();

        FrontConfigVehicle frontConfig = createFrontConfig2();
        VehicleServiceConfig vehicleServiceConfig = createVehicleServiceConfig();
        VehicleControllerImplConfig vehicleControllerImplConfig = vehicleControllerImplConfig(vehicleServiceConfig, frontConfig);
        VehicleControllerConfig vehicleControllerConfig = createVehicleControllerConfig(vehicleControllerImplConfig);
        VehicleMenuConfig vehicleMenuConfig = createVehicleMenuConfig(vehicleControllerConfig, frontConfig);
        Menu vehicleMenu = new VehicleMenu(vehicleMenuConfig);

//        Input<String[]> inputMultipleFields = new ShowInputMultipleFieldsImpl();
//        Input<String> inputOnlyField = new ShowInputOnlyFieldImpl();
//        Input<String> inputOptionString = new ShowInputOptionsStringImpl();
//        Input<String> inputCPF = new CPFInput();
//        Input<String> inputCNPJ = new CNPJInput();
//        Output showInformation = new ShowInformationOutputImpl();


//        CreateClient createClientService = new CreateClientService(clientRepository);
//        UpdateClient updateClientService = new UpdateClientService(clientRepository);
//        DeleteClient deleteClientService = new DeleteClientService(clientRepository);
//        UpdateClient updateClientService = new UpdateClientService();
//        Controller createClientCPF = new CreateClientCPFControllerImpl(inputMultipleFields, showInformation, inputCPF, createClientService);
//        Controller createClientCNPJ = new CreateClientCNPJControllerImpl(inputMultipleFields, showInformation, inputCNPJ, createClientService);
//        Controller deleteClientCPF = new DeleteClientCPFControllerImpl(inputOnlyField, showInformation, deleteClientService);
//        Controller updatedClientCPF = new UpdateClientCPFControllerImpl(inputMultipleFields, showInformation, updateClientService);
//        Controller updatedClientCNPJ = new UpdateClientCNPJControllerImpl(inputMultipleFields, showInformation, updateClientService);
//        Menu clientMenu = new ClientMenu(inputOptionString, createClientCPF, updatedClientCPF, createClientCNPJ, updatedClientCNPJ);

//        JFrame frame = CreateFrame.execute();
//        frame.setVisible(true);

        String option;
        do {
            //main menu
            //recebe de quem se trata a edição
            option = frontConfig.showMainMenu().execute();

            if (!option.isEmpty()) {
                //direciona para o menu com as opções específicas de Client, Vehicle ou Alocation
                switch (option) {
                    //case "Client" -> clientMenu.run();
                    case "Vehicle" -> vehicleMenu.run();
                    //Alocation
                    // case 3 -> AlocationMenu.run();
                }
            }
        } while (!option.isEmpty());

//        frame.dispose();
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    //injeta todas as dependencias para uma chamada da camada service
    private static VehicleServiceConfig createVehicleServiceConfig() {
        Repository<Vehicle> vehicleRepository = VehicleRepository.getInstance();
        return new VehicleServiceConfig(
                new CreateVehicleService(vehicleRepository),
                new ReadVehicleService(vehicleRepository),
                new UpdateVehicleService(vehicleRepository),
                new DeleteVehicleService(vehicleRepository)
        );
    }

    //injeta todas as dependencias para uma chamada do controller
    private static VehicleControllerConfig createVehicleControllerConfig(VehicleControllerImplConfig vehicleControllerImpl) {
        return new VehicleControllerConfig(
                new CreateVehicleControllerImpl(vehicleControllerImpl),
                new ReadVehicleControllerImpl(vehicleControllerImpl),
                new UpdateVehicleControllerImpl(vehicleControllerImpl),
                new DeleteVehicleControllerImpl(vehicleControllerImpl)
        );
    }

    //injeta para que eu consiga receber os inputs pelo front e consiga passar a requisição pro service
    private static VehicleControllerImplConfig vehicleControllerImplConfig(VehicleServiceConfig vehicleServiceConfig, FrontConfigVehicle front2) {
        return new VehicleControllerImplConfig(vehicleServiceConfig, front2);
    }

    //injeta para que eu consiga passar a requisição pro controller
    private static VehicleMenuConfig createVehicleMenuConfig(VehicleControllerConfig vehicleControllerConfig, FrontConfigVehicle front2) {
        return new VehicleMenuConfig(vehicleControllerConfig, front2);
    }

    //injeta todas as interfaces que eu posso ter no meu front
    private static FrontConfigVehicle createFrontConfig2() {
        return new FrontConfigVehicle(
                new ShowInputDataVehicle(MessagesVehicle.DESCRIPTION_INSERT_DATA.get(), MessagesVehicle.DESCRIPTION_ALL_DATA.get()),
                new ShowInputUpdateVehicleColorAndNumberPlate(MessagesVehicle.MENU_UPDATE_VEHICLE.get(), MessagesVehicle.OPTION_UPDATE_PLATE_COLOR.get()),
                new ShowInputExclusionField(MessagesVehicle.MENU_DELETE_VEHICLE.get(), MessagesVehicle.DESCRIPTION_DELETE_VEHICLE.get()),
                new ShowInputUpdatePlate(MessagesVehicle.MENU_UPDATE_VEHICLE.get(), MessagesVehicle.DESCRIPTION_ENTER_PLATE.get()),
                new ShowInputUpdateColor(MessagesVehicle.MENU_UPDATE_VEHICLE.get(), MessagesVehicle.DESCRIPTION_UPDATE_COLOR_VEHICLE.get()),
                new ShowInputNewPlateNumber(MessagesVehicle.MENU_UPDATE_VEHICLE.get(), MessagesVehicle.DESCRIPTION_UPDATE_PLATE_VEHICLE.get()),
                new ShowInputInsertFilterPlate(MessagesVehicle.MENU_INSERT_FILTER.get(), MessagesVehicle.DESCRIPTION_ENTER_PLATE.get()),
                new ShowInputInsertFilterColor(MessagesVehicle.MENU_INSERT_FILTER.get(),MessagesVehicle.MENU_INSERT_FILTER.get()),
                new ShowInputOptionsModel(MessagesVehicle.MENU_SELECT_MODEL.get(), MessagesVehicle.OPTION_ALL_MODELS.get()),
                new ShowInputOptionsReadVehicle(MessagesVehicle.MENU_READ_VEHICLE.get(), MessagesVehicle.OPTION_READ.get()),
                new ShowInputOptionsUpdateVehicle(MessagesVehicle.MENU_UPDATE_VEHICLE.get(), MessagesVehicle.OPTION_UPDATE_VEHICLE.get()),
                new ShowInputOptionsVehicle(MessagesVehicle.MENU_VEHICLE.get(), MessagesVehicle.OPTION_VEHICLE.get()),
                new ShowInputOptionsInsertModelFilter(MessagesVehicle.MENU_INSERT_FILTER.get(),MessagesVehicle.OPTION_ALL_MODELS.get()),
                new ShowMainMenu(MessagesApp.MAIN_MENU.get(), MessagesApp.MAIN_OPTIONS_MENU.get()),
                new ShowReadVehicle(MessagesVehicle.VEHICLE_DETAILS.get())
        );
    }
}
