package ada.locate.car.repository.api;

import ada.locate.car.core.model.Allocation;
import ada.locate.car.core.model.Client;

import java.util.List;
import java.util.Optional;

public interface RepositoryClient extends Repository<Client>{
    boolean createAllocation(Allocation allocation, String key);
    boolean returnAllocation(Allocation allocation, String key);
    List<Allocation> findAllAllocation(String key);
    Optional<Allocation> findAllocation(List<Allocation> allocationList, String key);
}
