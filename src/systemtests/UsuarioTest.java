package systemtests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import system.Usuario;

@SuppressWarnings("unused")
public class UsuarioTest {

    @Test
    public void testConstrutorInicializaCamposCorretamente() {
        Usuario usuario = new Usuario(1, "João");

        assertEquals(1, usuario.id);
        assertEquals("João", usuario.nome);
    }

    private void assertEquals(String string, String nome) {
		// TODO Auto-generated method stub
		
	}

	private void assertEquals(int i, int id) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testUsuarioComNomeVazio() {
        Usuario usuario = new Usuario(2, "");

        assertEquals(2, usuario.id);
        assertEquals("", usuario.nome);
    }

    @Test
    public void testUsuarioComNomeNulo() {
        Usuario usuario = new Usuario(3, null);

        assertEquals(3, usuario.id);
        assertNull(usuario.nome);
    }
    
	private void assertNull(String nome) {
		// TODO Auto-generated method stub
		
	}
}