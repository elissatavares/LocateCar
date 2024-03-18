package ada.locate.car.config.record.client;

import ada.locate.car.provider.client.*;

public record ProviderClientConfig(ClientInputProviderCreate create,
                                   ClientInputProviderRead read,
                                   ClientInputProviderUpdate update,
                                   ClientInputProviderDelete delete,
                                   ClientInputProviderDocument documentEntry,
                                   OutputClient output,
                                   ClientInputProviderMenu menu) {
}
