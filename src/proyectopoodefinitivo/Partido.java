/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoodefinitivo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
    private Mediocampista[] medio;
    private Delantero[] delantero;
    
    protected int secuencia;
    private Timer timer;
    private Image Muñeco;

    public Partido() {

        this.Muñeco = cargarimagen("received_10212987967997600.png");
        this.portero = new Portero("Ospina", 10, 20, 310);
        this.defensa = new Defensa[4];
        this.medio = new Mediocampista[4];
        this.delantero= new Delantero[2];
        
        defensa[0] = new Defensa("Pique", 22, 200, 100);
        defensa[1] = new Defensa("Boateng", 2, 200, 250);
        defensa[2] = new Defensa("Messi", 11, 200, 400);
        defensa[3] = new Defensa("Robayo", 22, 200, 550);
        
        medio[0] = new Mediocampista("Xabi", 12, 500, 100);
        medio[1] = new Mediocampista("Gerrard", 8, 500, 250);
        medio[2] = new Mediocampista("Ribery", 5, 500, 400);
        medio[3] = new Mediocampista("Rakitic", 6, 500, 550);
        
        delantero[0] = new Delantero("Messi", 10, 700, 150);
        delantero[1] = new Delantero("Cristiano", 7, 700,500);

        addKeyListener(new TAdapter());
        setFocusable(true);
        timer = new Timer(80, this);
        timer.start();

    }

    public void portero(Graphics g) {
        g.drawImage(Muñeco, portero.getMovX() + portero.getX(), portero.getMovY() + portero.getY(), portero.getX() + 60, portero.getMovY() + portero.getY() + 60, (this.secuencia * 60), 0, (this.secuencia * 60) + 60, 60, this);
        //Rectangle a = portero.getBounds();//esto es lo de colisiones, esta linea no hace nada
        g.drawRect(portero.getX()+4, portero.getY()+4, 48, 50);
        
    }

    public void Defensa(Graphics g) {

        defensa[0] = new Defensa("Pique", 22, 200, 100);
        defensa[1] = new Defensa("Boateng", 2, 200, 250);
        defensa[2] = new Defensa("Messi", 11, 200, 400);
        defensa[3] = new Defensa("Robayo", 22, 200, 550);

        for (int i = 0; i < defensa.length; i++) {
            g.drawImage(Muñeco, defensa[i].getMovX() + defensa[i].getX(), defensa[i].getMovY() + defensa[i].getY(), defensa[i].getX() + 60, defensa[i].getMovY() + defensa[i].getY() + 60, (this.secuencia * 60), 0, (this.secuencia * 60) + 60, 60, this);
            g.drawRect(defensa[i].getX()+4, defensa[i].getY()+4, 48, 50);
        }
    }

    public void Mediocampista(Graphics g) {
        medio[0] = new Mediocampista("Xabi", 12, 500, 100);
        medio[1] = new Mediocampista("Gerrard", 8, 500, 250);
        medio[2] = new Mediocampista("Ribery", 5, 500, 400);
        medio[3] = new Mediocampista("Rakitic", 6, 500, 550);
        for (int i = 0; i < medio.length; i++) {
            g.drawImage(Muñeco, medio[i].getMovX() + medio[i].getX(), medio[i].getMovY() + medio[i].getY(), medio[i].getX() + 60, medio[i].getMovY() + medio[i].getY() + 60, (this.secuencia * 60), 0, (this.secuencia * 60) + 60, 60, this);
            g.drawRect(medio[i].getX()+4, medio[i].getY()+4, 48, 50);
        }
    }

    public void Delanteros(Graphics g) {
        delantero[0] = new Delantero("Messi", 10, 700, 150);
        delantero[1] = new Delantero("Cristiano", 7, 700,500);
         for (int i = 0; i < delantero.length; i++) {
            g.drawImage(Muñeco, delantero[i].getMovX() + delantero[i].getX(), delantero[i].getMovY() +delantero[i].getY(), delantero[i].getX() + 60, delantero[i].getMovY() + delantero[i].getY() + 60, (this.secuencia * 60), 0, (this.secuencia * 60) + 60, 60, this);
            g.drawRect(delantero[i].getX()+4, delantero[i].getY()+4, 48, 50);
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
        Mediocampista(gbd);
        Delanteros(gbd);
        g.drawImage(db, 0, 0, this);
    }

    public Image cargarimagen(String imagen) {
        ImageIcon Image = new ImageIcon(imagen);
        Image image = Image.getImage();
        return image;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        portero.mover();
        checkCollisions();
        
        if (this.secuencia == 2) {
            this.secuencia = 0;
        } else {
            this.secuencia++;
        }
        
        repaint();
    }
    
    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            portero.keyReleased(e);
            //System.out.println("Solto la tecla ejecucion partido");
        }

        @Override
        public void keyPressed(KeyEvent e) {
            portero.keyPressed(e);
            //System.out.println("Ejecucion partido tecla presionada");
        }
    }
    
    public void checkCollisions(){
        Rectangle rArquero = portero.getBounds();
        Rectangle rDefensa1 = defensa[0].getBounds();
        if(rArquero.intersects(rDefensa1)){
            timer.stop();
            System.out.println("Colision");
        }
    }
}
