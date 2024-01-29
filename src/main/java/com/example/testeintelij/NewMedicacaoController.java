package com.example.testeintelij;

import com.example.testeintelij.Dominio.Medicacao;
import com.example.testeintelij.Persistencia.MedicacaoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class NewMedicacaoController {

    @FXML
    private TextField txtAnimalMedicacao;

    @FXML
    private TextField txtRemedioMedicacao;

    @FXML
    private TextField txtDataMedicacao;

    @FXML
    private Button btnSalvarMedicacao;


    @FXML
    private void initialize() {
    }

    @FXML
    private void handleBtnSalvarMedicacao(ActionEvent event) {
        try {
            String idAnimal = txtAnimalMedicacao.getText();
            String idRemedio = txtRemedioMedicacao.getText();
            String dataAplicacao = txtDataMedicacao.getText();

            // Validação de entrada
            if (idAnimal.isEmpty() || idRemedio.isEmpty() || dataAplicacao.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Preencha todos os campos.", ButtonType.OK);
                alert.showAndWait();
                return;
            }

            // Cria um objeto Medicacao com os dados fornecidos
            Medicacao novaMedicacao = new Medicacao();

            novaMedicacao.setId_animal(Integer.parseInt(idAnimal));
            novaMedicacao.setId_remedio(Integer.parseInt(idRemedio));
            novaMedicacao.setData_aplicacao(dataAplicacao);

            MedicacaoDAO medicacaoDAO = new MedicacaoDAO();
            medicacaoDAO.incluir(novaMedicacao);

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Medicação salva com sucesso!", ButtonType.OK);
            alert.showAndWait();

            // Obtém a referência à janela atual e fecha
            Stage currentStage = (Stage) btnSalvarMedicacao.getScene().getWindow();
            currentStage.close();
        } catch (IllegalArgumentException e) {
            // Trata exceção de validação de entrada
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }
    }
}