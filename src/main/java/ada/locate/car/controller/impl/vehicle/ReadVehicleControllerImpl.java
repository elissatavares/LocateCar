package ada.locate.car.controller.impl.vehicle;

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
        String searchType = config.provider().read().showInputOptionsReadVehicle();
        VehicleDTO vehicleDTO = config.DTO().search().buildSearchDTO(searchType);
        List<VehicleDTO> vehicleDTOList = config.service().read().execute(vehicleDTO);
        config.provider().output().details(VehicleDTO.formatVehicleList(vehicleDTOList));
    }
}