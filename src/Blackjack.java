public class Blackjack {
    private Baraja baraja;
    private Mano mano;

    public Blackjack() {
        baraja = new Baraja();
        mano = new Mano();
        mano.manoInicial(baraja);
    }

    public void jugar() {
        boolean estaJugando = true;
        do {
            mano.mostrar();
            Menu menu = new Menu();
            menu.mostrar();
            int opcion = menu.getOpcion();
            switch (opcion) {
                case 1:
                    mano.pedirCarta(baraja);
                    break;
                case 2:
                    reiniciarJuego();
                    break;
                case 3:
                    estaJugando = false;
                default:
                    break;
            }
        } while (estaJugando == true);
    }

    private void reiniciarJuego() {
        baraja = new Baraja();
        mano = new Mano();
        mano.manoInicial(baraja);
    }

    public static void main(String[] args) {
        new Blackjack().jugar();
    }

}
