package ada.locate.car.infra.provider.builder.vehicle;

import ada.locate.car.app.config.vehicle.ProviderVehicleConfig;
import ada.locate.car.infra.dto.VehicleDTO;

public class VehicleReadBuilder {
    private final ProviderVehicleConfig provider;

    public VehicleReadBuilder(ProviderVehicleConfig provider) {
        this.provider = provider;
    }

    public VehicleDTO buildSearchDTO(String searchType) {
        switch (searchType.toLowerCase()) {
            case "search by model":
                return new VehicleDTO.Builder().model(provider.read().searchModel()).description(searchType).build();
            case "search by plate":
                return new VehicleDTO.Builder().plateNumber(provider.read().searchPlate()).description(searchType).build();
            case "search by color":
                return new VehicleDTO.Builder().color(provider.read().searchColor()).description(searchType).build();
            case "search for available vehicles":
                return new VehicleDTO.Builder().description(searchType).build();
            default:
                return null;
        }
    }
    public VehicleDTO buildSearchDTOPlateNumber(String plateNumber){
        return new VehicleDTO.Builder().plateNumber(plateNumber).description("search by plate").build();
    }
}
