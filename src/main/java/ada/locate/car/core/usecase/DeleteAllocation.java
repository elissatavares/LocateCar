package ada.locate.car.core.usecase;

import ada.locate.car.infra.dto.VehicleDTO;

public interface DeleteAllocation {
    void execute(VehicleDTO vehicleDTO);
}

