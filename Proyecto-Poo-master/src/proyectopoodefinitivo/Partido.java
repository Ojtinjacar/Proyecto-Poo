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
import java.util.concurrent.ThreadLocalRandom;
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

    private Equipo a;
    private Equipo b;
   
    private Jugador portero;
    private Jugador porteroB;
    
    private Jugador defensa1;
    private Jugador defensa2;
    private Jugador defensa3;
    private Jugador defensa4;
    private Jugador defensa1B;
    private Jugador defensa2B;
    private Jugador defensa3B;
    private Jugador defensa4B;
    
    private Jugador medio1;
    private Jugador medio2;
    private Jugador medio3;
    private Jugador medio4;
    private Jugador medio1B;
    private Jugador medio2B;
    private Jugador medio3B;
    private Jugador medio4B;
    
    private Jugador delantero1;
    private Jugador delantero2;
    private Jugador delantero1B;
    private Jugador delantero2B;
    
    private Cancha campo;
    private Arco arco1;
    private Arco arco2;
    private int secuencia;
    private Timer timer;
    private Image Muñeco;
    private Image MuñecoB;

    public Partido() {
        
        campo = new Cancha(15, 15, 1000, 672);
        arco1 = new Arco (0, 240, 15, 220);
        arco2 = new Arco (1015, 240, 15, 220);
        Muñeco = cargarimagen("blanco.png");
        MuñecoB = cargarimagen("negrito.png");
        
        portero = new Portero("Ospina", 10, 20, 310);

        defensa1 = new JugadorDeCampo("Pique", 22, 200, 100);
        defensa2 = new JugadorDeCampo("Boateng", 2, 200, 250);
        defensa3 = new JugadorDeCampo("Messi", 11, 200, 400);
        defensa4 = new JugadorDeCampo("Robayo", 22, 200, 550);
        
        medio1 = new JugadorDeCampo("Xabi", 12, 325, 100);
        medio2 = new JugadorDeCampo("Gerrard", 8, 325, 250);
        medio3 = new JugadorDeCampo("Ribery", 5, 325, 400);
        medio4 = new JugadorDeCampo("Rakitic", 6, 325, 550);
        
        delantero1 = new JugadorDeCampo("Messi", 10, 450, 150);
        delantero2 = new JugadorDeCampo("Cristiano", 7, 450,500);
        
        
        porteroB = new Portero("Mignolet", 1, 935, 310);

        defensa1B = new JugadorDeCampo("Ramos", 2, 755, 100);
        defensa2B = new JugadorDeCampo("Hummels", 3, 755, 250);
        defensa3B = new JugadorDeCampo("Lahm", 4, 755, 400);
        defensa4B = new JugadorDeCampo("Alberto Moreno", 5, 755, 550);
        
        medio1B = new JugadorDeCampo("Can", 6, 640, 100);
        medio2B = new JugadorDeCampo("Mayer", 7, 640, 250);
        medio3B = new JugadorDeCampo("Coutinho", 8, 640, 400);
        medio4B = new JugadorDeCampo("Hazard", 9, 640, 550);
        
        delantero1B = new JugadorDeCampo("Benzema", 10, 525, 150);
        delantero2B = new JugadorDeCampo("Zlatan", 11, 525,500);
        
        a = new Equipo();  
        a.addJugador(portero);
        a.addJugador(defensa1);
        a.addJugador(defensa2);
        a.addJugador(defensa3);
        a.addJugador(defensa4);
        a.addJugador(medio1);
        a.addJugador(medio2);
        a.addJugador(medio3);
        a.addJugador(medio4);
        a.addJugador(delantero1);
        a.addJugador(delantero2);
        
        
        b = new Equipo();
        b.addJugador(porteroB);
        b.addJugador(defensa1B);
        b.addJugador(defensa2B);
        b.addJugador(defensa3B);
        b.addJugador(defensa4B);
        b.addJugador(medio1B);
        b.addJugador(medio2B);
        b.addJugador(medio3B);
        b.addJugador(medio4B);
        b.addJugador(delantero1B);
        b.addJugador(delantero2B);
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        timer = new Timer(80, this);
        timer.start();
    }

    public void dibujarJugador(Graphics g) {  
        for (int i = 0; i < 11; i++) {
            g.drawImage(Muñeco, a.getJugador(i).getMovX() + a.getJugador(i).getX(), a.getJugador(i).getMovY() + a.getJugador(i).getY(), a.getJugador(i).getX() + 60, a.getJugador(i).getY() + a.getJugador(i).getMovY() + 60, (this.secuencia * 60), 0, (this.secuencia * 60) + 60, 60, this);            
            g.drawImage(MuñecoB, b.getJugador(i).getMovX() + b.getJugador(i).getX(), b.getJugador(i).getMovY() + b.getJugador(i).getY(), b.getJugador(i).getX() + 60, b.getJugador(i).getY() + b.getJugador(i).getMovY() + 60, (this.secuencia * 60), 0, (this.secuencia * 60) + 60, 60, this);
            g.drawRect(a.getJugador(i).getX()+4, a.getJugador(i).getY()+4, 48, 50);
            g.drawRect(b.getJugador(i).getX()+4, b.getJugador(i).getY()+4, 48, 50);        
        }           
    }

    public void Campo (Graphics g){
        g.drawRect(campo.getX(),campo.getY(), campo.getXf(), campo.getYf());
    }
    
    public void Arco (Graphics g){
        g.drawRect(arco1.getX(), arco1.getY(), arco1.getXf(), arco1.getYf());
        g.drawRect(arco2.getX(), arco2.getY(), arco2.getXf(), arco2.getYf());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image Cancha = cargarimagen("cancha.jpg");
        Graphics gbd = db.getGraphics();
        gbd.drawImage(Cancha, 0, 0, this);
        dibujarJugador(gbd);
        Campo(gbd);
        Arco(gbd);
        g.drawImage(db, 0, 0, this);
    }

    public Image cargarimagen(String imagen) {
        ImageIcon Image = new ImageIcon(imagen);
        Image image = Image.getImage();
        return image;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //ACA ES DONDE NECESITO PASARLE LA REFERENCIA DEL JUGADOR SELECCIONADO
        //SE QUE LA VARIABLA VALOR NO HACE NADA, PENSE QUE EXISTE ALGUNA MANERA\
        //DE RELACIONAR LA VARIABLE DE LA CLASE TADAPTER CON ESTA VARIABLE AQUI
        int valor = 0;
        a.getJugador(valor).mover();
        //defensa1.mover();
        checkCollisions();
        
        if (this.secuencia == 2) {
            this.secuencia = 0;
        } else {
            this.secuencia++;
        }       
        repaint();
    }
    
    public class TAdapter extends KeyAdapter {
        int valor = 1;
        int valorB = 1;
        @Override
        public void keyReleased(KeyEvent e) {
                //a.getJugador(3).keyPressed(e);  
                a.getJugador(valor).keyReleased(e);
                b.getJugador(valorB).keyReleased(e);
        }
        @Override
        public void keyPressed(KeyEvent e) {
            int tecla = e.getKeyCode();
            //a.getJugador(3).keyPressed(e);
            a.getJugador(valor).keyPressed(e);
            if (tecla == KeyEvent.VK_P){
                System.out.println("Presiono P");
                valor = ThreadLocalRandom.current().nextInt(1, 11);        
                a.getJugador(valor).keyPressed(e);
                System.out.println(valor);
            }
            if (tecla == KeyEvent.VK_SPACE){
                System.out.println("Presiono espacio");
                valorB = ThreadLocalRandom.current().nextInt(1, 11);        
                b.getJugador(valorB).keyPressed(e);
                System.out.println(valorB);
            }
        }
    }
    
    public void checkCollisions(){
        Rectangle rArquero = portero.getBounds();
        Rectangle rDefensa1 = defensa1.getBounds();
        if(rArquero.intersects(rDefensa1)){
            timer.stop();
            System.out.println("Colision");
        }
    }
}
