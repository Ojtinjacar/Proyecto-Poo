/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoodefinitivo;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 *
 */
public class Equipo {

    private ArrayList<Jugador> jugador;

    public Equipo() {
        this.jugador = new ArrayList();
    }

    public void addJugador(Jugador a) {
        jugador.add(a);
    }

    public Jugador getJugador(int indice) {
        return jugador.get(indice);
    }

    public Jugador jugadorAleatorio() {
        int numero;
        numero = ThreadLocalRandom.current().nextInt(1, 11);
        return jugador.get(numero);
    }  
}