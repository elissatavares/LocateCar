package ada.locate.car.service.client;

import ada.locate.car.core.model.Client;
import ada.locate.car.core.usecase.UpdateClient;
import ada.locate.car.infra.api.Repository;
import ada.locate.car.infra.dto.ClientDTO;
import ada.locate.car.infra.dto.VehicleDTO;


public class UpdateClientService implements UpdateClient {
    private final Repository<Client> repository;

    public UpdateClientService(Repository<Client> repository) {
        this.repository = repository;
    }


    @Override
    public void update(ClientDTO o) {

    }
}
