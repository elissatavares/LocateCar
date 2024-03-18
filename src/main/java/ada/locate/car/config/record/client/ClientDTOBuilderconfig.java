package ada.locate.car.config.record.client;

import ada.locate.car.DTO.utils.client.ClientCreateDTO;
import ada.locate.car.DTO.utils.client.ClientDeleteDTO;
import ada.locate.car.DTO.utils.client.ClientReadDTO;
import ada.locate.car.DTO.utils.client.ClientUpdateDTO;

public record ClientDTOBuilderconfig(ClientCreateDTO create,
                                     ClientReadDTO search,
                                     ClientUpdateDTO update,
                                     ClientDeleteDTO delete) {
}
