package estruturas;

import system.Chamado;

public class ArvoreAVL {

    private NoAVL raiz;

    public NoAVL getRaiz() {
        return raiz;
    }

    private int altura(NoAVL n) {
        return n == null ? 0 : n.altura;
    }

    private int balanceamento(NoAVL n) {
        return n == null ? 0 : altura(n.esquerda) - altura(n.direita);
    }

    private NoAVL rotacaoDireita(NoAVL y) {

        Log.info(
            "AVL",
            "Iniciando rotação à direita."
        );

        NoAVL x = y.esquerda;
        NoAVL t2 = x.direita;

        x.direita = y;
        y.esquerda = t2;

        y.altura = Math.max(
            altura(y.esquerda),
            altura(y.direita)
        ) + 1;

        x.altura = Math.max(
            altura(x.esquerda),
            altura(x.direita)
        ) + 1;

        Log.info(
            "AVL",
            "Rotação à direita concluída."
        );

        return x;
    }

    private NoAVL rotacaoEsquerda(NoAVL x) {

        Log.info(
            "AVL",
            "Iniciando rotação à esquerda."
        );

        NoAVL y = x.direita;
        NoAVL t2 = y.esquerda;

        y.esquerda = x;
        x.direita = t2;

        x.altura = Math.max(
            altura(x.esquerda),
            altura(x.direita)
        ) + 1;

        y.altura = Math.max(
            altura(y.esquerda),
            altura(y.direita)
        ) + 1;

        Log.info(
            "AVL",
            "Rotação à esquerda concluída."
        );

        return y;
    }

    private int comparar(Chamado a, Chamado b) {

        if (a.prioridade != b.prioridade) {
            return a.prioridade - b.prioridade;
        }

        return b.id - a.id;
    }

    public void inserir(Chamado c) {

        Log.info(
            "AVL",
            "Inserindo chamado ID " + c.id
            + " com prioridade " + c.prioridade + "."
        );

        raiz = inserirRec(raiz, c);

        Log.info(
            "AVL",
            "Inserção do chamado ID " + c.id
            + " concluída."
        );
    }

    private NoAVL inserirRec(NoAVL no, Chamado c) {

        if (no == null) {

            Log.info(
                "AVL",
                "Novo nó criado para o chamado ID " + c.id + "."
            );

            return new NoAVL(c);
        }

        if (comparar(c, no.chamado) < 0) {

            no.esquerda = inserirRec(
                no.esquerda,
                c
            );

        } else if (comparar(c, no.chamado) > 0) {

            no.direita = inserirRec(
                no.direita,
                c
            );

        } else {

            Log.info(
                "AVL",
                "Chamado ID " + c.id
                + " já existe na árvore."
            );

            return no;
        }

        no.altura = 1 + Math.max(
            altura(no.esquerda),
            altura(no.direita)
        );

        int bal = balanceamento(no);

        if (
            bal > 1
            && comparar(c, no.esquerda.chamado) < 0
        ) {

            Log.info(
                "AVL",
                "Caso LL detectado."
            );

            return rotacaoDireita(no);
        }

        if (
            bal < -1
            && comparar(c, no.direita.chamado) > 0
        ) {

            Log.info(
                "AVL",
                "Caso RR detectado."
            );

            return rotacaoEsquerda(no);
        }

        if (
            bal > 1
            && comparar(c, no.esquerda.chamado) > 0
        ) {

            Log.info(
                "AVL",
                "Caso LR detectado."
            );

            no.esquerda = rotacaoEsquerda(
                no.esquerda
            );

            return rotacaoDireita(no);
        }

        if (
            bal < -1
            && comparar(c, no.direita.chamado) < 0
        ) {

            Log.info(
                "AVL",
                "Caso RL detectado."
            );

            no.direita = rotacaoDireita(
                no.direita
            );

            return rotacaoEsquerda(no);
        }

        return no;
    }

    public void listarEmOrdem() {

        Log.info(
            "AVL",
            "Iniciando listagem da árvore."
        );

        listarRec(raiz);

        Log.info(
            "AVL",
            "Listagem da árvore concluída."
        );
    }

    private void listarRec(NoAVL no) {

        if (no != null) {

            listarRec(no.direita);

            System.out.println(
                "ID: " + no.chamado.id +
                " | Prioridade: " + no.chamado.prioridade +
                " | " + no.chamado.descricao +
                " | Criado: " + no.chamado.dataCriacao +
                (
                    no.chamado.dataFinalizacao != null
                    ? " | Finalizado: " + no.chamado.dataFinalizacao
                    : ""
                )
            );

            listarRec(no.esquerda);
        }
    }
}