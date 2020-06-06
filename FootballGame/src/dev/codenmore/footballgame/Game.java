
package dev.codenmore.footballgame;

import dev.codenmore.footballgame.gfx.Assets;
import dev.codenmore.footballgame.gfx.ImageLoader;
import dev.codenmore.footballgame.gfx.SpriteSheet;
import dev.codenmore.footballgame.display.Display;
import dev.codenmore.footballgame.entities.creatures.Player;
import dev.codenmore.footballgame.input.KeyManager;
import dev.codenmore.footballgame.state.GameState;
import dev.codenmore.footballgame.state.GroundState;
import dev.codenmore.footballgame.state.MenuState;
import dev.codenmore.footballgame.state.State;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Game implements Runnable{
    
    
    public Display display;
    
    public int width,height;
    public String title;
    
   
    
    private boolean running = false;
    
    
    private Thread thread;
    
    private BufferStrategy bs;
    private Graphics g;
    
   /* private BufferedImage testImage;
    private SpriteSheet sheet;*/
    
    //States
    private State gameState;
    private State menuState;
    private State groundState;
    
    //Input
    
    private KeyManager keyManager;
    
    public Game(String title, int width, int height)
            
    {   
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        
       
        
        
    }
    private void init()
    {
         display = new Display(title,width,height);
         display.getFrame().addKeyListener(keyManager);
        /* testImage = ImageLoader.loadImage("/textures/spritesheet2.png");
         sheet = new SpriteSheet(testImage);*/
        
       Assets.init();
        gameState = new GameState(this);
        menuState = new MenuState(this);
        groundState = new GroundState(this);
        
       // State.setState(groundState);
        State.setState(gameState);
        // State.setState(menuState);
        
         
    }
    
  //  int x= 0;
  //  int y = 0;
    
    private void tick()
    {
      //  x +=1;
       /* if(x==8)
           x=0;
        
        y +=1;
        if(y==17)
           y=0;*/
        keyManager.tick();
       if(State.getState()!=null)
       {
           State.getState().tick();
       }
       
    }
    
    private void render()
    {
        bs = display.getCanvas().getBufferStrategy();
        
        if(bs == null)
        {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        
        g = bs.getDrawGraphics();
        //..........Clear Screen...........
        g.clearRect(0, 0, width, height);
        //..........Draw Here..............
        
        
      /*  g.setColor(Color.gray);
        g.fillRect(0, 0, width, height);
        g.drawImage(sheet.crop(0,0,512, 256), 150, 200, null);*/
     /* if(x==1 || x==3 || x==5 || x==7)
      {
       g.setColor(Color.pink);
        g.fillRect(0, 0, width, height);
      }*/
      //g.drawImage(Assets.bc[y], 0, 0, null);
    //  g.drawImage(Assets.lion[0], x, 400, null);
    
    if(State.getState()!=null)
       {
           State.getState().render(g);
       }
       
        //.........End DRawing.............
        bs.show();
        g.dispose();
        
      
    }
    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        init();
        int fps = 100;
        double timePerTick = 1000000000/fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        
        long timer = 0;
        int ticks = 0;
        
        
        while(running)
        {
            now = System.nanoTime();
            delta += (now - lastTime)/timePerTick;
            timer += now-lastTime;
            lastTime = now;
            
            if(delta>=1)
                {
                    tick();
                    render();
                    ticks++;
                    delta--;
                    
                   
                    
                }
            
           
            
            if(timer>=1000000000)
            {
                System.out.println("Ticks and Frames: "+ticks);
                ticks = 0;
                timer = 0;
            }
        }
        
        stop();
    }
    //12:21 video 14 ekhan theke start korbo
    public KeyManager getKeyManager()
    {
        return keyManager;
    }
    public synchronized void start()
    {   if(running)
        return;
    
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop()
    {   if(!running)
        return;
    
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
