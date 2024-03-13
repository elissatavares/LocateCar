package ada.locate.car.service.client;

import ada.locate.car.core.model.Client;
import ada.locate.car.core.usecase.UpdateClient;
import ada.locate.car.infra.api.Repository;
import ada.locate.car.infra.dto.ClientDTO;


public class UpdateClientService implements UpdateClient<ClientDTO> {
    private final Repository<Client> clientRepository;

    public UpdateClientService(Repository<Client> clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void update( o) {

    }
}
