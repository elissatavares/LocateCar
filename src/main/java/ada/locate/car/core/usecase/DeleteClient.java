package ada.locate.car.core.usecase;

import ada.locate.car.infra.dto.ClientDTO;

public interface DeleteClient <T>{
    void delete(T o);
}
