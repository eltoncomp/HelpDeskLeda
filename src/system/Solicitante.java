/* Código referente ao projeto da segunda unidade do curso de Lab. de Estrutura de dados
 * Professor: Janderson Jason Barbosa Aguiar
 * Curso: Bacharelado em Computação 
 * Universidade Estadual de Paraíba - UEPB
 * Alunos: Elton Farias Costa
 *         Emanuel Diogo Marinho de Souza
 */


package system;

public class Solicitante extends Usuario {

    public Solicitante(int id, String nome) {
        super(id, nome);
    }

    public Chamado criarChamado(int idChamado, int prioridade, String descricao, int ordemChegada) {
        return new Chamado(idChamado, prioridade, descricao, this, ordemChegada);
    }
}
