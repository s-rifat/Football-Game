
package dev.codenmore.footballgame.entities.creatures;

import dev.codenmore.footballgame.Game;
import dev.codenmore.footballgame.gfx.Assets;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

class A
{
    int x;
    int y;
    int width;
    int height;
    int dy = 1;
    int dx = 1;
    A()
    {
        
    }

    public A( int width, int height) {
        
        this.width = width;
        this.height = height;
    }
    
    void move(A ball, A GV,int L)
    {
      if(ball.y>L-100+33 && ball.y<L+100 && ball.y-L>=GV.y && ball.y-L<=GV.y+33)
       {
           
             // if(ball.y>245 && ball.y<445 && ball.y-345==GV.y)
          if(ball.dy>=0)
                GV.y = ball.y-L;
          else
              GV.y = ball.y-L-33;
           
               
       }
        else{
            GV.y +=GV.dy;
        if(GV.y>100 || GV.y<-100)
           GV.dy *=-1;
        }
    }
    
    
    
    
    
} 


public class Player extends Creature {
    
    boolean a = true,front=true,menu,end;
    int counter = 1;
    
    int brazilScore,germanyScore;
    boolean brabool=false,gerbool=false;
    void keyWorks()
    {
         if(game.getKeyManager().enter && brabool)
         {   
             brabool = false;
             
             
             a =true;
             brazilScore++;
            
         }
          if(game.getKeyManager().enter && gerbool)
         {   
             gerbool = false;
             
             
             a =true;
             germanyScore++;
            
         }
         
          System.out.println("Bra: "+brazilScore+"ger :"+germanyScore);
          
          if(game.getKeyManager().start && front)
         {   
             front = false;
             menu = true;
            
            
         }
           if(game.getKeyManager().menu)
         {   
             menu = false;
             
            
            a = true;
            
         }
           
           if(brazilScore >= 2 || germanyScore >= 2)
               end = true;
           
           if(game.getKeyManager().restart && end)
           {   
               brabool = false;
               gerbool = false;
               
               
               germanyScore = 0;
               brazilScore = 0;
               
               end = false;
               a = true;
               
           }
    }
    void score()
    {
        if(ball.x<=0 && ball.y+10>=235 && ball.y<=475)
        {   
            a =false;
          // germanyScore++;
           gerbool = true;
           
            
        }
        if(ball.x>=950 && ball.y+10>=235 && ball.y<=475)
        {   a = false;
           // brazilScore++;
           
             brabool = true;
        }
            
        
    }

    
   
    boolean collision(int x1, int y1, int x2, int y2)
{
    if(x1+10>=x2 && y1+10>=y2 && x1+10<=x2+21 &&y1+10 <= y2+33 )
        return true;
    
    return false;

}
    void direction_change()
    {  
       // if(ball.dx>0)
         //   ball.dx = (int) ((Math.random() * ((3 - 1) + 1)) + 1);
      //  else
             ball.dx = (int) ((Math.random() * ((-1 + 3) + 1)) -3);
        
        
      /*  if(ball.dy>0)
            ball.dy = (int) ((Math.random() * ((3 - 1) + 1)) + 1);
        else
             ball.dy = (int) ((Math.random() * ((-1 + 3) + 1)) -3);*/
       
      ball.dy = (int) ((Math.random() * ((3 +3) + 1)) - 3);
      
   //   System.out.println("X: "+ball.dx+"Y: "+ball.dy);
            
        ball.dx*=-1;
        ball.dy*=-1;
            
    }
    
      void direction_change2()
    {  
       // if(ball.dx>0)
            ball.dx = (int) ((Math.random() * ((3 - 1) + 1)) + 1);
        //else
             //ball.dx = (int) ((Math.random() * ((-1 + 3) + 1)) -3);
        
        
      /*  if(ball.dy>0)
            ball.dy = (int) ((Math.random() * ((3 - 1) + 1)) + 1);
        else
             ball.dy = (int) ((Math.random() * ((-1 + 3) + 1)) -3);*/
       
      ball.dy = (int) ((Math.random() * ((3 +3) + 1)) - 3);
      
   //   System.out.println("X: "+ball.dx+"Y: "+ball.dy);
            
        ball.dx*=-1;
        ball.dy*=-1;
            
    }
    
    void ballMovement()
    {
        /*if(game.getKeyManager().up)
            y-=3;
         if(game.getKeyManager().down)
            y+=3;
          if(game.getKeyManager().left)
            x-=3;
           if(game.getKeyManager().right)
            x+=3;*/
       
       ball.x+=ball.dx;
        if(ball.x>=950 || ball.x<=0)
        {   
           /* if(ball.x>=0)
            ball.dx = (int) ((Math.random() * ((3 - 1) + 1)) + 1);
            else{
                ball.dx = (int) ((Math.random() * ((-1 + 3) + 1)) -3);
            }
                */
            if(ball.x<=0)
                ball.dx =2;
            else
            
            ball.dx*=-1; //(Math.random() * ((max - min) + 1)) + min
             //ball.dx *= -((Math.random() * ((3 - 1) + 1)) + 1);
             
        }
        ball.y+=ball.dy;
        if(ball.y>=710 || ball.y<=0)
        {   
          /*  if(ball.y>=0)
            ball.dy = (int) ((Math.random() * ((3 - 1) + 1)) + 1);
            else{
                 ball.dy = (int) ((Math.random() * ((-1 +3) + 1)) -3);
            } */
            ball.dy*=-1; //(Math.random() * ((max - min) + 1)) + min
            //ball.dy *= -((Math.random() * ((2 - 1) + 1)) + 1);
            
        }
    }
    void HeroTeamCollision()
    {
         //goalkeeper collision
        if(collision(ball.x,ball.y,GH.x+0,GH.y+345))
        {
             direction_change();
            
        }
        //deffender2 collission
        if(collision(ball.x,ball.y,DH2.x+215,DH2.y+245))
        {
            direction_change();
            
        }
        //deffender1 collission
          if(collision(ball.x,ball.y,DH1.x+215,DH1.y+445))
        {
             direction_change();
            
        }
          //md1 collission 
             if(collision(ball.x,ball.y,MH1.x+430,MH1.y+345))
        {
            direction_change();
            
        }
             //mid 2 collission
                  if(collision(ball.x,ball.y,MH2.x+430,MH2.y+145 ))
        {
            direction_change();
            
        }
                  //mid 3 collission
                       if(collision(ball.x,ball.y,MH3.x+430,MH3.y+545))
        {
            direction_change();
            
        }
                   //strike 1 collission    
                  if(collision(ball.x,ball.y,SH1.x+645,SH1.y+445 ))
        {
            direction_change();
            
        }
                 // strike 2 collission 
                               
               if(collision(ball.x,ball.y,SH2.x+645,SH2.y+245 ))
        {
            direction_change();
            
        }
    }
    void HeroTeamMovement()
    {
        
      
       
       //Hero Team
       //movement for hero golkeeper
        if(game.getKeyManager().up && GH.y>-100 && game.getKeyManager().goalKeeperH)
            GH.y-=3;
        if(game.getKeyManager().down && GH.y<100 && game.getKeyManager().goalKeeperH)
            GH.y+=3;
        //movement for hero defence
         if(game.getKeyManager().up && DH1.y>-100 && game.getKeyManager().defenceH)
         {
            DH1.y-=3;
            DH2.y-=3;
         }
        if(game.getKeyManager().down && DH1.y<100 && game.getKeyManager().defenceH)
        {
            DH1.y+=3;
            DH2.y+=3;
        }
        //movement for hero mid
         if(game.getKeyManager().up && MH1.y>-100 && game.getKeyManager().midH)
         {
            MH1.y-=3;
            MH2.y-=3;
            MH3.y-=3;
         }
        if(game.getKeyManager().down && MH1.y<100 && game.getKeyManager().midH)
        {
            MH1.y+=3;
            MH2.y+=3;
            MH3.y+=3;
        }
        //movement for hero strike
        if(game.getKeyManager().up && SH1.y>-100 && game.getKeyManager().strikeH)
        {
            SH1.y-=3;
            SH2.y-=3;
        }
        if(game.getKeyManager().down && SH1.y<100 && game.getKeyManager().strikeH)
        {
            SH1.y+=3;
            SH2.y+=3;
        }
      
    }
    
    void moveVillain(int l, int y,int dy)
    {
         if(ball.y>l-100+33 && ball.y<l+100 && ball.y-l>=y && ball.y-l<=y+33)
       {
           
            
          if(ball.dy>=0)
                y = ball.y-l;
          else
              y = ball.y-l-33;
           
               
       }
         else{
           y +=dy;
        if(y>100 || y<-100)
           dy *=-1;
        }
        
    }
    void VillainTeamMovement()
    {
          //villain team movement
        
        /* GV.y +=GV.dy;
        if(GV.y>100 || GV.y<-100)
           GV.dy *=-1;*/
    /*   if(ball.y>245+33 && ball.y<445 && ball.y-345>=GV.y && ball.y-345<=GV.y+33)
       {
           
             // if(ball.y>245 && ball.y<445 && ball.y-345==GV.y)
          if(ball.dy>=0)
                GV.y = ball.y-345;
          else
              GV.y = ball.y-345-33;
           
               
       }
        else{
            GV.y +=GV.dy;
        if(GV.y>100 || GV.y<-100)
           GV.dy *=-1;
        }*/
        //moveVillain(345, GV.y,GV.dy);
        GV.move(ball, GV, 345);
       DV1.move(ball, DV1, 245);
        DV2.move(ball, DV2, 445);
        
        MV1.move(ball, MV1, 345);
        MV2.move(ball,  MV2, 145);
        MV3.move(ball, MV3, 545);
        
        SV1.move(ball, SV1, 445);
        SV2.move(ball,SV2, 245);
    }
    
    
    //Villain team collision
     void VillainTeamCollision()
    {
         //goalkeeper collision
        if(collision(ball.x,ball.y,GV.x+940,GV.y+345))
        {
             direction_change2();
            
        }
        //deffender2 collission
        if(collision(ball.x,ball.y,DV2.x+725,DH2.y+445))
        {
            direction_change2();
            
        }
        //deffender1 collission
          if(collision(ball.x,ball.y,DV1.x+725,DV1.y+245))
        {
             direction_change2();
            
        }
          //md1 collission 
             if(collision(ball.x,ball.y,MV1.x+510,MV1.y+345))
        {
            direction_change2();
            
        }
             //mid 2 collission
                  if(collision(ball.x,ball.y,MV2.x+510,MV2.y+145 ))
        {
            direction_change2();
            
        }
                  //mid 3 collission
                       if(collision(ball.x,ball.y,MV3.x+510,MV3.y+545))
        {
            direction_change2();
            
        }
                   //strike 1 collission    
                  if(collision(ball.x,ball.y,SV1.x+295,SV1.y+445 ))
        {
            direction_change2();
            
        }
                 // strike 2 collission 
                               
               if(collision(ball.x,ball.y,SV2.x+296,SV2.y+245 ))
        {
            direction_change2();
            
        }
    }
    
    //hero variable declaration 
    A GH = new A(21,33);
    A DH1 = new A();
    A DH2 = new A();
    A MH1 = new A();
    A MH2 = new A();
    A MH3 = new A();
    A SH1 = new A();
    A SH2 = new A();
    A ball = new A();
   
    //villain variable declaration 
    
    A GV = new A();
    A DV1 = new A();
    A DV2 = new A();
    A MV1 = new A();
    A MV2 = new A();
    A MV3 = new A();
    A SV1 = new A();
    A SV2 = new A();
    
    private Game game;
    
   
    public Player(Game game,float x, float y) {
        super(x, y,Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
        this.game = game;
    }

    @Override
    public void tick() {
       
       if(a == true)
       {
      ballMovement();
      HeroTeamCollision();
      HeroTeamMovement();
      VillainTeamMovement();
      VillainTeamCollision();
      
      score();
      
       
      getInput();
      move();
        System.out.println("DX: "+ball.dx+" X: "+ball.x+" Y: "+ball.y);
     
       }
       keyWorks();
       
    }
    private void getInput()
    {
        xMove = 0;
        yMove = 0;
        if(game.getKeyManager().up)
            yMove = -speed;
        if(game.getKeyManager().down)
            yMove = speed;
        if(game.getKeyManager().left)
            xMove = -speed;
        if(game.getKeyManager().right)
             xMove = speed;
    }

    @Override
    public void render(Graphics g) {
        //g.drawImage(Assets.ball,(int)x,(int) y,width,height, null);//that demo ball
        //Hero Team
        //goalkeeper
         g.drawImage(Assets.player[0],GH.x+0,GH.y+345,21,33, null);
         //defence
          g.drawImage(Assets.player[0],DH1.x+215,DH1.y+445 , null);//x incremented by 215
          g.drawImage(Assets.player[0],DH2.x+215,DH2.y+245 , null);
         //mid
      g.drawImage(Assets.player[0],MH1.x+430,MH1.y+345 , null);
      g.drawImage(Assets.player[0],MH2.x+430,MH2.y+145 , null);
      g.drawImage(Assets.player[0],MH3.x+430,MH3.y+545 , null);
      //strike
       g.drawImage(Assets.player[0],SH1.x+645,SH1.y+445 , null);
      g.drawImage(Assets.player[0],SH2.x+645,SH2.y+245 , null);
      
      
      //villain team
    //  g.drawImage(Assets.player[1],GV.x+940,GV.y+345 , null);
    //goalkeeper
      g.drawImage(Assets.player[1],GV.x+940,GV.y +345, null);
      //defence 1
      g.drawImage(Assets.player[1],DV1.x+725,DV1.y+245 , null);
      //defence 2
       g.drawImage(Assets.player[1],DV2.x+725,DV2.y+445 , null);
       //mid
        g.drawImage(Assets.player[1],MV1.x+510,MV1.y+345 , null);//x decremented by 215 
      g.drawImage(Assets.player[1],MV2.x+510,MV2.y+145 , null);
      g.drawImage(Assets.player[1],MV3.x+510,MV3.y+545 , null);
      
      //strike
      g.drawImage(Assets.player[1],SV1.x+295,SV1.y+445 , null);
      g.drawImage(Assets.player[1],SV2.x+295,SV2.y+245 , null);
    //ball
    g.drawImage(Assets.ball,ball.x,ball.y , null);
    
    g.setFont(new Font("Purisa", Font.PLAIN, 26));
    g.setColor(Color.white);
     g.drawString("Brazil "+brazilScore+" - "+germanyScore+" Germany", 385, 35);
     
     if(brabool)
       g.drawImage(Assets.goalImage,0,0, null);
     if(gerbool)
         g.drawImage(Assets.goalImage,0,0, null);
     
     if(brabool || gerbool)
         
     {   g.setColor(Color.red);
         g.setFont(new Font("Purisa", Font.PLAIN, 100));
         g.drawString("GOAL!!!", 300, 300);
         
        
         g.setFont(new Font("Purisa", Font.PLAIN, 50));
         g.drawString("Press T to Continue....", 250, 700);
         
     }
         if(front)
         {   
             g.drawImage(Assets.front,0,0, null);
             a=false;
             g.setColor(Color.red);
         g.setFont(new Font("Purisa", Font.PLAIN, 100));
         g.drawString("GORIBER FIFA", 150, 300);
         
         g.setFont(new Font("Purisa", Font.PLAIN, 50));
         g.drawString("Press R to Continue....", 250, 700);
         }
         
         if(menu)
         {
             g.drawImage(Assets.menu,0,0, null);
              g.setColor(Color.black);
              g.setFont(new Font("Purisa", Font.PLAIN, 26));
              g.drawString("Up - w", 325, 100);
              g.drawString("Down - s", 325, 150);
              
              g.drawString("Goalkeeper - h+Up/Down", 325, 250);
              g.drawString("Defence - j+Up/Down", 325, 300);
              g.drawString("Mid - k+Up/DOwn",325, 350);
               
              g.drawString("Strike- L+Up/Down", 325,400);
               
                
               g.setColor(Color.white);
              g.drawString("Score  two  goals  to  win . . .", 325,500);
              
              
              g.setColor(Color.white);
              g.setFont(new Font("Purisa", Font.PLAIN, 50));
              g.drawString("Press F to Continue....", 250, 700);
              
         }
         
         if(end)
         {
             g.drawImage(Assets.end,0,0, null);
             a= false;
             g.setColor(Color.red);
              g.setFont(new Font("Purisa", Font.PLAIN, 100));
             if(brazilScore>germanyScore)
                 g.drawString("YOU WIN!!!", 225, 350);
             else
                 g.drawString("YOU LOSE!!!", 225, 350);
                 
              
              g.setFont(new Font("Purisa", Font.PLAIN, 50));
             g.drawString("Press M to Restart or Click Cross to exit....", 26, 700);
         }
    }
    
}
