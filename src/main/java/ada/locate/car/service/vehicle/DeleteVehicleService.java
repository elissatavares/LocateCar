package ada.locate.car.service.vehicle;

import ada.locate.car.core.model.Vehicle;
import ada.locate.car.core.usecase.vehicle.DeleteVehicle;
import ada.locate.car.repository.api.RepositoryVehicle;
import ada.locate.car.DTO.VehicleDTO;

import java.util.Optional;

public class DeleteVehicleService implements DeleteVehicle {

    private final RepositoryVehicle repository;

    public DeleteVehicleService(RepositoryVehicle repository) {
        this.repository = repository;
    }


    @Override
    public void execute(VehicleDTO vehicleDTO) {
        Optional<Vehicle> vehicle = repository.read(vehicleDTO.plateNumber());
        repository.delete(vehicle.get());
    }
}
