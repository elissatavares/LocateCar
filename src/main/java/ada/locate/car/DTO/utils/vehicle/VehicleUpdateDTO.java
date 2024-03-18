package ada.locate.car.DTO.utils.vehicle;

import ada.locate.car.config.record.vehicle.ProviderVehicleConfig;
import ada.locate.car.DTO.VehicleDTO;

public class VehicleUpdateDTO {
    private final ProviderVehicleConfig provider;

    public VehicleUpdateDTO(ProviderVehicleConfig provider) {
        this.provider = provider;
    }

    public VehicleDTO buildVehicleDTO(String plateNumber, String searchType) {
        switch (searchType.toLowerCase()) {
            case "color":
                return new VehicleDTO.Builder()
                        .color(provider.update().colorUpdate())
                        .plateNumber(plateNumber)
                        .description(searchType)
                        .build();
            case "plate number":
                return new VehicleDTO.Builder()
                        .plateNumber(plateNumber)
                        .description(searchType)
                        .newPlateNumber(provider.update().plateNumberUpdate())
                        .build();
            case "plate color and number":
                String[] colorAndNumber = provider.update().plateColorAndNumber();
                return new VehicleDTO.Builder()
                        .color(colorAndNumber[0])
                        .newPlateNumber(colorAndNumber[1])
                        .plateNumber(plateNumber)
                        .description(searchType)
                        .build();
            default:
                return null;
        }
    }
}
