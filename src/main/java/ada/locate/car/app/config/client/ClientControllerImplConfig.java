package ada.locate.car.app.config.client;

public record ClientControllerImplConfig(ClientServiceConfig service,
                                         ProviderClientConfig provider,
                                         ClientDTOBuilderconfig DTO) {
}
