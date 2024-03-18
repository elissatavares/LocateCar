package ada.locate.car.core.usecase.client;

import ada.locate.car.DTO.ClientDTO;

public interface ReadClient {
    ClientDTO execute(ClientDTO clientDTO);
}
