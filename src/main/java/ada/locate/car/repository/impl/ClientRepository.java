package ada.locate.car.repository.impl;

import ada.locate.car.core.model.Allocation;
import ada.locate.car.core.model.Client;
import ada.locate.car.repository.api.RepositoryClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepository implements RepositoryClient {

    private final List<Client> clientList = new ArrayList<>();

    private static ClientRepository instance;

    private ClientRepository() {}

    public static ClientRepository getInstance() {
        if (instance == null) {
            instance = new ClientRepository();
        }
        return instance;
    }

    @Override
    public boolean create(Client client) {
       return clientList.add(client);
    }

    @Override
    public Optional<Client> read(String key) {
        return clientList.stream()
                .filter(client -> client.getDocument().equals(key))
                .findFirst();
    }

    @Override
    public boolean update(Client updatedClient, Client oldClient) {
        if (clientList.contains(oldClient)) {
            clientList.remove(oldClient);
            clientList.add(updatedClient);
            return true; // Atualização bem-sucedida
        }
        return false; // Falha na atualização
    }

    @Override
    public boolean delete(Client client) {
        return clientList.remove(client); // Retorna true se removido com sucesso, false caso contrário
    }

    @Override
    public List<Client> findAll() {
        return new ArrayList<>(clientList); // Retorna uma cópia da lista de clientes para evitar modificação direta
    }

    @Override
    public boolean createAllocation(Allocation allocation, String key) {
        Optional<Client> clientOptional = read(key);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            allocation.getVehicle().wasRented();
            client.setAllocationList(allocation);
            System.out.println(client);
            return true; // Criação de alocação bem-sucedida
        }
        return false; // Falha na criação de alocação (cliente não encontrado)
    }

    @Override
    public boolean returnAllocation(Allocation allocation, String key) {
        Optional<Client> clientOptional = read(key);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            allocation.getVehicle().wasReturned();
            return client.getAllocationList().remove(allocation); // Retorna true se removido com sucesso, false caso contrário
        }
        return false; // Falha ao retornar alocação (cliente não encontrado)
    }

    @Override
    public List<Allocation> findAllAllocation(String key) {
        return read(key)
                .map(Client::getAllocationList)
                .orElse(new ArrayList<>());
    }

    @Override
    public Optional<Allocation> findAllocation(List<Allocation> allocationList, String plateNumber) {
        return allocationList.stream()
                .filter(allocation -> allocation.getVehicle().getPlateNumber().equalsIgnoreCase(plateNumber))
                .findFirst();
    }
}
