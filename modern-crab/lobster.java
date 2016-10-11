import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class lobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class lobster extends Actor
{
    /**
     * Act - do whatever the lobster) wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      move(4);
      if(Greenfoot.getRandomNumber(100)<10){
         turn(Greenfoot.getRandomNumber(90)); 
     }
     if(isTouching(Crab.class)){
         World mundo = getWorld();
         //mundo.showText("game Over",250,250);
         ((CrabWorld)mundo).decrementaVidas();
          setLocation(50,30);
          ((CrabWorld)mundo).CangrejoAtrapado();
          
         //Label etiqueta = new Label("game Over",25);
         //mundo .addObject(etiqueta,250,250);
         //Greenfoot.stop();
     }
   }
}
