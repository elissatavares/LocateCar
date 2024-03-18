package ada.locate.car.config.record.vehicle;

import ada.locate.car.core.usecase.vehicle.CreateVehicle;
import ada.locate.car.core.usecase.vehicle.DeleteVehicle;
import ada.locate.car.core.usecase.vehicle.ReadVehicle;
import ada.locate.car.core.usecase.vehicle.UpdateVehicle;

//configuração pra quem precisa acessar meu service
public record VehicleServiceConfig(CreateVehicle create,
                                   ReadVehicle read,
                                   UpdateVehicle update,
                                   DeleteVehicle delete) {
}
