package ada.locate.car.core.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Allocation {
    private LocalDateTime localDateTimeRent;
    private String local;
    private Vehicle vehicle;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Long days(String today){
        LocalDateTime localDateTimeDevolution = LocalDateTime.parse(today, formatter);
        Duration duration = Duration.between(localDateTimeDevolution, this.localDateTimeRent);
        return duration.toDays();
    }
}
