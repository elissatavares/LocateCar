package ada.locate.car.app.config.vehicle;

import ada.locate.car.DTO.utils.vehicle.VehicleCreateBuilder;
import ada.locate.car.DTO.utils.vehicle.VehicleDeleteBuilder;
import ada.locate.car.DTO.utils.vehicle.VehicleReadBuilder;
import ada.locate.car.DTO.utils.vehicle.VehicleUpdateBuilder;

public record VehicleDTOBuilderconfig(VehicleCreateBuilder create,
                                      VehicleReadBuilder search,
                                      VehicleUpdateBuilder update,
                                      VehicleDeleteBuilder delete) {
}
