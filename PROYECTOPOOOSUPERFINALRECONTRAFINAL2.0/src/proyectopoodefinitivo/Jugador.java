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
public abstract class Jugador {

    //Nombre
    protected String Nombre;
    //Número 
    protected int Numero;
    //Posición Jugador en X
    protected int x;
    //Posición Jugador en Y
    protected int y;
    //Mov en x
    protected int dx;
    //Mov en y  
    protected int dy;
    //SEcuencia
    protected int width = 35;
    protected int height = 35;
    protected int CuadradoX;
    protected int CuandradoY;

    public Jugador(String Nombre, int Numero, int x, int y) {
        this.Nombre = Nombre;
        this.Numero = Numero;
        this.x = x;
        this.y = y;
        CuadradoX = x + 10;
        CuandradoY = y + 4;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getMovX() {
        return dx;
    }

    public int getCuadradoX() {
        return CuadradoX;
    }

    public int getCuandradoY() {
        return CuandradoY;
    }

    public void setMovX(int dx) {
        this.dx = dx;
    }

    public int getMovY() {
        return dy;
    }

    public void setMovY(int dy) {
        this.dy = dy;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void volverPosicionInicial() {
        x = getX();
        y = getY();
    }

    public Rectangle getBounds() {
        return new Rectangle(getMovX(), getY(), width, height);
    }

    public abstract void mover();

    public abstract void keyReleased(KeyEvent e);

    public abstract void keyPressed(KeyEvent e);

    public abstract void MoverPosicionInicial();

    public abstract void keyReleased1(KeyEvent e);

    public abstract void keyPressed1(KeyEvent e);

}
