package atividade13;

public class Atividade13 {

    public static void main(String[] args) {

        //ex 1
        Integer[] valores = {3, 7, 8, 9, 10, 5};
        //árvore gerada a partir do construtor
        Arvore arvore = new Arvore(valores);
        //ex 2
        arvore.inserirNo(1);
        //ex 3
        arvore.preOrder(); //saída: 3 1 7 5 8 9 10 
        //ex 4
        arvore.posOrder(); //saída: 1 5 10 9 8 7 3 
        //ex 5
        arvore.inOrder();  //saída: 1 3 5 7 8 9 10 
    }

}
