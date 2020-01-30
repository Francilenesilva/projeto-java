package poo.restaurante;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class ControllerPrincipal {


    @FXML
    private ComboBox<Mesa> comboBoxOcupadas;

    @FXML
    private ComboBox<String> comboBoxGarcom;


    @FXML
    private ListView<Mesa> listViewOcupadas;

    @FXML
    private ListView<Mesa> listViewReservadas;

    @FXML
    private ListView<Mesa> listViewLivres;


    private ObservableList<Mesa> obsMesasLivre;
    private ObservableList<Mesa> obsMesasOcupadas;
    private ObservableList<Mesa> obsMesasReservada;


    private FachadaMesas mesas = new FachadaMesas();


    @FXML
    private Button botaoDesocuparMesa;

    @FXML
    private Button botaoAbrirMesa;

    @FXML
    private Button botaoReservarMesa;

    @FXML
    private ComboBox<?> comboBoxPedidos;


    private static ArrayList<ObsMudaTela> ouvintes = new ArrayList<ObsMudaTela>();
    private MouseEvent event;

    public ControllerPrincipal() {
    }


    public static interface ObsMudaTela {
        void mudaTela(Object objetoQualquer);
    }

    public static void addMudaTela(ObsMudaTela novoOuvinte) {
        ouvintes.add(novoOuvinte);
    }

    public static void notificaOuvintes(Object dado) {
        for (ObsMudaTela o : ouvintes) {
            o.mudaTela(dado);
        }
    }


    @FXML
    public void initialize() {
        carregandoMesas();
        listViewLivres.setItems(obsMesasLivre);
        carregandoMesas();

    }

    public void carregandoMesas() {
        Mesa[] mesas = {
                new Mesa(1),
                new Mesa(2),
                new Mesa(3),
                new Mesa(4),
                new Mesa(5)
        };


        obsMesasLivre = FXCollections.observableArrayList(mesas);
        obsMesasOcupadas = FXCollections.observableArrayList(new ArrayList<>());
        obsMesasReservada = FXCollections.observableArrayList(new ArrayList<>());

        //    System.out.println("TESTES -> "+m.getComanda().pedidos[0].garcom.getNome());


    }

    @FXML
    void reservar(ActionEvent event) {
        // selecionar mesa  listViewLivres
        Mesa m = listViewLivres.getSelectionModel().getSelectedItem();
        if (m == null) return;
        // mover para reservadas ]

        m.setStatusReservado();

        listViewReservadas.getItems().add(m);
        listViewLivres.getItems().remove(m);
        listViewLivres.getSelectionModel().clearSelection();

    }

    @FXML
    void liberar(ActionEvent event) {
        Mesa m = listViewOcupadas.getSelectionModel().getSelectedItem();
        if (m == null) return;
        m.setStatusLivre();
        listViewLivres.getItems().add(m);
        listViewOcupadas.getItems().remove(m);
        listViewOcupadas.getSelectionModel().clearSelection();
    }

    @FXML
    void cancelar(ActionEvent event) {
        Mesa m = listViewReservadas.getSelectionModel().getSelectedItem();
        if (m == null) return;
        m.setStatusLivre();
        listViewLivres.getItems().add(m);
        listViewReservadas.getItems().remove(m);
        listViewReservadas.getSelectionModel().clearSelection();
    }

    // acertar esse
    // livre para reservado
    // ocupado para livre
    //reservado para ocupado
    @FXML
    void ocupar(ActionEvent event) {
        Mesa m = listViewReservadas.getSelectionModel().getSelectedItem();
        if (m == null) return;
        m.setStatusOcupada();
        listViewOcupadas.getItems().add(m);
        listViewReservadas.getItems().remove(m);
        listViewReservadas.getSelectionModel().clearSelection();
    }

    @FXML
    void ocuparMesa(MouseEvent event) {
        Mesa m = listViewLivres.getSelectionModel().getSelectedItem();
        if (m == null) return;
        m.setStatusOcupada();
        listViewOcupadas.getItems().add(m);
        listViewLivres.getItems().remove(m);
        listViewLivres.getSelectionModel().clearSelection();

    }

    @FXML
    void selecionarMesa(ActionEvent event) {

    }


    @FXML
    void imprime(ActionEvent event) {

        // System.out.println("teste");
        // Mesa objMesa = listViewLivres.getSelectionModel().getSelectedItem();
        // listViewLivres.getSelectionModel().clearSelection();

        // mesas.remove(objMesa);

        //System.out.println(mesasOcupadas.isEmpty());
        // mesasOcupadas.add(objMesa);


        // obsMesas = FXCollections.observableArrayList(mesas);
        //obsMesasOcupadas = FXCollections.observableArrayList(mesas);
        //        listViewLivres.setItems(obsMesas);
        // listViewOcupadas.setItems(obsMesasOcupadas);


    }


    @FXML
    public void abrirMesa(ActionEvent event) throws IOException {
//        Stage stage1 = (Stage) botaoAbrirMesa.getScene().getWindow();
//        stage1.close();


        FXMLLoader load = new FXMLLoader(this.getClass().getResource("./view/Comanda.fxml"));
        Parent root = load.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        if (listViewOcupadas.getSelectionModel().getSelectedItem() != null) {
            listViewOcupadas.getSelectionModel().clearSelection();
            System.out.println(listViewOcupadas.getSelectionModel().getSelectedItem());
            notificaOuvintes(listViewOcupadas.getSelectionModel().getSelectedItem());
            stage.show();
        } else {
            System.out.println("invalido");
        }

    }
    @FXML
    public void  criarPedido(ActionEvent event) throws IOException {
        FXMLLoader load = new FXMLLoader(this.getClass().getResource("view/Pedidos.fxml"));
        Parent root = load.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }


}