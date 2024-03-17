package ada.locate.car.app;

import ada.locate.car.DTO.utils.allocation.CreateAllocationDTO;
import ada.locate.car.DTO.utils.vehicle.*;
import ada.locate.car.app.config.allocation.*;
import ada.locate.car.app.config.client.*;
import ada.locate.car.app.config.vehicle.*;

import ada.locate.car.app.menu.AllocationMenu;
import ada.locate.car.app.menu.ClientMenu;
import ada.locate.car.app.menu.Menu;
import ada.locate.car.app.messages.MessagesAllocation;
import ada.locate.car.app.messages.MessagesApp;
import ada.locate.car.app.messages.MessagesClient;

import ada.locate.car.controller.impl.allocation.RentVehicleControllerImpl;
import ada.locate.car.controller.impl.allocation.ReturnRentedVehicleControllerImpl;
import ada.locate.car.controller.impl.client.CreateClientControllerImpl;
import ada.locate.car.controller.impl.client.DeleteClientControllerImpl;
import ada.locate.car.controller.impl.client.ReadControllerClientImpl;
import ada.locate.car.controller.impl.client.UpdateClientControllerImpl;
import ada.locate.car.core.model.Client;
import ada.locate.car.frontend.impl.allocation.create.ShowInputDataCreateAllocation;
import ada.locate.car.frontend.impl.allocation.create.ShowInputOptionsCreateAllocation;
import ada.locate.car.frontend.impl.allocation.create.ShowInputPlateNumberAllocation;
import ada.locate.car.frontend.impl.allocation.create.ShowOptionsAllocation;
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
import ada.locate.car.DTO.utils.client.ClientCreateBuilder;
import ada.locate.car.DTO.utils.client.ClientDeleteBuilder;
import ada.locate.car.DTO.utils.client.ClientReadBuilder;
import ada.locate.car.DTO.utils.client.ClientUpdateBuilder;
import ada.locate.car.provider.allocation.AllocationCreateInputProvider;
import ada.locate.car.provider.client.*;
import ada.locate.car.repository.api.Repository;
import ada.locate.car.repository.api.RepositoryClient;
import ada.locate.car.repository.api.RepositoryVehicle;
import ada.locate.car.app.menu.VehicleMenu;
import ada.locate.car.app.messages.MessagesVehicle;

import ada.locate.car.controller.impl.vehicle.CreateVehicleControllerImpl;
import ada.locate.car.controller.impl.vehicle.DeleteVehicleControllerImpl;
import ada.locate.car.controller.impl.vehicle.ReadVehicleControllerImpl;
import ada.locate.car.controller.impl.vehicle.UpdateVehicleControllerImpl;

import ada.locate.car.frontend.impl.vehicle.*;
import ada.locate.car.DTO.utils.vehicle.VehicleCreateBuilder;
import ada.locate.car.DTO.utils.vehicle.VehicleUpdateBuilder;
import ada.locate.car.repository.impl.ClientRepository;
import ada.locate.car.repository.impl.VehicleRepository;
import ada.locate.car.provider.vehicle.*;
import ada.locate.car.service.allocation.*;
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
        FrontVehicleConfig frontConfigVehicle = createFrontConfigVehicle();
        VehicleServiceConfig vehicleServiceConfig = createVehicleServiceConfig();
        ProviderVehicleConfig providerVehicleConfig = createproviderVehicleConfig(frontConfigVehicle);
        VehicleDTOBuilderconfig vehicleDTOBuilderconfig = createvehicleDTOBuilderconfig(providerVehicleConfig);
        VehicleControllerImplConfig vehicleControllerImplConfig = vehicleControllerImplConfig(vehicleServiceConfig,
                providerVehicleConfig, vehicleDTOBuilderconfig);
        VehicleControllerConfig vehicleControllerConfig = createVehicleControllerConfig(vehicleControllerImplConfig);
        VehicleMenuConfig vehicleMenuConfig = createVehicleMenuConfig(vehicleControllerConfig, providerVehicleConfig);
        Menu vehicleMenu = new VehicleMenu(vehicleMenuConfig);

        FrontClientConfig frontConfigClient = createFrontConfigClient();
        ClientServiceConfig clientServiceConfig = createClientServiceConfig();
        ProviderClientConfig providerClientConfig = createProviderClientConfig(frontConfigClient);
        ClientDTOBuilderconfig clientDTOBuilderConfig = createClientDTOBuilderConfig(providerClientConfig);
        ClientControllerImplConfig clientControllerImplConfig = createClientControllerImplConfig(clientServiceConfig,
                providerClientConfig, clientDTOBuilderConfig);
        ClientControllerConfig clientControllerConfig = createClientControllerConfig(clientControllerImplConfig);
        ClientMenuConfig clientMenuConfig = createClientMenuConfig(clientControllerConfig, providerClientConfig);
        Menu clientMenu = new ClientMenu(clientMenuConfig);

        FrontAllocationConfig frontAllocationConfig = createFrontConfigAllocation();
        AllocationServiceConfig allocationServiceConfig = createAllocationServiceConfig(vehicleServiceConfig, clientServiceConfig);
        ProviderAllocationConfig providerAllocationConfig = createProviderAllocationConfig(frontAllocationConfig);
        AllocationControllerImplConfig allocationControllerImplConfig = createAllocationControllerImplConfig(vehicleDTOBuilderconfig,
                providerVehicleConfig, clientDTOBuilderConfig, providerClientConfig, providerAllocationConfig, allocationServiceConfig);
        AllocationControllerConfig allocationControllerConfig = createAllocationControllerConfig(allocationControllerImplConfig);
        AllocationMenuConfig allocationMenuConfig = createAllocationMenuConfig(allocationControllerConfig, providerAllocationConfig);
        Menu allocation = new AllocationMenu(allocationMenuConfig);

        FrontAppConfig frontApp = createFrontConfigApp();


        String option;
        do {
            //main menu
            //recebe de quem se trata a edição
            option = frontApp.showMainMenu().execute();

            if (!option.isEmpty()) {
                //direciona para o menu com as opções específicas de Client, Vehicle ou Alocation
                switch (option) {
                    case "Client" -> clientMenu.run();
                    case "Vehicle" -> vehicleMenu.run();
                    case "Location Vehicle" ->
                        allocation.run();
                }
            }
        } while (!option.isEmpty());

    }

    private static ProviderAllocationConfig createProviderAllocationConfig(FrontAllocationConfig frontAllocationConfig) {
        return new ProviderAllocationConfig(new AllocationCreateInputProvider(frontAllocationConfig));
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
    private static VehicleControllerImplConfig vehicleControllerImplConfig(VehicleServiceConfig vehicleServiceConfig,
                                                                           ProviderVehicleConfig providerVehicleConfig,
                                                                           VehicleDTOBuilderconfig vehicleDTOBuilderconfig) {
        return new VehicleControllerImplConfig(vehicleServiceConfig, providerVehicleConfig, vehicleDTOBuilderconfig);
    }

    //injeta para que eu consiga passar a requisição pro controller
    private static VehicleMenuConfig createVehicleMenuConfig(VehicleControllerConfig vehicleControllerConfig,
                                                             ProviderVehicleConfig providerVehicleConfig) {
        return new VehicleMenuConfig(vehicleControllerConfig, providerVehicleConfig);
    }

    //injeta todas as interfaces que eu posso ter no meu front
    private static FrontVehicleConfig createFrontConfigVehicle() {
        return new FrontVehicleConfig(
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
                new ShowReadVehicle(MessagesVehicle.VEHICLE_DETAILS.get())
        );
    }

    private static ProviderVehicleConfig createproviderVehicleConfig(FrontVehicleConfig frontVehicleConfig) {
        return new ProviderVehicleConfig(
                new VehicleCreateInputProvider(frontVehicleConfig),
                new VehicleReadInputProvider(frontVehicleConfig),
                new VehicleUpdateInputProvider(frontVehicleConfig),
                new VehicleDeleteInputProvider(frontVehicleConfig),
                new OutputVehicle(frontVehicleConfig),
                new VehicleMenuInputProvider(frontVehicleConfig));
    }

    private static VehicleDTOBuilderconfig createvehicleDTOBuilderconfig(ProviderVehicleConfig provider) {
        return new VehicleDTOBuilderconfig(
                new VehicleCreateBuilder(),
                new VehicleReadBuilder(provider),
                new VehicleUpdateBuilder(provider),
                new VehicleDeleteBuilder()
        );
    }

    private static FrontClientConfig createFrontConfigClient() {
        return new FrontClientConfig(
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
        RepositoryClient clientRepository = ClientRepository.getInstance();
        return new ClientServiceConfig(
                new CreateClientService(clientRepository),
                new ReadClientService(clientRepository),
                new UpdateClientService(clientRepository),
                new DeleteClientService(clientRepository)
        );
    }

    private static ClientControllerImplConfig createClientControllerImplConfig(ClientServiceConfig clientServiceConfig,
                                                                               ProviderClientConfig provider,
                                                                               ClientDTOBuilderconfig clientDTOBuilderconfig) {
        return new ClientControllerImplConfig(clientServiceConfig, provider, clientDTOBuilderconfig);
    }

    private static ClientControllerConfig createClientControllerConfig(ClientControllerImplConfig clientControllerImplConfig) {
        return new ClientControllerConfig(
                new CreateClientControllerImpl(clientControllerImplConfig),
                new ReadControllerClientImpl(clientControllerImplConfig),
                new UpdateClientControllerImpl(clientControllerImplConfig),
                new DeleteClientControllerImpl(clientControllerImplConfig)
        );
    }

    private static ClientMenuConfig createClientMenuConfig(ClientControllerConfig clientControllerConfig,
                                                           ProviderClientConfig provider) {
        return new ClientMenuConfig(clientControllerConfig, provider);
    }

    private static ProviderClientConfig createProviderClientConfig(FrontClientConfig front) {
        return new ProviderClientConfig(
                new ClientCreateInputProvider(front),
                new ClientReadInputProvider(front),
                new ClientUpdateInputProvider(front),
                new ClientDeleteInputProvider(front),
                new ClientInputDocument(front),
                new OutputClient(front),
                new ClientMenuInputProvider(front)
        );
    }

    private static ClientDTOBuilderconfig createClientDTOBuilderConfig(ProviderClientConfig provider) {
        return new ClientDTOBuilderconfig(
                new ClientCreateBuilder(),
                new ClientReadBuilder(),
                new ClientUpdateBuilder(provider),
                new ClientDeleteBuilder()
        );
    }

    private static AllocationControllerConfig createAllocationControllerConfig(AllocationControllerImplConfig allocationControllerImplConfig) {
        return new AllocationControllerConfig(
                new RentVehicleControllerImpl(allocationControllerImplConfig),
                new ReturnRentedVehicleControllerImpl(allocationControllerImplConfig)
        );
    }

    private static AllocationMenuConfig createAllocationMenuConfig(AllocationControllerConfig allocationControllerConfig, ProviderAllocationConfig provider) {
        return new AllocationMenuConfig(allocationControllerConfig, provider);
    }

    private static AllocationControllerImplConfig createAllocationControllerImplConfig(VehicleDTOBuilderconfig dtoVehicle,
                                                                                       ProviderVehicleConfig providerVehicle,
                                                                                       ClientDTOBuilderconfig dtoClient,
                                                                                       ProviderClientConfig providerClient,
                                                                                       ProviderAllocationConfig providerAllocationConfig,
                                                                                       AllocationServiceConfig service
    ) {
        return new AllocationControllerImplConfig(dtoVehicle,
                providerVehicle,
                dtoClient,
                providerClient,
                providerAllocationConfig,
                new CreateAllocationDTO(),
                service);
    }

    private static AllocationServiceConfig createAllocationServiceConfig(VehicleServiceConfig vehicleServiceConfig,
                                                                         ClientServiceConfig clientServiceConfig) {
        return new AllocationServiceConfig(
                new CreateAllocationService(vehicleServiceConfig.read(),
                        clientServiceConfig.read(),
                        ClientRepository.getInstance(),
                        VehicleRepository.getInstance())
        );
    }

    private static FrontAllocationConfig createFrontConfigAllocation(){
        return new FrontAllocationConfig(
                new ShowInputOptionsCreateAllocation(MessagesAllocation.ENTER_TYPE_CLIENT.get(), MessagesAllocation.SEARCH_OPTION_PROMPT.get()),
                new ShowInputPlateNumberAllocation(MessagesAllocation.ALLOCATION_MENU.get(), MessagesAllocation.VEHICLE_IDENTIFICATION.get()),
                new ShowInputDataCreateAllocation(MessagesAllocation.ALLOCATION_MENU.get(), MessagesAllocation.ALL_ALLOCATION_DATA.get()),
                new ShowOptionsAllocation(MessagesAllocation.ALLOCATION_MENU.get(), MessagesAllocation.OPTION_ALLOCATION.get())
        );
    }

    private static FrontAppConfig createFrontConfigApp(){
        return new FrontAppConfig( new ShowMainMenu(MessagesApp.MAIN_MENU.get(), MessagesApp.MAIN_OPTIONS_MENU.get()));
    }

}
