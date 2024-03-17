package ada.locate.car.app.config.vehicle;
import ada.locate.car.controller.api.Controller;

//configura quem precisa acessar o meu controller
public record VehicleControllerConfig(Controller create,
                                      Controller read,
                                      Controller update,
                                      Controller delete) {
}

