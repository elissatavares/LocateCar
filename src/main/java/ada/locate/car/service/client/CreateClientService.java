package ada.locate.car.service.client;

import ada.locate.car.core.model.Client;
import ada.locate.car.core.model.ClientCPF;
import ada.locate.car.core.usecase.CreateClient;
import ada.locate.car.infra.api.Repository;
import ada.locate.car.infra.dto.ClientDTO;

import java.util.Objects;

public class CreateClientService implements CreateClient<ClientDTO> {

    private final Repository<Objects> clientRepository;

    public CreateClientService(Repository<Objects> clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void create(ClientDTO clientDTO) {
        Client client = new Client(
                clientDTO.name(),
                clientDTO.address(),
                clientDTO.phoneNumber(),
                clientDTO.email(),
                clientDTO.identification());
        clientRepository.create(client);
    }
}
