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
public class Defensa extends Jugador {

    public Defensa(String Nombre, int Numero, int x, int y) {
        super(Nombre, Numero, x, y);
    }

    public void mover() {
        x=getX();
        y=getY();
        x+=dx;
        y+=dy;
    }
    
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        if (tecla == KeyEvent.VK_LEFT){
            dx = -5;
        }
        if(tecla == KeyEvent.VK_RIGHT){
            dx = 5;
        }
        if(tecla == KeyEvent.VK_UP){
            dy = 5;
        }
        if(tecla == KeyEvent.VK_DOWN){
            dy = -5;
        }
    }
    
    public void keyReleased(KeyEvent e) {
        
    }
    
    public Rectangle getBounds(){
        return new Rectangle(getX() ,getY(), 60, 60);
    }

}
