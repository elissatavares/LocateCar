package ada.locate.car.core.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Allocation {
    private LocalDateTime localDateTimeRent;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private String local;
    private Vehicle vehicle;
    private final double dailyRateSmall = 100.00;
    private final double dailyRateMedium = 150.00;
    private final double dailyRateSUV = 200.00;

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

    public double allocationValue(String finalDay, String typeClient, String model) {
        double initialValue = 0.0;
        Long days = days(finalDay);
        System.out.println(days);

        switch (model.toLowerCase()) {
            case "small":
                initialValue = dailyRateSmall * days;
                break;
            case "medium":
                initialValue = dailyRateMedium * days;
                break;
            case "suv":
                initialValue = dailyRateSUV * days;
                break;
        }
        System.out.println(initialValue);
        return percentDiscount(days, typeClient, initialValue);
    }

    private Long days(String finalDay) {
        LocalDateTime localDateTimeDevolution = LocalDateTime.parse(finalDay, formatter);
        long toDays = ChronoUnit.DAYS.between(this.localDateTimeRent, localDateTimeDevolution);

        // Verificar se a hora de devolução é após a hora de retirada
        if (localDateTimeDevolution.getHour() > this.localDateTimeRent.getHour() || (localDateTimeDevolution.getHour() == this.localDateTimeRent.getHour() && localDateTimeDevolution.getMinute() > this.localDateTimeRent.getMinute())) {
            toDays++;
        }
        return toDays;
    }

    private double percentDiscount(Long days, String type, double value) {
        if (type.equalsIgnoreCase("CNPJ") && days > 3) {
            value -= value * 0.10; // Desconto de 10% para pessoa jurídica com mais de 3 dias
        } else if (type.equalsIgnoreCase("CPF") && days > 5) {
            value -= value * 0.05; // Desconto de 5% para pessoa física com mais de 5 dias
        }
        System.out.println(value);
        return value;
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
