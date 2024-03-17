package ada.locate.car.repository.api;

import ada.locate.car.core.model.Allocation;
import ada.locate.car.core.model.Client;

public interface RepositoryClient extends Repository<Client>{
    void createAllocation(Allocation allocation, String key);
}
