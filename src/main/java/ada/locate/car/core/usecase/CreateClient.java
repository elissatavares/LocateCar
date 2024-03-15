package ada.locate.car.core.usecase;

import ada.locate.car.infra.dto.ClientDTO;

public interface CreateClient {
    void create(ClientDTO clientDTO);
}
