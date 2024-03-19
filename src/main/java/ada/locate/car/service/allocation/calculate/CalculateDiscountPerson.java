package ada.locate.car.service.allocation.calculate;

import ada.locate.car.core.usecase.allocation.CalculateDiscount;

public enum CalculateDiscountPerson implements CalculateDiscount {
    CLT {
        @Override
        public double value(Long days, double value) {
            if (days > 3) {
                value -= value * 0.10; // Desconto de 10% para pessoa jurídica com mais de 3 dias
            }
            return value;
        }
    },
    CNPJ {
        @Override
        public double value(Long days, double value) {
            if (days > 5) {
                value -= value * 0.05; // Desconto de 5% para pessoa física com mais de 5 dias
            }
            return value;
        }
    }
}
