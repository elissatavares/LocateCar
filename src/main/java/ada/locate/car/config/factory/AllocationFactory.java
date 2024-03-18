package ada.locate.car.config.factory;

import ada.locate.car.DTO.utils.allocation.CreateAllocationDTO;
import ada.locate.car.DTO.utils.allocation.DeleteAllocationDTO;
import ada.locate.car.app.messages.MessagesAllocation;
import ada.locate.car.config.record.allocation.*;
import ada.locate.car.config.record.client.ClientDTOBuilderconfig;
import ada.locate.car.config.record.client.ClientServiceConfig;
import ada.locate.car.config.record.client.ProviderClientConfig;
import ada.locate.car.config.record.vehicle.ProviderVehicleConfig;
import ada.locate.car.config.record.vehicle.VehicleDTOBuilderconfig;
import ada.locate.car.config.record.vehicle.VehicleServiceConfig;
import ada.locate.car.controller.impl.allocation.RentVehicleControllerImpl;
import ada.locate.car.controller.impl.allocation.ReturnRentedVehicleControllerImpl;
import ada.locate.car.frontend.impl.allocation.create.ShowInputDataCreateAllocation;
import ada.locate.car.frontend.impl.allocation.create.ShowInputOptionsCreateAllocation;
import ada.locate.car.frontend.impl.allocation.create.ShowInputPlateNumberAllocation;
import ada.locate.car.frontend.impl.allocation.create.ShowOptionsAllocation;
import ada.locate.car.frontend.impl.allocation.delete.*;
import ada.locate.car.provider.allocation.AllocationInputProviderCreate;
import ada.locate.car.provider.allocation.AllocationInputProviderDelete;
import ada.locate.car.repository.impl.ClientRepository;
import ada.locate.car.repository.impl.VehicleRepository;
import ada.locate.car.service.allocation.CreateAllocationService;
import ada.locate.car.service.allocation.ReturnAllocationService;

public class AllocationFactory {
    public static AllocationControllerConfig createAllocationControllerConfig(AllocationControllerImplConfig allocationControllerImplConfig) {
        return new AllocationControllerConfig(
                new RentVehicleControllerImpl(allocationControllerImplConfig),
                new ReturnRentedVehicleControllerImpl(allocationControllerImplConfig)
        );
    }

    public static AllocationMenuConfig createAllocationMenuConfig(AllocationControllerConfig allocationControllerConfig, ProviderAllocationConfig provider) {
        return new AllocationMenuConfig(allocationControllerConfig, provider);
    }

    public static AllocationControllerImplConfig createAllocationControllerImplConfig(VehicleDTOBuilderconfig dtoVehicle,
                                                                                      ProviderVehicleConfig providerVehicle,
                                                                                      ClientDTOBuilderconfig dtoClient,
                                                                                      ProviderClientConfig providerClient,
                                                                                      ProviderAllocationConfig providerAllocationConfig,
                                                                                      AllocationDTOConfig allocationDTOConfig,
                                                                                      AllocationServiceConfig service
    ) {
        return new AllocationControllerImplConfig(dtoVehicle,
                providerVehicle,
                dtoClient,
                providerClient,
                providerAllocationConfig,
                allocationDTOConfig,
                service);
    }

    public static AllocationDTOConfig createAllocationDTOConfig(){
        return new AllocationDTOConfig(new CreateAllocationDTO(), new DeleteAllocationDTO());
    }

    public static AllocationServiceConfig createAllocationServiceConfig(VehicleServiceConfig vehicleServiceConfig,
                                                                        ClientServiceConfig clientServiceConfig) {
        return new AllocationServiceConfig(
                new CreateAllocationService(vehicleServiceConfig.read(),
                        clientServiceConfig.read(),
                        ClientRepository.getInstance(),
                        VehicleRepository.getInstance()),
                new ReturnAllocationService(ClientRepository.getInstance(), clientServiceConfig.read())
        );
    }

    public static ProviderAllocationConfig createProviderAllocationConfig(AllocationFrontendConfig frontAllocationConfig) {
        return new ProviderAllocationConfig(
                new AllocationInputProviderCreate(frontAllocationConfig),
                new AllocationInputProviderDelete(frontAllocationConfig));
    }

    public static AllocationFrontendConfig createFrontConfigAllocation(){
        return new AllocationFrontendConfig(
                new ShowInputOptionsCreateAllocation(MessagesAllocation.ENTER_CREATE_TYPE_CLIENT.get(), MessagesAllocation.SEARCH_OPTION_PROMPT.get()),
                new ShowInputPlateNumberAllocation(MessagesAllocation.ALLOCATION_MENU.get(), MessagesAllocation.VEHICLE_IDENTIFICATION.get()),
                new ShowInputDataCreateAllocation(MessagesAllocation.ALLOCATION_MENU.get(), MessagesAllocation.ALL_ALLOCATION_DATA.get()),
                new ShowOptionsAllocation(MessagesAllocation.ALLOCATION_MENU.get(), MessagesAllocation.OPTION_ALLOCATION.get()),
                new ShowInputOptionsDeleteAllocation(MessagesAllocation.ENTER_RETURN_TYPE_CLIENT.get(), MessagesAllocation.SEARCH_OPTION_PROMPT.get()),
                new ShowInputPlateNumberReturnAllocation(MessagesAllocation.MENU_RETURN.get(), MessagesAllocation.VEHICLE_IDENTIFICATION.get()),
                new ShowOutputClientAllocations(MessagesAllocation.ALLOCATION_ClIENT_CAR.get()),
                new ShowInputFinalDay(MessagesAllocation.ENTER_FINAL_DAY.get(), MessagesAllocation.DESCRIPTION_FINAL_DAY.get()),
                new ShowValueAllocation(MessagesAllocation.VALUE_FINAL.get())
        );
    }

}
