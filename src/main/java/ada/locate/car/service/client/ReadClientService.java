package ada.locate.car.service.client;

import ada.locate.car.core.model.Client;
import ada.locate.car.DTO.ClientDTO;
import ada.locate.car.core.usecase.client.ReadClient;
import ada.locate.car.repository.api.RepositoryClient;

import java.util.Optional;

public class ReadClientService implements ReadClient {
    private final RepositoryClient clientRepository;

    public ReadClientService(RepositoryClient clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public ClientDTO execute(ClientDTO clientDTO) {
        //precisa chamar a camada security e valida se existe ou nao
        Optional<Client> client = clientRepository.read(clientDTO.document());
        return ClientDTO.convertClientToDTO(client.get());
    }
}
