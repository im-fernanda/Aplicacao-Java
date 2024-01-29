package com.example.testeintelij;


import com.example.testeintelij.Dominio.Vacina;
import com.example.testeintelij.Persistencia.VacinaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;


public class NewVacinaController<Stage> {

    @FXML
    private TextField txtNomeVacina;

    @FXML
    private TextField txtDescVacina;

    @FXML
    private Button btnSalvarVacina;


    @FXML
    private void initialize() {
    }

    @FXML
    private void handleBtnSalvarVacina(ActionEvent event) {
        // Crie um objeto Vacina com os dados fornecidos
        Vacina novaVacina = new Vacina();

        novaVacina.setNome(txtNomeVacina.getText());
        novaVacina.setDescricao(txtDescVacina.getText());

        VacinaDAO vacinaDAO = new VacinaDAO();
        vacinaDAO.incluir(novaVacina);

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Vacina salva com sucesso!", ButtonType.OK);
        alert.showAndWait();


    }



}
