package ada.locate.car.service.vehicle;

import ada.locate.car.core.model.Vehicle;
import ada.locate.car.core.usecase.DeleteVehicle;
import ada.locate.car.infra.api.RepositoryVehicle;
import ada.locate.car.infra.dto.VehicleDTO;

public class DeleteVehicleService implements DeleteVehicle {

    private final RepositoryVehicle repository;

    public DeleteVehicleService(RepositoryVehicle repository) {
        this.repository = repository;
    }


    @Override
    public void execute(VehicleDTO vehicleDTO) {
        Vehicle vehicle = repository.read(vehicleDTO.plateNumber());
        repository.delete(vehicle);
    }
}
