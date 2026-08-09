package estruturas;

public class Log {

    private static final boolean ATIVO = true;

    public static void info(String estrutura, String mensagem) {
        if (ATIVO) {
            System.out.println("[LOG][" + estrutura + "] " + mensagem);
        }
    }
}
