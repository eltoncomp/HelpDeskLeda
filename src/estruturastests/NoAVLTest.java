package estruturastests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import estruturas.NoAVL;
import system.Chamado;
import system.Usuario;

@SuppressWarnings("unused")
public class NoAVLTest {

    @Test
    public void testConstrutorInicializaCamposCorretamente() {
        Usuario usuario = new Usuario(1, "João");
        Chamado chamado = new Chamado(10, 2, "Erro de login", usuario, 1);

        NoAVL no = new NoAVL(chamado);

        assertEquals(chamado, no.chamado);
        assertEquals(1, no.altura);
        assertNull(no.esquerda);
        assertNull(no.direita);
    }

    private void assertEquals(Chamado chamado, Chamado chamado2) {
		// TODO Auto-generated method stub
		
	}

	private void assertNull(NoAVL esquerda) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(int i, int altura) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testChamadoAssociadoAoNo() {
        Usuario usuario = new Usuario(2, "Maria");
        Chamado chamado = new Chamado(20, 5, "Problema de rede", usuario, 2);

        NoAVL no = new NoAVL(chamado);

        assertNotNull(no.chamado);
        assertEquals(20, no.chamado.id);
        assertEquals(5, no.chamado.prioridade);
        assertEquals("Problema de rede", no.chamado.descricao);
        assertEquals(usuario, no.chamado.usuario);
    }

    private void assertEquals(Usuario usuario, Usuario usuario2) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(String string, String descricao) {
		// TODO Auto-generated method stub
		
	}

	private void assertNotNull(Chamado chamado) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testAlturaInicialEhUm() {
        Usuario usuario = new Usuario(3, "Carlos");
        Chamado chamado = new Chamado(30, 1, "Falha de impressão", usuario, 3);

        NoAVL no = new NoAVL(chamado);

        assertEquals(1, no.altura);
    }
}