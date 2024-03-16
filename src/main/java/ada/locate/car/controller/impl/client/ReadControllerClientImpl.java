package ada.locate.car.controller.impl.client;

import ada.locate.car.app.messages.MessagesClient;
import ada.locate.car.controller.api.Controller;
import ada.locate.car.core.usecase.ReadClient;
import ada.locate.car.frontend.api.Input;
import ada.locate.car.frontend.api.Output;
import ada.locate.car.infra.dto.ClientDTO;

import java.util.List;

public class ReadControllerClientImpl implements Controller {
    private final ReadClient readClients;
    private final Input<String> stringOption;
    private final Input<String> inputCPF;
    private final Input<String> inputCNPJ;
    private final Output showInformation;

    public ReadControllerClientImpl(ReadClient readClients, Input<String> stringOption, Input<String> inputCPF, Input<String> inputCNPJ, Output showInformation) {
        this.readClients = readClients;
        this.stringOption = stringOption;
        this.inputCPF = inputCPF;
        this.inputCNPJ = inputCNPJ;
        this.showInformation = showInformation;
    }

    @Override
    public void execute() {
        //buscar client por cnpj, cpf
        //colocar pra selecionar cpf ou cnpj
        String option = stringOption.execute(MessagesClient.ENTER_SEARCH_OPTION.get(), MessagesClient.SEARCH_OPTION_PROMPT.get());

        String document;
        if (option.equalsIgnoreCase("CPF")) {
            document = inputCPF.execute(MessagesClient.ENTER_CPF.get(), MessagesClient.ENTER_CPF.get());

        } else {
            document = inputCNPJ.execute(MessagesClient.ENTER_CNPJ.get(), MessagesClient.ENTER_CNPJ.get());

            ClientDTO clientDTO = new ClientDTO.Builder().document(document).build();
            ClientDTO readClient = readClients.execute(clientDTO);

            showInformation.execute("All Clients:", MessagesClient.CLIENT_DETAILS.get());
//            showInformation.execute(getClientDetails(readClient), "Client Details");

            System.out.println(readClient);
            /* 1- verificar se retornou cpf ou cnpj
             * 2 - se for cnpj: chama o input do cnpj
             * 3 - se for cpf: chama o input do cpf
             * 4 - mostrar na tela os dados do cliente: FALTA ISSO AQUI
             * */

//        ClientDTO clientDTO = new ClientDTO.Builder().document(document);
//        ClientDTO readClient = readClients.execute(clientDTO);
//        System.out.println(readClient);

//            List<ClientDTO> allClients = readClientService.execute();

        }
    }
 }
