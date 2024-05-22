public class Mano {
    private Carta[] mano;
    private int cartas;

    public Mano() {
        mano = new Carta[12];
        cartas = 0;
    }

    public void mostrar() {
        int puntos;
        System.out.print("Mano: ");
        for (int i = 0; i < cartas; i++) {
            mano[i].mostrar();
        }
        puntos = calcularPuntos();
        System.out.print("- Puntaje: " + puntos);
        if (haGanado(puntos))
            System.out.println("==> Ganó");
        else if (haPerdido(puntos))
            System.out.println("==> Perdió");
        else
            System.out.println("==> Sigue jugando");

        System.out.println("----------------------------");

    }

    private boolean haPerdido(int puntos) {
        return puntos > 21;
    }

    private boolean haGanado(int puntos) {
        return puntos == 21;
    }

    private int ajustarPuntos(int puntos, int ases) {
        while (puntos > 21 && ases > 0) {
            puntos -= 10;
            ases--;
        }
        return puntos;
    }

    private int calcularPuntos() {
        int puntos = 0;
        int ases = 0;
        for (int i = 0; i < cartas; i++) {
            puntos += mano[i].getNumero();
            if (mano[i].esAs()) {
                ases++;
            }
        }
        return ajustarPuntos(puntos, ases);
    }

    public void pedirCarta(Baraja baraja) {
        if (!haGanado(calcularPuntos()) && !haPerdido(calcularPuntos())) {
            Carta carta = baraja.sacar();
            carta.voltear();
            mano[cartas] = carta;
            cartas++;
        } else {
            System.out.println("""
                    ==========================
                    No puede seguir jugando
                    ==========================
                    """);
        }

    }

    public void manoInicial(Baraja baraja) {
        pedirCarta(baraja);
        pedirCarta(baraja);
    }
}
