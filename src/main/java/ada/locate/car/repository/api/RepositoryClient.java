package ada.locate.car.repository.api;

import ada.locate.car.core.model.Allocation;
import ada.locate.car.core.model.Client;
import ada.locate.car.core.model.Vehicle;

import java.util.List;
import java.util.function.Predicate;

public interface RepositoryClient extends Repository<Client>{
    void createAllocation(Allocation allocation, String key);
    void returnAllocation(Allocation allocation, String key);
    List<Allocation> findAllAllocation(String key);
    Allocation findAllocation(List<Allocation> allocationList, String key);
}
