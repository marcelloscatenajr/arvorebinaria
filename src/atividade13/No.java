package atividade13;

public class No {

    //ex1
    public Integer valor;
    public No pai;
    public No filhoE;
    public No filhoD;

    //construtores que criam cada nó
    public No(Integer valor) {
        this.valor = valor;
    }

    public No() {
        this.valor = null;
    }

}
