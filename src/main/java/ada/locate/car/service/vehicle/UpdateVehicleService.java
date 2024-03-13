package ada.locate.car.service.vehicle;

import ada.locate.car.core.model.Vehicle;
import ada.locate.car.core.usecase.UpdateVehicle;
import ada.locate.car.dto.VehicleDTO;
import ada.locate.car.infra.api.Repository;

public class UpdateVehicleService implements UpdateVehicle<VehicleDTO> {

    private final Repository<Vehicle> vehicleRepository;

    public UpdateVehicleService(Repository<Vehicle> vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    @Override
    public void update(VehicleDTO o) {

    }
}
