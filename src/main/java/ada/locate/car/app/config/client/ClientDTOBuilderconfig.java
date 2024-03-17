package ada.locate.car.app.config.client;

import ada.locate.car.infra.provider.builder.client.ClientCreateBuilder;
import ada.locate.car.infra.provider.builder.client.ClientDeleteBuilder;
import ada.locate.car.infra.provider.builder.client.ClientReadBuilder;
import ada.locate.car.infra.provider.builder.client.ClientUpdateBuilder;

public record ClientDTOBuilderconfig(ClientCreateBuilder create,
                                     ClientReadBuilder search,
                                     ClientUpdateBuilder update,
                                     ClientDeleteBuilder delete) {
}
