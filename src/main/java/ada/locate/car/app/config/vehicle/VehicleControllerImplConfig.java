package ada.locate.car.app.config.vehicle;

import ada.locate.car.app.config.vehicle.front.FrontConfigVehicle;

//configura as implementações dos meus controllers, que devem poder chamar meu service
public record VehicleControllerImplConfig(VehicleServiceConfig service, FrontConfigVehicle front) {
}
