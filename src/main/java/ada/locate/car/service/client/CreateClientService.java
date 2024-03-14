package ada.locate.car.service.client;

import ada.locate.car.core.model.Client;
import ada.locate.car.core.usecase.CreateClient;
import ada.locate.car.infra.api.Repository;
import ada.locate.car.infra.dto.ClientDTO;


public class CreateClientService implements CreateClient {

    private final Repository<Client> repository;

    public CreateClientService(Repository<Client> repository) {
        this.repository = repository;
    }


    @Override
    public void create(ClientDTO clientDTO) {
        Client client = new Client(
                clientDTO.name(),
                clientDTO.address(),
                clientDTO.phoneNumber(),
                clientDTO.email(),
                clientDTO.identification());
        repository.create(client);
    }
}
