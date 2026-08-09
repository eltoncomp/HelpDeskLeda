package estruturastests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import estruturas.TabelaHash;
import system.Chamado;
import system.Usuario;

@SuppressWarnings("unused")
public class TabelaHashTest {

    @Test
    public void testInserirEBuscarElemento() {
        TabelaHash tabela = new TabelaHash();
        Usuario usuario = new Usuario(1, "João");
        Chamado chamado = new Chamado(10, 3, "Erro de login", usuario, 1);

        tabela.inserir(chamado);

        Chamado resultado = tabela.buscar(10);
        assertNotNull(resultado, "Chamado deve ser encontrado");
        assertEquals(chamado, resultado);
    }

    private void assertEquals(Chamado chamado, Chamado resultado) {
		// TODO Auto-generated method stub
		
	}

	private void assertNotNull(Chamado resultado, String string) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testBuscarElementoInexistenteRetornaNull() {
        TabelaHash tabela = new TabelaHash();
        Usuario usuario = new Usuario(2, "Maria");
        Chamado chamado = new Chamado(20, 2, "Problema de rede", usuario, 2);

        tabela.inserir(chamado);

        Chamado resultado = tabela.buscar(99);
        assertNull(resultado, "Chamado inexistente deve retornar null");
    }

    private void assertNull(Chamado resultado, String string) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testInserirComColisao() {
        TabelaHash tabela = new TabelaHash();
        Usuario usuario = new Usuario(3, "Carlos");

        // IDs diferentes mas mesmo índice (ex: 10 % 10 == 0 e 20 % 10 == 0)
        Chamado chamado1 = new Chamado(10, 1, "Chamado 10", usuario, 1);
        Chamado chamado2 = new Chamado(20, 5, "Chamado 20", usuario, 2);

        tabela.inserir(chamado1);
        tabela.inserir(chamado2);

        Chamado resultado1 = tabela.buscar(10);
        Chamado resultado2 = tabela.buscar(20);

        assertEquals(chamado1, resultado1, "Chamado 10 deve ser encontrado mesmo após colisão");
        assertEquals(chamado2, resultado2, "Chamado 20 deve ser encontrado mesmo após colisão");
    }

    private void assertEquals(Chamado chamado1, Chamado resultado1, String string) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testInserirMultiplosElementos() {
        TabelaHash tabela = new TabelaHash();
        Usuario usuario = new Usuario(4, "Ana");

        Chamado chamado1 = new Chamado(1, 2, "Chamado 1", usuario, 1);
        Chamado chamado2 = new Chamado(2, 3, "Chamado 2", usuario, 2);
        Chamado chamado3 = new Chamado(3, 4, "Chamado 3", usuario, 3);

        tabela.inserir(chamado1);
        tabela.inserir(chamado2);
        tabela.inserir(chamado3);

        assertEquals(chamado1, tabela.buscar(1));
        assertEquals(chamado2, tabela.buscar(2));
        assertEquals(chamado3, tabela.buscar(3));
    }
}