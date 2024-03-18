package ada.locate.car.DTO.utils.vehicle;

import ada.locate.car.DTO.VehicleDTO;

public class VehicleCreateDTO {
    public VehicleDTO buildVehicleDTO(String[] data, String model) {
        return new VehicleDTO.Builder()
                .brand(data[0])
                .yearManufacture(data[1])
                .color(data[2])
                .plateNumber(data[3])
                .model(model)
                .build();
    }
}
