package ada.locate.car.core.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Allocation {
    private LocalDateTime localDateTimeRent;
    private String local;
    private Vehicle vehicle;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @Override
    public String toString() {
        return "Allocation: " +
                "LocalDateTimeRent: " + localDateTimeRent +
                ", Local: " + local +
                ", vehicle: " + "\n" + vehicle;
    }

    public Allocation(String localDateTimeRent, String local, Vehicle vehicle) {
        this.localDateTimeRent = LocalDateTime.parse(localDateTimeRent, formatter);
        this.local = local;
        this.vehicle = vehicle;
    }

    public Long days(String today){
        LocalDateTime localDateTimeDevolution = LocalDateTime.parse(today, formatter);
        Duration duration = Duration.between(localDateTimeDevolution, this.localDateTimeRent);
        return duration.toDays();
    }

    public String getLocalDate() {
        return localDateTimeRent.format(formatter);
    }

    public String getLocal() {
        return local;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
