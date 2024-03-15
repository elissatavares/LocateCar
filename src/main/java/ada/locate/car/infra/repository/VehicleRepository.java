package ada.locate.car.infra.repository;

import ada.locate.car.infra.api.Repository;
import ada.locate.car.core.model.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class VehicleRepository implements Repository<Vehicle> {

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
        return null;
    }

    @Override
    public void update(Vehicle o, Vehicle key) {

    }

    @Override
    public void delete(Vehicle o) {

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