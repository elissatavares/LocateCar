package ada.locate.car.app.config.allocation;

import ada.locate.car.DTO.utils.allocation.CreateAllocationDTO;
import ada.locate.car.DTO.utils.allocation.DeleteAllocationDTO;
import ada.locate.car.app.config.client.ClientDTOBuilderconfig;
import ada.locate.car.app.config.client.ProviderClientConfig;
import ada.locate.car.app.config.vehicle.ProviderVehicleConfig;
import ada.locate.car.app.config.vehicle.VehicleDTOBuilderconfig;

public record AllocationControllerImplConfig(VehicleDTOBuilderconfig dtoVehicle,
                                             ProviderVehicleConfig providerVehicle,
                                             ClientDTOBuilderconfig dtoClient,
                                             ProviderClientConfig providerClient,
                                             ProviderAllocationConfig providerAllocation,
                                             AllocationDTOConfig DTO,
                                             AllocationServiceConfig service) {
}
