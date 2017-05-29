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
 * @author oscar
 */
public class Portero extends Jugador {

    public Portero(String Nombre, int Numero, int x, int y) {
        super(Nombre, Numero, x, y);

    }
    //aca es donde se modifica.
    public void mover() {
        x = getX();
        y = getY();
        x += dx;
        y += dy;

    }
    //lo de abajo no va porque el portero se mueve de arriba hacia abajo

    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        if (tecla == KeyEvent.VK_LEFT) {
            dx = -10;
        }
        if (tecla == KeyEvent.VK_RIGHT) {
            dx = 10;
        }
        if (tecla == KeyEvent.VK_UP) {
            dy = -10;
        }
        if (tecla == KeyEvent.VK_DOWN) {
            dy = +10;
        }
    }

    public void keyReleased(KeyEvent e) {
        System.out.println("Solto la tecla ejecucion portero");
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), 60, 60);
    }

}
