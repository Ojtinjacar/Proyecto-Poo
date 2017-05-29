/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoodefinitivo;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author oscar
 */
public class Equipo {
    private int numero;

    private ArrayList<Jugador> jugador;

    public Equipo() {
        this.jugador = new ArrayList();
    }   
    
    public void addJugador(Jugador a){
        jugador.add(a);
    }

    public Jugador getJugador(int indice) {
        return jugador.get(indice);
    }
    //creo que no hace nada
    public Jugador getJugadorAleatorio() {
        int indice = numero;
        return jugador.get(indice);
    }

    public int jugadorAleatorio() {
        numero = ThreadLocalRandom.current().nextInt(1, 11);        
        return numero;
    }
    
    
}

