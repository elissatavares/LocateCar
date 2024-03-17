package ada.locate.car.service.client;

import ada.locate.car.core.model.Client;
import ada.locate.car.infra.repository.api.Repository;
import ada.locate.car.infra.dto.ClientDTO;
import ada.locate.car.core.usecase.ReadClient;

public class ReadClientService implements ReadClient {
    private final Repository<Client> clientRepository;

    public ReadClientService(Repository<Client> clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public ClientDTO execute(ClientDTO clientDTO) {
        Client client = clientRepository.read(clientDTO.document());
        return ClientDTO.convertClientToDTO(client);
    }
}
