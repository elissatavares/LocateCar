package ada.locate.car.config.factory.impl;

import ada.locate.car.app.menu.AllocationMenu;
import ada.locate.car.app.menu.Menu;
import ada.locate.car.config.factory.AllocationFactory;
import ada.locate.car.config.record.allocation.*;

public class AllocationFactoryConfig {
    private VehicleFactoryConfig vehicleFactoryConfig;
    private ClientFactoryConfig clientFactoryConfig;

    private final Menu allocation;

    public AllocationFactoryConfig(VehicleFactoryConfig vehicleFactoryConfig, ClientFactoryConfig clientFactoryConfig) {
        AllocationFrontendConfig frontAllocationConfig = AllocationFactory.createFrontConfigAllocation();
        AllocationServiceConfig allocationServiceConfig = AllocationFactory.createAllocationServiceConfig(
                vehicleFactoryConfig.getVehicleServiceConfig(), clientFactoryConfig.getClientServiceConfig());
        ProviderAllocationConfig providerAllocationConfig = AllocationFactory.createProviderAllocationConfig(frontAllocationConfig);
        AllocationDTOConfig allocationDTOConfig = AllocationFactory.createAllocationDTOConfig();
        AllocationControllerImplConfig allocationControllerImplConfig = AllocationFactory.createAllocationControllerImplConfig(
                vehicleFactoryConfig.getVehicleDTOBuilderconfig(),
                vehicleFactoryConfig.getProviderVehicleConfig(),
                clientFactoryConfig.getClientDTOBuilderConfig(),
                clientFactoryConfig.getProviderClientConfig(),
                providerAllocationConfig, allocationDTOConfig, allocationServiceConfig);
        AllocationControllerConfig allocationControllerConfig = AllocationFactory.createAllocationControllerConfig(allocationControllerImplConfig);
        AllocationMenuConfig allocationMenuConfig = AllocationFactory.createAllocationMenuConfig(allocationControllerConfig, providerAllocationConfig);

        this.allocation = new AllocationMenu(allocationMenuConfig);
    }

    public Menu getAllocationMenu() {
        return allocation;
    }

}

