package ada.locate.car.app;

import ada.locate.car.app.config.allocation.AllocationControllerConfig;
import ada.locate.car.app.config.allocation.AllocationControllerImplConfig;
import ada.locate.car.app.config.allocation.AllocationMenuConfig;
import ada.locate.car.app.config.allocation.AllocationServiceConfig;
import ada.locate.car.app.config.client.ClientControllerConfig;
import ada.locate.car.app.config.client.ClientControllerImplConfig;
import ada.locate.car.app.config.client.ClientServiceConfig;
import ada.locate.car.app.config.client.ClientMenuConfig;
import ada.locate.car.app.config.client.FrontConfigClient;
import ada.locate.car.app.config.vehicle.FrontConfigVehicle;

import ada.locate.car.app.menu.AllocationMenu;
import ada.locate.car.app.menu.ClientMenu;
import ada.locate.car.app.menu.Menu;
import ada.locate.car.app.messages.MessagesApp;
import ada.locate.car.app.messages.MessagesClient;

import ada.locate.car.controller.impl.allocation.RentVehicleControllerImpl;
import ada.locate.car.controller.impl.allocation.ReturnRentedVehicleControllerImpl;
import ada.locate.car.controller.impl.client.CreateClientControllerImpl;
import ada.locate.car.controller.impl.client.DeleteClientControllerImpl;
import ada.locate.car.controller.impl.client.ReadControllerClientImpl;
import ada.locate.car.controller.impl.client.UpdateClientControllerImpl;
import ada.locate.car.core.model.Client;
import ada.locate.car.frontend.impl.client.ShowInputCNPJ;
import ada.locate.car.frontend.impl.client.ShowInputCPF;
import ada.locate.car.frontend.impl.client.ShowInputOptionsClient;
import ada.locate.car.frontend.impl.client.create.ShowCreatedSuccessfullyClient;
import ada.locate.car.frontend.impl.client.create.ShowInputDataCreateClient;
import ada.locate.car.frontend.impl.client.create.ShowInputOptionsCreateClient;
import ada.locate.car.frontend.impl.client.delete.ShowDeletedSuccessfullyClient;
import ada.locate.car.frontend.impl.client.delete.ShowInputDeleteOptionsClient;
import ada.locate.car.frontend.impl.client.read.ShowClient;
import ada.locate.car.frontend.impl.client.read.ShowInputOptionsReadClient;
import ada.locate.car.frontend.impl.client.update.*;
import ada.locate.car.frontend.impl.vehicle.create.ShowInputDataCreateVehicle;
import ada.locate.car.infra.api.Repository;
import ada.locate.car.infra.api.RepositoryVehicle;
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

import ada.locate.car.frontend.impl.vehicle.*;
import ada.locate.car.infra.repository.ClientRepository;
import ada.locate.car.infra.repository.VehicleRepository;
import ada.locate.car.service.allocation.CreateAllocationService;
import ada.locate.car.service.client.CreateClientService;
import ada.locate.car.service.client.DeleteClientService;
import ada.locate.car.service.client.ReadClientService;
import ada.locate.car.service.client.UpdateClientService;
import ada.locate.car.service.vehicle.CreateVehicleService;
import ada.locate.car.service.vehicle.DeleteVehicleService;
import ada.locate.car.service.vehicle.ReadVehicleService;
import ada.locate.car.service.vehicle.UpdateVehicleService;

public class LocateCar {
    public static void run() {

        FrontConfigVehicle frontConfigVehicle = createFrontConfigVehicle();
        VehicleServiceConfig vehicleServiceConfig = createVehicleServiceConfig();
        VehicleControllerImplConfig vehicleControllerImplConfig = vehicleControllerImplConfig(vehicleServiceConfig, frontConfigVehicle);
        VehicleControllerConfig vehicleControllerConfig = createVehicleControllerConfig(vehicleControllerImplConfig);
        VehicleMenuConfig vehicleMenuConfig = createVehicleMenuConfig(vehicleControllerConfig, frontConfigVehicle);
        Menu vehicleMenu = new VehicleMenu(vehicleMenuConfig);

        FrontConfigClient frontConfigClient = createFrontConfigClient();
        ClientServiceConfig clientServiceConfig = createClientServiceConfig();
        ClientControllerImplConfig clientControllerImplConfig = createClientControllerImplConfig(clientServiceConfig, frontConfigClient);
        ClientControllerConfig clientControllerConfig = createClientControllerConfig(clientControllerImplConfig);
        ClientMenuConfig clientMenuConfig = createClientMenuConfig(clientControllerConfig, frontConfigClient);
        Menu clientMenu = new ClientMenu(clientMenuConfig);

        AllocationServiceConfig allocationServiceConfig = createAllocationServiceConfig(vehicleServiceConfig);
        AllocationControllerImplConfig allocationControllerImplConfig = createAllocationControllerImplConfig(allocationServiceConfig);
        AllocationControllerConfig allocationControllerConfig = createAllocationControllerConfig(allocationControllerImplConfig);
        AllocationMenuConfig allocationMenuConfig = createAllocationMenuConfig(allocationControllerConfig);
        Menu allocation = new AllocationMenu(allocationMenuConfig);


        String option;
        do {
            //main menu
            //recebe de quem se trata a edição
            option = frontConfigVehicle.showMainMenu().execute();

            if (!option.isEmpty()) {
                //direciona para o menu com as opções específicas de Client, Vehicle ou Alocation
                switch (option) {
                    case "Client" -> clientMenu.run();
                    case "Vehicle" -> vehicleMenu.run();
                    case "Allocation"-> allocation.run();
                }
            }
        } while (!option.isEmpty());

    }

    //injeta todas as dependencias para uma chamada da camada service
    private static VehicleServiceConfig createVehicleServiceConfig() {
        RepositoryVehicle vehicleRepository = VehicleRepository.getInstance();
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
    private static VehicleControllerImplConfig vehicleControllerImplConfig(VehicleServiceConfig vehicleServiceConfig, FrontConfigVehicle front) {
        return new VehicleControllerImplConfig(vehicleServiceConfig, front);
    }

    //injeta para que eu consiga passar a requisição pro controller
    private static VehicleMenuConfig createVehicleMenuConfig(VehicleControllerConfig vehicleControllerConfig, FrontConfigVehicle front) {
        return new VehicleMenuConfig(vehicleControllerConfig, front);
    }

    //injeta todas as interfaces que eu posso ter no meu front
    private static FrontConfigVehicle createFrontConfigVehicle() {
        return new FrontConfigVehicle(
                new ShowInputDataCreateVehicle(MessagesVehicle.DESCRIPTION_INSERT_DATA.get(), MessagesVehicle.DESCRIPTION_ALL_DATA.get()),
                new ShowInputUpdateVehicleColorAndNumberPlate(MessagesVehicle.MENU_UPDATE_VEHICLE.get(), MessagesVehicle.OPTION_UPDATE_PLATE_COLOR.get()),
                new ShowInputExclusionField(MessagesVehicle.MENU_DELETE_VEHICLE.get(), MessagesVehicle.DESCRIPTION_DELETE_VEHICLE.get()),
                new ShowInputUpdatePlate(MessagesVehicle.MENU_UPDATE_VEHICLE.get(), MessagesVehicle.DESCRIPTION_ENTER_PLATE.get()),
                new ShowInputUpdateColor(MessagesVehicle.MENU_UPDATE_VEHICLE.get(), MessagesVehicle.DESCRIPTION_UPDATE_COLOR_VEHICLE.get()),
                new ShowInputNewPlateNumber(MessagesVehicle.MENU_UPDATE_VEHICLE.get(), MessagesVehicle.DESCRIPTION_UPDATE_PLATE_VEHICLE.get()),
                new ShowInputInsertFilterPlate(MessagesVehicle.MENU_INSERT_FILTER.get(), MessagesVehicle.DESCRIPTION_ENTER_PLATE.get()),
                new ShowInputInsertFilterColor(MessagesVehicle.MENU_INSERT_FILTER.get(), MessagesVehicle.MENU_INSERT_FILTER.get()),
                new ShowInputOptionsModel(MessagesVehicle.MENU_SELECT_MODEL.get(), MessagesVehicle.OPTION_ALL_MODELS.get()),
                new ShowInputOptionsReadVehicle(MessagesVehicle.MENU_READ_VEHICLE.get(), MessagesVehicle.OPTION_READ.get()),
                new ShowInputOptionsUpdateVehicle(MessagesVehicle.MENU_UPDATE_VEHICLE.get(), MessagesVehicle.OPTION_UPDATE_VEHICLE.get()),
                new ShowInputOptionsVehicle(MessagesVehicle.MENU_VEHICLE.get(), MessagesVehicle.OPTION_VEHICLE.get()),
                new ShowInputOptionsInsertModelFilter(MessagesVehicle.MENU_INSERT_FILTER.get(), MessagesVehicle.OPTION_ALL_MODELS.get()),
                new ShowMainMenu(MessagesApp.MAIN_MENU.get(), MessagesApp.MAIN_OPTIONS_MENU.get()),
                new ShowReadVehicle(MessagesVehicle.VEHICLE_DETAILS.get())
        );
    }

    private static FrontConfigClient createFrontConfigClient() {
        return new FrontConfigClient(
                new ShowInputOptionsClient(MessagesClient.CLIENT_MENU.get(), MessagesClient.OPTION_CLIENT.get()),
                new ShowInputOptionsCreateClient(MessagesClient.CREATE_CLIENT.get(), MessagesClient.ALL_TYPES.get()),
                new ShowInputDataCreateClient(MessagesClient.INSERT_CLIENT_DATA.get(), MessagesClient.ALL_CLIENT_DATA.get()),
                new ShowInputCPF(MessagesClient.ENTER_CPF.get(), MessagesClient.ENTER_CPF.get()),
                new ShowInputCNPJ(MessagesClient.ENTER_CNPJ.get(), MessagesClient.ENTER_CNPJ.get()),
                new ShowCreatedSuccessfullyClient(MessagesClient.CREATE_SUCESS_MSG.get()),
                new ShowInputDeleteOptionsClient(MessagesClient.TITLE_DELETE_CLIENT.get(), MessagesClient.SEARCH_OPTION_PROMPT.get()),
                new ShowDeletedSuccessfullyClient(MessagesClient.DELETE_SUCESS_MSG.get()),
                new ShowInputOptionsReadClient(MessagesClient.ENTER_SEARCH_OPTION.get(), MessagesClient.SEARCH_OPTION_PROMPT.get()),
                new ShowClient(MessagesClient.CLIENT_DETAILS.get()),
                new ShowInputOptionsUpdateClient(MessagesClient.MENU_UPDATED_CLIENT.get(), MessagesClient.UPDATED_CLIENT_DATA.get()),
                new ShowInputUpdateCPFOrCNPJ(MessagesClient.MENU_UPDATED_CLIENT.get(), MessagesClient.SEARCH_OPTION_PROMPT.get()),
                new ShowInputUpdateName(MessagesClient.MENU_UPDATED_CLIENT.get(), "Name"),
                new ShowInputUpdateAddress(MessagesClient.MENU_UPDATED_CLIENT.get(), "Address"),
                new ShowInputUpdatePhoneNumber(MessagesClient.MENU_UPDATED_CLIENT.get(), "Phone Number"),
                new ShowInputUpdateEmail(MessagesClient.MENU_UPDATED_CLIENT.get(), "Email"),
                new ShowUpdatedSuccessfullyClient(MessagesClient.UPDATE_SUCESS_MSG.get())
        );
    }

    private static ClientServiceConfig createClientServiceConfig() {
        Repository<Client> clientRepository = ClientRepository.getInstance();
        return new ClientServiceConfig(
                new CreateClientService(clientRepository),
                new ReadClientService(clientRepository),
                new UpdateClientService(clientRepository),
                new DeleteClientService(clientRepository)
        );
    }

    private static ClientControllerImplConfig createClientControllerImplConfig(ClientServiceConfig clientServiceConfig, FrontConfigClient frontConfigClient) {
        return new ClientControllerImplConfig(clientServiceConfig, frontConfigClient);
    }

    private static ClientControllerConfig createClientControllerConfig(ClientControllerImplConfig clientControllerImplConfig) {
        return new ClientControllerConfig(
                new CreateClientControllerImpl(clientControllerImplConfig),
                new ReadControllerClientImpl(clientControllerImplConfig),
                new UpdateClientControllerImpl(clientControllerImplConfig),
                new DeleteClientControllerImpl(clientControllerImplConfig)
        );
    }

    private static ClientMenuConfig createClientMenuConfig(ClientControllerConfig clientControllerConfig, FrontConfigClient frontConfigClient) {
        return new ClientMenuConfig(clientControllerConfig, frontConfigClient);
    }

    private static AllocationControllerConfig createAllocationControllerConfig(AllocationControllerImplConfig allocationControllerImplConfig){
        return new AllocationControllerConfig(
                new RentVehicleControllerImpl(allocationControllerImplConfig),
                new ReturnRentedVehicleControllerImpl()
        );
    }

    private static AllocationMenuConfig createAllocationMenuConfig(AllocationControllerConfig allocationControllerConfig){
        return new AllocationMenuConfig(allocationControllerConfig);
    }

    private static AllocationControllerImplConfig createAllocationControllerImplConfig(AllocationServiceConfig allocationServiceConfig){
        return new AllocationControllerImplConfig(allocationServiceConfig);
    }

    private static AllocationServiceConfig createAllocationServiceConfig(VehicleServiceConfig vehicleServiceConfig){
        return new AllocationServiceConfig(
                new CreateAllocationService(vehicleServiceConfig.read())
        );
    }























}
