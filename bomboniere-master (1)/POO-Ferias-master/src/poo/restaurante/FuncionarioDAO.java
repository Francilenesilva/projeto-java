package poo.restaurante;

import java.util.ArrayList;
import java.util.Collection;

public class FuncionarioDAO {
    Collection<Funcionario> garcom() {
        Collection<Funcionario> garcom = new ArrayList();
        garcom.add(new Funcionario("Joao", 22,"9888755"));
        garcom.add(new Funcionario("Pedro", 25, "8513245"));
        garcom.add(new Funcionario("Maria", 38, "9854123"));
        garcom.add(new Funcionario("Antonio", 35,"2135478"));
        garcom.add(new Funcionario("Ana", 18, "8546971"));
        return garcom;
    }
}
