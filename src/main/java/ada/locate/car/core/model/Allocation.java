package ada.locate.car.core.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Allocation {
    private LocalDateTime localDateTimeRent;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private String local;
    private Vehicle vehicle;

    @Override
    public String toString() {
        return "Allocation: " +
                "LocalDateTimeRent: " + localDateTimeRent +
                ", Local: " + local + "\n" + vehicle;
    }

    public Allocation(String localDateTimeRent, String local, Vehicle vehicle) {
        this.localDateTimeRent = LocalDateTime.parse(localDateTimeRent, formatter);
        this.local = local;
        this.vehicle = vehicle;
    }


    public String getLocalDateFormatted() {
        return localDateTimeRent.format(formatter);
    }

    public LocalDateTime getLocalDateTimeRent() {
        return localDateTimeRent;
    }

    public String getLocal() {
        return local;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }
}
