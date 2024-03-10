package ada.locate.car.swing;

import javax.swing.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Input<Integer> inputOption = new ShowMenu();
        Input<String> inputSting = new ShowInputDialog();
        Input<String[]> inputCampus = new ShowInputDialogVariosCampos();
        JFrame frame = CrateFrame.execute();
        frame.setVisible(true);

        String options = """
                1 - DELETE
                2 - CREATE""";
        String title = "Edit Menu2";

        int selectedOption = inputOption.execute(title, options);
        System.out.println(selectedOption != -1 ? "Opp selection: " + selectedOption : "find do menu." + selectedOption);

        String title2 = "Input Nome";
        String description = "Por favor, digite o seu nome:";

        String userInput = inputSting.execute(title2, description);
        System.out.println(userInput);

        String title3 = "Input Pessoa";
        String fields = "Nome\nSobrenome\nTelefone";

        String[] userInputs2 = inputCampus.execute(title3, fields);
        System.out.println(Arrays.toString(userInputs2));

        String message = "Descrição da pessoa!"; // Mensagem que você deseja exibir
        String title4 = "nome: sjkdjaskdj"; // Título do Popup

        ShowInformation.execute(message, title4);
        frame.dispose();
    }
}