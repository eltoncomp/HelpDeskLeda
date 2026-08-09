package estruturas;

import java.util.function.Consumer;

public class FilaComPilhas<T> {

    private final Pilha<T> pilhaEntrada;
    private final Pilha<T> pilhaSaida;

    public FilaComPilhas() {
        pilhaEntrada = new Pilha<>();
        pilhaSaida = new Pilha<>();
    }

    public void enfileirar(T valor) {

        pilhaEntrada.empilhar(valor);

        Log.info(
            "FILA",
            "Elemento enfileirado na pilha de entrada."
        );
    }

    public T desenfileirar() {

        transferirSeNecessario();

        T valor = pilhaSaida.desempilhar();

        if (valor != null) {

            Log.info(
                "FILA",
                "Elemento desenfileirado com sucesso."
            );
        }

        return valor;
    }

    public T frente() {

        transferirSeNecessario();

        T valor = pilhaSaida.topo();

        if (valor != null) {

            Log.info(
                "FILA",
                "Consulta ao primeiro elemento da fila realizada."
            );
        }

        return valor;
    }

    private void transferirSeNecessario() {

        if (
            pilhaSaida.estaVazia()
            && !pilhaEntrada.estaVazia()
        ) {

            Log.info(
                "FILA",
                "Iniciando transferência da pilha de entrada para a pilha de saída."
            );

            while (!pilhaEntrada.estaVazia()) {

                pilhaSaida.empilhar(
                    pilhaEntrada.desempilhar()
                );
            }

            Log.info(
                "FILA",
                "Transferência entre as pilhas concluída."
            );
        }
    }

    public void percorrer(Consumer<T> acao) {

        pilhaSaida.percorrer(acao);

        pilhaEntrada.percorrerInverso(acao);
    }

    public boolean estaVazia() {

        return pilhaEntrada.estaVazia()
            && pilhaSaida.estaVazia();
    }
}