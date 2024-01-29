package com.example.testeintelij;

import com.example.testeintelij.Dominio.FuncionarioTarefa;
import com.example.testeintelij.Persistencia.FuncionarioTarefaDAO;
import com.example.testeintelij.Persistencia.TarefaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class NewTarefaController<Tarefa> {
    @FXML
    public TextField txtNomeTarefa;
    @FXML
    public TextField txtDescTarefa;
    @FXML
    public TextField txtTaskID_USER;
    @FXML
    private Button btnSalvarTarefa;


    private Stage stage;

    @FXML
    private void initialize() {
        this.stage = new Stage();
    }

    @FXML
    public void handleBtnSalvarTarefa(ActionEvent event) {

        if (txtTaskID_USER.getText().isEmpty()  || txtDescTarefa.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Preencha todos os campos.", ButtonType.OK);
            alert.showAndWait();
            return;
        }

        FuncionarioTarefa novaTarefa = new FuncionarioTarefa();
        TarefaDAO nt = new TarefaDAO();

        novaTarefa.setId_funcionario(Integer.parseInt(txtTaskID_USER.getText()));
        novaTarefa.setDescricao(txtDescTarefa.getText());
        novaTarefa.setId_tarefa(nt.UltimoIDTarefa());

        FuncionarioTarefaDAO tarefaDAO = new FuncionarioTarefaDAO();
        tarefaDAO.incluir(novaTarefa);

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Tarefa salva com sucesso!", ButtonType.OK);
        alert.showAndWait();

        // Obtém a referência à janela atual e fecha
        Stage currentStage = (Stage) btnSalvarTarefa.getScene().getWindow();
        currentStage.close();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
