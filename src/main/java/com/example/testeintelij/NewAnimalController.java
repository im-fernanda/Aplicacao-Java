package com.example.testeintelij;

import com.example.testeintelij.Dominio.Animal;
import com.example.testeintelij.Persistencia.AnimalDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class NewAnimalController {

    public TextField txtAnimalDataNasc;
    public TextField txtAnimalPeso;
    public TextField txtAnimalSexo;
    public TextField txtAnimalEspecie;
    public TextField txtAnimalStatus;
    public TextField txtAnimalGest;
    public TextField txtAnimalVacinacao;
    public TextField txtAnimalNome;


    @FXML
    private Button btnSalvarAnimal;

    private AnimalDAO animalDAO = new AnimalDAO();
    private Stage stage;


    @FXML
    private void handleBtnSalvarAnimal(ActionEvent event) {
        // Recupera os valores dos campos de entrada
        String nome = txtAnimalNome.getText();
        String nascimento = txtAnimalDataNasc.getText();
        String especie = txtAnimalEspecie.getText();
        String sexo = txtAnimalSexo.getText();
        String gestacao = txtAnimalGest.getText();
        String peso = txtAnimalPeso.getText();
        String status = txtAnimalStatus.getText();

        if (nome.isEmpty() || nascimento.isEmpty() || especie.isEmpty() || sexo.isEmpty()
                || gestacao.isEmpty() || peso.isEmpty() || status.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Preencha todos os campos.", ButtonType.OK);
            alert.showAndWait();
            return;
        }

        // Cria um novo objeto Animal com os dados inseridos
        Animal novoAnimal = new Animal();
        novoAnimal.setNome(nome);
        novoAnimal.setData_nascimento(nascimento);
        novoAnimal.setEspecie(especie);
        novoAnimal.setSexo(sexo);
        novoAnimal.setGestante(gestacao);
        novoAnimal.setPeso(Float.parseFloat(peso));
        novoAnimal.setStatus_vida(status);

        // Chama o método para incluir o animal no banco de dados
        animalDAO.incluir(novoAnimal);

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Animal salvo com sucesso!", ButtonType.OK);
        alert.showAndWait();

        // Obtém a referência à janela atual e fecha
        Stage currentStage = (Stage) btnSalvarAnimal.getScene().getWindow();
        currentStage.close();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}