package exec;

import java.util.Scanner;
import java.util.InputMismatchException;

import estruturas.*;
import system.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        FilaComPilhas<Chamado> fila = new FilaComPilhas<>();
        Pilha<Chamado> historico = new Pilha<>();
        HeapMaximo heap = new HeapMaximo(100);
        ArvoreAVL arvore = new ArvoreAVL();
        TabelaHash chamadosHash = new TabelaHash();

        int ordemGlobal = 0;
        int proximoId = 1;

        Solicitante solicitante = new Solicitante(1, "João");
        Tecnico tecnico = new Tecnico(2, "Carlos");

        int opcao;

        do {

            System.out.println("\n===== SISTEMA HELPDESK =====");
            System.out.println("1 - Técnico");
            System.out.println("2 - Solicitante");
            System.out.println("0 - Sair");

            try {

                opcao = sc.nextInt();

            } catch (InputMismatchException e) {

                System.out.println(
                    "Erro: Digite apenas números válidos!"
                );

                sc.nextLine();

                opcao = -1;

                continue;
            }

            switch (opcao) {

                case 1:

                    int opTec;

                    do {

                        System.out.println("\n--- MENU TÉCNICO ---");
                        System.out.println(
                            "1 - Atender próximo por prioridade (MAX HEAP)"
                        );
                        System.out.println(
                            "2 - Histórico de atendimento (PILHA)"
                        );
                        System.out.println(
                            "3 - Relatório completo (AVL)"
                        );
                        System.out.println(
                            "4 - Buscar chamado por ID (HASH)"
                        );
                        System.out.println("0 - Voltar");

                        try {

                            opTec = sc.nextInt();

                        } catch (InputMismatchException e) {

                            System.out.println(
                                "Erro: Digite apenas números válidos!"
                            );

                            sc.nextLine();

                            opTec = -1;

                            continue;
                        }

                        if (opTec == 1) {

                            if (heap.estaVazio()) {

                                System.out.println(
                                    "Sem chamados."
                                );

                            } else {

                                Chamado c = heap.extrairMaximo();

                                System.out.println("\nChamado:");

                                System.out.println(
                                    "ID: " + c.id +
                                    " | " + c.descricao +
                                    " | Prioridade: " + c.prioridade +
                                    " | Criado: " + c.dataCriacao
                                );

                                System.out.println(
                                    "\nDeseja finalizar? (1-Sim / 0-Não)"
                                );

                                int escolha;

                                try {

                                    escolha = sc.nextInt();

                                } catch (InputMismatchException e) {

                                    System.out.println(
                                        "Entrada inválida!"
                                    );

                                    sc.nextLine();

                                    heap.inserir(c);

                                    continue;
                                }

                                if (escolha == 1) {

                                    tecnico.resolverChamado(c);

                                    historico.empilhar(c);

                                    System.out.println(
                                        "Chamado finalizado!"
                                    );

                                } else {

                                    heap.inserir(c);

                                    System.out.println(
                                        "Chamado retornou para a fila de prioridade."
                                    );
                                }
                            }
                        }

                        if (opTec == 2) {

                            Pilha<Chamado> temp = new Pilha<>();

                            boolean vazio = true;

                            while (!historico.estaVazia()) {

                                Chamado c =
                                    historico.desempilhar();

                                System.out.println(
                                    "ID: " + c.id +
                                    " | " + c.descricao +
                                    " | Prioridade: " + c.prioridade +
                                    " | Criado: " + c.dataCriacao +
                                    " | Finalizado: " + c.dataFinalizacao
                                );

                                temp.empilhar(c);

                                vazio = false;
                            }

                            while (!temp.estaVazia()) {

                                historico.empilhar(
                                    temp.desempilhar()
                                );
                            }

                            if (vazio) {

                                System.out.println(
                                    "Nenhum chamado foi resolvido ainda."
                                );
                            }
                        }

                        if (opTec == 3) {

                            System.out.println(
                                "\n--- RELATÓRIO COMPLETO ---"
                            );

                            arvore.listarEmOrdem();
                        }

                        if (opTec == 4) {

                            System.out.println(
                                "Digite o ID do chamado:"
                            );

                            int idBusca;

                            try {

                                idBusca = sc.nextInt();

                            } catch (InputMismatchException e) {

                                System.out.println(
                                    "Erro: Digite apenas números válidos!"
                                );

                                sc.nextLine();

                                continue;
                            }

                            Chamado c =
                                chamadosHash.buscar(idBusca);

                            if (c != null) {

                                System.out.println(
                                    "ID: " + c.id +
                                    " | " + c.descricao +
                                    " | Prioridade: " + c.prioridade +
                                    " | Status: " + c.status +
                                    " | Criado: " + c.dataCriacao +
                                    (
                                        c.dataFinalizacao != null
                                        ? " | Finalizado: "
                                            + c.dataFinalizacao
                                        : ""
                                    )
                                );

                            } else {

                                System.out.println(
                                    "Chamado não encontrado."
                                );
                            }
                        }

                    } while (opTec != 0);

                    break;

                case 2:

                    int opSol;

                    do {

                        System.out.println("\n--- MENU SOLICITANTE ---");
                        System.out.println("1 - Criar chamado");
                        System.out.println("2 - Listar Pendentes");
                        System.out.println("3 - Listar Resolvidos");
                        System.out.println("0 - Voltar");

                        try {

                            opSol = sc.nextInt();

                        } catch (InputMismatchException e) {

                            System.out.println(
                                "Erro: Digite apenas números válidos!"
                            );

                            sc.nextLine();

                            opSol = -1;

                            continue;
                        }

                        if (opSol == 1) {

                            sc.nextLine();

                            System.out.println("Descrição:");

                            String desc = sc.nextLine();

                            int prioridade;

                            while (true) {

                                try {

                                    System.out.println(
                                        "Prioridade (1-5):"
                                    );

                                    prioridade = sc.nextInt();

                                    if (
                                        prioridade < 1
                                        || prioridade > 5
                                    ) {

                                        System.out.println(
                                            "Erro: prioridade deve ser entre 1 e 5!"
                                        );

                                        continue;
                                    }

                                    break;

                                } catch (InputMismatchException e) {

                                    System.out.println(
                                        "Erro: Digite apenas números válidos!"
                                    );

                                    sc.nextLine();
                                }
                            }

                            Chamado novo =
                                solicitante.criarChamado(
                                    proximoId++,
                                    prioridade,
                                    desc,
                                    ordemGlobal++
                                );

                            fila.enfileirar(novo);

                            heap.inserir(novo);

                            arvore.inserir(novo);

                            chamadosHash.inserir(novo);

                            Log.info(
                                "SISTEMA",
                                "Chamado ID "
                                + novo.id
                                + " criado e inserido nas estruturas."
                            );

                            System.out.println(
                                "Chamado criado!"
                            );
                        }

                        if (opSol == 2) {

                            boolean[] encontrou = {false};

                            Log.info(
                                "SISTEMA",
                                "Consultando chamados pendentes."
                            );

                            fila.percorrer(c -> {

                                if (
                                    c.status
                                    == StatusChamado.PENDENTE
                                ) {

                                    System.out.println(
                                        "ID: " + c.id +
                                        " | " + c.descricao +
                                        " | Prioridade: "
                                            + c.prioridade +
                                        " | Criado: "
                                            + c.dataCriacao
                                    );

                                    encontrou[0] = true;
                                }
                            });

                            if (!encontrou[0]) {

                                System.out.println(
                                    "Não existem chamados pendentes!"
                                );
                            }

                            Log.info(
                                "SISTEMA",
                                "Consulta de chamados pendentes concluída."
                            );
                        }

                        if (opSol == 3) {

                            FilaComPilhas<Chamado> temp =
                                new FilaComPilhas<>();

                            boolean encontrou = false;

                            while (!fila.estaVazia()) {

                                Chamado c =
                                    fila.desenfileirar();

                                if (
                                    c.status
                                    == StatusChamado.RESOLVIDO
                                ) {

                                    System.out.println(
                                        "ID: " + c.id +
                                        " | " + c.descricao +
                                        " | Criado: "
                                            + c.dataCriacao +
                                        " | Finalizado: "
                                            + c.dataFinalizacao
                                    );

                                    encontrou = true;
                                }

                                temp.enfileirar(c);
                            }

                            while (!temp.estaVazia()) {

                                fila.enfileirar(
                                    temp.desenfileirar()
                                );
                            }

                            if (!encontrou) {

                                System.out.println(
                                    "Não existem chamados finalizados!"
                                );
                            }
                        }

                    } while (opSol != 0);

                    break;
            }

        } while (opcao != 0);

        sc.close();
    }
}