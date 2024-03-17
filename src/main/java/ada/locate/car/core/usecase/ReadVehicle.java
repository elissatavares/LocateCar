package ada.locate.car.core.usecase;

import ada.locate.car.DTO.VehicleDTO;

import java.util.List;

public interface ReadVehicle {
    List<VehicleDTO> execute(VehicleDTO vehicleDTO);
}
