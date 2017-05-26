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
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author oscar
 */
public class Partido extends JPanel implements ActionListener {

    BufferedImage db = new BufferedImage(1050, 730, BufferedImage.TYPE_4BYTE_ABGR);

    private Formacion formation;
    private Jugador[] jugador;
    private Portero portero;
    private Defensa[] defensa;
    private int time;
    protected int secuencia;
    private Timer timer;
    private int x;
    private int yyy;
    private Image Muñeco;

    public Partido() {
        this.Muñeco = cargarimagen("received_10212987967997600.png");
        timer = new Timer(80, this);
        timer.start();

    }

    public void portero(Graphics g) {
        this.portero = new Portero("Ospina", 10, 20, 310);
        g.drawImage(Muñeco, portero.getMovX() + portero.getX(), portero.getMovY() + portero.getY(), portero.getX() + 60, portero.getMovY() + portero.getY() + 60, (this.secuencia * 60), 0, (this.secuencia * 60) + 60, 60, this);

    }

    public void Defensa(Graphics g) {
        this.defensa = new Defensa[4];
        defensa[0] = new Defensa("Pique", 4, 200, 100);
        defensa[1] = new Defensa("Boateng", 2, 200, 250);
        defensa[2] = new Defensa("Messi", 4, 200, 400);
        defensa[3] = new Defensa("Robayo", 4, 200, 550);

        for (int i = 0; i < defensa.length; i++) {
            g.drawImage(Muñeco, defensa[i].getMovX() + defensa[i].getX(), defensa[i].getMovY() + defensa[i].getY(), defensa[i].getX() + 60, defensa[i].getMovY() + defensa[i].getY() + 60, (this.secuencia * 60), 0, (this.secuencia * 60) + 60, 60, this);

        }
    }

    public void Mediocampista(Graphics g) {

    }



    public void formaciones(Graphics g) {
        this.jugador = new Jugador[11];
        jugador[0] = new Jugador("James", 10, 0, 0);
        jugador[1] = new Jugador("James", 10, 60, 60);
        jugador[2] = new Jugador("James", 10, 120, 120);
        jugador[3] = new Jugador("James", 10, 180, 180);
        jugador[4] = new Jugador("James", 10, 240, 240);
        jugador[5] = new Jugador("James", 10, 300, 300);
        jugador[6] = new Jugador("James", 10, 360, 360);
        jugador[7] = new Jugador("James", 10, 420, 420);
        jugador[8] = new Jugador("James", 10, 480, 480);
        jugador[9] = new Jugador("James", 10, 540, 540);
        jugador[10] = new Jugador("James", 10, 600, 600);

        for (int i = 0; i < jugador.length; i++) {
            g.drawImage(Muñeco, jugador[i].getMovX() + jugador[i].getX(), jugador[i].getY(), jugador[i].getX() + 60, jugador[i].getY() + 60, (this.secuencia * 60), 0, (this.secuencia * 60) + 60, 60, this);

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image Cancha = cargarimagen("funny-tumblr-search.jpg");
        Graphics gbd = db.getGraphics();
        gbd.drawImage(Cancha, 0, 0, this);
        portero(gbd);
        Defensa(gbd);
        // formaciones(gbd);
        g.drawImage(db, 0, 0, this);

    }

    public Image cargarimagen(String imagen) {
        ImageIcon Image = new ImageIcon(imagen);
        Image image = Image.getImage();
        return image;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /* for (int i = 0; i < jugador.length; i++) {
            jugador[i].setMovX(+50);
            /* x[i] += 50;
            x[i] = jugador[i].getMovX();

        }*/

        portero.setMovY(20);
        if (this.secuencia == 2) {

            this.secuencia = 0;
        } else {
            this.secuencia++;

        }
        repaint();

    }
}
