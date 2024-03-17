package ada.locate.car.app.config.client;

import ada.locate.car.DTO.utils.client.ClientCreateBuilder;
import ada.locate.car.DTO.utils.client.ClientDeleteBuilder;
import ada.locate.car.DTO.utils.client.ClientReadBuilder;
import ada.locate.car.DTO.utils.client.ClientUpdateBuilder;

public record ClientDTOBuilderconfig(ClientCreateBuilder create,
                                     ClientReadBuilder search,
                                     ClientUpdateBuilder update,
                                     ClientDeleteBuilder delete) {
}
