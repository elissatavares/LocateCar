package ada.locate.car.service.vehicle;

import ada.locate.car.core.model.Vehicle;
import ada.locate.car.core.usecase.DeleteVehicle;
import ada.locate.car.infra.dto.VehicleDTO;
import ada.locate.car.infra.api.Repository;

public class DeleteVehicleService implements DeleteVehicle {

    private final Repository<Vehicle> repository;

    public DeleteVehicleService(Repository<Vehicle> vehicleRepository) {
        this.repository = vehicleRepository;
    }


    @Override
    public void execute(VehicleDTO o) {
        Vehicle vehicle = repository.read(o.color());
        repository.delete(vehicle);
    }
}
