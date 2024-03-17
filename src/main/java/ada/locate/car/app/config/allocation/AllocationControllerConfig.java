package ada.locate.car.app.config.allocation;

import ada.locate.car.controller.api.Controller;

public record AllocationControllerConfig(Controller rentVehicle, Controller returnRentedVehicle) {
}
