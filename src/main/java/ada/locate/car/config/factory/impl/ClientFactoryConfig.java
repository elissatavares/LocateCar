package ada.locate.car.config.factory.impl;

import ada.locate.car.app.menu.ClientMenu;
import ada.locate.car.app.menu.Menu;
import ada.locate.car.config.factory.ClientFactory;
import ada.locate.car.config.record.client.*;

public class ClientFactoryConfig {
    private final ClientServiceConfig clientServiceConfig;
    private final ProviderClientConfig providerClientConfig;
    private final ClientDTOBuilderconfig clientDTOBuilderConfig;
    private final Menu clientMenu;

    public ClientFactoryConfig() {
        ClientFrontendConfig frontConfigClient = ClientFactory.createFrontConfigClient();
        this.clientServiceConfig = ClientFactory.createClientServiceConfig();
        this.providerClientConfig = ClientFactory.createProviderClientConfig(frontConfigClient);
        this.clientDTOBuilderConfig = ClientFactory.createClientDTOBuilderConfig(providerClientConfig);
        ClientControllerImplConfig clientControllerImplConfig = ClientFactory.createClientControllerImplConfig(clientServiceConfig,
                providerClientConfig, clientDTOBuilderConfig);
        ClientControllerConfig clientControllerConfig = ClientFactory.createClientControllerConfig(clientControllerImplConfig);
        ClientMenuConfig clientMenuConfig = ClientFactory.createClientMenuConfig(clientControllerConfig, providerClientConfig);
        this.clientMenu = new ClientMenu(clientMenuConfig);
    }

    protected ClientDTOBuilderconfig getClientDTOBuilderConfig() {
        return clientDTOBuilderConfig;
    }

    protected ProviderClientConfig getProviderClientConfig() {
        return providerClientConfig;
    }

    protected ClientServiceConfig getClientServiceConfig() {
        return clientServiceConfig;
    }

    public Menu getClientMenu() {
        return clientMenu;
    }
}

