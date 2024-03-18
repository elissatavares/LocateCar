package ada.locate.car.DTO.utils.vehicle;

import ada.locate.car.DTO.VehicleDTO;

public class VehicleSearchPlateNumberDTO {
    public VehicleDTO buildSearchDTOPlateNumberDTO(String plateNumber){
        return new VehicleDTO.Builder().plateNumber(plateNumber).description("search by plate").build();
    }
}
