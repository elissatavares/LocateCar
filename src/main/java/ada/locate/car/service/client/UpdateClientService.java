package ada.locate.car.service.client;

import ada.locate.car.core.model.Client;
import ada.locate.car.core.usecase.client.UpdateClient;
import ada.locate.car.DTO.ClientDTO;
import ada.locate.car.repository.api.RepositoryClient;

import java.util.Optional;

public class UpdateClientService implements UpdateClient {

    private final RepositoryClient clientRepository;

    public UpdateClientService(RepositoryClient clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDTO execute(ClientDTO clientDTO) {
        //precisa chamar a camada security e valida se existe ou nao
        Optional<Client> oldClient = clientRepository.read(clientDTO.document());
        Client updatedClient = null;
        switch (clientDTO.description().toLowerCase()){
            case "name" -> updatedClient = new Client(
                    clientDTO.name(),
                    oldClient.get().getAddress(),
                    oldClient.get().getPhoneNumber(),
                    oldClient.get().getEmail(),
                    oldClient.get().getIdentification(),
                    oldClient.get().getDocument());
            case "address" ->
                    updatedClient = new Client(
                            oldClient.get().getName(),
                            clientDTO.address(),
                            oldClient.get().getPhoneNumber(),
                            oldClient.get().getEmail(),
                            oldClient.get().getIdentification(),
                            oldClient.get().getDocument());
            case "phone number" ->
                    updatedClient = new Client(
                            oldClient.get().getName(),
                            oldClient.get().getAddress(),
                            clientDTO.phoneNumber(),
                            oldClient.get().getEmail(),
                            oldClient.get().getIdentification(),
                            oldClient.get().getDocument());
            case "email" -> updatedClient = new Client(
                    oldClient.get().getName(),
                    oldClient.get().getAddress(),
                    oldClient.get().getPhoneNumber(),
                    clientDTO.email(),
                    oldClient.get().getIdentification(),
                    oldClient.get().getDocument());
        }
        clientRepository.update(updatedClient, oldClient.get());
        return ClientDTO.convertClientToDTO(updatedClient);
    }
}