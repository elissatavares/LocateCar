package ada.locate.car.service.allocation.calculate;

import ada.locate.car.core.usecase.allocation.CalculateValueModel;

public enum CalculateValuePerModel implements CalculateValueModel {
    
    SMALL {
        final double dailyRateSmall = 100.00;
        @Override
        public double valueModel(Long totalDays) {
            return value(totalDays, dailyRateSmall);
        }
    },
    MEDIUM {
        final double dailyRateMedium = 150.00;
        @Override
        public double valueModel(Long totalDays) {
            return value(totalDays, dailyRateMedium);
        }
    },
    SUV {
        final double dailyRateSUV = 200.00;
        @Override
        public double valueModel(Long totalDays) {
            return value(totalDays, dailyRateSUV);
        }
    };
    private static double value(Long days, double dailyRateModel){
        double initialValue = 0.0;
        return dailyRateModel * days;
    }
}
