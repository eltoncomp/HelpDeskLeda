package estruturastests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import estruturas.ArvoreAVL;
import estruturas.NoAVL;
import system.Chamado;
import system.Usuario;

@SuppressWarnings("unused")
public class ArvoreAVLTest {

    @Test
    public void testInserirElementoNaArvore() {
        ArvoreAVL arvore = new ArvoreAVL();
        Usuario usuario = new Usuario(1, "João");

        Chamado chamado1 = new Chamado(10, 2, "Erro de login", usuario, 1);
        arvore.inserir(chamado1);

        assertNotNull(arvore.getRaiz());
        assertEquals(chamado1, arvore.getRaiz().chamado);
    }

    private void assertEquals(Chamado chamado1, Chamado chamado) {
		// TODO Auto-generated method stub
		
	}

	private void assertNotNull(NoAVL raiz) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testInserirDoisElementosComPrioridadeDiferente() {
        ArvoreAVL arvore = new ArvoreAVL();
        Usuario usuario = new Usuario(1, "Maria");

        Chamado chamado1 = new Chamado(1, 1, "Chamado prioridade 1", usuario, 1);
        Chamado chamado2 = new Chamado(2, 5, "Chamado prioridade 5", usuario, 2);

        arvore.inserir(chamado1);
        arvore.inserir(chamado2);

        assertEquals(chamado1, arvore.getRaiz().chamado);
        assertEquals(chamado2, arvore.getRaiz().direita.chamado);
    }

    @Test
    public void testInserirComDesempatePorId() {
        ArvoreAVL arvore = new ArvoreAVL();
        Usuario usuario = new Usuario(1, "Carlos");

        Chamado chamado1 = new Chamado(1, 3, "Chamado ID 1", usuario, 1);
        Chamado chamado2 = new Chamado(2, 3, "Chamado ID 2", usuario, 2);

        arvore.inserir(chamado1);
        arvore.inserir(chamado2);

        // Como prioridade é igual, desempate é pelo ID decrescente → chamado2 deve ir à esquerda
        assertEquals(chamado1, arvore.getRaiz().chamado);
        assertEquals(chamado2, arvore.getRaiz().esquerda.chamado);
    }

    @Test
    public void testListarEmOrdemImprimeCorretamente() {
        ArvoreAVL arvore = new ArvoreAVL();
        Usuario usuario = new Usuario(1, "Ana");

        Chamado chamado1 = new Chamado(1, 1, "Prioridade baixa", usuario, 1);
        Chamado chamado2 = new Chamado(2, 5, "Prioridade alta", usuario, 2);

        arvore.inserir(chamado1);
        arvore.inserir(chamado2);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        arvore.listarEmOrdem();

        String output = outContent.toString();
        assertTrue(output.contains("Prioridade: 5"));
        assertTrue(output.contains("Prioridade: 1"));
        // Ordem deve ser prioridade alta primeiro
        assertTrue(output.indexOf("Prioridade: 5") < output.indexOf("Prioridade: 1"));
    }

	private void assertTrue(boolean contains) {
		// TODO Auto-generated method stub
		
	}
}