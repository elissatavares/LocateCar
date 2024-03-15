package ada.locate.car.controller.impl.vehicle;

import ada.locate.car.app.messages.MessagesVehicle;
import ada.locate.car.app.config.vehicle.VehicleControllerImplConfig;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.infra.dto.VehicleDTO;

public class UpdateVehicleControllerImpl implements Controller {
    private final VehicleControllerImplConfig config;

    public UpdateVehicleControllerImpl(VehicleControllerImplConfig config) {
        this.config = config;
    }


    @Override
    public void execute() {
        String plateNumber = config.front().inputOnlyField().execute(MessagesVehicle.MENU_UPDATE_VEHICLE.get(), MessagesVehicle.DESCRIPTION_ENTER_PLATE.get());
        String searchType = config.front().inputOptionString().execute(MessagesVehicle.MENU_UPDATE_VEHICLE.get(), MessagesVehicle.OPTION_UPDATE_VEHICLE.get());
        VehicleDTO vehicleDTO = buildVehicleDTO(plateNumber, searchType.trim().toLowerCase());
        config.service().update().execute(vehicleDTO);
    }

    private VehicleDTO buildVehicleDTO(String plateNumber, String searchType) {
        return switch (searchType) {
            case "color" -> new VehicleDTO.Builder()
                    .color(colorUpdate())
                    .plateNumber(plateNumber)
                    .description(searchType)
                    .build();
            case "plate number" -> new VehicleDTO.Builder()
                    .plateNumber(plateNumber)
                    .description(searchType)
                    .newPlateNumber(plateNumberUpdate())
                    .build();
            case "plate color and number" -> {
                String[] colorAndNumber = plateColorAndNumber();
                yield new VehicleDTO.Builder()
                        .color(colorAndNumber[0])
                        .newPlateNumber(colorAndNumber[1])
                        .plateNumber(plateNumber)
                        .description(searchType)
                        .build();
            }
            default -> null;
        };
    }

    private String colorUpdate() {
        return config.front().inputOnlyField().execute(MessagesVehicle.MENU_UPDATE_VEHICLE.get(), MessagesVehicle.DESCRIPTION_UPDATE_COLOR_VEHICLE.get());
    }

    private String plateNumberUpdate() {
        return config.front().inputOnlyField().execute(MessagesVehicle.MENU_UPDATE_VEHICLE.get(), MessagesVehicle.DESCRIPTION_UPDATE_PLATE_VEHICLE.get());
    }

    private String[] plateColorAndNumber() {
        return config.front().inputMultipleFields().execute(MessagesVehicle.MENU_UPDATE_VEHICLE.get(), MessagesVehicle.OPTION_UPDATE_PLATE_COLOR.get());
    }
}
