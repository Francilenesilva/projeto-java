package poo.restaurante;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Collection;

public class ControllerPedidos<comanda> {

    @FXML
    private TableColumn<?, ?> colunaGarcom;

    @FXML
    private Button botaoCozinha;

    @FXML
    private Button botaoAdicionar;

    @FXML
    private ComboBox<?> comboBoxGarcom;

    @FXML
    private TableView<?> tabelaPedidos;

    @FXML
    private Button botaoEditarPedido;

    @FXML
    private ComboBox<?> comboBoxPedidoAtual;

    @FXML
    private TableColumn<?, ?> colunaHorario;

    @FXML
    private TableColumn<?, ?> colunaPedido;

    @FXML
    private Button botaoFecharMesa;

    @FXML
    private TableColumn<?, ?> colunaMesa;

    @FXML
    private Button botaoEliminar;

    @FXML
    private TextArea textAreaComentarios;

    @FXML
    void editarPedido(ActionEvent event) {

    }




}
