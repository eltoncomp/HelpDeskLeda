package systemtests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import system.Chamado;
import system.Solicitante;
import system.StatusChamado;
import system.Usuario;

@SuppressWarnings("unused")
public class SolicitanteTest {

    @Test
    public void testConstrutorInicializaCamposCorretamente() {
        Solicitante solicitante = new Solicitante(1, "João");

        assertEquals(1, solicitante.id);
        assertEquals("João", solicitante.nome);
    }

    private void assertEquals(String string, String nome) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(int i, int id) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testCriarChamadoRetornaChamadoCorreto() {
        Solicitante solicitante = new Solicitante(2, "Maria");
        Chamado chamado = solicitante.criarChamado(100, 3, "Erro no sistema", 5);

        assertNotNull(chamado);
        assertEquals(100, chamado.id);
        assertEquals(3, chamado.prioridade);
        assertEquals("Erro no sistema", chamado.descricao);
        assertEquals(solicitante, chamado.usuario);
        assertEquals(5, chamado.ordemChegada);
        assertEquals(StatusChamado.PENDENTE, chamado.status);
        assertNotNull(chamado.dataCriacao);
        assertNull(chamado.dataFinalizacao);
    }

	private void assertEquals(StatusChamado pendente, StatusChamado status) {
		// TODO Auto-generated method stub
		
	}

	private void assertNull(String dataFinalizacao) {
		// TODO Auto-generated method stub
		
	}

	private void assertNotNull(String dataCriacao) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(Solicitante solicitante, Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	private void assertNotNull(Chamado chamado) {
		// TODO Auto-generated method stub
		
	}
}