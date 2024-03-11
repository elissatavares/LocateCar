package ada.locate.car.infra.repository;

import ada.locate.car.infra.data.api.CRUD;
import ada.locate.car.infra.repository.api.Repository;
import ada.locate.car.model.ClientCPF;

import java.util.List;

public class ClientCPFRepository implements Repository<ClientCPF> {
    private final CRUD<ClientCPF> clientCPFCRUD;

    public ClientCPFRepository(CRUD<ClientCPF> clientCPFCRUD) {
        this.clientCPFCRUD = clientCPFCRUD;
    }

    @Override
    public void create(ClientCPF o) {
        clientCPFCRUD.create(o);
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
