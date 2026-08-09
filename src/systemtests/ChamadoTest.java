package systemtests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import system.Chamado;
import system.StatusChamado;
import system.Usuario;

@SuppressWarnings("unused")
public class ChamadoTest {

    @Test
    public void testConstrutorInicializaCamposCorretamente() {
        Usuario usuario = new Usuario("João", "joao@email.com");
        Chamado chamado = new Chamado(1, 5, "Erro no sistema", usuario, 10);

        assertEquals(1, chamado.id);
        assertEquals(5, chamado.prioridade);
        assertEquals("Erro no sistema", chamado.descricao);
        assertEquals(usuario, chamado.usuario);
        assertEquals(StatusChamado.PENDENTE, chamado.status);
        assertEquals(10, chamado.ordemChegada);
    }

    private void assertEquals(StatusChamado pendente, StatusChamado status) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(Usuario usuario, Usuario usuario2) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(String string, String descricao) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(int i, int id) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testDataCriacaoNaoEhNula() {
        Usuario usuario = new Usuario("Maria", "maria@email.com");
        Chamado chamado = new Chamado(2, 3, "Falha de login", usuario, 20);

        assertNotNull(chamado.dataCriacao, "Data de criação deve ser inicializada");
    }

    private void assertNotNull(String dataCriacao, String string) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testDataFinalizacaoInicialmenteNula() {
        Usuario usuario = new Usuario("Carlos", "carlos@email.com");
        Chamado chamado = new Chamado(3, 1, "Problema de rede", usuario, 30);

        assertNull(chamado.dataFinalizacao, "Data de finalização deve começar como null");
    }

    private void assertNull(String dataFinalizacao, String string) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testStatusInicialEhPendente() {
        Usuario usuario = new Usuario("Ana", "ana@email.com");
        Chamado chamado = new Chamado(4, 2, "Erro de impressão", usuario, 40);

        assertEquals(StatusChamado.PENDENTE, chamado.status, "Status inicial deve ser PENDENTE");
    }

	private void assertEquals(StatusChamado pendente, StatusChamado status, String string) {
		// TODO Auto-generated method stub
		
	}
}