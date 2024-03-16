package ada.locate.car.app.config.vehicle;

import ada.locate.car.app.config.vehicle.front.FrontConfigVehicle;

//menu que vai acessar os meus controllers
public record VehicleMenuConfig(VehicleControllerConfig controller, FrontConfigVehicle front) {
}
