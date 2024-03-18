package ada.locate.car.config.factory;

import ada.locate.car.DTO.utils.vehicle.*;
import ada.locate.car.app.messages.MessagesVehicle;
import ada.locate.car.config.record.vehicle.*;
import ada.locate.car.controller.impl.vehicle.CreateVehicleControllerImpl;
import ada.locate.car.controller.impl.vehicle.DeleteVehicleControllerImpl;
import ada.locate.car.controller.impl.vehicle.ReadVehicleControllerImpl;
import ada.locate.car.controller.impl.vehicle.UpdateVehicleControllerImpl;
import ada.locate.car.frontend.impl.vehicle.*;
import ada.locate.car.frontend.impl.vehicle.create.ShowInputDataCreateVehicle;
import ada.locate.car.provider.vehicle.*;
import ada.locate.car.repository.api.RepositoryVehicle;
import ada.locate.car.repository.impl.VehicleRepository;
import ada.locate.car.service.vehicle.CreateVehicleService;
import ada.locate.car.service.vehicle.DeleteVehicleService;
import ada.locate.car.service.vehicle.ReadVehicleService;
import ada.locate.car.service.vehicle.UpdateVehicleService;

public class VehicleFactory {
    public static VehicleServiceConfig createVehicleServiceConfig() {
        RepositoryVehicle vehicleRepository = VehicleRepository.getInstance();
        return new VehicleServiceConfig(
                new CreateVehicleService(vehicleRepository),
                new ReadVehicleService(vehicleRepository),
                new UpdateVehicleService(vehicleRepository),
                new DeleteVehicleService(vehicleRepository)
        );
    }
    //injeta todas as dependencias para uma chamada do controller

    public static VehicleControllerConfig createVehicleControllerConfig(VehicleControllerImplConfig vehicleControllerImpl) {
        return new VehicleControllerConfig(
                new CreateVehicleControllerImpl(vehicleControllerImpl),
                new ReadVehicleControllerImpl(vehicleControllerImpl),
                new UpdateVehicleControllerImpl(vehicleControllerImpl),
                new DeleteVehicleControllerImpl(vehicleControllerImpl)
        );
    }
    //injeta para que eu consiga receber os inputs pelo front e consiga passar a requisição pro service

    public static VehicleControllerImplConfig vehicleControllerImplConfig(VehicleServiceConfig vehicleServiceConfig,
                                                                          ProviderVehicleConfig providerVehicleConfig,
                                                                          VehicleDTOBuilderconfig vehicleDTOBuilderconfig) {
        return new VehicleControllerImplConfig(vehicleServiceConfig, providerVehicleConfig, vehicleDTOBuilderconfig);
    }
    //injeta para que eu consiga passar a requisição pro controller

    public static VehicleMenuConfig createVehicleMenuConfig(VehicleControllerConfig vehicleControllerConfig,
                                                            ProviderVehicleConfig providerVehicleConfig) {
        return new VehicleMenuConfig(vehicleControllerConfig, providerVehicleConfig);
    }
    //injeta todas as interfaces que eu posso ter no meu front

    public static VehicleFrontendConfig createFrontConfigVehicle() {
        return new VehicleFrontendConfig(
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
    public static ProviderVehicleConfig createproviderVehicleConfig(VehicleFrontendConfig frontVehicleConfig) {
        return new ProviderVehicleConfig(
                new VehicleInputProviderCreate(frontVehicleConfig),
                new VehicleInputProviderRead(frontVehicleConfig),
                new VehicleInputProviderUpdate(frontVehicleConfig),
                new VehicleInputProviderDelete(frontVehicleConfig),
                new OutputVehicle(frontVehicleConfig),
                new VehicleInputProviderMenu(frontVehicleConfig));
    }

    public static VehicleDTOBuilderconfig createvehicleDTOBuilderconfig(ProviderVehicleConfig provider) {
        return new VehicleDTOBuilderconfig(
                new VehicleCreateDTO(),
                new VehicleReadDTO(provider),
                new VehicleUpdateDTO(provider),
                new VehicleDeleteDTO(),
                new VehicleSearchPlateNumberDTO()
        );
    }

}
