package ada.locate.car.controller.impl.vehicle;

import ada.locate.car.app.messages.MessagesVehicle;
import ada.locate.car.app.config.vehicle.VehicleControllerImplConfig;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.infra.dto.VehicleDTO;

public class DeleteVehicleControllerImpl implements Controller {

    private final VehicleControllerImplConfig config;

    public DeleteVehicleControllerImpl(VehicleControllerImplConfig config) {
        this.config = config;
    }


    @Override
    public void execute() {
        String plateNumber = config.front().inputOnlyField().execute(MessagesVehicle.MENU_DELETE_VEHICLE.get(), MessagesVehicle.DESCRIPTION_DELETE_VEHICLE.get());
        VehicleDTO vehicleDTO = buildVehicleDTO(plateNumber);
        config.service().delete().execute(vehicleDTO);
        //deleteVehicleService.execute(vehicleDTO);
        config.front().showInformation().execute("Plate Number", plateNumber);
    }
    private VehicleDTO buildVehicleDTO(String plateNumber) {
        return new VehicleDTO.Builder()
                .plateNumber(plateNumber)
                .build();
    }
}
