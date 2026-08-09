package estruturas;

import system.Chamado;

public class HeapMaximo {

    private Chamado[] heap;
    private int tamanho;

    public HeapMaximo(int capacidade) {
        heap = new Chamado[capacidade];
        tamanho = 0;
    }

    private int pai(int i) {
        return (i - 1) / 2;
    }

    private int esquerda(int i) {
        return 2 * i + 1;
    }

    private int direita(int i) {
        return 2 * i + 2;
    }

    private boolean maior(Chamado a, Chamado b) {

        if (a.prioridade != b.prioridade) {
            return a.prioridade > b.prioridade;
        }

        return a.ordemChegada < b.ordemChegada;
    }

    public void inserir(Chamado c) {

        if (tamanho == heap.length) {

            Log.info(
                "HEAP",
                "Heap cheia. Inserção do chamado ID "
                + c.id
                + " cancelada."
            );

            return;
        }

        heap[tamanho] = c;

        int i = tamanho;

        tamanho++;

        Log.info(
            "HEAP",
            "Chamado ID " + c.id
            + " inserido na posição " + i
            + " da heap."
        );

        while (
            i > 0
            && maior(heap[i], heap[pai(i)])
        ) {

            Log.info(
                "HEAP",
                "Chamado ID " + heap[i].id
                + " subindo na heap."
            );

            trocar(i, pai(i));

            i = pai(i);
        }

        Log.info(
            "HEAP",
            "Inserção do chamado ID "
            + c.id
            + " concluída."
        );
    }

    public Chamado extrairMaximo() {

        if (tamanho == 0) {

            Log.info(
                "HEAP",
                "Tentativa de extrair elemento de uma heap vazia."
            );

            return null;
        }

        Chamado raiz = heap[0];

        Log.info(
            "HEAP",
            "Extraindo chamado ID "
            + raiz.id
            + " com prioridade "
            + raiz.prioridade
            + "."
        );

        heap[0] = heap[tamanho - 1];

        heap[tamanho - 1] = null;

        tamanho--;

        if (tamanho > 0) {
            heapificar(0);
        }

        Log.info(
            "HEAP",
            "Chamado ID "
            + raiz.id
            + " extraído com sucesso."
        );

        return raiz;
    }

    private void heapificar(int i) {

        int maior = i;

        int esq = esquerda(i);
        int dir = direita(i);

        if (
            esq < tamanho
            && maior(heap[esq], heap[maior])
        ) {
            maior = esq;
        }

        if (
            dir < tamanho
            && maior(heap[dir], heap[maior])
        ) {
            maior = dir;
        }

        if (maior != i) {

            Log.info(
                "HEAP",
                "Reorganizando heap: "
                + "posição " + i
                + " para posição " + maior + "."
            );

            trocar(i, maior);

            heapificar(maior);
        }
    }

    private void trocar(int i, int j) {

        Chamado temp = heap[i];

        heap[i] = heap[j];

        heap[j] = temp;

        Log.info(
            "HEAP",
            "Elementos das posições "
            + i
            + " e "
            + j
            + " trocados."
        );
    }

    public boolean estaVazio() {
        return tamanho == 0;
    }
}