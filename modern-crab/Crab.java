import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List ; 

public class Crab extends Actor
{
    /**
     * Act - do whatever the Crab wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(4);
        gira();
        come();
   }
   
   public void gira()
   {
        if(Greenfoot.isKeyDown("left")){
        turn(3);
       } 
        if(Greenfoot.isKeyDown("right")){
        turn(3);
       } 
    }
    
    public void come()
    {
        if(isTouching(worm.class)){
            Greenfoot.playSound("eating.wav");
            removeTouching(worm.class);
            CrabWorld mundo = (CrabWorld)getWorld();
            mundo.incrementaGusanos();
            List Lista = mundo.getObjects(worm.class);
            if(Lista.size() == 0)
            {
               Label etiquetaWin = new Label("Winner",50);
               mundo.addObject(etiquetaWin,250,250);
               Greenfoot.stop();
            }
            }
        
        }
    }

