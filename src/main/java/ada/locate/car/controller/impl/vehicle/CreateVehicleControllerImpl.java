package ada.locate.car.controller.impl.vehicle;

import ada.locate.car.app.messages.MessagesVehicle;
import ada.locate.car.app.config.vehicle.VehicleControllerImplConfig;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.infra.dto.VehicleDTO;

import java.time.LocalDate;
public class CreateVehicleControllerImpl implements Controller {

    private final VehicleControllerImplConfig config;

    public CreateVehicleControllerImpl(VehicleControllerImplConfig config) {
        this.config = config;
    }


    @Override
    public void execute() {
        String[] data = config.front().inputMultipleFields().execute(MessagesVehicle.DESCRIPTION_INSERT_DATA.get(), MessagesVehicle.DESCRIPTION_ALL_DATA.get());
        String model = config.front().inputOptionString().execute(MessagesVehicle.MENU_SELECT_MODEL.get(), MessagesVehicle.OPTION_ALL_MODELS.get());
        VehicleDTO vehicleDTO = buildVehicleDTO(data, model);
        config.service().create().execute(vehicleDTO);
        config.front().showInformation().execute(MessagesVehicle.VEHICLE_DETAILS.get(), vehicleDTO.toString());
    }
    private VehicleDTO buildVehicleDTO(String[] data, String model) {
        return new VehicleDTO.Builder()
                .brand(data[0])
                .yearManufacture(LocalDate.parse(data[1]))
                .color(data[2])
                .plateNumber(data[3])
                .model(model)
                .build();
    }
}
