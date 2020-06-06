
package dev.codenmore.footballgame.state;

import dev.codenmore.footballgame.Game;
import dev.codenmore.footballgame.gfx.Assets;
import java.awt.Graphics;


public class MenuState extends State {

    public MenuState(Game game) {
        super(game);
    }

   
    
    @Override
    public void tick() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void render(Graphics g) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         g.drawImage(Assets.goalImage,0,0 , null);
    }
    
}
