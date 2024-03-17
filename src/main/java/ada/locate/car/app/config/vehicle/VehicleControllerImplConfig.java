package ada.locate.car.app.config.vehicle;

//configura as implementações dos meus controllers, que devem poder chamar meu service
public record VehicleControllerImplConfig(VehicleServiceConfig service, FrontConfigVehicle front) {
}
