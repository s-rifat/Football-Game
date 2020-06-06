
package dev.codenmore.footballgame.state;

import dev.codenmore.footballgame.Game;
import dev.codenmore.footballgame.entities.creatures.Player;
import dev.codenmore.footballgame.gfx.Assets;
import java.awt.Graphics;


public class GameState extends State {
    int x=0;
    int y=0;
    
    int x2=0,y2=0;
    int x3=0,y3=-100,x33=0,y33=100,y333 =50,y3333=-50;
    int dy3 = 1,dy33 = 1,dy333 = 1,dy3333 = 1;
    int x4=480;
    int y4 =360;
    int dx4=1;
    int dy4=1;
    private Player player;
    
    public GameState(Game game){
        super(game);
        player = new Player(game,100,100);
        
    }

    @Override
    public void tick() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      //x +=1;
      //  if(x==8)
        //   x=0;
        player.tick();
        x4+=dx4;
        if(x4>950 || x4<0)
            dx4*=-1;
         y4+=dy4;
        if(y4>710 || y4<0)
            dy4*=-1;
        
        y3 +=dy3;
        if(y3>100 || y3<-100)
           dy3 *=-1;
        
        
         y33 +=dy33;
        if(y33>100 || y33<-100)
           dy33 *=-1;
        
        
    }

    @Override
    public void render(Graphics g) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
      // g.drawImage(Assets.bc[y], 0, 0, null);
      // g.drawImage(Assets.lion[x], x, 400, null);
     
      g.drawImage(Assets.ground, 0, 0, null);
      
      //Hero Team
      //goalkeeper
    //  g.drawImage(Assets.player[0],x2+0,y2+345 , null);
      //defence
    //  g.drawImage(Assets.player[0],x2+215,y2+445 , null);//x incremented by 215
    //  g.drawImage(Assets.player[0],x2+215,y2+245 , null);
      
      //midfielders
    //  g.drawImage(Assets.player[0],x2+430,y2+345 , null);
     // g.drawImage(Assets.player[0],x2+430,y2+145 , null);
     // g.drawImage(Assets.player[0],x2+430,y2+545 , null);
      
      //strike
     // g.drawImage(Assets.player[0],x2+645,y2+445 , null);
     // g.drawImage(Assets.player[0],x2+645,y2+245 , null);
      
      //Opposite Team
      //goalkeeper
     // g.drawImage(Assets.player[1],x33+940,y33+345 , null);
      //defence
     // g.drawImage(Assets.player[1],x3+725,y3+445 , null);
     // g.drawImage(Assets.player[1],x3+725,y3+245 , null);
      
      //midfielders
     /* g.drawImage(Assets.player[1],x33+510,y33+345 , null);//x decremented by 215 
      g.drawImage(Assets.player[1],x33+510,y33+145 , null);
      g.drawImage(Assets.player[1],x33+510,y33+545 , null);
      
      //strike
      g.drawImage(Assets.player[1],x3+295,y3+445 , null);
      g.drawImage(Assets.player[1],x3+295,y3+245 , null);*/
      
      //Football
      // g.drawImage(Assets.ball,x4,y4 , null);
       player.render(g);
      
    }
    
}
