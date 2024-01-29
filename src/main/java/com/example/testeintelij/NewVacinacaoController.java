package com.example.testeintelij;

import com.example.testeintelij.Dominio.Vacinacao;
import com.example.testeintelij.Persistencia.VacinacaoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewVacinacaoController {

    @FXML
    private TextField txtAnimalVacinacao;

    @FXML
    private TextField txtVacinaVacinacao;

    @FXML
    private TextField txtDataVacinacao;

    @FXML
    private Button btnSalvarVacinacao;

    @FXML
    private void initialize() {

    }

    @FXML
    private void handleBtnSalvarVacinacao(ActionEvent event) throws Exception{
        // Recupera os valores dos campos de entrada
        String idAnimal = txtAnimalVacinacao.getText();
        String idVacina = txtVacinaVacinacao.getText();
        String dataAplicacao = txtDataVacinacao.getText();

        // Validação dos campos
        if (idAnimal.isEmpty() || idVacina.isEmpty() || dataAplicacao.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Preencha todos os campos.", ButtonType.OK);
            alert.showAndWait();
            return;
        }

        // Cria um novo objeto Vacinacao com os dados inseridos
        Vacinacao novaVacinacao = new Vacinacao();
        novaVacinacao.setId_animal(Integer.parseInt(idAnimal));
        novaVacinacao.setId_vacina(Integer.parseInt(idVacina));
        novaVacinacao.setData_aplicacao(dataAplicacao);

        // Chama o método para incluir a vacinação no banco de dados
        VacinacaoDAO vacinacaoDAO = new VacinacaoDAO();
        vacinacaoDAO.incluir(novaVacinacao);

        // Exibe uma mensagem de sucesso
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Vacinação salva com sucesso!", ButtonType.OK);
        alert.showAndWait();

        // Obtém a referência à janela atual e fecha
        Stage currentStage = (Stage) btnSalvarVacinacao.getScene().getWindow();
        currentStage.close();
    }
}
