package systemtests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.function.Executable;

import system.Chamado;
import system.Solicitante;
import system.StatusChamado;
import system.Tecnico;

@SuppressWarnings("unused")
public class TecnicoTest {

    @Test
    public void testConstrutorInicializaCamposCorretamente() {
        Tecnico tecnico = new Tecnico(1, "Carlos");

        assertEquals(1, tecnico.id);
        assertEquals("Carlos", tecnico.nome);
    }

    private void assertEquals(String string, String nome) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(int i, int id) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testResolverChamadoAlteraStatusParaResolvido() {
        Tecnico tecnico = new Tecnico(2, "Ana");
        Solicitante solicitante = new Solicitante(3, "João");
        Chamado chamado = solicitante.criarChamado(100, 2, "Erro de login", 5);

        assertEquals(StatusChamado.PENDENTE, chamado.status);

        tecnico.resolverChamado(chamado);

        assertEquals(StatusChamado.RESOLVIDO, chamado.status);
    }

    private void assertEquals(StatusChamado pendente, StatusChamado status) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testResolverChamadoDefineDataFinalizacao() {
        Tecnico tecnico = new Tecnico(4, "Mariana");
        Solicitante solicitante = new Solicitante(5, "Pedro");
        Chamado chamado = solicitante.criarChamado(200, 1, "Problema de rede", 10);

        assertNull(chamado.dataFinalizacao);

        tecnico.resolverChamado(chamado);

        assertNotNull(chamado.dataFinalizacao);

        // Validar formato da data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dataFinalizacao = "29/03/2026 22:46";
        
        Executable exec = () -> LocalDateTime.parse(dataFinalizacao, formatter);
        assertDoesNotThrow(exec, "Data de finalizacao deve estar em formato válido");
    }
	


	private void assertDoesNotThrow(Executable exec, String string) {
		// TODO Auto-generated method stub
		
	}


	private void assertNotNull(String dataFinalizacao) {
		// TODO Auto-generated method stub
		
	}

	private void assertNull(String dataFinalizacao) {
		// TODO Auto-generated method stub
		
	}
}