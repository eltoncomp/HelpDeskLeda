package estruturas;

import system.Chamado;

public class TabelaHash {

    private No<Chamado>[] tabela;
    private int tamanho = 11;

    @SuppressWarnings("unchecked")
    public TabelaHash() {
        tabela = (No<Chamado>[]) new No[tamanho];

        Log.info(
            "HASH",
            "Tabela Hash criada com tamanho " + tamanho + "."
        );
    }

    private int funcaoHash(int chave) {
        return Math.floorMod(chave, tamanho);
    }

    public void inserir(Chamado chamado) {

        int indice = funcaoHash(chamado.id);

        Log.info(
            "HASH",
            "Tentando inserir chamado ID "
            + chamado.id
            + " no índice "
            + indice
            + "."
        );

        if (tabela[indice] != null) {

            Log.info(
                "HASH",
                "Colisão detectada no índice "
                + indice
                + " para o chamado ID "
                + chamado.id
                + "."
            );
        }

        No<Chamado> novo = new No<>(chamado);

        novo.proximo = tabela[indice];

        tabela[indice] = novo;

        Log.info(
            "HASH",
            "Chamado ID "
            + chamado.id
            + " inserido com sucesso no índice "
            + indice
            + "."
        );
    }

    public Chamado buscar(int id) {

        int indice = funcaoHash(id);

        Log.info(
            "HASH",
            "Iniciando busca pelo chamado ID "
            + id
            + " no índice "
            + indice
            + "."
        );

        No<Chamado> atual = tabela[indice];

        while (atual != null) {

            if (atual.valor.id == id) {

                Log.info(
                    "HASH",
                    "Chamado ID "
                    + id
                    + " encontrado com sucesso."
                );

                return atual.valor;
            }

            atual = atual.proximo;
        }

        Log.info(
            "HASH",
            "Chamado ID "
            + id
            + " não encontrado."
        );

        return null;
    }
}