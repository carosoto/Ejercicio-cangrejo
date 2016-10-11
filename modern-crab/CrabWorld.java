import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrabWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrabWorld extends World
{
    public final int TIEMPO_NIVEL = 15;
    private Counter contadorGusanos;
    private Counter contadorVidas;
    private Counter contadorTiempo;
    private SimpleTimer reloj;
    private Crab Cangrejo;
    private lobster langosta;
    private worm gusano;

    /**
     * Constructor for objects of class CrabWorld.
     * 
     */
    public CrabWorld()
    {    
        super(560, 560, 1); 
        contadorGusanos = new Counter("gusanos: ");
        contadorVidas = new Counter("vidas: ");
        contadorTiempo = new Counter("Tiempo: ");
        
        addObject(contadorGusanos,64,18);
        addObject(contadorVidas,184,18);
        addObject(contadorTiempo,300,18);
        prepare();
        contadorTiempo.setValue( TIEMPO_NIVEL );
        reloj = new SimpleTimer();
        
        
    }

    public void started(){
        reloj.mark();
        System.out.println("boton run presionado");
    }
    
    public void stoped(){
        System.out.println("boton pause presionado");
    }
    
    public void act()
    {
        
        if(reloj.millisElapsed() > 1000){
            contadorTiempo.add(-1);
            reloj.mark();
            if(contadorTiempo.getValue() == 0){
               Label etiquetaFin = new Label("Game Over",50);
               addObject(etiquetaFin,250,250);
               Greenfoot.stop();  
            }
            if(contadorTiempo.getValue() == 3){
                worm worm = new worm();
                addObject(worm,100,100);
            }
        }
        
    }
    
    public void incrementaGusanos(){
        contadorGusanos.add(1);
    }

    public void decrementaVidas(){
        contadorVidas.add(-1);
    }
    
    public void reiniciaPosCangrejo(){
        Cangrejo.setLocation(300,300);
    }
    
    public void CangrejoAtrapado()
    {
        langosta.setLocation(20,30);
         Cangrejo.setLocation(214,211);
        if(contadorVidas.getValue()==0){
            Label etiquetaFin = new Label("Game Over",50);
            addObject(etiquetaFin,250,250);
            Greenfoot.stop();
        }
    }
    
    public void winner(){
        if(contadorGusanos.getValue()==10){
            Label etiquetaWin = new Label("Winner",50);
            addObject(etiquetaWin,250,250);
            Greenfoot.stop();
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        worm worm = new worm();
        addObject(worm,71,81);
        worm worm2 = new worm();
        addObject(worm2,270,84);
        worm worm3 = new worm();
        addObject(worm3,480,86);
        worm worm4 = new worm();
        addObject(worm4,365,223);
        worm worm5 = new worm();
        addObject(worm5,144,235);
        worm worm6 = new worm();
        addObject(worm6,265,350);
        worm worm7 = new worm();
        addObject(worm7,457,387);
        worm worm8 = new worm();
        addObject(worm8,95,389);
        worm worm9 = new worm();
        addObject(worm9,195,501);
        worm worm10 = new worm();
        addObject(worm10,376,515);
        Crab crab = new Crab();
        addObject(crab,265,174);
        crab.act();
        Cangrejo = new Crab();
        langosta = new lobster();
        contadorVidas.setValue(3);
        lobster lobster  = new lobster();
        addObject(lobster,477,522);
        Counter counter = new Counter("Tiempo: ");
        addObject(counter,309,24);
        counter.setLocation(306,19);

        removeObject(counter);
    }
}
