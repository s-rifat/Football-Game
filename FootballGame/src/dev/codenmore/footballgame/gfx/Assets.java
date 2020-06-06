 
package dev.codenmore.footballgame.gfx;

import java.awt.image.BufferedImage;


public class Assets {
   
    
   
    
   private static final int width =512, height = 256;
   private static final int width2 =960, height2 = 720;
    
    public static BufferedImage[] lion = new BufferedImage[8] ;
    public static BufferedImage[] bc = new BufferedImage[17] ;
    public static BufferedImage ground;
    public static BufferedImage[] player = new BufferedImage[8] ;
    public static BufferedImage ball;
     public static BufferedImage goalImage,front,menu,end,front2;
    public static void init() {
        
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheet2.png"));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/bc3.png"));
        SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/field2.png"));
       lion[0] = sheet.crop(0, 0, width, height);
         lion[1] = sheet.crop(width, 0, width, height);
         lion[2] = sheet.crop(0, height, width, height);
          lion[3] = sheet.crop(width, height, width, height);
          lion[4] = sheet.crop(0, height*2, width, height);
          lion[5] = sheet.crop(width, height*2, width, height);
          
           lion[6] = sheet.crop(0, height*3, width, height);
          lion[7] = sheet.crop(width, height*3, width, height);
        
          
          
          bc[0] = sheet2.crop(0, 0, 800, 800);
          
          bc[1] = sheet2.crop(50, 0, 800, 800);
          
          bc[2] = sheet2.crop(100, 0, 800, 800);
          bc[3] = sheet2.crop(150, 0, 800, 800);
          
          bc[4] = sheet2.crop(200, 0, 800, 800);
          bc[5] = sheet2.crop(250, 0, 800, 800);
          
          bc[6] = sheet2.crop(300, 0, 800, 800);
          bc[7] = sheet2.crop(350, 0, 800, 800);
          
          bc[8] = sheet2.crop(400, 0, 800, 800);
          
          bc[9] = sheet2.crop(450, 0, 800, 800);
          
          bc[10] = sheet2.crop(500, 0, 800, 800);
          bc[11] = sheet2.crop(550, 0, 800, 800);
          
          bc[12] = sheet2.crop(600, 0, 800, 800);
          bc[13] = sheet2.crop(650, 0, 800, 800);
          
          bc[14] = sheet2.crop(700, 0, 800, 800);
          bc[15] = sheet2.crop(750, 0, 800, 800);
          
          bc[16] = sheet2.crop(800, 0, 800, 800);
          
          ground= sheet3.crop(0, 0, 960, 720);
          player[0] = ImageLoader.loadImage("/textures/test2.png");
           player[1] = ImageLoader.loadImage("/textures/test4.png");
           
           ball = ImageLoader.loadImage("/textures/football.png");//here
           
           goalImage = ImageLoader.loadImage("/textures/goal.jpg");//here
           front = ImageLoader.loadImage("/textures/front.jpg");//here
            menu = ImageLoader.loadImage("/textures/menu.png");
            end = ImageLoader.loadImage("/textures/end.jpg");
            
              front2 = ImageLoader.loadImage("/textures/front2.jpg");//here
           
           
          
              
              
        
     
    }
}
