
package dev.codenmore.footballgame.state;

import dev.codenmore.footballgame.Game;
import dev.codenmore.footballgame.gfx.Assets;
import java.awt.Graphics;


public class GroundState extends State{

    public GroundState(Game game) {
        super(game);
    }
    

    @Override
    public void tick() {
  
    }

    @Override
    public void render(Graphics g) {
       g.drawImage(Assets.goalImage, 0, 0, null);
    }
    
}
