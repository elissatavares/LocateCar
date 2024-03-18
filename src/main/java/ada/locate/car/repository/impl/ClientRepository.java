package ada.locate.car.repository.impl;

import ada.locate.car.core.model.Allocation;
import ada.locate.car.core.model.Client;
import ada.locate.car.repository.api.RepositoryClient;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements RepositoryClient {

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

    @Override
    public void createAllocation(Allocation allocation, String key) {
        Client client = read(key);
        allocation.getVehicle().wasRented();
        client.setAllocationList(allocation);
        System.out.println(client);
    }

    @Override
    public void returnAllocation(Allocation allocation, String key) {
        Client client = read(key);
        allocation.getVehicle().wasReturned();
        client.getAllocationList().remove(allocation);
    }

    @Override
    public List<Allocation> findAllAllocation(String key) {
        Client client = read(key);
        return client.getAllocationList();
    }

    @Override
    public Allocation findAllocation(List<Allocation> allocationList, String plateNumber) {
        return allocationList.stream().
                filter(allocation -> allocation.getVehicle().getPlateNumber().equalsIgnoreCase(plateNumber))
                .findFirst().orElse(null);
    }
}
