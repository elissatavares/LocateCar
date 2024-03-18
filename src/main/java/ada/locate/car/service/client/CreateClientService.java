package ada.locate.car.service.client;

import ada.locate.car.core.model.Client;
import ada.locate.car.core.usecase.client.CreateClient;
import ada.locate.car.DTO.ClientDTO;
import ada.locate.car.repository.api.RepositoryClient;

public class CreateClientService implements CreateClient {

    private final RepositoryClient clientRepository;

    public CreateClientService(RepositoryClient clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public void execute(ClientDTO clientDTO) {
        //precisa chamar a camada security e valida se existe ou nao
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
