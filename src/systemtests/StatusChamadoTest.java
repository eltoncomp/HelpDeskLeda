package systemtests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import system.StatusChamado;

@SuppressWarnings("unused")
public class StatusChamadoTest {

    @Test
    public void testEnumValoresExistem() {
        assertNotNull(StatusChamado.PENDENTE);
        assertNotNull(StatusChamado.RESOLVIDO);
    }

    private void assertNotNull(StatusChamado pendente) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testValuesRetornaTodosOsValores() {
        StatusChamado[] valores = StatusChamado.values();
        assertEquals(2, valores.length);
        assertTrue(java.util.Arrays.asList(valores).contains(StatusChamado.PENDENTE));
        assertTrue(java.util.Arrays.asList(valores).contains(StatusChamado.RESOLVIDO));
    }

    private void assertTrue(boolean contains) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(int i, int length) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testValueOfRetornaCorreto() {
        assertEquals(StatusChamado.PENDENTE, StatusChamado.valueOf("PENDENTE"));
        assertEquals(StatusChamado.RESOLVIDO, StatusChamado.valueOf("RESOLVIDO"));
    }

    private void assertEquals(StatusChamado pendente, StatusChamado valueOf) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testValueOfLancaExcecaoParaValorInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StatusChamado.valueOf("INEXISTENTE");
        });
	}



	private void assertThrows(Class<IllegalArgumentException> class1, Object object) {
		// TODO Auto-generated method stub
		
	}
}