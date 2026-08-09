/* Código referente ao projeto da segunda unidade do curso de Lab. de Estrutura de dados
 * Professor: Janderson Jason Barbosa Aguiar
 * Curso: Bacharelado em Computação 
 * Universidade Estadual de Paraíba - UEPB
 * Alunos: Elton Farias Costa
 *         Emanuel Diogo Marinho de Souza
 */

package estruturas;

// Lista encadeada

public class No<T> {
    T valor;
    public No<T> proximo;

    public No(T valor) {
        this.valor = valor;
        this.proximo = null;
    }

    public Integer getValor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getValor'");
    }
}
