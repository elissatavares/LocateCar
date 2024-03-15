package ada.locate.car.service.vehicle;

import ada.locate.car.core.model.Vehicle;
import ada.locate.car.core.usecase.ReadVehicle;
import ada.locate.car.infra.api.Repository;
import ada.locate.car.infra.dto.VehicleDTO;

import java.util.ArrayList;
import java.util.List;

public class ReadVehicleService implements ReadVehicle {
    private final Repository<Vehicle> repository;

    public ReadVehicleService(Repository<Vehicle> repository) {
        this.repository = repository;
    }

    @Override
    public List<VehicleDTO> read(VehicleDTO vehicleDTO) {
        List<Vehicle> list = new ArrayList<>(10);
        switch (vehicleDTO.description().toLowerCase()){
            case "search by model" -> list = searchByModelAvailable(vehicleDTO.model());
            case "search by plate" -> list = searchByPlateAvailable(vehicleDTO.plateNumber());
            case "search by color" -> list = searchByColorAvailable(vehicleDTO.color());
            case "search all" -> list = repository.findAll();
            case "search for available vehicles" -> list = searchForAvailable();
        }
        return vehicleDTO.convertToVehicleDTO(list);
    }

    private List<Vehicle> searchByModelAvailable(String model) {
        return repository.findAllByPredicate(vehicle -> vehicle.getModel().equalsIgnoreCase(model) && vehicle.isAvailable());
    }

    private List<Vehicle> searchByPlateAvailable(String plate) {
        return repository.findAllByPredicate(vehicle -> vehicle.getPlateNumber().equalsIgnoreCase(plate) && vehicle.isAvailable());
    }

    private List<Vehicle> searchByColorAvailable(String color) {
        return repository.findAllByPredicate(vehicle -> vehicle.getColor().equalsIgnoreCase(color));
    }

    private List<Vehicle> searchForAvailable(){
        return repository.findAllByPredicate(Vehicle::isAvailable);
    }

}
