package ada.locate.car.infra.provider.builder.vehicle;

import ada.locate.car.infra.dto.VehicleDTO;

public class VehicleDeleteBuilder {
    public VehicleDTO buildVehicleDTO(String plateNumber) {
        return new VehicleDTO.Builder()
                .plateNumber(plateNumber)
                .build();
    }
}
