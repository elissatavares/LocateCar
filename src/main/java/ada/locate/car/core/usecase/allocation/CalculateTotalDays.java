package ada.locate.car.core.usecase.allocation;

import ada.locate.car.core.model.Allocation;

public interface CalculateTotalDays {
    Long totalDays(String finalDay, Allocation allocation);
}
