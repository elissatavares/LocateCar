package ada.locate.car.infra.provider.builder.vehicle;

import ada.locate.car.infra.dto.VehicleDTO;

import java.time.LocalDate;

public class VehicleCreateBuilder {
    public VehicleDTO buildVehicleDTO(String[] data, String model) {
        return new VehicleDTO.Builder()
                .brand(data[0])
                .yearManufacture(LocalDate.parse(data[1]))
                .color(data[2])
                .plateNumber(data[3])
                .model(model)
                .build();
    }
}
