package ada.locate.car.infra.repository;

import ada.locate.car.infra.data.api.CRUD;
import ada.locate.car.infra.repository.api.Repository;
import ada.locate.car.model.Vehicle;

import java.util.List;

public class VehicleRepository implements Repository<Vehicle> {
    private final CRUD<Vehicle> vehicleCRUD;

    public VehicleRepository(CRUD<Vehicle> vehicleCRUD) {
        this.vehicleCRUD = vehicleCRUD;
    }

    @Override
    public void create(Vehicle o) {

    }

    @Override
    public Vehicle read(Vehicle key) {
        return null;
    }

    @Override
    public void update(Vehicle o, Vehicle key) {

    }

    @Override
    public void delete(Vehicle o) {

    }

    @Override
    public List<Vehicle> findAllBySpecification(Vehicle o) {
        return null;
    }

    @Override
    public List<Vehicle> findAll() {
        return null;
    }
}
