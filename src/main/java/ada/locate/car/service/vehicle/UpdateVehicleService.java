package ada.locate.car.service.vehicle;

import ada.locate.car.core.model.Vehicle;
import ada.locate.car.core.usecase.vehicle.UpdateVehicle;
import ada.locate.car.repository.api.RepositoryVehicle;
import ada.locate.car.DTO.VehicleDTO;

import java.util.Optional;

public class UpdateVehicleService implements UpdateVehicle {

    private final RepositoryVehicle repository;

    public UpdateVehicleService(RepositoryVehicle repository) {
        this.repository = repository;
    }


    @Override
    public void execute(VehicleDTO vehicleDTO) {
        Optional<Vehicle> oldVehicle = repository.read(vehicleDTO.plateNumber());
        Vehicle newVehicle = null;
        switch (vehicleDTO.description().toLowerCase()){
            case "color" -> newVehicle = new Vehicle(
                    oldVehicle.get().getBrand(),
                    oldVehicle.get().getYearManufacture(),
                    vehicleDTO.color(),
                    oldVehicle.get().getPlateNumber(),
                    oldVehicle.get().getModel());
            case "plate number" -> newVehicle = new Vehicle(
                    oldVehicle.get().getBrand(),
                    oldVehicle.get().getYearManufacture(),
                    oldVehicle.get().getColor(),
                    vehicleDTO.newPlateNumber(),
                    oldVehicle.get().getModel());
            case "plate color and number" -> newVehicle = new Vehicle(
                    oldVehicle.get().getBrand(),
                    oldVehicle.get().getYearManufacture(),
                    vehicleDTO.color(),
                    vehicleDTO.newPlateNumber(),
                    oldVehicle.get().getModel());
        }
        repository.update(newVehicle, oldVehicle.get());
    }
}
