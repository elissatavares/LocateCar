package ada.locate.car.infra.data.base;

import ada.locate.car.infra.data.api.CRUD;
import ada.locate.car.model.ClientCPF;

import java.util.ArrayList;
import java.util.List;

public class ClientCPFBase implements CRUD<ClientCPF> {

    List<ClientCPF> clientCPFList = new ArrayList<>(10);
    private static ClientCPFBase instance;

    private ClientCPFBase() {
    }

    public static ClientCPFBase getInstance() {
        if (instance == null) {
            instance = new ClientCPFBase();
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
    public List<ClientCPF> findAll() {
        return null;
    }
}
