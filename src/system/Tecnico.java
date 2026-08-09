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

public class Tecnico extends Usuario {

    public Tecnico(int id, String nome) {
        super(id, nome);
    }

    public void resolverChamado(Chamado chamado) {
        chamado.status = StatusChamado.RESOLVIDO;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        chamado.dataFinalizacao = LocalDateTime.now().format(formatter);
    }
}