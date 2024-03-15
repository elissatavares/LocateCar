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
        String searchType = config.front().inputOptionString().execute(MessagesVehicle.MENU_READ_VEHICLE.get(), MessagesVehicle.OPTION_READ.get());
        VehicleDTO vehicleDTO = buildSearchDTO(searchType);
        List<VehicleDTO> vehicleDTOList = config.service().read().execute(vehicleDTO);
        config.front().showInformation().execute(MessagesVehicle.RESULTS_SEARCH_FILTER.get(), vehicleDTOList.toString());
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
        return config.front().inputOptionString().execute(MessagesVehicle.MENU_INSERT_FILTER.get(), MessagesVehicle.OPTION_ALL_MODELS.get());
    }

    private String searchPlate() {
        return config.front().inputOnlyField().execute(MessagesVehicle.MENU_INSERT_FILTER.get(), MessagesVehicle.DESCRIPTION_ENTER_PLATE.get());
    }

    private String searchColor() {
        return config.front().inputOnlyField().execute(MessagesVehicle.MENU_INSERT_FILTER.get(), MessagesVehicle.DESCRIPTION_ENTER_COLOR.get());
    }
}