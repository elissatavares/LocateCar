package ada.locate.car.service.vehicle;

import ada.locate.car.core.model.Vehicle;
import ada.locate.car.core.usecase.vehicle.UpdateVehicle;
import ada.locate.car.repository.api.RepositoryVehicle;
import ada.locate.car.DTO.VehicleDTO;

public class UpdateVehicleService implements UpdateVehicle {

    private final RepositoryVehicle repository;

    public UpdateVehicleService(RepositoryVehicle repository) {
        this.repository = repository;
    }


    @Override
    public void execute(VehicleDTO vehicleDTO) {
        Vehicle oldVehicle = repository.read(vehicleDTO.plateNumber());
        Vehicle newVehicle = null;
        switch (vehicleDTO.description().toLowerCase()){
            case "color" -> newVehicle = new Vehicle(
                    oldVehicle.getBrand(),
                    oldVehicle.getYearManufacture(),
                    vehicleDTO.color(),
                    oldVehicle.getPlateNumber(),
                    oldVehicle.getModel());
            case "plate number" -> newVehicle = new Vehicle(
                    oldVehicle.getBrand(),
                    oldVehicle.getYearManufacture(),
                    oldVehicle.getColor(),
                    vehicleDTO.newPlateNumber(),
                    oldVehicle.getModel());
            case "plate color and number" -> newVehicle = new Vehicle(
                    oldVehicle.getBrand(),
                    oldVehicle.getYearManufacture(),
                    vehicleDTO.color(),
                    vehicleDTO.newPlateNumber(),
                    oldVehicle.getModel());
        }
        repository.update(newVehicle, oldVehicle);
    }
}
