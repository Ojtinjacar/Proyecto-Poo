/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoodefinitivo;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

/**
 *
 * 
 */
public class Balon {

    private final int dd = 10;
    private int x;
    private int y;
    private int xa = 15;
    private int ya = 15;

    private JugadorDeCampo jugadorDeCampo;
    private Jugador jugador;
    private static Thread thread;

    public Balon(int x, int y, int xa, int ya, Jugador jugador) {
        this.x = x;
        this.y = y;
        this.jugador = jugador;
    }

    public void keyPressed(KeyEvent e) {
        int boton = e.getKeyCode();
        int distancia = 2;
        if (boton == KeyEvent.VK_K) {
            if (jugadorDeCampo.getX() + 40 - x < distancia) {
                xa = 20;
                ya = 20;
            }
            if (jugadorDeCampo.getX() - x + 10 < distancia) {
                xa = 20;
                ya = 20;
            }
            if (jugadorDeCampo.getY() - y + 20 < distancia) {
                xa = 20;
                ya = 20;
            }
            if (y - jugadorDeCampo.getY() + 40 < distancia) {
                xa = 20;
                ya = 20;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int boton = e.getKeyCode();
        int distancia = 2;
        if (boton == KeyEvent.VK_K) {
            if (jugadorDeCampo.getX() + 40 - x < distancia) {
                xa = 20;
                ya = 20;
            } else if (jugadorDeCampo.getX() - x + 1 < distancia) {
                xa = 20;
                ya = 20;
            } else if (jugadorDeCampo.getY() - y + 20 < distancia) {
                xa = 20;
                ya = 20;
            } else if (y - jugadorDeCampo.getY() + 40 < distancia) {
                xa = 20;
                ya = 20;
            }
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getXa() {
        return xa;
    }

    public int getYa() {
        return ya;
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void moverfrente() {
        x = getX();
        x = x + dd;
    }

    public void moverAtras() {
        x = getX();
        x = x - dd;
    }

    public void moverIzquierda() {
        y = getY();
        y = y - dd;
    }

    public void moverderecha() {
        y = getY();
        y = y + dd;
    }

    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), 30, 30);
    }

    public void move() {
        if (x + xa < 0) {
            xa = 15;
        }
        if (x + xa >= 1030 - 20) {
            xa = -15; 
        }
        if (y + ya < 0) {
            ya = 15;
        }
        if (y + ya > 720 - 20) {
            ya = -15;
        }      
        x = x + xa;
        y = y + ya;
    }
}
