/* Código referente ao projeto da segunda unidade do curso de Lab. de Estrutura de dados
 * Professor: Janderson Jason Barbosa Aguiar
 * Curso: Bacharelado em Computação 
 * Universidade Estadual de Paraíba - UEPB
 * Alunos: Elton Farias Costa
 *         Emanuel Diogo Marinho de Souza
 */


package system;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Chamado {
    public int id;
    public int prioridade;
    public String descricao;
    public Usuario usuario;
    public StatusChamado status;

    public String dataCriacao;
    public String dataFinalizacao;

    //FIFO
    public int ordemChegada;

    public Chamado(int id, int prioridade, String descricao, Usuario usuario, int ordemChegada) {
        this.id = id;
        this.prioridade = prioridade;
        this.descricao = descricao;
        this.usuario = usuario;
        this.status = StatusChamado.PENDENTE;
        this.ordemChegada = ordemChegada;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.dataCriacao = LocalDateTime.now().format(formatter);
        this.dataFinalizacao = null;
    }
}