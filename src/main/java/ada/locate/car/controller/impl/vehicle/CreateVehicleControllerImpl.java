package ada.locate.car.controller.impl.vehicle;

import ada.locate.car.app.config.vehicle.VehicleControllerImplConfig;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.infra.dto.VehicleDTO;

public class CreateVehicleControllerImpl implements Controller {

    private final VehicleControllerImplConfig config;

    public CreateVehicleControllerImpl(VehicleControllerImplConfig config) {
        this.config = config;
    }


    @Override
    public void execute() {
        String[] data = config.provider().create().showDataVehicleEntry();
        String model = config.provider().create().showInputOptionsModel();
        VehicleDTO vehicleDTO = config.DTO().create().buildVehicleDTO(data, model);
        config.service().create().execute(vehicleDTO);
        config.provider().output().details(vehicleDTO.toString());
    }
}
