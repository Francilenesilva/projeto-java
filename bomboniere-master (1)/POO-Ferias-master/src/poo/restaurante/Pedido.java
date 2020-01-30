package poo.restaurante;

public class Pedido {
    public Funcionario garcom;
    public Prato prato;
    public Integer quantidade;

    public Pedido(Prato prato, Funcionario garcom) {
        this.prato = prato;
        this.garcom = garcom ;
    }

    public Double calculaPreco() {
        return this.prato.getValor() * this.quantidade;
    }
}
