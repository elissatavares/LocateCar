package ada.locate.car.app.config.vehicle;

import ada.locate.car.infra.provider.builder.vehicle.VehicleCreateBuilder;
import ada.locate.car.infra.provider.builder.vehicle.VehicleDeleteBuilder;
import ada.locate.car.infra.provider.builder.vehicle.VehicleReadBuilder;
import ada.locate.car.infra.provider.builder.vehicle.VehicleUpdateBuilder;

public record VehicleDTOBuilderconfig(VehicleCreateBuilder create,
                                      VehicleReadBuilder search,
                                      VehicleUpdateBuilder update,
                                      VehicleDeleteBuilder delete) {
}
