package atividade13;

public class Arvore {

    //ex 1
    public No raiz;

    //função que gera árvore é instanciada a partir do construtor 
    public Arvore(Integer[] nos) {
        this.gerarArvore(nos);
    }

    private void gerarArvore(Integer[] nos) {
        if (nos.length > 1) {
            this.raiz = new No(nos[0]);

            for (int i = 1; i < nos.length; i++) {
                No comparativo = raiz;
                No novoNo;
                if (nos[i] != null) {
                    novoNo = new No(nos[i]);
                    while (true) {
                        if (nos[i] > comparativo.valor) {
                            if (comparativo.filhoD != null) {
                                comparativo = comparativo.filhoD;
                            } else {
                                comparativo.filhoD = novoNo;
                                novoNo.pai = comparativo;
                                break;
                            }
                        } else {
                            if (comparativo.filhoE != null) {
                                comparativo = comparativo.filhoE;
                            } else {
                                comparativo.filhoE = novoNo;
                                novoNo.pai = comparativo;
                                break;
                            }
                        }
                    }
                } else {
                    novoNo = new No();
                    while (true) {
                        if (novoNo.filhoE != null) {
                            novoNo = novoNo.filhoE;
                        } else {
                            break;
                        }
                    }
                    comparativo.filhoE = novoNo;
                    novoNo.pai = comparativo;

                }

            }
        } else {
            this.raiz.valor = null;
        }

    }

    //ex 2
    public void inserirNo(Integer valor) {
        No comparativo = raiz;
        No novoNo;
        if (valor != null) {
            novoNo = new No(valor);
            while (true) {
                if (valor > comparativo.valor) {
                    if (comparativo.filhoD != null) {
                        comparativo = comparativo.filhoD;
                    } else {
                        comparativo.filhoD = novoNo;
                        novoNo.pai = comparativo;
                        break;
                    }
                } else {
                    if (comparativo.filhoE != null) {
                        comparativo = comparativo.filhoE;
                    } else {
                        comparativo.filhoE = novoNo;
                        novoNo.pai = comparativo;
                        break;
                    }
                }
            }
        } else {
            novoNo = new No();
            while (true) {
                if (novoNo.filhoE != null) {
                    novoNo = raiz.filhoE;
                } else {
                    break;
                }
            }
            comparativo.filhoE = novoNo;
            novoNo.pai = comparativo;

        }
    }

    //ex 3
    //essa função serve apenas para ser chamada dentro da função preOrder(), sendo assim, não deve ser chamada no main
    public void preOrderI(No no) {
        System.out.print(no.valor + " ");
        if (no.filhoE != null) {
            this.preOrderI(no.filhoE);
        }
        if (no.filhoD != null) {
            this.preOrderI(no.filhoD);
        }

    }

    //função de ajuste para no fim da exibição do print pular uma linha, ela que deve ser executada na classe main
    public void preOrder() {
        this.preOrderI(this.raiz);
        System.out.println("");
    }

    //ex 4
    //essa função serve apenas para ser chamada dentro da função posOrder(), sendo assim, não deve ser chamada no main
    public void posOrderI(No no) {
        if (no.filhoE != null) {
            this.posOrderI(no.filhoE);
        }
        if (no.filhoD != null) {
            this.posOrderI(no.filhoD);
        }
        System.out.print(no.valor + " ");
    }

    //ex 5
    //função de ajuste para no fim da exibição do print pular uma linha, ela que deve ser executada na classe main
    public void posOrder() {
        this.posOrderI(this.raiz);
        System.out.println("");
    }

    //ex 5
    //essa função serve apenas para ser chamada dentro da função inOrder(), sendo assim, não deve ser chamada no main
    public void inOrderI(No no) {
        if (no.filhoE != null) {
            this.inOrderI(no.filhoE);
        }
        System.out.print(no.valor + " ");
        if (no.filhoD != null) {
            this.inOrderI(no.filhoD);
        }
    }

    //função de ajuste para no fim da exibição do print pular uma linha, ela que deve ser executada na classe main
    public void inOrder() {
        this.inOrderI(this.raiz);
        System.out.println("");
    }

    //ex 6
    public boolean estaNaArore(int value) {
        No atual = raiz;
        boolean esta = false;
        while (esta == false && atual != null) {
            if (value > atual.valor) {
                atual = atual.filhoD;
            } else if (value < atual.valor) {
                atual = atual.filhoE;
            } else {
                esta = true;
            }
        }
        return esta;
    }

    //ex 7
    public Integer menorValor() {
        No atual = raiz;
        while (true) {
            if (atual.filhoE != null) {
                atual = raiz.filhoE;
            } else {
                break;
            }
        }
        return atual.valor;
    }

    //ex 8
    public int quantidadeNos(No no) {
        if (no == null) {
            return 0;
        }
        return (1 + quantidadeNos(no.filhoE) + quantidadeNos(no.filhoD));
    }

    //ex 9
    //para executar essa função está sendo a função somatoria(no) que é declarada no item 13.
    public int media(No no) {
        int s = somatoria(no);
        int q = quantidadeNos(no);
        return s / q;
    }

    //ex 10
    public int altura(No no) {
        if (no == null) {
            return 0;
        } else {
            Integer profE = altura(no.filhoE);
            Integer profD = altura(no.filhoD);

            if (profE > profD) {
                return (profE + 1);
            } else {
                return (profD + 1);
            }
        }
    }

    //ex 11
    public Integer quantidadeNulls(No no) {
        if (no == null) {
            return 0;
        } else {
            int ehNull;
            if (no.valor == null) {
                ehNull = 1;
            } else {
                ehNull = 0;
            }

            return (ehNull + quantidadeNulls(no.filhoE) + quantidadeNulls(no.filhoD));
        }

    }

    //ex 12
    //essa função serve apenas para ser chamada dentro da função multiplo2(no), sendo assim, não deve ser chamada no main
    private void multiplo2I(No no) {
        if (no.filhoE != null) {
            this.multiplo2I(no.filhoE);
        }
        if (no.valor % 2 == 0) {
            System.out.print(no.valor + " ");
        }
        if (no.filhoD != null) {
            this.multiplo2I(no.filhoD);
        }
    }

    // função de ajuste para no fim da exibição do print pular uma linha, ela que deve ser executada na classe main
    public void multiplo2(No no) {
        this.multiplo2I(no);
        System.out.println("");
    }

    //ex 13
    public int somatoria(No no) {
        if (no == null) {
            return 0;
        }
        return (no.valor + somatoria(no.filhoE) + somatoria(no.filhoD));
    }

}
