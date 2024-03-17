package ada.locate.car.infra.provider.builder.vehicle;

import ada.locate.car.app.config.vehicle.ProviderVehicleConfig;
import ada.locate.car.infra.dto.VehicleDTO;

public class VehicleUpdateBuilder {
    private final ProviderVehicleConfig provider;

    public VehicleUpdateBuilder(ProviderVehicleConfig provider) {
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
