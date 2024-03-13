package ada.locate.car.service.vehicle;

import ada.locate.car.core.model.Vehicle;
import ada.locate.car.core.usecase.CreateVehicle;
import ada.locate.car.dto.VehicleDTO;
import ada.locate.car.infra.api.Repository;

public class CreateVehicleService implements CreateVehicle {

    private final Repository<Vehicle> vehicleRepository;

    public CreateVehicleService(Repository<Vehicle> vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    @Override
    public void create(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle(vehicleDTO.brand(),
                vehicleDTO.yearManufacture(),
                vehicleDTO.color(),
                vehicleDTO.plateNumber(),
                vehicleDTO.model());
        vehicleRepository.create(vehicle);
    }
}
