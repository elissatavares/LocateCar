package ada.locate.car.core.usecase;

import ada.locate.car.infra.dto.ClientDTO;


public interface CreateClient<T> {
    void create(T o);
}
