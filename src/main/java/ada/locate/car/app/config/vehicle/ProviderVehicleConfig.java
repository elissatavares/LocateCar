package ada.locate.car.app.config.vehicle;

import ada.locate.car.infra.provider.data.client.OutputClient;
import ada.locate.car.infra.provider.data.vehicle.*;

public record ProviderVehicleConfig(VehicleCreateInputProvider create,
                                    VehicleReadInputProvider read,
                                    VehicleUpdateInputProvider update,
                                    VehicleDeleteInputProvider delete,
                                    OutputVehicle output,
                                    VehicleMenuInputProvider menu) {
}
