package ada.locate.car.config.record.client;

import ada.locate.car.core.usecase.client.CreateClient;
import ada.locate.car.core.usecase.client.DeleteClient;
import ada.locate.car.core.usecase.client.ReadClient;
import ada.locate.car.core.usecase.client.UpdateClient;

public record ClientServiceConfig(CreateClient create, ReadClient read, UpdateClient update, DeleteClient delete) {
}
