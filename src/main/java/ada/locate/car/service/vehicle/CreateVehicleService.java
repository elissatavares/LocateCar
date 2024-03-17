package ada.locate.car.service.vehicle;

import ada.locate.car.core.model.Vehicle;
import ada.locate.car.core.usecase.CreateVehicle;
import ada.locate.car.infra.api.RepositoryVehicle;
import ada.locate.car.infra.dto.VehicleDTO;

public class CreateVehicleService implements CreateVehicle {

    private final RepositoryVehicle repository;

    public CreateVehicleService(RepositoryVehicle repository) {
        this.repository = repository;
    }


    @Override
    public void execute(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle(vehicleDTO.brand(),
                vehicleDTO.yearManufacture(),
                vehicleDTO.color(),
                vehicleDTO.plateNumber(),
                vehicleDTO.model());
        repository.create(vehicle);
    }
}
