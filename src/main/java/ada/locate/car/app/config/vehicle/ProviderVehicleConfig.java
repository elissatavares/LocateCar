package ada.locate.car.app.config.vehicle;

import ada.locate.car.provider.vehicle.*;

public record ProviderVehicleConfig(VehicleCreateInputProvider create,
                                    VehicleReadInputProvider read,
                                    VehicleUpdateInputProvider update,
                                    VehicleDeleteInputProvider delete,
                                    OutputVehicle output,
                                    VehicleMenuInputProvider menu) {
}
