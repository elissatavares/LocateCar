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
            case "search by model" -> list = searchByModel(vehicleDTO.model());
            case "search by plate" -> list = searchByPlate(vehicleDTO.plateNumber());
            case "search by color" -> list = searchByColor(vehicleDTO.color());
            case "search all" -> list = repository.findAll();
        }
        return vehicleDTO.convertToVehicleDTO(list);
    }

    private List<Vehicle> searchByModel(String model) {
        return repository.findAllByPredicate(vehicle -> vehicle.getModel().equalsIgnoreCase(model) && vehicle.isAvailable());
    }

    private List<Vehicle> searchByPlate(String plate) {
        return repository.findAllByPredicate(vehicle -> vehicle.getPlateNumber().equalsIgnoreCase(plate)&& vehicle.isAvailable());
    }

    private List<Vehicle> searchByColor(String color) {
        return repository.findAllByPredicate(vehicle -> vehicle.getColor().equalsIgnoreCase(color)&& vehicle.isAvailable());
    }
}
