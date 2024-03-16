package ada.locate.car.service.vehicle;

import ada.locate.car.core.model.Vehicle;
import ada.locate.car.core.usecase.CreateVehicle;
import ada.locate.car.infra.dto.VehicleDTO;
import ada.locate.car.infra.api.Repository;

public class CreateVehicleService implements CreateVehicle {

    private final Repository<Vehicle> repository;

    public CreateVehicleService(Repository<Vehicle> vehicleRepository) {
        this.repository = vehicleRepository;
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
