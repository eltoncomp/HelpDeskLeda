package estruturastests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import estruturas.No;

public class NoTest {

    @Test
    public void testConstrutorInicializaValor() {
        No<String> no = new No<>("Primeiro");

        assertEquals("Primeiro", no.getValor());
        assertNull(no.proximo, "O próximo nó deve iniciar como null");
    }

    private void assertEquals(String string, Integer valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }

    @Test
    public void testEncadeamentoDeNos() {
        No<Integer> no1 = new No<>(10);
        No<Integer> no2 = new No<>(20);
        No<Integer> no3 = new No<>(30);

        no1.proximo = no2;
        no2.proximo = no3;

        assertEquals(10, no1.getValor());
        assertEquals(20, no1.proximo.getValor());
        assertEquals(30, no1.proximo.proximo.getValor());
        assertNull(no1.proximo.proximo.proximo, "Último nó deve ter próximo = null");
    }

    private void assertEquals(int i, Integer valor) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testNoComValorNulo() {
        No<String> no = new No<String>(null);

        assertNull(no.getValor(), "É permitido criar nó com valor nulo");
        assertNull(no.proximo);
    }
}