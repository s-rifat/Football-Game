/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.codenmore.footballgame.state;

import dev.codenmore.footballgame.Game;
import dev.codenmore.footballgame.gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author pc
 */
public class GoalState extends State{

    public GoalState(Game game) {
        super(game);
    }

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        // g.drawImage(Assets.ball,0, 0, null);
    }
    
}
