import java.util.Scanner;

public class Menu {
    private final Intervalo OPCIONES = new Intervalo(1, 3);

    public void mostrar() {
        final String OPCIONES = """
                ----------------------------
                1. Pedir,
                2. Volver a empezar,
                3. Salir
                ----------------------------
                """;
        System.out.println(OPCIONES);
    }

    public int getOpcion() {
        int opcion;
        boolean error;
        do {
            opcion = new Scanner(System.in).nextInt();
            error = !OPCIONES.incluye(opcion);
        } while (error);
        return opcion;
    }
}
