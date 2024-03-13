package ada.locate.car.infra.repository;

import ada.locate.car.infra.api.Repository;
import ada.locate.car.core.model.ClientCPF;

import java.util.ArrayList;
import java.util.List;

public class ClientCPFRepository implements Repository<ClientCPF> {
    List<ClientCPF> clientCPFList = new ArrayList<>(10);
    private static ClientCPFRepository instance;

    private ClientCPFRepository() {
    }

    public static ClientCPFRepository getInstance() {
        if (instance == null) {
            instance = new ClientCPFRepository();
        }
        return instance;
    }

    @Override
    public void create(ClientCPF o) {
        clientCPFList.add(o);
    }

    @Override
    public ClientCPF read(ClientCPF key) {
        return null;
    }

    @Override
    public void update(ClientCPF o, ClientCPF key) {

    }

    @Override
    public void delete(ClientCPF o) {

    }

    @Override
    public List<ClientCPF> findAllBySpecification(ClientCPF o) {
        return null;
    }

    @Override
    public List<ClientCPF> findAll() {
        return null;
    }
}
