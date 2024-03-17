package ada.locate.car.controller.impl.vehicle;

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
        String plateNumber = config.provider().delete().showExclusionField();
        VehicleDTO vehicleDTO = config.DTO().delete().buildVehicleDTO(plateNumber);
        config.service().delete().execute(vehicleDTO);
    }
}
