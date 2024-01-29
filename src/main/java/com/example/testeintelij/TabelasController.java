package com.example.testeintelij;

import com.example.testeintelij.Dominio.*;
import com.example.testeintelij.Persistencia.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;

public class TabelasController {

    public Button btnNewMedicacao;
    public Button btnNewVacina;
    public Button btnNewVacinacao;
    public Button btnRelFunc;
    public Button btnDeletarAnimal;
    public Button btnRelAnimais;
    public Button btnRelTarefa;
    public Button btnDeletarTarefa;
    public Button btnRelRemedio;
    public Button btnDeletarRemedio;
    public Button btnEditarRemedio;
    public Button btnRelMedicacao;
    public Button btnDeletarMedicacao;
    public Button btnEditarMedicacao;
    public Button btnRelVacina;
    public Button btnDeletarVacina;
    public Button btnEditarVacina;
    public Button btnRelVacinacao;
    public Button btnDeletarVacinacao;
    public Button btnEditarVacinacao;
    public Button btnDeletarUser;
    @FXML
    private Button btnNewUser;

    @FXML
    private TableView<Funcionario> tabelaFuncionarios;
    @FXML
    private TableColumn<Funcionario, Integer> tbcUserID;
    @FXML
    private TableColumn<Funcionario, String> tbcUserNome;
    @FXML
    private TableColumn<Funcionario, String> tbcUserTelefone;
    @FXML
    private TableColumn<Funcionario, String> tbcUserEmail;
    @FXML
    private TextField searchUser;
    @FXML
    private Button btnEditarUser;

    @FXML
    private Button btnNewTask;
    @FXML
    private TableView<FuncionarioTarefa> tabelaTarefas;
    @FXML
    private TableColumn<FuncionarioTarefa, Integer> tbcFuncTaskID;
    @FXML
    private TableColumn<FuncionarioTarefa, Integer> tbcTaskID_USER;
    @FXML
    private TableColumn<FuncionarioTarefa, Integer> tbcTaskID;
    @FXML
    private TableColumn<FuncionarioTarefa, String> tbcTaskDesc;
    @FXML
    private TextField searchTask;
    @FXML
    private Button btnEditarTarefa;

    @FXML
    private TextField searchAnimal;
    @FXML
    private Button btnNewAnimal;

    @FXML
    private TableView<Animal> tabelaAnimais;
    @FXML
    private TableColumn<Animal, Integer> tbcAnimID;
    @FXML
    private TableColumn<Animal, String> tbcAnimNome;
    @FXML
    private TableColumn<Animal, String> tbcAnimNasc;
    @FXML
    private TableColumn<Animal, String> tbcAnimSex;
    @FXML
    private TableColumn<Animal, String> tbcAnimEsp;
    @FXML
    private TableColumn<Animal, Float> tbcAnimPeso;
    @FXML
    private TableColumn<Animal, String> tbcAnimGest;
    @FXML
    private TableColumn<Animal, String> tbcAnimStatus;
    @FXML
    private Button btnEditarAnimal;

    @FXML
    private TextField searchRemedio;

    @FXML
    private TableView<Remedio> tabelaRemedio;
    @FXML
    private TableColumn<Remedio, Integer> tbcRemedioID;

    @FXML
    private TableColumn<Remedio, String> tbcRemedioNome;

    @FXML
    private TableColumn<Remedio, String> tbcRemedioDesc;

    public Button btnNewRemedio;

    @FXML
    private TableView<Vacina> tabelaVacinas;
    @FXML
    private TableColumn<Vacina, Integer> tbcVacinaID;
    @FXML
    private TableColumn<Vacina, Integer> tbcVacinaAnimal;
    @FXML
    private TableColumn<Vacina, String> tbcVacinaNome;
    @FXML
    private TableColumn<Vacina, String> tbcVacinaData;
    @FXML
    private TableColumn<Vacina, String> tbcVacinaDesc;
    public TextField searchVacina;


    @FXML
    private TableView<Medicacao> tabelaMedicacao;
    @FXML
    private TableColumn<Medicacao, Integer> tbcMedicacaoID;
    @FXML
    private TableColumn<Medicacao, Integer> tbcMedicacaoIDAnim;
    @FXML
    private TableColumn<Medicacao, Integer> tbcMedicRemedio;
    @FXML
    private TableColumn<Medicacao, String> MedicacaoData;
    @FXML
    public TextField searchMedicacao;

    @FXML
    private TableView<Vacinacao> tabelaVacinacao;
    @FXML
    private TableColumn<Vacinacao, Integer> tbcVacinacaoID;
    @FXML
    private TableColumn<Vacinacao, Integer> tbcVacinacaoIDAnim;
    @FXML
    private TableColumn<Vacinacao, Integer> tbcVacIDVacina;
    @FXML
    private TableColumn<Vacinacao, String> VacinacaoData;
    public TextField searchVacinacao;

    private FuncionarioDAO funcDAO = new FuncionarioDAO();
    private FuncionarioTarefaDAO functaskDAO = new FuncionarioTarefaDAO();
    private AnimalDAO animalDAO = new AnimalDAO();
    private RemedioDAO remedioDAO = new RemedioDAO();
    private VacinaDAO vacinaDAO = new VacinaDAO();
    private MedicacaoDAO medicacaoDAO = new MedicacaoDAO();
    private VacinacaoDAO vacinacaoDAO = new VacinacaoDAO();

    private ObservableList<Funcionario> listaFuncionarios = FXCollections.observableArrayList();
    private ObservableList<FuncionarioTarefa> listaFuncTaref = FXCollections.observableArrayList();
    private ObservableList<Animal> listaAnimais = FXCollections.observableArrayList();
    private ObservableList<Remedio> listaRemedios = FXCollections.observableArrayList();
    private ObservableList<Vacina> listaVacinas = FXCollections.observableArrayList();
    private ObservableList<Medicacao> listaMedicacao = FXCollections.observableArrayList();
    private ObservableList<Vacinacao> listaVacinacao = FXCollections.observableArrayList();



    @FXML
    private void initialize() {
        // Configura as colunas para a tabela de Funcionários
        tbcUserID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbcUserNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tbcUserTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tbcUserEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Adiciona à lista observável
        listaFuncionarios.addAll(funcDAO.buscar());
        // Preenche a tabela com dados
        tabelaFuncionarios.setItems(listaFuncionarios);

        // Configura as colunas para a tabela de Tarefas
        tbcFuncTaskID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbcTaskID_USER.setCellValueFactory(new PropertyValueFactory<>("id_funcionario"));
        tbcTaskID.setCellValueFactory(new PropertyValueFactory<>("id_tarefa"));
        tbcTaskDesc.setCellValueFactory(new PropertyValueFactory<>("descricao"));

        listaFuncTaref.addAll(functaskDAO.buscar());
        tabelaTarefas.setItems(listaFuncTaref);

        // Configura as colunas para a tabela de Animais
        tbcAnimID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbcAnimNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tbcAnimNasc.setCellValueFactory(new PropertyValueFactory<>("data_nascimento"));
        tbcAnimSex.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        tbcAnimEsp.setCellValueFactory(new PropertyValueFactory<>("especie"));
        tbcAnimGest.setCellValueFactory(new PropertyValueFactory<>("gestante"));
        tbcAnimPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        tbcAnimStatus.setCellValueFactory(new PropertyValueFactory<>("status_vida"));

        listaAnimais.addAll(animalDAO.relatorio());
        tabelaAnimais.setItems(listaAnimais);

        // Configura as colunas para a tabela de Remedios
        tbcRemedioID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbcRemedioNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tbcRemedioDesc.setCellValueFactory(new PropertyValueFactory<>("descricao"));

        listaRemedios.addAll(remedioDAO.relatorio());
        tabelaRemedio.setItems(listaRemedios);

        // Configura as colunas para a tabela de Vacinas
        tbcVacinaID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbcVacinaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tbcVacinaDesc.setCellValueFactory(new PropertyValueFactory<>("descricao"));

        listaVacinas.addAll(vacinaDAO.relatorio());
        tabelaVacinas.setItems(listaVacinas);

        // Configura as colunas para a tabela de Medicacao
        tbcMedicacaoID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbcMedicacaoIDAnim.setCellValueFactory(new PropertyValueFactory<>("id_animal"));
        tbcMedicRemedio.setCellValueFactory(new PropertyValueFactory<>("id_remedio"));
        MedicacaoData.setCellValueFactory(new PropertyValueFactory<>("data_aplicacao"));

        listaMedicacao.addAll(medicacaoDAO.relatorio());
        tabelaMedicacao.setItems(listaMedicacao);

        // Configura as colunas para a tabela de Vacinacao
        tbcVacinacaoID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tbcVacinacaoIDAnim.setCellValueFactory(new PropertyValueFactory<>("id_animal"));
        tbcVacIDVacina.setCellValueFactory(new PropertyValueFactory<>("id_vacina"));
        VacinacaoData.setCellValueFactory(new PropertyValueFactory<>("data_aplicacao"));

        listaVacinacao.addAll(vacinacaoDAO.relatorio());
        tabelaVacinacao.setItems(listaVacinacao);

        //Desacionar botões
        btnNewUser.setDisable(false);
        btnEditarUser.setDisable(true);
        btnDeletarUser.setDisable(true);

        btnNewTask.setDisable(false);
        btnEditarTarefa.setDisable(true);
        btnDeletarTarefa.setDisable(true);

        btnNewAnimal.setDisable(false);
        btnEditarAnimal.setDisable(true);
        btnDeletarAnimal.setDisable(true);

        btnNewRemedio.setDisable(false);
        btnEditarRemedio.setDisable(true);
        btnDeletarRemedio.setDisable(true);

        btnNewMedicacao.setDisable(false);
        btnEditarMedicacao.setDisable(true);
        btnDeletarMedicacao.setDisable(true);

        btnNewVacina.setDisable(false);
        btnEditarVacina.setDisable(true);
        btnDeletarVacina.setDisable(true);

        btnNewVacinacao.setDisable(false);
        btnEditarVacinacao.setDisable(true);
        btnDeletarVacinacao.setDisable(true);
    }

    //Funcionários
    @FXML
    private void handleBtnRelFunc(ActionEvent event){
        btnEditarUser.setText("Editar");
        // Chama o método para buscar todos os funcionários
        listaFuncionarios.clear();  // Limpa a lista para evitar duplicatas
        listaFuncionarios.addAll(funcDAO.buscar());

        // Atualiza a tabela com os dados obtidos
        tabelaFuncionarios.setItems(listaFuncionarios);

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Relatório de Funcionários gerado com sucesso.", ButtonType.OK);
        alert.showAndWait();

        btnNewUser.setDisable(false);
        btnEditarUser.setDisable(true);
        btnDeletarUser.setDisable(true);
    }

    @FXML
    private void handleSearchUser() {
        try {
            // Obtém o ID digitado pelo usuário
            int userID = Integer.parseInt(searchUser.getText());
            // Busca o funcionário pelo ID
            Funcionario funcBusca = funcDAO.buscarPorId(userID);

            // Se o id está vazio
            if (funcBusca == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Funcionário não encontrado.", ButtonType.OK);
                alert.showAndWait();
            } else {
                // Se o id não está vazio
                ObservableList<Funcionario> data = tabelaFuncionarios.getItems();
                data.clear();  // Limpa os dados existentes
                data.add(funcBusca);  // Adiciona o novo funcionário

                btnNewUser.setDisable(false);
                searchUser.setDisable(false);
                btnEditarUser.setDisable(false);
                btnDeletarUser.setDisable(false);
            }

        } catch (NumberFormatException e) {
            // Trata a exceção caso o ID inserido não seja um número válido
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Insira um ID válido para realizar a busca.", ButtonType.OK);
            alert.showAndWait();
        }
    }

    private void addEditListeners() {
        // Adiciona listeners para capturar as alterações nas células
        tbcUserNome.setOnEditCommit(event -> {
            Funcionario func = event.getRowValue();
            func.setNome(event.getNewValue());
            funcDAO.editar(func);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alteração realizada com sucesso.", ButtonType.OK);
            alert.showAndWait();
        });

        tbcUserTelefone.setOnEditCommit(event -> {
            Funcionario func = event.getRowValue();
            func.setTelefone(event.getNewValue());
            funcDAO.editar(func);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alteração realizada com sucesso.", ButtonType.OK);
            alert.showAndWait();
        });

        tbcUserEmail.setOnEditCommit(event -> {
            Funcionario func = event.getRowValue();
            func.setEmail(event.getNewValue());
            funcDAO.editar(func);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alteração realizada com sucesso.", ButtonType.OK);
            alert.showAndWait();
        });


    }

    @FXML
    private void handleBtnEditarUser(ActionEvent event) {

        btnEditarUser.setText("Alterar");
        // Verifica se algum item está selecionado na tabela
        Funcionario func = tabelaFuncionarios.getSelectionModel().getSelectedItem();

        // Configura as colunas para edição
        tbcUserID.setEditable(false);
        tbcUserNome.setEditable(true);
        tbcUserTelefone.setEditable(true);
        tbcUserEmail.setEditable(true);

        if (func != null) {
            tbcUserNome.setCellFactory(TextFieldTableCell.forTableColumn());
            tbcUserTelefone.setCellFactory(TextFieldTableCell.forTableColumn());
            tbcUserEmail.setCellFactory(TextFieldTableCell.forTableColumn());

            // Adiciona os listeners para capturar as alterações nas células
            addEditListeners();

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Selecione o funcionário.", ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    private void handleBtnDeletarUser(ActionEvent event) {
        int userID = Integer.parseInt(searchUser.getText());

        Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION,
                "Tem certeza que deseja excluir o funcionário?\nEsta ação não pode ser desfeita.",
                ButtonType.YES, ButtonType.NO);
        confirmacao.showAndWait();

        if (confirmacao.getResult() == ButtonType.YES) {
            // Se o usuário confirmar, exclui o funcionário
            funcDAO.DELseRefFuncionario(userID);
            funcDAO.deletar(userID);

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Funcionário excluído com sucesso.", ButtonType.OK);
            alert.showAndWait();
        }
    }


    @FXML
    private void handleBtnNewUser(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("novoFuncionario.fxml"));
        Parent newFuncPage = loader.load();

        // Obtém o controlador da nova página
        NewFuncionarioController newFuncionarioController = loader.getController();

        // Cria um novo palco (stage) para a nova cena
        Stage novoPalco = new Stage();
        novoPalco.setTitle("Pastos - Cadastro de funcionário");


        // Define a nova cena no novo palco
        Scene novaCena = new Scene(newFuncPage);
        novoPalco.setScene(novaCena);

        // Mostra o novo palco
        novoPalco.show();
    }

    //Tarefas
    @FXML
    private void handleBtnRelTarefas(ActionEvent event){
        btnEditarTarefa.setText("Editar");
        listaFuncTaref.clear();
        listaFuncTaref.addAll(functaskDAO.buscar());

        // Atualiza a tabela com os dados obtidos
        tabelaTarefas.setItems(listaFuncTaref);

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Relatório de Tarefas gerado com sucesso.", ButtonType.OK);
        alert.showAndWait();

        btnNewTask.setDisable(false);
        btnEditarTarefa.setDisable(true);
        btnDeletarTarefa.setDisable(true);
    }

    @FXML
    private void handleSearchTask() {
        try {
            // Obtém o ID digitado pelo usuário
            int userID = Integer.parseInt(searchTask.getText());
            // Busca a tarefa pelo ID
            FuncionarioTarefa ftBusca = functaskDAO.buscarPorId(userID);

            // Se o id está vazio
            if (ftBusca == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Tarefa não encontrada.", ButtonType.OK);
                alert.showAndWait();
            } else {
                // Se o id não está vazio
                ObservableList<FuncionarioTarefa> data = tabelaTarefas.getItems();
                data.clear();  // Limpa os dados existentes
                data.add(ftBusca);  // Adiciona a nova tarefa

                btnEditarRemedio.setText("Alterar");
                btnNewTask.setDisable(false);
                searchTask.setDisable(false);
                btnEditarTarefa.setDisable(false);
                btnDeletarTarefa.setDisable(false);

                // Configura as colunas para edição
                tbcFuncTaskID.setEditable(false);
                tbcTaskID_USER.setEditable(true);
                tbcTaskDesc.setEditable(true);

            }
        } catch (NumberFormatException e) {
            // Trata a exceção caso o ID inserido não seja um número válido
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Insira um ID válido para realizar a busca.", ButtonType.OK);
            alert.showAndWait();
        }
    }

    private void addEditTarefaListeners() {
        // Adiciona listeners para capturar as alterações nas células
        tbcTaskID_USER.setOnEditCommit(event -> {
            FuncionarioTarefa ft = event.getRowValue();
            ft.setId_funcionario(event.getNewValue());
            functaskDAO.editar(ft);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alteração realizada com sucesso.", ButtonType.OK);
            alert.showAndWait();
        });

        tbcTaskDesc.setOnEditCommit(event -> {
            FuncionarioTarefa ft = event.getRowValue();
            ft.setDescricao(event.getNewValue());
            functaskDAO.editar(ft);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alteração realizada com sucesso.", ButtonType.OK);
            alert.showAndWait();
        });

    }

    @FXML
    private void handleBtnEditarTarefa(ActionEvent event) {
        // Verifica se algum item está selecionado na tabela
        FuncionarioTarefa ft = tabelaTarefas.getSelectionModel().getSelectedItem();

        if (ft != null) {
            tbcTaskID_USER.setCellFactory(TextFieldTableCell.forTableColumn((new IntegerStringConverter())));
            tbcTaskDesc.setCellFactory(TextFieldTableCell.forTableColumn());

            // Adiciona os listeners para capturar as alterações nas células
            addEditTarefaListeners();


        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Selecione a tarefa.", ButtonType.OK);
            alert.showAndWait();
        }
    }
    @FXML
    private void handleBtnNewTask(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("novaTarefa.fxml"));
        Parent novaTarefaPage = loader.load();

        // Obtém o controlador da nova página, se necessário
        NewTarefaController NewTarefaController = loader.getController();

        // Cria um novo palco (stage) para a nova cena
        Stage novoPalco = new Stage();
        novoPalco.setTitle("Pastos - Cadastro de Tarefa");

        // Define a nova cena no novo palco
        Scene novaCena = new Scene(novaTarefaPage);
        novoPalco.setScene(novaCena);

        // Mostra o novo palco
        novoPalco.show();
    }


    @FXML
    private void handleBtnDeletarTask(ActionEvent event) {
        try {
            // Verifica se o campo de pesquisa de tarefa está vazio
            if (searchTask.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Digite um ID válido para buscar uma tarefa.", ButtonType.OK);
                alert.showAndWait();
                return;
            }

            int tarefaID = Integer.parseInt(searchTask.getText());

            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION,
                    "Tem certeza que deseja excluir a tarefa?",
                    ButtonType.YES, ButtonType.NO);
            confirmacao.showAndWait();

            if (confirmacao.getResult() == ButtonType.YES) {
                functaskDAO.deletar(tarefaID);

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Tarefa excluída com sucesso.", ButtonType.OK);
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Insira um ID válido para realizar a exclusão.", ButtonType.OK);
            alert.showAndWait();
        }
    }


    //Animais
    @FXML
    private void handleBtnRelAnimais(ActionEvent event){
        btnEditarAnimal.setText("Editar");
         listaAnimais.clear();
         listaAnimais.addAll(animalDAO.relatorio());

        // Atualiza a tabela com os dados obtidos
        tabelaAnimais.setItems(listaAnimais);

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Relatório de Animais gerado com sucesso.", ButtonType.OK);
        alert.showAndWait();

        btnNewAnimal.setDisable(false);
        btnEditarAnimal.setDisable(true);
        btnDeletarAnimal.setDisable(true);
    }

    @FXML
    private void handleBtnNewAnimal(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("novoAnimal.fxml"));
        Parent novoAnimalPage = loader.load();

        // Obtém o controlador da nova página, se necessário
        NewAnimalController NewAnimalController = loader.getController();

        // Cria um novo palco (stage) para a nova cena
        Stage novoPalco = new Stage();
        novoPalco.setTitle("Pastos - Cadastro de Animal");

        // Define a nova cena no novo palco
        Scene novaCena = new Scene(novoAnimalPage);
        novoPalco.setScene(novaCena);

        // Mostra o novo palco
        novoPalco.show();
    }

    @FXML
    private void handleSearchAnimal() {
        try {
            // Obtém o ID digitado pelo usuário
            int userID = Integer.parseInt(searchAnimal.getText());

            // Busca o funcionário pelo ID
            Animal animalBusca = animalDAO.buscarPorId(userID);

            // Se o id está vazio
            if (animalBusca == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Animal não encontrado.", ButtonType.OK);
                alert.showAndWait();
            } else {
                // Se o id não está vazio
                ObservableList<Animal> data = tabelaAnimais.getItems();
                data.clear();  // Limpa os dados existentes
                data.add(animalBusca);  // Adiciona o novo animal

                btnEditarAnimal.setText("Alterar");
                btnNewAnimal.setDisable(false);
                searchAnimal.setDisable(false);
                btnEditarAnimal.setDisable(false);
                btnDeletarAnimal.setDisable(false);

                // Configura as colunas para edição
                tbcAnimID.setEditable(false);
                tbcAnimNome.setEditable(true);
                tbcAnimEsp.setEditable(true);
                tbcAnimPeso.setEditable(true);
                tbcAnimSex.setEditable(true);
                tbcAnimPeso.setEditable(true);
                tbcAnimNasc.setEditable(true);

                tbcAnimNome.setCellFactory(TextFieldTableCell.forTableColumn());
                tbcAnimEsp.setCellFactory(TextFieldTableCell.forTableColumn());
                tbcAnimPeso.setCellFactory(TextFieldTableCell.forTableColumn((new FloatStringConverter())));
                tbcAnimSex.setCellFactory(TextFieldTableCell.forTableColumn());
                tbcAnimNasc.setCellFactory(TextFieldTableCell.forTableColumn());

            }
        } catch (NumberFormatException e) {
            // Trata a exceção caso o ID inserido não seja um número válido
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Insira um ID válido para realizar a busca.", ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    private void handleBtnEditarAnimal(ActionEvent event) {
        // Verifica se algum item está selecionado na tabela
        Animal animal = tabelaAnimais.getSelectionModel().getSelectedItem();

        if (animal != null) {
            // Adiciona listeners para capturar as alterações nas células
            addEditAnimalListeners();

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Selecione o animal.", ButtonType.OK);
            alert.showAndWait();
        }
    }

    private void addEditAnimalListeners() {
        // Adiciona listeners para capturar as alterações nas células
        tbcAnimNome.setOnEditCommit(event -> {
            Animal animal = event.getRowValue();
            animal.setNome(event.getNewValue());
            animalDAO.editar(animal);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alteração realizada com sucesso.", ButtonType.OK);
            alert.showAndWait();
        });
        tbcAnimEsp.setOnEditCommit(event -> {
            Animal animal = event.getRowValue();
            animal.setEspecie(event.getNewValue());
            animalDAO.editar(animal);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alteração realizada com sucesso.", ButtonType.OK);
            alert.showAndWait();
        });
        tbcAnimID.setOnEditCommit(event -> {
            Animal animal = event.getRowValue();
            animal.setId(event.getNewValue());
            animalDAO.editar(animal);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alteração realizada com sucesso.", ButtonType.OK);
            alert.showAndWait();
        });
        tbcAnimPeso.setOnEditCommit(event -> {
            Animal animal = event.getRowValue();
            animal.setPeso(event.getNewValue());
            animalDAO.editar(animal);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alteração realizada com sucesso.", ButtonType.OK);
            alert.showAndWait();
        });
        tbcAnimSex.setOnEditCommit(event -> {
            Animal animal = event.getRowValue();
            animal.setSexo(event.getNewValue());
            animalDAO.editar(animal);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alteração realizada com sucesso.", ButtonType.OK);
            alert.showAndWait();
        });
        tbcAnimNasc.setOnEditCommit(event -> {
            Animal animal = event.getRowValue();
            animal.setData_nascimento(event.getNewValue());
            animalDAO.editar(animal);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alteração realizada com sucesso.", ButtonType.OK);
            alert.showAndWait();
        });
        tbcAnimEsp.setOnEditCommit(event -> {
            Animal animal = event.getRowValue();
            animal.setEspecie(event.getNewValue());
            animalDAO.editar(animal);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alteração realizada com sucesso.", ButtonType.OK);
            alert.showAndWait();
        });


    }

    private void clearAnimalFields() {
        tbcAnimID.setText("");
        tbcAnimNome.setText("");
        tbcAnimNasc.setText("");
        tbcAnimSex.setText("");
        tbcAnimEsp.setText("");
        tbcAnimGest.setText("");
        tbcAnimPeso.setText("");
        tbcAnimStatus.setText("");

        // Desabilita a edição dos campos
        tbcAnimNome.setEditable(false);
        tbcAnimNasc.setEditable(false);
        tbcAnimSex.setEditable(false);
        tbcAnimEsp.setEditable(false);
        tbcAnimGest.setEditable(false);
        tbcAnimPeso.setEditable(false);
        tbcAnimStatus.setEditable(false);

        // Habilita o campo de pesquisa e os botões relevantes
        searchAnimal.setDisable(false);
        btnEditarAnimal.setDisable(true);
        btnNewAnimal.setDisable(false);

    }


    @FXML
    private void handleBtnDelAnimal(ActionEvent event) {
        try {
            if (searchAnimal.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Digite um ID válido para buscar um animal.", ButtonType.OK);
                alert.showAndWait();
                return;
            }

            int animalID = Integer.parseInt(searchAnimal.getText());

            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION,
                    "Tem certeza que deseja excluir o animal?\nEsta ação não pode ser desfeita.",
                    ButtonType.YES, ButtonType.NO);
            confirmacao.showAndWait();

            if (confirmacao.getResult() == ButtonType.YES) {
                animalDAO.DELseRefVacinacao(animalID);
                animalDAO.DELseRefMedicacao(animalID);
                animalDAO.deletar(animalID);
                clearAnimalFields();

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Animal excluído com sucesso.", ButtonType.OK);
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            clearAnimalFields();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Insira um ID válido para realizar a exclusão.", ButtonType.OK);
            alert.showAndWait();
        }
    }



    //Remedios
    @FXML
    private void handleBtnRelRemedios(ActionEvent event){
        btnEditarRemedio.setText("Editar");
        listaRemedios.clear();
        listaRemedios.addAll(remedioDAO.relatorio());

        // Atualiza a tabela com os dados obtidos
        tabelaRemedio.setItems(listaRemedios);

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Relatório de Remédios gerado com sucesso.", ButtonType.OK);
        alert.showAndWait();

        btnNewRemedio.setDisable(false);
        btnEditarRemedio.setDisable(true);
        btnDeletarRemedio.setDisable(true);
    }



    @FXML
    private void handleSearchRemedio() {
        try {
            // Obtém o ID digitado pelo usuário
            String userID = searchRemedio.getText();
            // Busca o remedio pelo ID
            Remedio remBusca = remedioDAO.buscarPorNome(userID);

            // Se o id está vazio
            if (remBusca == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Remédio não encontrado.", ButtonType.OK);
                alert.showAndWait();
            } else {
                // Se o id não está vazio
                ObservableList<Remedio> data = tabelaRemedio.getItems();
                data.clear();  // Limpa os dados existentes
                data.add(remBusca);  // Adiciona o novo remédio

                btnEditarRemedio.setText("Alterar");
                btnNewRemedio.setDisable(false);
                searchRemedio.setDisable(false);
                btnEditarRemedio.setDisable(false);
                btnDeletarRemedio.setDisable(false);

                // Configura as colunas para edição
                tbcRemedioID.setEditable(false);
                tbcRemedioNome.setEditable(true);
                tbcRemedioDesc.setEditable(true);

            }
        } catch (NumberFormatException e) {
            // Trata a exceção caso o ID inserido não seja um número válido
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Insira um ID válido para realizar a busca.", ButtonType.OK);
            alert.showAndWait();
        }
    }

    private void addEditRemedioListeners() {
        // Adiciona listeners para capturar as alterações nas células
        tbcRemedioNome.setOnEditCommit(event -> {
            Remedio rem = event.getRowValue();
            rem.setNome(event.getNewValue());
            remedioDAO.editar(rem);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alteração realizada com sucesso.", ButtonType.OK);
            alert.showAndWait();
        });

        tbcRemedioDesc.setOnEditCommit(event -> {
            Remedio rem = event.getRowValue();
            rem.setDescricao(event.getNewValue());
            remedioDAO.editar(rem);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alteração realizada com sucesso.", ButtonType.OK);
            alert.showAndWait();
        });

    }

    @FXML
    private void handleBtnEditarRemedio(ActionEvent event) {
        // Verifica se algum item está selecionado na tabela
        Remedio rem = tabelaRemedio.getSelectionModel().getSelectedItem();

        if (rem != null) {
            tbcRemedioID.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            tbcRemedioNome.setCellFactory(TextFieldTableCell.forTableColumn());
            tbcRemedioDesc.setCellFactory(TextFieldTableCell.forTableColumn());

            // Adiciona os listeners para capturar as alterações nas células
            addEditRemedioListeners();

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Selecione o remédio.", ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    private void handleBtnDelRemedio(ActionEvent event) {
        try {
            if (searchRemedio.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Digite um ID válido para buscar um remédio.", ButtonType.OK);
                alert.showAndWait();
                return;
            }

            String remedioID = searchRemedio.getText();

            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION,
                    "Tem certeza que deseja excluir o remédio?",
                    ButtonType.YES, ButtonType.NO);
            confirmacao.showAndWait();

            if (confirmacao.getResult() == ButtonType.YES) {
                remedioDAO.DELseRefMedicacao(remedioID);
                remedioDAO.deletar(remedioID);

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Remédio excluído com sucesso.", ButtonType.OK);
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Insira um ID válido para realizar a exclusão.", ButtonType.OK);
            alert.showAndWait();
        }
    }


    @FXML
    private void handleBtnNovoRemedio(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("novoRemedio.fxml"));
        Parent novoRemedioPage = loader.load();

        // Obtém o controlador da nova página, se necessário
        NewRemedioController newRemedioController = loader.getController();

        // Cria um novo palco (stage) para a nova cena
        Stage novoPalco = new Stage();
        novoPalco.setTitle("Pastos - Cadastro de Remédio");

        // Define a nova cena no novo palco
        Scene novaCena = new Scene(novoRemedioPage);
        novoPalco.setScene(novaCena);

        // Mostra o novo palco
        novoPalco.show();
    }

    //Vacinas

    @FXML
    private void handleBtnRelVacina(ActionEvent event){
        btnEditarVacina.setText("Editar");
        listaVacinas.clear();
        listaVacinas.addAll(vacinaDAO.relatorio());

        // Atualiza a tabela com os dados obtidos
        tabelaVacinas.setItems(listaVacinas);

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Relatório de Vacina gerado com sucesso.", ButtonType.OK);
        alert.showAndWait();

        btnNewVacina.setDisable(false);
        btnEditarVacina.setDisable(true);
        btnDeletarVacina.setDisable(true);
    }
    @FXML
    private void handleSearchVacina() {
        try {
            // Obtém o ID digitado pelo usuário
            int userID = Integer.parseInt(searchVacina.getText());
            // Busca a vacina pelo ID
            Vacina vacinaBusca = vacinaDAO.buscarPorId(userID);

            // Se o id está vazio
            if (vacinaBusca == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Vacina não encontrada.", ButtonType.OK);
                alert.showAndWait();
            } else {
                // Se o id não está vazio
                ObservableList<Vacina> data = tabelaVacinas.getItems();
                data.clear();  // Limpa os dados existentes
                data.add(vacinaBusca);  // Adiciona o novo funcionário

                btnEditarVacina.setText("Alterar");
                btnNewVacina.setDisable(false);
                searchVacina.setDisable(false);
                btnEditarVacina.setDisable(false);
                btnDeletarVacina.setDisable(false);

                // Configura as colunas para edição
                tbcVacinaID.setEditable(false);
                tbcVacinaNome.setEditable(true);
                tbcVacinaDesc.setEditable(true);

            }
        } catch (NumberFormatException e) {
            // Trata a exceção caso o ID inserido não seja um número válido
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Insira um ID válido para realizar a busca.", ButtonType.OK);
            alert.showAndWait();
        }
    }

    private void addEditVacinaListeners() {
        // Adiciona listeners para capturar as alterações nas células
        tbcVacinaNome.setOnEditCommit(event -> {
            Vacina vaci = event.getRowValue();
            vaci.setNome(event.getNewValue());
            vacinaDAO.editar(vaci);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alteração realizada com sucesso.", ButtonType.OK);
            alert.showAndWait();
        });

        tbcVacinaDesc.setOnEditCommit(event -> {
            Vacina vaci = event.getRowValue();
            vaci.setDescricao(event.getNewValue());
            vacinaDAO.editar(vaci);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alteração realizada com sucesso.", ButtonType.OK);
            alert.showAndWait();
        });

    }

    @FXML
    private void handleBtnEditarVacina(ActionEvent event) {
        // Verifica se algum item está selecionado na tabela
        Vacina vaci = tabelaVacinas.getSelectionModel().getSelectedItem();

        if (vaci != null) {
            tbcVacinaID.setCellFactory(TextFieldTableCell.forTableColumn((new IntegerStringConverter())));
            tbcVacinaNome.setCellFactory(TextFieldTableCell.forTableColumn());
            tbcVacinaDesc.setCellFactory(TextFieldTableCell.forTableColumn());

            // Adiciona os listeners para capturar as alterações nas células
            addEditVacinaListeners();

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Selecione a vacina.", ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    private void handleBtnDelVacina() {
        try {
            if (searchVacina.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Digite um ID válido.", ButtonType.OK);
                alert.showAndWait();
                return;
            }

            int vacinaID = Integer.parseInt(searchVacina.getText());

            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION,
                    "Tem certeza que deseja excluir a vacina?",
                    ButtonType.YES, ButtonType.NO);
            confirmacao.showAndWait();

            if (confirmacao.getResult() == ButtonType.YES) {
                vacinaDAO.DELseRefVacinacao(vacinaID);
                vacinaDAO.deletar(vacinaID);

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Vacina excluída com sucesso.", ButtonType.OK);
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Insira um ID válido para realizar a exclusão.", ButtonType.OK);
            alert.showAndWait();
        }
    }


    @FXML
    private void handleBtnNovaVacina(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("novaVacina.fxml"));
        Parent novaVacinaPage = loader.load();


        // Obtém o controlador da nova página, se necessário
        NewVacinaController newVacinaController = loader.getController();

        // Cria um novo palco (stage) para a nova cena
        Stage novoPalco = new Stage();
        novoPalco.setTitle("Pastos - Cadastro de Vacina");

        // Define a nova cena no novo palco
        Scene novaCena = new Scene(novaVacinaPage);
        novoPalco.setScene(novaCena);

        // Mostra o novo palco
        novoPalco.show();

    }


    //Vacinação
    @FXML
    private void handleBtnRelVacinacao(ActionEvent event){
        btnEditarVacinacao.setText("Editar");
         listaVacinacao.clear();
         listaVacinacao.addAll(vacinacaoDAO.relatorio());

        // Atualiza a tabela com os dados obtidos
        tabelaVacinacao.setItems(listaVacinacao);

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Relatório de Vacinação gerado com sucesso.", ButtonType.OK);
        alert.showAndWait();

        btnNewVacinacao.setDisable(false);
        btnEditarVacinacao.setDisable(true);
        btnDeletarVacinacao.setDisable(true);
    }
    @FXML
    private void handleBtnNovaVacinacao(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("novaVacinacao.fxml"));
        Parent novaVacinacaoPage = loader.load();

        // Obtém o controlador da nova página, se necessário
        NewVacinacaoController newVacinacaoController = loader.getController();

        // Cria um novo palco (stage) para a nova cena
        Stage novoPalco = new Stage();
        novoPalco.setTitle("Pastos - Cadastro de Vacinação");

        // Define a nova cena no novo palco
        Scene novaCena = new Scene(novaVacinacaoPage);
        novoPalco.setScene(novaCena);

        // Mostra o novo palco
        novoPalco.show();
    }

    @FXML
    private void handleSearchVacinacao() {
        try {
            // Obtém o ID digitado pelo usuário
            int userID = Integer.parseInt(searchVacinacao.getText());
            // Busca a vacinacao pelo ID
            Vacinacao vacinacaoBusca = vacinacaoDAO.buscarPorId(userID);

            // Se o id está vazio
            if (vacinacaoBusca == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Vacinação não encontrada.", ButtonType.OK);
                alert.showAndWait();
            } else {
                // Se o id não está vazio
                ObservableList<Vacinacao> data = tabelaVacinacao.getItems();
                data.clear();  // Limpa os dados existentes
                data.add(vacinacaoBusca);  // Adiciona a nova vacinação

                btnEditarVacinacao.setText("Alterar");
                btnNewVacinacao.setDisable(false);
                searchVacinacao.setDisable(false);
                btnEditarVacinacao.setDisable(false);
                btnDeletarVacinacao.setDisable(false);

                // Configura as colunas para edição
                tbcVacinacaoID.setEditable(false);
                tbcVacinacaoIDAnim.setEditable(true);
                tbcVacIDVacina.setEditable(true);
                VacinacaoData.setEditable(true);

                tbcVacinacaoID.setCellFactory(TextFieldTableCell.forTableColumn((new IntegerStringConverter())));
                tbcVacinacaoIDAnim.setCellFactory(TextFieldTableCell.forTableColumn((new IntegerStringConverter())));
                tbcVacIDVacina.setCellFactory(TextFieldTableCell.forTableColumn((new IntegerStringConverter())));
                VacinacaoData.setCellFactory(TextFieldTableCell.forTableColumn());

            }
        } catch (NumberFormatException e) {
            // Trata a exceção caso o ID inserido não seja um número válido
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Insira um ID válido para realizar a busca.", ButtonType.OK);
            alert.showAndWait();
        }
    }

    private void addEditVacinacaoListeners() {
        // Adiciona listeners para capturar as alterações nas células
        tbcVacinacaoIDAnim.setOnEditCommit(event -> {
            Vacinacao vaci = event.getRowValue();
            vaci.setId_animal(event.getNewValue());
            vacinacaoDAO.editar(vaci);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alteração realizada com sucesso.", ButtonType.OK);
            alert.showAndWait();
        });

        tbcVacIDVacina.setOnEditCommit(event -> {
            Vacinacao vaci = event.getRowValue();
            vaci.setId_vacina(event.getNewValue());
            vacinacaoDAO.editar(vaci);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alteração realizada com sucesso.", ButtonType.OK);
            alert.showAndWait();
        });

        VacinacaoData.setOnEditCommit(event -> {
            Vacinacao vaci = event.getRowValue();
            vaci.setData_aplicacao(event.getNewValue());
            vacinacaoDAO.editar(vaci);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alteração realizada com sucesso.", ButtonType.OK);
            alert.showAndWait();
        });

    }

    @FXML
    private void handleBtnEditarVacinacao(ActionEvent event) {
        // Verifica se algum item está selecionado na tabela
        Vacinacao vaci = tabelaVacinacao.getSelectionModel().getSelectedItem();

        if (vaci != null) {

            // Adiciona os listeners para capturar as alterações nas células
            addEditVacinacaoListeners();

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Selecione a vacinação.", ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    private void handleBtnDelVacinacao(ActionEvent event) {
        try {
            if (searchVacinacao.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Digite um ID válido para buscar uma vacinação.", ButtonType.OK);
                alert.showAndWait();
                return;
            }

            int vacinacaoID = Integer.parseInt(searchVacinacao.getText());

            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION,
                    "Tem certeza que deseja excluir a vacinação?",
                    ButtonType.YES, ButtonType.NO);
            confirmacao.showAndWait();

            if (confirmacao.getResult() == ButtonType.YES) {
                vacinacaoDAO.deletar(vacinacaoID);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Vacinação excluída com sucesso.", ButtonType.OK);
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Insira um ID válido para realizar a exclusão.", ButtonType.OK);
            alert.showAndWait();
        }
    }


    //Medicação
    @FXML
    private void handleBtnRelMedicacao(ActionEvent event){
        btnEditarMedicacao.setText("Editar");
         listaMedicacao.clear();
         listaMedicacao.addAll(medicacaoDAO.relatorio());

        // Atualiza a tabela com os dados obtidos
        tabelaMedicacao.setItems(listaMedicacao);

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Relatório de Medicação gerado com sucesso.", ButtonType.OK);
        alert.showAndWait();

        btnNewMedicacao.setDisable(false);
        btnEditarMedicacao.setDisable(true);
        btnDeletarMedicacao.setDisable(true);
    }
    @FXML
    private void handleBtnNovaMedicacao(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("novaMedicacao.fxml"));
        Parent novaMedicacaoPage = loader.load();

        // Obtém o controlador da nova página, se necessário
        NewMedicacaoController newMedicacaoController = loader.getController();

        // Cria um novo palco (stage) para a nova cena
        Stage novoPalco = new Stage();
        novoPalco.setTitle("Pastos - Cadastro de Vacinação");

        // Define a nova cena no novo palco
        Scene novaCena = new Scene(novaMedicacaoPage);
        novoPalco.setScene(novaCena);

        // Mostra o novo palco
        novoPalco.show();
    }


    @FXML
    private void handleBtnDelMedicacao(ActionEvent event) {
        try {
            if (searchMedicacao.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Digite um ID válido para buscar uma medicação.", ButtonType.OK);
                alert.showAndWait();
                return;
            }

            int medicacaoID = Integer.parseInt(searchMedicacao.getText());

            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION,
                    "Tem certeza que deseja excluir a medicação?",
                    ButtonType.YES, ButtonType.NO);
            confirmacao.showAndWait();

            if (confirmacao.getResult() == ButtonType.YES) {
                medicacaoDAO.deletar(medicacaoID);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Medicação excluída com sucesso.", ButtonType.OK);
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Insira um ID válido para realizar a exclusão.", ButtonType.OK);
            alert.showAndWait();
        }
    }

    @FXML
    private void handleSearchMedicacao() {
        try {
            // Obtém o ID digitado pelo usuário
            int userID = Integer.parseInt(searchMedicacao.getText());
            // Busca a medicacao pelo ID
            Medicacao medicBusca = medicacaoDAO.buscarPorId(userID);

            // Se o id está vazio
            if (medicBusca == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Medicação não encontrada.", ButtonType.OK);
                alert.showAndWait();
            } else {
                // Se o id não está vazio
                ObservableList<Medicacao> data = tabelaMedicacao.getItems();
                data.clear();  // Limpa os dados existentes
                data.add(medicBusca);  // Adiciona o novo funcionário

                btnEditarMedicacao.setText("Alterar");
                btnNewMedicacao.setDisable(false);
                searchMedicacao.setDisable(false);
                btnEditarMedicacao.setDisable(false);
                btnDeletarMedicacao.setDisable(false);

                // Configura as colunas para edição
                tbcMedicacaoIDAnim.setEditable(true);
                tbcMedicRemedio.setEditable(true);
                MedicacaoData.setEditable(true);
            }
        } catch (NumberFormatException e) {
            // Trata a exceção caso o ID inserido não seja um número válido
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Insira um ID válido para realizar a busca.", ButtonType.OK);
            alert.showAndWait();
        }
    }

    private void addEditMedicacaoListeners() {
        // Adiciona listeners para capturar as alterações nas células
        tbcMedicacaoIDAnim.setOnEditCommit(event -> {
            Medicacao medic = event.getRowValue();
            medic.setId_animal(event.getNewValue());
            medicacaoDAO.editar(medic);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alteração realizada com sucesso.", ButtonType.OK);
            alert.showAndWait();
        });

        tbcMedicRemedio.setOnEditCommit(event -> {
            Medicacao medic = event.getRowValue();
            medic.setId_remedio(event.getNewValue());
            medicacaoDAO.editar(medic);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alteração realizada com sucesso.", ButtonType.OK);
            alert.showAndWait();
        });

        MedicacaoData.setOnEditCommit(event -> {
            Medicacao medic = event.getRowValue();
            medic.setData_aplicacao(event.getNewValue());
            medicacaoDAO.editar(medic);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Alteração realizada com sucesso.", ButtonType.OK);
            alert.showAndWait();
        });


    }

    @FXML
    private void handleBtnEditarMedicacao(ActionEvent event) {
        // Verifica se algum item está selecionado na tabela
        Medicacao medic = tabelaMedicacao.getSelectionModel().getSelectedItem();

        if (medic != null) {
            tbcMedicacaoIDAnim.setCellFactory(TextFieldTableCell.forTableColumn((new IntegerStringConverter())));
            tbcMedicRemedio.setCellFactory(TextFieldTableCell.forTableColumn((new IntegerStringConverter())));
            MedicacaoData.setCellFactory(TextFieldTableCell.forTableColumn());

            // Adiciona os listeners para capturar as alterações nas células
            addEditMedicacaoListeners();

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Selecione a medicação.", ButtonType.OK);
            alert.showAndWait();
        }
    }


}

