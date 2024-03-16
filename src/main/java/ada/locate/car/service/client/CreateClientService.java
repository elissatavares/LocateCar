package ada.locate.car.service.client;

import ada.locate.car.core.model.Client;
import ada.locate.car.core.usecase.CreateClient;
import ada.locate.car.infra.api.Repository;
import ada.locate.car.infra.dto.ClientDTO;

public class CreateClientService implements CreateClient {

    private final Repository<Client> clientRepository;

    public CreateClientService(Repository<Client> clientRepository) {

        this.clientRepository = clientRepository;
    }

    @Override
    public void execute(ClientDTO clientDTO) {
        Client client = new Client(
                clientDTO.name(),
                clientDTO.address(),
                clientDTO.phoneNumber(),
                clientDTO.email(),
                clientDTO.flagIdentification(),
                clientDTO.document());
        System.out.println(client);
        clientRepository.create(client);
    }
}
