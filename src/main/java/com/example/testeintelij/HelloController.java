package com.example.testeintelij;

import javafx.application.Application;
import java.io.IOException;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Parent;


public class HelloController extends Application {
    public Label lblMensagemLogin;

    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtSenha;
    @FXML
    private Button btnEntrar;
    @FXML
    private ImageView logoPastos;

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);


    @FXML
    private void initialize() {
    }

    @FXML
    private void handleEntrarButton(ActionEvent event) {
        String login = "bode";
        String senha = "123";

        if(txtLogin.getText().equals(login) && txtSenha.getText().equals(senha)){
            try {
                // Carrega a FXML da nova página
                FXMLLoader loader = new FXMLLoader(getClass().getResource("tabelas-page.fxml"));
                Parent tabelaPage = loader.load();

                // Obtém o controlador da nova página
                TabelasController tabelasPageController = loader.getController();

                // Cria um novo palco (stage) para a nova cena
                Stage novoPalco = new Stage();
                novoPalco.setTitle("Pastos - Página de Tabelas");

                // Define a nova cena no novo palco
                Scene novaCena = new Scene(tabelaPage);
                novoPalco.setScene(novaCena);

                // Fecha o palco atual
                Stage palcoAtual = (Stage) btnEntrar.getScene().getWindow();
                palcoAtual.close();

                // Mostra o novo palco
                novoPalco.show();
            } catch (Exception e) {
                logger.error("Erro ao carregar a FXML da nova página", e);
                e.printStackTrace();
            }
        } else {
            //Caso os dados de login estejam incorretos
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Dados de login incorretos.", ButtonType.OK);
            alert.showAndWait();
            txtLogin.setText("");
            txtSenha.setText("");
            txtLogin.requestFocus();
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-page.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 450, 450);
        stage.setTitle("Aplicação Pastos");

        Image favicon = new Image("favicon.png");
        stage.getIcons().add(favicon);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}


