package ada.locate.car.core.usecase;

import ada.locate.car.infra.dto.VehicleDTO;

public interface UpdateVehicle {
    void execute(VehicleDTO vehicleDTO);
}
