package poo.restaurante;

import javafx.collections.FXCollections;

import java.util.ArrayList;
import java.util.Collection;

public class PratoDAO {

    Collection<Prato> cardapio(){
         Collection<Prato> pratos = new ArrayList();
         pratos.add(new Prato("Macarronada" , 2.0));
         pratos.add(new Prato("Feijoada" , 3.0));
         pratos.add(new Prato("Guizado" , 5.0));
         pratos.add(new Prato("Macaxeira" , 2.0));
         pratos.add(new Prato("Farofa" , 1.0));
        return pratos;
     }

}
