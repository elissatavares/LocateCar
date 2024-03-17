package ada.locate.car.DTO;

public record AllocationDTO(ClientDTO clientDocument, VehicleDTO plateNumberVehicle, String[] data){
    @Override
    public ClientDTO clientDocument() {
        return clientDocument;
    }

    @Override
    public VehicleDTO plateNumberVehicle() {
        return plateNumberVehicle;
    }

    public String[] data(int i) {
        return data;
    }
}
