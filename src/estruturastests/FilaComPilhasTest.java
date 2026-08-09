package estruturastests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import estruturas.FilaComPilhas;

@SuppressWarnings("unused")
public class FilaComPilhasTest {

    @Test
    public void testFilaInicialmenteVazia() {
        FilaComPilhas<Integer> fila = new FilaComPilhas<>();
        assertTrue(fila.estaVazia(), "Fila deve iniciar vazia");
    }

    private void assertTrue(boolean estaVazia, String string) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testEnfileirarElemento() {
        FilaComPilhas<String> fila = new FilaComPilhas<>();
        fila.enfileirar("A");
        assertFalse(fila.estaVazia(), "Fila não deve estar vazia após enfileirar");
        assertEquals("A", fila.frente(), "Elemento da frente deve ser o primeiro enfileirado");
    }

    private void assertEquals(String string, String frente, String string2) {
		// TODO Auto-generated method stub
		
	}

	private void assertFalse(boolean estaVazia, String string) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testEnfileirarEDesenfileirarMantemOrdemFIFO() {
        FilaComPilhas<Integer> fila = new FilaComPilhas<>();
        fila.enfileirar(1);
        fila.enfileirar(2);
        fila.enfileirar(3);

        assertEquals(1, fila.desenfileirar());
        assertEquals(2, fila.desenfileirar());
        assertEquals(3, fila.desenfileirar());
        assertTrue(fila.estaVazia(), "Fila deve estar vazia após remover todos elementos");
    }

    private void assertEquals(int i, Integer desenfileirar) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testFrenteNaoRemoveElemento() {
        FilaComPilhas<String> fila = new FilaComPilhas<>();
        fila.enfileirar("X");
        fila.enfileirar("Y");

        assertEquals("X", fila.frente(), "Frente deve retornar o primeiro elemento");
        assertEquals("X", fila.desenfileirar(), "Desenfileirar deve retornar o mesmo primeiro elemento");
    }

    @Test
    public void testDesenfileirarDeFilaVaziaLancaExcecao() {
        FilaComPilhas<Integer> fila = new FilaComPilhas<>();
        assertThrows(RuntimeException.class, fila.desenfileirar(), 
            "Desenfileirar de fila vazia deve lançar exceção");
    }


	private void assertThrows(Class<RuntimeException> class1, Object object, String string) {
		// TODO Auto-generated method stub
		
	}

		
	}