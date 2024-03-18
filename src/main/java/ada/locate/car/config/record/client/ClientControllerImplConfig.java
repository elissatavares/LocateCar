package ada.locate.car.config.record.client;

public record ClientControllerImplConfig(ClientServiceConfig service,
                                         ProviderClientConfig provider,
                                         ClientDTOBuilderconfig DTO) {
}
