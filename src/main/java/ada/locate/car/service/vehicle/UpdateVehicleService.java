package ada.locate.car.service.vehicle;

import ada.locate.car.core.model.Vehicle;
import ada.locate.car.core.usecase.UpdateVehicle;
import ada.locate.car.infra.dto.VehicleDTO;
import ada.locate.car.infra.api.Repository;

public class UpdateVehicleService implements UpdateVehicle {

    private final Repository<Vehicle> repository;

    public UpdateVehicleService(Repository<Vehicle> vehicleRepository) {
        this.repository = vehicleRepository;
    }


    @Override
    public void execute(VehicleDTO o) {

    }
}
