package ada.locate.car.core.model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String flagIdentification;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String document;
    private List<Allocation> allocationList = new ArrayList<>();

    public Client(String name, String address, String phoneNumber, String email, String flagIdentification, String document) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.flagIdentification = flagIdentification;
        this.document = document;
    }

    @Override
    public String toString() {
        return
        "Client: " +
                "Name: " + name +
                ", Address: " + address +
                ", PhoneNumber: " + phoneNumber +
                ", Email: " + email +
                ", Identification: " + flagIdentification +
                ", Document: " + document;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getEmail() {
        return email;
    }


    public String getIdentification() {
        return flagIdentification;
    }
    public List<Allocation> getAllocationList() {
        return allocationList;
    }


    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }


    public String formatAllocationList() {
        StringBuilder list = new StringBuilder();

        allocationList.forEach(allocation -> {
            list.append(allocation.toString())
                    .append(System.lineSeparator());
        });
        return String.valueOf(list);
    }

    public void setAllocationList(Allocation newAllocation) {
        this.allocationList.add(newAllocation);
    }

    private enum Model {
        CPF("CPF"),
        CNPJ("CNPJ");

        private String description;

        Model(String description) {
            this.description = description;
        }

        private static String allModels() {
            StringBuilder stringBuilder = new StringBuilder();
            for (Client.Model model : Client.Model.values()) {
                stringBuilder.append(model.description).append("\n");
            }
            return stringBuilder.toString();
        }

    }

    public static String getModels(){
        return Client.Model.allModels();
    }
}
