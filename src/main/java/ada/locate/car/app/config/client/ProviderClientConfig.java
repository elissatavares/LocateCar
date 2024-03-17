package ada.locate.car.app.config.client;

import ada.locate.car.infra.provider.data.client.*;

public record ProviderClientConfig(ClientCreateInputProvider create,
                                   ClientReadInputProvider read,
                                   ClientUpdateInputProvider update,
                                   ClientDeleteInputProvider delete,
                                   ClientInputDocument documentEntry,
                                   OutputClient output,
                                   ClientMenuInputProvider menu) {
}
