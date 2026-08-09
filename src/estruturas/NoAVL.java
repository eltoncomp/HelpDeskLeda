/* Código referente ao projeto da segunda unidade do curso de Lab. de Estrutura de dados
 * Professor: Janderson Jason Barbosa Aguiar
 * Curso: Bacharelado em Computação 
 * Universidade Estadual de Paraíba - UEPB
 * Alunos: Elton Farias Costa
 *         Emanuel Diogo Marinho de Souza
 */


package estruturas;

import system.Chamado;

public class NoAVL {
    public Chamado chamado;
    public NoAVL esquerda, direita;
    public int altura;

    public NoAVL(Chamado c) {
        this.chamado = c;
        this.altura = 1;
    }
}