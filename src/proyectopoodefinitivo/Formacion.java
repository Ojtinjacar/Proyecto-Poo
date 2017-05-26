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
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author oscar
 */
public class Formacion {

    private Portero portero;
    private Defensa defensa;
    private Mediocampista mediocampista;
    private Delantero delantero;

    public Formacion() {

        this.portero = new Portero("Ospina", 1, 15, 300);

    }

}
