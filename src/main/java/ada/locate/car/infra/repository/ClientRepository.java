package ada.locate.car.infra.repository;

import ada.locate.car.infra.api.Repository;
import ada.locate.car.core.model.ClientCPF;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClientRepository implements Repository<Objects> {
    List<Objects> clientList = new ArrayList<>(10);
    private static ClientRepository instance;
    private ClientRepository() {
    }

    public static ClientRepository getInstance() {
        if (instance == null) {
            instance = new ClientRepository();
        }
        return instance;
    }

    @Override
    public void create(Objects o) {
        clientList.add(o);
    }

    @Override
    public Objects read(Objects key) {
        return null;
    }

    @Override
    public void update(Objects o, Objects key) {

    }

    @Override
    public void delete(Objects o) {

    }

    @Override
    public List<Objects> findAll() {
        return null;
    }

    @Override
    public List<Objects> findAllBySpecification(Objects o) {
        return null;
    }
}
