/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usandotodosescuchadores;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.ImageIcon;

import javax.swing.JLabel;

/**
 *
 * @author guill
 */
class Vista extends JFrame {
    private Controlador ctr;
    private JLabel lbEstrella=new JLabel();
    private ImageIcon ESTRELLA_AMARILLA=new ImageIcon(getClass().getResource(".\\..\\assets\\Estrella.png"));
    private ImageIcon ESTRELLA_AZUL=new ImageIcon(getClass().getResource(".\\..\\assets\\EstrellaModif.png"));
    private Panel pn1,pn2,pn3,panelLetra,panelRaton;
    private Label lbLetra,lbXraton,lbYraton,lbInferior;
    protected final static String ID_LABEL_LETRA="ID_LABEL_LETRA";
    protected final static String ID_LABEL_RATON="ID_LABEL_RATON";
    private final static String CADENA_X="X---> ";
    private final static String CADENA_Y="Y--->";
    
    public Vista() {
        super("Ventana");
        this.ctr=new Controlador(this);
        inicializar();
    }

    private void inicializar() {
        this.setSize(500,500);
        this.setLayout(new GridLayout(3,0));
        crearPanelSup();
        crearPanelMedio();
        crearPanelInf();
        this.addWindowListener(ctr);
        this.addKeyListener(ctr);
        setVisible(true);
    }

    private void crearPanelSup() {
        pn1=new Panel();
       lbEstrella.setIcon(ESTRELLA_AMARILLA);
       lbEstrella.addMouseListener(ctr);
       lbEstrella.addMouseMotionListener(ctr);
        pn1.add(lbEstrella);
        pn1.addMouseMotionListener(ctr);
        add(pn1);
    }

    private void crearPanelMedio() {
        pn2=new Panel(new GridLayout(0,2,15,0));
        panelLetra=new Panel(new BorderLayout());
        panelLetra.setBackground(Color.white);
        
        lbLetra=new Label("Pulsa una tecla");
        lbLetra.setAlignment(WIDTH);
        lbLetra.setFont(new Font("Arial",Font.BOLD,30));
        
        panelLetra.add(lbLetra,BorderLayout.CENTER);
        
        lbLetra.setName(ID_LABEL_LETRA);
        lbLetra.addMouseMotionListener(ctr);
        lbLetra.addMouseListener(ctr);
        
        panelRaton=new Panel(new GridLayout(2,0));
        panelRaton.setBackground(Color.orange);
        
        lbXraton=new Label(CADENA_X);
        lbYraton=new Label(CADENA_Y);
        lbXraton.setName(ID_LABEL_RATON);
        lbYraton.setName(ID_LABEL_RATON);
        lbXraton.addMouseListener(ctr);
        lbYraton.addMouseListener(ctr);
        lbXraton.addMouseMotionListener(ctr);
        lbYraton.addMouseMotionListener(ctr);
        
        panelRaton.add(lbXraton);
        panelRaton.add(lbYraton);
        
        pn2.add(panelLetra);
        pn2.add(panelRaton);
        add(pn2);
    }

    private void crearPanelInf() {
        pn3=new Panel(new BorderLayout());
        
        lbInferior=new Label("",WIDTH);
        lbInferior.setFont(new Font("Arial",Font.BOLD,30));
        lbInferior.addMouseMotionListener(ctr);
        pn3.add(lbInferior);
        add(pn3);
        
    }   
    
   public void actualizarLetra(char c){
       lbLetra.setText(String.valueOf(c));
   }
   public void cambiarImagen() {
        if(lbEstrella.getIcon().equals(ESTRELLA_AMARILLA))
        lbEstrella.setIcon(ESTRELLA_AZUL);
        else
           lbEstrella.setIcon(ESTRELLA_AMARILLA); 
    }

    void actualizarlbInferior(String FUERA) {
       lbInferior.setText(FUERA);
    }

    void actualizarlbXraton(int i) {
        lbXraton.setText(CADENA_X+i);
    }

    void actualizarlbYraton(int i) {
        lbYraton.setText(CADENA_Y+i);
    }
    
}
