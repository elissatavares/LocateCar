package ada.locate.car.config.record.vehicle;

import ada.locate.car.provider.vehicle.*;

public record ProviderVehicleConfig(VehicleInputProviderCreate create,
                                    VehicleInputProviderRead read,
                                    VehicleInputProviderUpdate update,
                                    VehicleInputProviderDelete delete,
                                    OutputVehicle output,
                                    VehicleInputProviderMenu menu) {
}
