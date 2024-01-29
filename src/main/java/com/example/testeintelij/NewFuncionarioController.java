package com.example.testeintelij;

import com.example.testeintelij.Dominio.Funcionario;
import com.example.testeintelij.Persistencia.FuncionarioDAO;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class NewFuncionarioController {
    @FXML
    private Label lblMensIncluirFunc;
    @FXML
    private TextField txtNomeFuncionario;
    @FXML
    private TextField txtEmailFuncionario;
    @FXML
    private TextField txtTelefoneFuncionario;
    @FXML
    private Button btnSalvarFuncionario;

    private FuncionarioDAO funcDAO = new FuncionarioDAO();
    private Stage stage;

    @FXML
    private void initialize() {
        this.stage = new Stage();
    }

    @FXML
    private void handleBtnSalvarFuncionario() {
        // Recupera os valores dos campos de entrada
        String nome = txtNomeFuncionario.getText();
        String telefone = txtTelefoneFuncionario.getText();
        String email = txtEmailFuncionario.getText();

        if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Preencha todos os campos.", ButtonType.OK);
            alert.showAndWait();
            return;
        }

        // Cria um novo objeto Funcionario com os dados inseridos
        Funcionario novoFuncionario = new Funcionario();
        novoFuncionario.setNome(nome);
        novoFuncionario.setTelefone(telefone);
        novoFuncionario.setEmail(email);

        // Chama o método para incluir o funcionário no banco de dados
        funcDAO.incluir(novoFuncionario);

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Funcionário salvo com sucesso!", ButtonType.OK);
        alert.showAndWait();

        // Obtém a referência à janela atual e fecha
        Stage currentStage = (Stage) btnSalvarFuncionario.getScene().getWindow();
        currentStage.close();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
