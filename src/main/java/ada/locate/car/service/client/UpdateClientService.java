package ada.locate.car.service.client;

import ada.locate.car.core.model.Client;
import ada.locate.car.core.usecase.UpdateClient;
import ada.locate.car.infra.api.Repository;
import ada.locate.car.infra.dto.ClientDTO;

public class UpdateClientService implements UpdateClient {

    private final Repository<Client> clientRepository;

    public UpdateClientService(Repository<Client> repository) {
        this.clientRepository = repository;
    }

    @Override
    public void update(String clientId, String[] updatedFields) {
        Client clientToUpdate = clientRepository.read(new Client(clientId, null, null, null, null));
        if (clientToUpdate != null) {
            for (int i = 0; i < updatedFields.length; i++) {
                switch (i) {
                    case 0:
                        clientToUpdate.setName(updatedFields[i]);
                        break;
                    case 1:
                        clientToUpdate.setAddress(updatedFields[i]);
                        break;
                    case 2:
                        clientToUpdate.setPhoneNumber(updatedFields[i]);
                        break;
                    case 3:
                        clientToUpdate.setEmail(updatedFields[i]);
                        break;
                    case 4:
                        clientToUpdate.setIdentification(updatedFields[i]);
                        break;
                }
            }
            clientRepository.update(clientToUpdate, null);
        }
    }

//    @Override
//    public void update(Client clientToUpdate, Client updatedClient) {
//        clientRepository.update(clientToUpdate, updatedClient);
//    }


}
//public void create(ClientDTO clientDTO) {
//    Client client = new Client(
//            clientDTO.name(),
//            clientDTO.address(),
//            clientDTO.phoneNumber(),
//            clientDTO.email(),
//            clientDTO.identification());
//    clientRepository.create(client);