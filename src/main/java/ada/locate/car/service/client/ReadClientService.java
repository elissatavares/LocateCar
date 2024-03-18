package ada.locate.car.service.client;

import ada.locate.car.core.model.Client;
import ada.locate.car.repository.api.Repository;
import ada.locate.car.DTO.ClientDTO;
import ada.locate.car.core.usecase.ReadClient;
import ada.locate.car.repository.api.RepositoryClient;

public class ReadClientService implements ReadClient {
    private final RepositoryClient clientRepository;

    public ReadClientService(RepositoryClient clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public ClientDTO execute(ClientDTO clientDTO) {
        Client client = clientRepository.read(clientDTO.document());
        return ClientDTO.convertClientToDTO(client);
    }
}
