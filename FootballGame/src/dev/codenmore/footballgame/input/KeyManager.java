/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.footballgame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author pc
 */
public class KeyManager implements KeyListener {
    
    private boolean[] keys;
    public boolean up,down,left,right,goalKeeperH,defenceH,midH,strikeH,enter,start,menu,restart;
  
    
    public KeyManager() {
        keys = new boolean[256];
    }
    
    public void tick()
    {
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        goalKeeperH = keys[KeyEvent.VK_H];
        defenceH = keys[KeyEvent.VK_J];
        midH = keys[KeyEvent.VK_K];
        strikeH = keys[KeyEvent.VK_L];
        
        enter = keys[KeyEvent.VK_T];
        start = keys[KeyEvent.VK_R];
       menu = keys[KeyEvent.VK_F];
       
       restart = keys[KeyEvent.VK_M];
       
        
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
         //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       keys[e.getKeyCode()] =true;
        System.out.println("Pressed ");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        keys[e.getKeyCode()] = false;
    }
    
}
