package ada.locate.car.service.client;

import ada.locate.car.core.model.Client;
import ada.locate.car.core.usecase.UpdateClient;
import ada.locate.car.repository.api.Repository;
import ada.locate.car.DTO.ClientDTO;
import ada.locate.car.repository.api.RepositoryClient;

public class UpdateClientService implements UpdateClient {

    private final RepositoryClient clientRepository;

    public UpdateClientService(RepositoryClient clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDTO execute(ClientDTO clientDTO) {
        Client oldClient = clientRepository.read(clientDTO.document());
        Client updatedClient = null;
        switch (clientDTO.description().toLowerCase()){
            case "name" -> updatedClient = new Client(
                    clientDTO.name(),
                    oldClient.getAddress(),
                    oldClient.getPhoneNumber(),
                    oldClient.getEmail(),
                    oldClient.getIdentification(),
                    oldClient.getDocument());
            case "address" ->
                    updatedClient = new Client(
                            oldClient.getName(),
                            clientDTO.address(),
                            oldClient.getPhoneNumber(),
                            oldClient.getEmail(),
                            oldClient.getIdentification(),
                            oldClient.getDocument());
            case "phone number" ->
                    updatedClient = new Client(
                            oldClient.getName(),
                            oldClient.getAddress(),
                            clientDTO.phoneNumber(),
                            oldClient.getEmail(),
                            oldClient.getIdentification(),
                            oldClient.getDocument());
            case "email" -> updatedClient = new Client(
                    oldClient.getName(),
                    oldClient.getAddress(),
                    oldClient.getPhoneNumber(),
                    clientDTO.email(),
                    oldClient.getIdentification(),
                    oldClient.getDocument());
        }
        clientRepository.update(updatedClient, oldClient);
        return ClientDTO.convertClientToDTO(updatedClient);
    }
}