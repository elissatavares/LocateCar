package ada.locate.car.service.client;

import ada.locate.car.core.model.Client;
import ada.locate.car.core.usecase.client.DeleteClient;
import ada.locate.car.DTO.ClientDTO;
import ada.locate.car.repository.api.RepositoryClient;

public class DeleteClientService implements DeleteClient {
    private final RepositoryClient repository;

    public DeleteClientService(RepositoryClient clientRepository) {
        this.repository = clientRepository;
    }


    @Override
    public void execute(ClientDTO clientDTO) {
        Client client = repository.read(clientDTO.document());
        repository.delete(client);
    }
}
