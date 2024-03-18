package ada.locate.car.config.record.allocation;

import ada.locate.car.config.record.client.ClientDTOBuilderconfig;
import ada.locate.car.config.record.client.ProviderClientConfig;
import ada.locate.car.config.record.vehicle.ProviderVehicleConfig;
import ada.locate.car.config.record.vehicle.VehicleDTOBuilderconfig;

public record AllocationControllerImplConfig(VehicleDTOBuilderconfig dtoVehicle,
                                             ProviderVehicleConfig providerVehicle,
                                             ClientDTOBuilderconfig dtoClient,
                                             ProviderClientConfig providerClient,
                                             ProviderAllocationConfig providerAllocation,
                                             AllocationDTOConfig DTO,
                                             AllocationServiceConfig service) {
}
