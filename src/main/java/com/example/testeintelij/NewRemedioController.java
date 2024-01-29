package com.example.testeintelij;

import com.example.testeintelij.Dominio.Remedio;
import com.example.testeintelij.Persistencia.RemedioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewRemedioController {

    @FXML
    private TextField txtNomeRemedio;

    @FXML
    private TextField txtDescRemedio;

    @FXML
    private Button btnSalvarRemedio;

    @FXML
    private void initialize() {

    }

    @FXML
    private void handleBtnSalvarRemedio(ActionEvent event) {
        try {
            // Validação de entrada
            if (txtNomeRemedio.getText().isEmpty() || txtDescRemedio.getText().isEmpty()) {
                throw new IllegalArgumentException("Preencha todos os campos.");
            }

            // Crie um objeto Remedio com os dados fornecidos
            Remedio novoRemedio = new Remedio();

            novoRemedio.setNome(txtNomeRemedio.getText());
            novoRemedio.setDescricao(txtDescRemedio.getText());

            RemedioDAO remedioDAO = new RemedioDAO();
            remedioDAO.incluir(novoRemedio);

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Remédio salvo com sucesso!", ButtonType.OK);
            alert.showAndWait();

            // Obtém a referência à janela atual e fecha
            Stage currentStage = (Stage) btnSalvarRemedio.getScene().getWindow();
            currentStage.close();
        } catch (IllegalArgumentException e) {
            // Trata exceção de validação de entrada
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }
    }
}