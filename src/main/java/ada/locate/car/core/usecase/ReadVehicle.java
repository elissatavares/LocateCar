package ada.locate.car.core.usecase;

import ada.locate.car.infra.dto.VehicleDTO;

import java.util.List;

public interface ReadVehicle {
    List<VehicleDTO> read(VehicleDTO vehicleDTO);
}
