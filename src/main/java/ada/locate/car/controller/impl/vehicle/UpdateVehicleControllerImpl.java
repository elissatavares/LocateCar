package ada.locate.car.controller.impl.vehicle;

import ada.locate.car.app.config.vehicle.VehicleControllerImplConfig;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.DTO.VehicleDTO;

public class UpdateVehicleControllerImpl implements Controller {
    private final VehicleControllerImplConfig config;

    public UpdateVehicleControllerImpl(VehicleControllerImplConfig config) {
        this.config = config;
    }


    @Override
    public void execute() {
        String plateNumber = config.provider().update().showUpdatePlateEntry();
        String searchType = config.provider().update().showInputOptionsUpdateVehicle();
        VehicleDTO vehicleDTO = config.DTO().update().buildVehicleDTO(plateNumber, searchType);
        config.service().update().execute(vehicleDTO);
    }
}
