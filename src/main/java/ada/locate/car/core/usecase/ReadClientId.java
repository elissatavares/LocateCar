package ada.locate.car.core.usecase;

import ada.locate.car.infra.dto.ClientDTO;

public interface ReadClientId {
    ClientDTO read(String identification);
}
