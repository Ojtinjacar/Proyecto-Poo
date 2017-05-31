/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoodefinitivo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * 
 */
public class Partido extends JPanel implements ActionListener {

    BufferedImage db = new BufferedImage(1050, 730, BufferedImage.TYPE_4BYTE_ABGR);
    private Equipo a;
    private Equipo b;

    private int Contador;
    private int Contador2;
    private Font fondo;
    private int TiempoJuego;

    private Portero porteroA;
    private Portero porteroB;

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

    private Jugador jugadorSeleccionado;
    private Jugador jugadorSeleccionadoB;

    private int secuencia;
    private Timer timer;
    private Image Muñeco;
    private Image SeleccionarJugador;
    private Image MuñecoB;
    private Balon balon;
    private Cancha campo;
    private Arco arco1;
    private Arco arco2;

    public Partido() {
        SeleccionarJugador = cargarimagen("element (66).png");
        Muñeco = cargarimagen("blanco.png");
        MuñecoB = cargarimagen("negrito.png");

        a = new Equipo();
        a.addJugador(porteroA = new Portero("Ospina", 10, 20, 310));
        a.addJugador(defensa1 = new JugadorDeCampo("Pique", 22, 200, 100));
        a.addJugador(defensa2 = new JugadorDeCampo("Boateng", 2, 200, 250));
        a.addJugador(defensa3 = new JugadorDeCampo("Messi", 11, 200, 400));
        a.addJugador(defensa4 = new JugadorDeCampo("Robayo", 22, 200, 550));
        a.addJugador(medio1 = new JugadorDeCampo("Xabi", 12, 325, 100));
        a.addJugador(medio2 = new JugadorDeCampo("Gerrard", 8, 325, 250));
        a.addJugador(medio3 = new JugadorDeCampo("Ribery", 5, 325, 400));
        a.addJugador(medio4 = new JugadorDeCampo("Rakitic", 6, 325, 550));
        a.addJugador(delantero1 = new JugadorDeCampo("Messi", 10, 450, 150));
        a.addJugador(delantero2 = new JugadorDeCampo("Cristiano", 7, 450, 500));
        jugadorSeleccionado = delantero1;

        b = new Equipo();
        b.addJugador(porteroB = new Portero("Mignolet", 1, 935, 310));
        b.addJugador(defensa1B = new JugadorDeCampo("Ramos", 2, 755, 100));
        b.addJugador(defensa2B = new JugadorDeCampo("Hummels", 3, 755, 250));
        b.addJugador(defensa3B = new JugadorDeCampo("Lahm", 4, 755, 400));
        b.addJugador(defensa4B = new JugadorDeCampo("Alberto Moreno", 5, 755, 550));
        b.addJugador(medio1B = new JugadorDeCampo("Can", 6, 640, 100));
        b.addJugador(medio2B = new JugadorDeCampo("Mayer", 7, 640, 250));
        b.addJugador(medio3B = new JugadorDeCampo("Coutinho", 8, 640, 400));
        b.addJugador(medio4B = new JugadorDeCampo("Hazard", 9, 640, 550));
        b.addJugador(delantero1B = new JugadorDeCampo("Benzema", 10, 525, 150));
        b.addJugador(delantero2B = new JugadorDeCampo("Zlatan", 11, 525, 500));
        jugadorSeleccionadoB = delantero1B;

        balon = new Balon(480, 333, 30, 30, jugadorSeleccionadoB);
        campo = new Cancha(15, 15, 1000, 672);
        arco1 = new Arco(0, 240, 15, 220);
        arco2 = new Arco(1015, 240, 15, 220);

        addKeyListener(new TAdapter());
        setFocusable(true);
        timer = new Timer(80, this);
        timer.start();
    }

    public void dibujarJugador(Graphics g) {
        for (int i = 0; i < 11; i++) {
            g.drawImage(Muñeco, a.getJugador(i).getX(), a.getJugador(i).getMovY() + a.getJugador(i).getY(), a.getJugador(i).getX() + 60, a.getJugador(i).getY() + a.getJugador(i).getMovY() + 60, (this.secuencia * 60), 0, (this.secuencia * 60) + 60, 60, this);
            g.drawImage(MuñecoB, b.getJugador(i).getX(), b.getJugador(i).getMovY() + b.getJugador(i).getY(), b.getJugador(i).getX() + 60, b.getJugador(i).getY() + b.getJugador(i).getMovY() + 60, (this.secuencia * 60), 0, (this.secuencia * 60) + 60, 60, this);
            if (jugadorSeleccionado == a.getJugador(i)) {
                g.setColor(Color.red);
                g.drawImage(SeleccionarJugador, a.getJugador(i).getX() - 5, a.getJugador(i).getY() - 60, this);
            }
            if (jugadorSeleccionadoB == b.getJugador(i)) {
                g.setColor(Color.blue);
                g.drawImage(SeleccionarJugador, b.getJugador(i).getX() - 5, b.getJugador(i).getY() - 60, this);
            }
        }
    }

    public void Movbalon(Graphics g) {
        Image Balon = cargarimagen("Balon2.png");
        g.drawImage(Balon, balon.getX(), balon.getY(), this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image Cancha = cargarimagen("cancha.jpg");
        Graphics gbd = db.getGraphics();
        gbd.drawImage(Cancha, 0, 0, this);
        dibujarJugador(gbd);
        Movbalon(gbd);
        Marcador(gbd);
        PintarTiempo(gbd);
        g.drawImage(db, 0, 0, this);
    }

    public void PintarTiempo(Graphics g) {
        fondo = new Font("Arial", Font.BOLD, 60);

        int min = TiempoJuego / 600;
        int seg = (TiempoJuego % 600) / 10;
        String sMin = "" + min;
        String sSeg = "" + seg;
        if (min < 10) {
            sMin = "0" + min;
        }
        if (seg < 10) {
            sSeg = "0" + seg;
        }
        setFont(fondo);
        g.drawString(sMin + " : " + sSeg, 50, 80);
        g.drawRect(45, 36, 170, 50);
    }

    public void Marcador(Graphics g) {
        fondo = new Font("Arial", Font.BOLD, 50);
        g.setFont(fondo);
        g.setColor(Color.BLACK);
        g.drawRect(790, 37, 150, 50);
        g.drawString(Contador + "  -  " + Contador2, 800, 80);
    }

    public Image cargarimagen(String imagen) {
        ImageIcon Image = new ImageIcon(imagen);
        Image image = Image.getImage();
        return image;
    }

    public void FinalizarPartido() {
        String Ganador = "";
        if (TiempoJuego == 600) {
            if (Contador < Contador2) {
                Ganador = "El ganador fue el jugador 2";
            }
            if (Contador > Contador2) {
                Ganador = "El ganador fue el jugador 1";
            }
            if (Contador == Contador2) {
                Ganador = "El juego finalizó en empate";
            }
            JOptionPane.showMessageDialog(this, Ganador, "Final Game", 1);
            System.exit(ABORT);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TiempoJuego++;
        porteroA.mover();
        porteroB.mover();
        for (int i = 1; i < 11; i++) {
            if (jugadorSeleccionado == a.getJugador(i)) {
                a.getJugador(i).mover();
            }
            if (jugadorSeleccionadoB == b.getJugador(i)) {
                b.getJugador(i).mover();
            }
        }  
        FinalizarPartido();
        checkCollisions();
        if (this.secuencia == 2) {
            this.secuencia = 0;
        } else {
            this.secuencia++;
        }
        repaint();
    }

    public void checkCollisions() {

        Rectangle rBalon = balon.getBounds();
        Rectangle rCancha = campo.getBounds();
        Rectangle rArco1 = arco1.getBounds();
        Rectangle rArco2 = arco2.getBounds();
        Rectangle rBalonArriba = new Rectangle(balon.getX() + 5, balon.getY() - 3, 20, 3);
        Rectangle rBalonAbajo = new Rectangle(balon.getX() + 5, balon.getY() + 30, 20, 3);
        Rectangle rBalonIzquierda = new Rectangle(balon.getX() - 3, balon.getY() + 5, 3, 20);
        Rectangle rBalonDerecha = new Rectangle(balon.getX() + 30, balon.getY() + 5, 3, 20);

        if (rCancha.contains(rBalon)) {
        } else {
            this.balon.setX(500);
            this.balon.setY(330);
            for (int i = 1; i < 11; i++) {
                a.getJugador(i).MoverPosicionInicial();
                b.getJugador(i).MoverPosicionInicial();
            }
        }
        if (rBalon.intersects(rArco2)) {
            for (int i = 1; i < 11; i++) {
                a.getJugador(i).MoverPosicionInicial();
                b.getJugador(i).MoverPosicionInicial();
            }
            JOptionPane.showMessageDialog(this, "Gol de " + jugadorSeleccionado.getNombre());
            Contador++;
        }
        if (rBalon.intersects(rArco1)) {
            for (int i = 1; i < 11; i++) {
                a.getJugador(i).MoverPosicionInicial();
                b.getJugador(i).MoverPosicionInicial();
            }
            JOptionPane.showMessageDialog(this, "Gol de " + jugadorSeleccionadoB.getNombre());
            Contador2++;
        }

        for (int i = 0; i < 11; i++) {
            if (a.getJugador(i).getBounds().intersects(rBalonArriba)) {
                balon.moverderecha();
            } else if (a.getJugador(i).getBounds().intersects(rBalonAbajo)) {
                balon.moverIzquierda();
            } else if (a.getJugador(i).getBounds().intersects(rBalonDerecha)) {
                balon.moverAtras();
            } else if (a.getJugador(i).getBounds().intersects(rBalonIzquierda)) {
                balon.moverfrente();
            }
        }
        for (int i = 0;
                i < 11; i++) {
            if (b.getJugador(i).getBounds().intersects(rBalonArriba)) {
                balon.moverderecha();
            } else if (b.getJugador(i).getBounds().intersects(rBalonAbajo)) {
                balon.moverIzquierda();
            } else if (b.getJugador(i).getBounds().intersects(rBalonDerecha)) {
                balon.moverAtras();
            } else if (b.getJugador(i).getBounds().intersects(rBalonIzquierda)) {
                balon.moverfrente();
            }
        }
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            jugadorSeleccionadoB.keyReleased(e);
            jugadorSeleccionado.keyReleased1(e);
            balon.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            jugadorSeleccionadoB.keyPressed(e);
            jugadorSeleccionado.keyPressed1(e);
            balon.keyPressed(e);
            int tecla = e.getKeyCode();
            if (tecla == KeyEvent.VK_G) {
                jugadorSeleccionado = a.jugadorAleatorio();
            }
            if (tecla == KeyEvent.VK_L) {
                jugadorSeleccionadoB = b.jugadorAleatorio();
            }
        }
    }
}
