package ada.locate.car.infra.repository;

import ada.locate.car.core.model.Client;
import ada.locate.car.infra.api.Repository;
import ada.locate.car.infra.dto.ClientDTO;

import java.util.ArrayList;
import java.util.List;

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


    // Lê cliente por Id | to do: trocar nome e atualizar onde é usado
    @Override
    public Client read(Client key) {
        for (Client client : clientList) {
            if (client.getId().equals(key.getId())) {
                return client;
            }
        }
        return null;
    }



    @Override
    public void update(Client oldClient, Client updatedClient) {
        int index = clientList.indexOf(oldClient);
        if (index != -1) {
            clientList.set(index, updatedClient);
        }
    }


    @Override
    public void delete(Client client) {
        // Implementar lógica para excluir um cliente
    }

    @Override
    public List<Client> findAll() {
        return clientList;
    }

    @Override
    public List<Client> findAllBySpecification(Client client) {
        // Implementar lógica para buscar clientes por especificação
        return null;
    }
}
