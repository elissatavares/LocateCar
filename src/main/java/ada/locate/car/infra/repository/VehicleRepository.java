package ada.locate.car.infra.repository;

import ada.locate.car.core.model.Vehicle;
import ada.locate.car.infra.api.RepositoryVehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class VehicleRepository implements RepositoryVehicle {

    List<Vehicle> vehicleList = new ArrayList<>(10);
    private static VehicleRepository instance;

    private VehicleRepository() {
    }

    public static VehicleRepository getInstance() {
        if (instance == null) {
            instance = new VehicleRepository();
        }
        return instance;
    }


    @Override
    public void create(Vehicle o) {
        vehicleList.add(o);

    }

    @Override
    public Vehicle read(String key) {
        return vehicleList.stream()
                .filter(vehicle -> vehicle.getPlateNumber().equalsIgnoreCase(key))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Vehicle newVehicle, Vehicle oldVehicle) {
        vehicleList.remove(oldVehicle);
        vehicleList.add(newVehicle);
    }

    @Override
    public void delete(Vehicle o) {
        vehicleList.remove(o);
    }


    @Override
    public List<Vehicle> findAll() {
        return vehicleList;
    }

    @Override
    public List<Vehicle> findAllByPredicate(Predicate<Vehicle> predicate) {
        return vehicleList.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
