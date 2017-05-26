/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoodefinitivo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author oscar
 */
public class Jugador {

    //Nombre
    protected String Nombre;
    //Número 
    protected int Numero;
 //Posición Jugador en X
    protected int x;
    //Posición Jugador en Y
    protected int y;
    //Mov en x
    protected int MovX;
    //Mov en y
    protected int MovY;
    //SEcuencia

    public Jugador(String Nombre, int Numero, int x, int y) {
        this.Nombre = Nombre;
        this.Numero = Numero;
        this.x = x;
        this.y = y;

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
        return MovX;
    }

    public void setMovX(int MovX) {
        this.MovX = MovX;
    }

    public int getMovY() {
        return MovY;
    }

    public void setMovY(int MovY) {
        this.MovY = MovY;
    }


}
