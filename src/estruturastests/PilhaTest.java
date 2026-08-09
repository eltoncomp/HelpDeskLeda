package estruturastests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import estruturas.Pilha;

@SuppressWarnings("unused")
public class PilhaTest {

    @Test
    public void testPilhaInicialmenteVazia() {
        Pilha<Integer> pilha = new Pilha<>();
        assertTrue(pilha.estaVazia(), "Pilha deve iniciar vazia");
        assertNull(pilha.topo(), "Topo de pilha vazia deve ser null");
        assertNull(pilha.desempilhar(), "Desempilhar de pilha vazia deve retornar null");
    }

    private void assertNull(Integer topo, String string) {
		// TODO Auto-generated method stub
		
	}

	private void assertTrue(boolean estaVazia, String string) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testEmpilharElemento() {
        Pilha<String> pilha = new Pilha<>();
        pilha.empilhar("A");

        assertFalse(pilha.estaVazia(), "Pilha não deve estar vazia após empilhar");
        assertEquals("A", pilha.topo(), "Topo deve ser o último elemento empilhado");
    }

    private void assertEquals(String string, String topo, String string2) {
		// TODO Auto-generated method stub
		
	}

	private void assertFalse(boolean estaVazia, String string) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testEmpilharEDesenfileirarMantemOrdemLIFO() {
        Pilha<Integer> pilha = new Pilha<>();
        pilha.empilhar(1);
        pilha.empilhar(2);
        pilha.empilhar(3);

        assertEquals(3, pilha.desempilhar());
        assertEquals(2, pilha.desempilhar());
        assertEquals(1, pilha.desempilhar());
        assertTrue(pilha.estaVazia(), "Pilha deve estar vazia após remover todos elementos");
    }

    private void assertEquals(int i, Integer desempilhar) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testTopoNaoRemoveElemento() {
        Pilha<String> pilha = new Pilha<>();
        pilha.empilhar("X");
        pilha.empilhar("Y");

        assertEquals("Y", pilha.topo(), "Topo deve retornar o último elemento empilhado");
        assertEquals("Y", pilha.topo(), "Topo não deve remover o elemento");
        assertEquals("Y", pilha.desempilhar(), "Desempilhar deve retornar o mesmo elemento do topo");
    }

    @Test
    public void testEmpilharValorNulo() {
        Pilha<String> pilha = new Pilha<>();
        pilha.empilhar(null);

        assertFalse(pilha.estaVazia(), "Pilha não deve estar vazia após empilhar null");
        assertNull(pilha.topo(), "Topo deve ser null quando empilhado valor null");
        assertNull(pilha.desempilhar(), "Desempilhar deve retornar null quando valor empilhado é null");
    }

	private void assertNull(String topo, String string) {
		// TODO Auto-generated method stub
		
	}
}