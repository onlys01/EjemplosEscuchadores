/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usandotodosescuchadores;

import java.awt.Label;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JLabel;

/**
 *
 * @author guill
 */
class Controlador implements WindowListener,KeyListener,FocusListener,MouseListener,MouseMotionListener{
    private Vista vista;

    public Controlador(Vista vista) {
        this.vista=vista;
    }

    @Override
    public void windowOpened(WindowEvent we) {
      
    }

    @Override
    public void windowClosing(WindowEvent we) {
            System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent we) {
    
    }

    @Override
    public void windowIconified(WindowEvent we) {
        System.out.println("Ventana Minimizada");
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
        
    }

    @Override
    public void windowActivated(WindowEvent we) {
  
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
       
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        char c=ke.getKeyChar();
      vista.actualizarLetra(c);
    }

    @Override
    public void keyPressed(KeyEvent ke) {
       
    }

    @Override
    public void keyReleased(KeyEvent ke) {
       
    }

    @Override
    public void focusGained(FocusEvent fe) {
        
    }

    @Override
    public void focusLost(FocusEvent fe) {
       
    }

    @Override
    public void mouseClicked(MouseEvent me) {
  
    }

    @Override
    public void mousePressed(MouseEvent me) {
        System.out.println(me.getX());
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    
    }

    @Override
    public void mouseEntered(MouseEvent me) {
      if(me.getSource().getClass().equals(JLabel.class)){
          vista.cambiarImagen();
          
      }
      
      if(me.getSource().getClass().equals(Label.class)){
          Label etq=(Label)me.getSource();
          switch (etq.getName()) {
              case Vista.ID_LABEL_RATON:
                  vista.actualizarlbInferior("Dentro de Panel Ratón");
                  break;
              case Vista.ID_LABEL_LETRA:
                  vista.actualizarlbInferior("Dentro de Panel letra");
                  break;
          }
      }
    }

    @Override
    public void mouseExited(MouseEvent me) {
    if(me.getSource().getClass().equals(JLabel.class)){
        vista.cambiarImagen();
    }
    if(me.getSource().getClass().equals(Label.class)){
        Label etq=(Label)me.getSource();
        switch(etq.getName()){
                case Vista.ID_LABEL_LETRA:
                    vista.actualizarlbInferior("Fuera de Panel letra");
                    break;
                case Vista.ID_LABEL_RATON:
                    vista.actualizarlbInferior("Fuera de Panel Ratón");
                    break;
                    
        }
                    
    }
    }

    @Override
    public void mouseDragged(MouseEvent me) {
      
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        PointerInfo p=MouseInfo.getPointerInfo();
        Point point=p.getLocation();
      vista.actualizarlbXraton((int)point.getX());
      vista.actualizarlbYraton((int)point.getY());
    }
    
    
    
}
