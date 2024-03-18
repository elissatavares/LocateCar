package ada.locate.car.app.config.vehicle;

import ada.locate.car.core.usecase.CreateVehicle;
import ada.locate.car.core.usecase.DeleteVehicle;
import ada.locate.car.core.usecase.ReadVehicle;
import ada.locate.car.core.usecase.UpdateVehicle;

//configuração pra quem precisa acessar meu service
public record VehicleServiceConfig(CreateVehicle create,
                                   ReadVehicle read,
                                   UpdateVehicle update,
                                   DeleteVehicle delete) {
}
