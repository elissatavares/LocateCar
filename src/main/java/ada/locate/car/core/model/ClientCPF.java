package ada.locate.car.core.model;

public class ClientCPF {
    private Client client;
    private String cpf;

    public ClientCPF(String name, String address, String phoneNumber, String email, String cpf) {
        this.client = new Client(name, address, phoneNumber, email, clientDTO.identification());
        this.cpf = formatCpf(cpf);
    }

    @Override
    public String toString() {
        return "ClientCPF{" +
                "client=" + client +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    private String formatCpf(String cpf) {
        return cpf.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }
}
