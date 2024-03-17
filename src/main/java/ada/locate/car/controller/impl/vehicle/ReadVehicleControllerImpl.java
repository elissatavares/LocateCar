package ada.locate.car.controller.impl.vehicle;

import ada.locate.car.app.messages.MessagesVehicle;
import ada.locate.car.app.config.vehicle.VehicleControllerImplConfig;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.infra.dto.VehicleDTO;

import java.util.List;

public class ReadVehicleControllerImpl implements Controller {
    private final VehicleControllerImplConfig config;

    public ReadVehicleControllerImpl(VehicleControllerImplConfig config) {
        this.config = config;
    }


    @Override
    public void execute() {
        String searchType = config.front().showInputOptionsReadVehicle().execute();
        VehicleDTO vehicleDTO = buildSearchDTO(searchType);
        List<VehicleDTO> vehicleDTOList = config.service().read().execute(vehicleDTO);
        config.front().readVehicle().execute(VehicleDTO.formatVehicleList(vehicleDTOList));
    }

    private VehicleDTO buildSearchDTO(String searchType) {
        return switch (searchType.toLowerCase()) {
            case "search by model" -> new VehicleDTO.Builder().model(searchModel()).description(searchType).build();
            case "search by plate" ->
                    new VehicleDTO.Builder().plateNumber(searchPlate()).description(searchType).build();
            case "search by color" -> new VehicleDTO.Builder().color(searchColor()).description(searchType).build();
            case "search all", "search for available vehicles" -> new VehicleDTO.Builder().description(searchType).build();
            default -> null;
        };
    }

    private String searchModel() {
        return config.front().showInputOptionsInsertModelFilter().execute();
    }

    private String searchPlate() {
        return config.front().showFilterPlateEntry().execute();
    }

    private String searchColor() {
        return config.front().showFilterColorEntry().execute();
    }
}