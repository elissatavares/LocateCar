package ada.locate.car.service.allocation.calculate;

import ada.locate.car.core.model.Allocation;
import ada.locate.car.core.usecase.allocation.CalculateTotalDays;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CalculateDays implements CalculateTotalDays {
    @Override
    public Long totalDays(String finalDay, Allocation allocation) {
        LocalDateTime localDateTimeDevolution = LocalDateTime.parse(finalDay, allocation.getFormatter());
        LocalDateTime localDateTimeRend = allocation.getLocalDateTimeRent();
        long toDays = ChronoUnit.DAYS.between(localDateTimeRend, localDateTimeDevolution);

        // Verificar se a hora de devolução é após a hora de retirada
        if (localDateTimeDevolution.getHour() > localDateTimeRend.getHour() ||
                        (localDateTimeDevolution.getHour() == localDateTimeRend.getHour()
                        && localDateTimeDevolution.getMinute() > localDateTimeRend.getMinute())) {
            toDays++;
        }
        return toDays;
    }
}
