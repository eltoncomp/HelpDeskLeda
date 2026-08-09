package estruturastests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import estruturas.HeapMaximo;
import system.Chamado;
import system.Usuario;

@SuppressWarnings("unused")
public class HeapMaximoTest {

    @Test
    public void testHeapInicialmenteVazio() {
        HeapMaximo heap = new HeapMaximo(5);
        assertTrue(heap.estaVazio(), "Heap deve iniciar vazio");
        assertNull(heap.extrairMaximo(), "Extrair de heap vazio deve retornar null");
    }

    private void assertNull(Chamado extrairMaximo, String string) {
		// TODO Auto-generated method stub
		
	}

	private void assertTrue(boolean estaVazio, String string) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testInserirUmElemento() {
        HeapMaximo heap = new HeapMaximo(5);
        Usuario usuario = new Usuario(1, "João");
        Chamado chamado = new Chamado(10, 3, "Erro de login", usuario, 1);

        heap.inserir(chamado);

        assertFalse(heap.estaVazio(), "Heap não deve estar vazio após inserção");
        assertEquals(chamado, heap.extrairMaximo(), "Extrair deve retornar o único elemento inserido");
    }

    private void assertEquals(Chamado chamado, Chamado extrairMaximo, String string) {
		// TODO Auto-generated method stub
		
	}

	private void assertFalse(boolean estaVazio, String string) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testInserirMantemMaiorPrioridadeNaRaiz() {
        HeapMaximo heap = new HeapMaximo(5);
        Usuario usuario = new Usuario(1, "Maria");

        Chamado chamado1 = new Chamado(1, 2, "Prioridade baixa", usuario, 1);
        Chamado chamado2 = new Chamado(2, 5, "Prioridade alta", usuario, 2);

        heap.inserir(chamado1);
        heap.inserir(chamado2);

        Chamado maximo = heap.extrairMaximo();
        assertEquals(chamado2, maximo, "Chamado com maior prioridade deve ser extraído primeiro");
    }

    @Test
    public void testDesempatePorOrdemChegada() {
        HeapMaximo heap = new HeapMaximo(5);
        Usuario usuario = new Usuario(1, "Carlos");

        Chamado chamado1 = new Chamado(1, 3, "Primeiro chamado", usuario, 1);
        Chamado chamado2 = new Chamado(2, 3, "Segundo chamado", usuario, 2);

        heap.inserir(chamado1);
        heap.inserir(chamado2);

        Chamado maximo = heap.extrairMaximo();
        assertEquals(chamado1, maximo, "Em caso de empate de prioridade, menor ordemChegada deve sair primeiro");
    }

    @Test
    public void testInserirAteCapacidadeMaxima() {
        HeapMaximo heap = new HeapMaximo(2);
        Usuario usuario = new Usuario(1, "Ana");

        Chamado chamado1 = new Chamado(1, 4, "Chamado 1", usuario, 1);
        Chamado chamado2 = new Chamado(2, 5, "Chamado 2", usuario, 2);
        Chamado chamado3 = new Chamado(3, 1, "Chamado 3", usuario, 3);

        heap.inserir(chamado1);
        heap.inserir(chamado2);
        heap.inserir(chamado3); // não deve ser inserido pois heap está cheio

        assertEquals(chamado2, heap.extrairMaximo(), "Chamado 2 deve ser extraído primeiro");
        assertEquals(chamado1, heap.extrairMaximo(), "Chamado 1 deve ser extraído em seguida");
        assertTrue(heap.estaVazio(), "Heap deve estar vazio após extrair todos elementos válidos");
    }
}