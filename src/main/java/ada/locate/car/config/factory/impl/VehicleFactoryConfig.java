package ada.locate.car.config.factory.impl;

import ada.locate.car.app.menu.Menu;
import ada.locate.car.app.menu.VehicleMenu;
import ada.locate.car.config.factory.VehicleFactory;
import ada.locate.car.config.record.vehicle.*;

public class VehicleFactoryConfig {
    private final VehicleServiceConfig vehicleServiceConfig;
    private final ProviderVehicleConfig providerVehicleConfig;
    private final VehicleDTOBuilderconfig vehicleDTOBuilderconfig;
    private final Menu vehicleMenu;

    public VehicleFactoryConfig() {
        VehicleFrontendConfig frontConfigVehicle = VehicleFactory.createFrontConfigVehicle();
        this.vehicleServiceConfig = VehicleFactory.createVehicleServiceConfig();
        this.providerVehicleConfig = VehicleFactory.createproviderVehicleConfig(frontConfigVehicle);
        this.vehicleDTOBuilderconfig = VehicleFactory.createvehicleDTOBuilderconfig(providerVehicleConfig);
        VehicleControllerImplConfig vehicleControllerImplConfig = VehicleFactory.vehicleControllerImplConfig(vehicleServiceConfig,
                providerVehicleConfig, vehicleDTOBuilderconfig);
        VehicleControllerConfig vehicleControllerConfig = VehicleFactory.createVehicleControllerConfig(vehicleControllerImplConfig);
        VehicleMenuConfig vehicleMenuConfig = VehicleFactory.createVehicleMenuConfig(vehicleControllerConfig, providerVehicleConfig);
        this.vehicleMenu = new VehicleMenu(vehicleMenuConfig);
    }

    public Menu getVehicleMenu() {
        return vehicleMenu;
    }

    protected VehicleDTOBuilderconfig getVehicleDTOBuilderconfig() {
        return vehicleDTOBuilderconfig;
    }

    protected VehicleServiceConfig getVehicleServiceConfig() {
        return vehicleServiceConfig;
    }

    protected ProviderVehicleConfig getProviderVehicleConfig() {
        return providerVehicleConfig;
    }
}
