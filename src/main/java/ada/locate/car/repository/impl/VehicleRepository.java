package ada.locate.car.repository.impl;

import ada.locate.car.core.model.Vehicle;
import ada.locate.car.repository.api.RepositoryVehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class VehicleRepository implements RepositoryVehicle {

    private final List<Vehicle> vehicleList = new ArrayList<>();
    private static VehicleRepository instance;

    private VehicleRepository() {}

    public static VehicleRepository getInstance() {
        if (instance == null) {
            instance = new VehicleRepository();
        }
        return instance;
    }


    @Override
    public boolean create(Vehicle vehicle) {
        return vehicleList.add(vehicle);
    }

    @Override
    public Optional<Vehicle> read(String key) {
        return vehicleList.stream()
                .filter(vehicle -> vehicle.getPlateNumber().equalsIgnoreCase(key))
                .findFirst();
    }

    @Override
    public boolean update(Vehicle newVehicle, Vehicle oldVehicle) {
        if (!vehicleList.remove(oldVehicle)) return false;
        vehicleList.add(newVehicle);
        return true;
    }

    @Override
    public boolean delete(Vehicle vehicle) {
        return vehicleList.remove(vehicle);
    }

    @Override
    public List<Vehicle> findAllByPredicate(Predicate<Vehicle> predicate) {
        return vehicleList.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> findAll() {
        return new ArrayList<>(vehicleList);
    }
}
