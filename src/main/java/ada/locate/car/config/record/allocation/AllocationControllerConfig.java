package ada.locate.car.config.record.allocation;

import ada.locate.car.controller.api.Controller;

public record AllocationControllerConfig(Controller rentVehicle,
                                         Controller returnRentedVehicle) {
}
