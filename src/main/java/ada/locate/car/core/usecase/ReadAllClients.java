package ada.locate.car.core.usecase;

import ada.locate.car.infra.dto.ClientDTO;

import java.util.List;

public interface ReadAllClients {
    List<ClientDTO> readAll();
}
