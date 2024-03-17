package ada.locate.car.service.client;

import ada.locate.car.core.model.Client;
import ada.locate.car.core.usecase.DeleteClient;
import ada.locate.car.infra.repository.api.Repository;
import ada.locate.car.infra.dto.ClientDTO;

public class DeleteClientService implements DeleteClient {
    private final Repository<Client> repository;

    public DeleteClientService(Repository<Client> repository) {
        this.repository = repository;
    }


    @Override
    public void execute(ClientDTO clientDTO) {
        Client client = repository.read(clientDTO.document());
        repository.delete(client);
    }
}
