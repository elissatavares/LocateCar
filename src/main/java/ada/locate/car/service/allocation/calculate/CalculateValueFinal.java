package ada.locate.car.service.allocation.calculate;

import ada.locate.car.core.usecase.allocation.CalculateDiscount;
import ada.locate.car.core.usecase.allocation.CalculateTotalDays;
import ada.locate.car.core.usecase.allocation.CalculateValueModel;

public class CalculateValueFinal {
    private final CalculateTotalDays calculateTotalDays;
    private final CalculateValueModel calculateValueModel;
    private final CalculateDiscount calculateDiscount;

    public CalculateValueFinal(CalculateValueModel calculateValueModel, CalculateDiscount calculateDiscount, CalculateTotalDays calculateTotalDays) {
        this.calculateValueModel = calculateValueModel;
        this.calculateDiscount = calculateDiscount;
        this.calculateTotalDays = calculateTotalDays;
    }

}
