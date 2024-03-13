package ada.locate.car.service.vehicle;

import ada.locate.car.core.model.Vehicle;
import ada.locate.car.core.usecase.DeleteVehicle;
import ada.locate.car.infra.api.Repository;

public class DeleteVehicleService implements DeleteVehicle {

    private final Repository<Vehicle> vehicleRepository;

    public DeleteVehicleService(Repository<Vehicle> vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    @Override
    public void delete() {
    
    }
}
