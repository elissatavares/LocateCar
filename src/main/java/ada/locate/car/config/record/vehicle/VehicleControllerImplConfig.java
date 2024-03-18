package ada.locate.car.config.record.vehicle;

//configura as implementações dos meus controllers, que devem poder chamar meu service
public record VehicleControllerImplConfig(VehicleServiceConfig service,
                                          ProviderVehicleConfig provider,
                                          VehicleDTOBuilderconfig DTO) {
}
