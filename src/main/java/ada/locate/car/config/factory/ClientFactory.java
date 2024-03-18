package ada.locate.car.config.factory;

import ada.locate.car.DTO.utils.client.ClientCreateDTO;
import ada.locate.car.DTO.utils.client.ClientDeleteDTO;
import ada.locate.car.DTO.utils.client.ClientReadDTO;
import ada.locate.car.DTO.utils.client.ClientUpdateDTO;
import ada.locate.car.app.messages.MessagesClient;
import ada.locate.car.config.record.client.*;
import ada.locate.car.controller.impl.client.CreateClientControllerImpl;
import ada.locate.car.controller.impl.client.DeleteClientControllerImpl;
import ada.locate.car.controller.impl.client.ReadControllerClientImpl;
import ada.locate.car.controller.impl.client.UpdateClientControllerImpl;
import ada.locate.car.frontend.impl.client.ShowInputCNPJ;
import ada.locate.car.frontend.impl.client.ShowInputCPF;
import ada.locate.car.frontend.impl.client.ShowInputOptionsClient;
import ada.locate.car.frontend.impl.client.create.ShowCreatedSuccessfullyClient;
import ada.locate.car.frontend.impl.client.create.ShowInputDataCreateClient;
import ada.locate.car.frontend.impl.client.create.ShowInputOptionsCreateClient;
import ada.locate.car.frontend.impl.client.delete.ShowDeletedSuccessfullyClient;
import ada.locate.car.frontend.impl.client.delete.ShowInputDeleteOptionsClient;
import ada.locate.car.frontend.impl.client.read.ShowClient;
import ada.locate.car.frontend.impl.client.read.ShowInputOptionsReadClient;
import ada.locate.car.frontend.impl.client.update.*;
import ada.locate.car.provider.client.*;
import ada.locate.car.repository.api.RepositoryClient;
import ada.locate.car.repository.impl.ClientRepository;
import ada.locate.car.service.client.CreateClientService;
import ada.locate.car.service.client.DeleteClientService;
import ada.locate.car.service.client.ReadClientService;
import ada.locate.car.service.client.UpdateClientService;

public class ClientFactory {
    public static ClientFrontendConfig createFrontConfigClient() {
        return new ClientFrontendConfig(
                new ShowInputOptionsClient(MessagesClient.CLIENT_MENU.get(), MessagesClient.OPTION_CLIENT.get()),
                new ShowInputOptionsCreateClient(MessagesClient.CREATE_CLIENT.get(), MessagesClient.ALL_TYPES.get()),
                new ShowInputDataCreateClient(MessagesClient.INSERT_CLIENT_DATA.get(), MessagesClient.ALL_CLIENT_DATA.get()),
                new ShowInputCPF(MessagesClient.ENTER_CPF.get(), MessagesClient.ENTER_CPF.get()),
                new ShowInputCNPJ(MessagesClient.ENTER_CNPJ.get(), MessagesClient.ENTER_CNPJ.get()),
                new ShowCreatedSuccessfullyClient(MessagesClient.CREATE_SUCESS_MSG.get()),
                new ShowInputDeleteOptionsClient(MessagesClient.TITLE_DELETE_CLIENT.get(), MessagesClient.SEARCH_OPTION_PROMPT.get()),
                new ShowDeletedSuccessfullyClient(MessagesClient.DELETE_SUCESS_MSG.get()),
                new ShowInputOptionsReadClient(MessagesClient.ENTER_SEARCH_OPTION.get(), MessagesClient.SEARCH_OPTION_PROMPT.get()),
                new ShowClient(MessagesClient.CLIENT_DETAILS.get()),
                new ShowInputOptionsUpdateClient(MessagesClient.MENU_UPDATED_CLIENT.get(), MessagesClient.UPDATED_CLIENT_DATA.get()),
                new ShowInputUpdateCPFOrCNPJ(MessagesClient.MENU_UPDATED_CLIENT.get(), MessagesClient.SEARCH_OPTION_PROMPT.get()),
                new ShowInputUpdateName(MessagesClient.MENU_UPDATED_CLIENT.get(), "Name"),
                new ShowInputUpdateAddress(MessagesClient.MENU_UPDATED_CLIENT.get(), "Address"),
                new ShowInputUpdatePhoneNumber(MessagesClient.MENU_UPDATED_CLIENT.get(), "Phone Number"),
                new ShowInputUpdateEmail(MessagesClient.MENU_UPDATED_CLIENT.get(), "Email"),
                new ShowUpdatedSuccessfullyClient(MessagesClient.UPDATE_SUCESS_MSG.get())
        );
    }

    public static ClientServiceConfig createClientServiceConfig() {
        RepositoryClient clientRepository = ClientRepository.getInstance();
        return new ClientServiceConfig(
                new CreateClientService(clientRepository),
                new ReadClientService(clientRepository),
                new UpdateClientService(clientRepository),
                new DeleteClientService(clientRepository)
        );
    }

    public static ClientControllerImplConfig createClientControllerImplConfig(ClientServiceConfig clientServiceConfig,
                                                                              ProviderClientConfig provider,
                                                                              ClientDTOBuilderconfig clientDTOBuilderconfig) {
        return new ClientControllerImplConfig(clientServiceConfig, provider, clientDTOBuilderconfig);
    }

    public static ClientControllerConfig createClientControllerConfig(ClientControllerImplConfig clientControllerImplConfig) {
        return new ClientControllerConfig(
                new CreateClientControllerImpl(clientControllerImplConfig),
                new ReadControllerClientImpl(clientControllerImplConfig),
                new UpdateClientControllerImpl(clientControllerImplConfig),
                new DeleteClientControllerImpl(clientControllerImplConfig)
        );
    }

    public static ClientMenuConfig createClientMenuConfig(ClientControllerConfig clientControllerConfig,
                                                          ProviderClientConfig provider) {
        return new ClientMenuConfig(clientControllerConfig, provider);
    }

    public static ProviderClientConfig createProviderClientConfig(ClientFrontendConfig front) {
        return new ProviderClientConfig(
                new ClientInputProviderCreate(front),
                new ClientInputProviderRead(front),
                new ClientInputProviderUpdate(front),
                new ClientInputProviderDelete(front),
                new ClientInputProviderDocument(front),
                new OutputClient(front),
                new ClientInputProviderMenu(front)
        );
    }

    public static ClientDTOBuilderconfig createClientDTOBuilderConfig(ProviderClientConfig provider) {
        return new ClientDTOBuilderconfig(
                new ClientCreateDTO(),
                new ClientReadDTO(),
                new ClientUpdateDTO(provider),
                new ClientDeleteDTO()
        );
    }

}
