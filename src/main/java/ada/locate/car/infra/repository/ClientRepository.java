package ada.locate.car.infra.repository;

import ada.locate.car.core.model.Client;
import ada.locate.car.infra.api.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ClientRepository implements Repository<Client> {

    private List<Client> clientList = new ArrayList<>();

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
    public void create(Client client) {
        clientList.add(client);

    }

    @Override
    public Client read(String key) {
        return clientList.stream()
                .filter(client -> client.getDocument().equals(key))
                .findFirst()
                .orElse(null);
    }



    @Override
    public void update(Client updatedClient, Client oldClient) {
        clientList.add(updatedClient);
        clientList.remove(oldClient);
    }


    @Override
    public void delete(Client client) {
        clientList.remove(client);
    }

    @Override
    public List<Client> findAll() {
        return clientList;
    }

}
