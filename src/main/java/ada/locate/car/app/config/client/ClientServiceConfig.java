package ada.locate.car.app.config.client;

import ada.locate.car.core.usecase.*;

public record ClientServiceConfig(CreateClient create, ReadClient read, UpdateClient update, DeleteClient delete) {
}
