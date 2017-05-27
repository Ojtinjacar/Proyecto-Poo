/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoodefinitivo;

/**
 *
 * @author oscar
 */
public class Delantero extends Jugador {

    public Delantero(String Nombre, int Numero, int x, int y) {
        super(Nombre, Numero, x, y);
    }


    public void mover() {
        x=getX();
        y=getY();
        x+=dx;
        y+=dy;
    }

    
    
}
