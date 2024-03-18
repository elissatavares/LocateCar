package ada.locate.car.DTO.utils.vehicle;

import ada.locate.car.DTO.VehicleDTO;

public class VehicleDeleteDTO {
    public VehicleDTO buildVehicleDTO(String plateNumber) {
        return new VehicleDTO.Builder()
                .plateNumber(plateNumber)
                .build();
    }
}
