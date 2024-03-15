package ada.locate.car.app.config.vehicle;

import ada.locate.car.app.config.front.FrontConfig;
//menu que vai acessar os meus controllers
public record VehicleMenuConfig(VehicleControllerConfig controller, FrontConfig front) {
}
