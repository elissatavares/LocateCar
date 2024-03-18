package ada.locate.car.config.record.vehicle;

import ada.locate.car.DTO.utils.vehicle.*;

public record VehicleDTOBuilderconfig(VehicleCreateDTO create,
                                      VehicleReadDTO search,
                                      VehicleUpdateDTO update,
                                      VehicleDeleteDTO delete,
                                      VehicleSearchPlateNumberDTO searchPlateNumber) {
}
