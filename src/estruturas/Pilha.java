package estruturas;

import java.util.function.Consumer;

public class Pilha<T> {

    private No<T> topo;

    public Pilha() {
        topo = null;
    }

    public void empilhar(T valor) {

        No<T> novo = new No<>(valor);

        novo.proximo = topo;
        topo = novo;

        Log.info(
            "PILHA",
            "Elemento empilhado com sucesso."
        );
    }

    public T desempilhar() {

        if (estaVazia()) {

            Log.info(
                "PILHA",
                "Tentativa de desempilhar em uma pilha vazia."
            );

            return null;
        }

        T valor = topo.valor;

        topo = topo.proximo;

        Log.info(
            "PILHA",
            "Elemento desempilhado com sucesso."
        );

        return valor;
    }

    public T topo() {

        if (estaVazia()) {

            Log.info(
                "PILHA",
                "Consulta ao topo realizada, mas a pilha está vazia."
            );

            return null;
        }

        Log.info(
            "PILHA",
            "Consulta ao topo realizada com sucesso."
        );

        return topo.valor;
    }

    public void percorrer(Consumer<T> acao) {

        No<T> atual = topo;

        while (atual != null) {

            acao.accept(atual.valor);

            atual = atual.proximo;
        }
    }

    public void percorrerInverso(Consumer<T> acao) {

        percorrerInversoRecursivo(topo, acao);
    }

    private void percorrerInversoRecursivo(
        No<T> no,
        Consumer<T> acao
    ) {

        if (no == null) {
            return;
        }

        percorrerInversoRecursivo(
            no.proximo,
            acao
        );

        acao.accept(no.valor);
    }

    public boolean estaVazia() {
        return topo == null;
    }
}