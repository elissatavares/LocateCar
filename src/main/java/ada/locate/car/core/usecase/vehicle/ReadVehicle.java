package ada.locate.car.core.usecase.vehicle;

import ada.locate.car.DTO.VehicleDTO;

import java.util.List;

public interface ReadVehicle {
    List<VehicleDTO> execute(VehicleDTO vehicleDTO);
}
