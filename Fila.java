public class Fila {
    Nodo inicio, fim;

    public Fila() {
        this.inicio = null;
        this.fim = null;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public void enfileirar(int dado) {
        Nodo novoNodo = new Nodo(dado);
        if (fim == null) {
            inicio = fim = novoNodo;
        } else {
            fim.proximo = novoNodo;
            fim = novoNodo;
        }
    }

    public int desenfileirar() {
        if (estaVazia()) {
            throw new RuntimeException("Fila vazia");
        }
        int dado = inicio.dado;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null;
        }
        return dado;
    }

    public void listarSenhas() {
        Nodo atual = inicio;
        while (atual != null) {
            System.out.println(atual.dado);
            atual = atual.proximo;
        }
    }
    public boolean removerSenha(int dado) {
        if (estaVazia()) {
            return false;
        }

        if (inicio.dado == dado) {
            desenfileirar();
            return true;
        }
        Nodo atual = inicio;
        Nodo anterior = null;

        while (atual != null && atual.dado != dado) {
            anterior = atual;
            atual = atual.proximo;
        }

        if (atual != null) {
            anterior.proximo = atual.proximo;
            if (atual == fim) {
                fim = anterior;
            }
            return true;
        }

        return false;
    }
}