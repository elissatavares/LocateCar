package ada.locate.car.infra.repository;

import ada.locate.car.core.model.Client;
import ada.locate.car.infra.api.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ClientRepository implements Repository<Client> {

    List<Client> clientCPFList = new ArrayList<>(10);
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
    public void create(Client o) {

    }

    @Override
    public Client read(String key) {
        return null;
    }

    @Override
    public void update(Client o, Client key) {

    }

    @Override
    public void delete(Client o) {

    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public List<Client> findAllByPredicate(Predicate<Client> predicate) {
        return null;
    }
}
