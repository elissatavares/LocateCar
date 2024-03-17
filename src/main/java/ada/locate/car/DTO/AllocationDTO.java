package ada.locate.car.DTO;

import ada.locate.car.core.model.Allocation;
import ada.locate.car.core.model.Vehicle;

import java.util.List;
import java.util.stream.Collectors;


public record AllocationDTO(ClientDTO clientDocument, VehicleDTO plateNumberVehicle,
                            String[] data, String localDateTimeRent, String local, Vehicle vehicle){

    @Override
    public String toString() {
        return "Allocation: " +
                "LocalDateTimeRent: " + localDateTimeRent +
                ", Local: " + local +
                ", vehicle: " + "\n" + vehicle;
    }
    @Override
    public ClientDTO clientDocument() {
        return clientDocument;
    }

    @Override
    public VehicleDTO plateNumberVehicle() {
        return plateNumberVehicle;
    }
    public static class Builder {
        private ClientDTO clientDocument;
        private VehicleDTO plateNumberVehicle;
        private String[] data;
        private String localDateTimeRent;
        private String local;
        private Vehicle vehicle;

        public Builder clientDocument(ClientDTO clientDocument) {
            this.clientDocument = clientDocument;
            return this;
        }

        public Builder plateNumberVehicle(VehicleDTO plateNumberVehicle) {
            this.plateNumberVehicle = plateNumberVehicle;
            return this;
        }

        public Builder data(String[] data) {
            this.data = data;
            return this;
        }

        public Builder localDateTimeRent(String localDateTimeRent) {
            this.localDateTimeRent = localDateTimeRent;
            return this;
        }

        public Builder local(String local) {
            this.local = local;
            return this;
        }

        public Builder vehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public AllocationDTO build() {
            return new AllocationDTO(clientDocument, plateNumberVehicle, data, localDateTimeRent, local, vehicle);
        }
    }
    public static List<AllocationDTO> convertToDTO(List<Allocation> allocationList) {
        return allocationList.stream()
                .map(allocation -> new Builder()
                        .localDateTimeRent(allocation.getLocalDate())
                        .local(allocation.getLocal())
                        .vehicle(allocation.getVehicle())
                        .build())
                .collect(Collectors.toList());
    }
    public static String formatAllocationDTOList(List<AllocationDTO> list) {
        return list.stream()
                .map(AllocationDTO::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
