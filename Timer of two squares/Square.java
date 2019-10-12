
import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Square extends Thread{                
    private int x,y,e;                             
    private Random random;
    private Color c;
    private JFrame fs;
    
    public Square(JFrame fs){      // I created square constructor which takes JFrame for using Turin class' JFrame and its x,y coordinates are 85,200 also edge length of square is 50. It's color is selected randomly// 
       random=new Random();                                       
       x=85;
       y=200;
       e=50;
       c= new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)); 
         this.fs=fs;
    }

    
    public int getX() { // This method getting x coordinate.//
		return x;
	}

 
	public void setX(int x) {  // This method setting x coordinate.//
		this.x = x;
	}


	public int getY() {     // This method getting y coordinate.//
		return y;
	}

 
	public void setY(int y) {    // This method setting y coordinate.//
		this.y = y;
	}


	public int getE() {     // This method getting edge length .//
		return e;
	}


	public void setE(int e) {    // This method setting edge length .//
		this.e = e;
	}


	public Color getC() {   // This method getting color .//
        return c;
    }

    public void setC(Color c) {  // This method setting color.//
        this.c = c;
    }
 
    public void run(){                                                                          //This run method sets color of square randomly.//             
           Color []colors={Color.RED,Color.BLUE,Color.GREEN,Color.BLACK,Color.YELLOW,            // I created colors array which has 10 different colors.//
        		   Color.ORANGE,Color.WHITE,Color.CYAN,Color.GRAY,Color.PINK};
           while (4>3) {     
        	   try {
      			 
   	            java.lang.Thread.sleep(1000);
   	          
   	        } catch (InterruptedException ex) {
   	            Logger.getLogger(Square2.class.getName()).log(Level.SEVERE, null, ex);            
   	        }
                 
                 setC(colors[random.nextInt(9)]);                                             // Setting color of square randomly from colors array.//
                
        }
        }
     
        
        
       
    
   
}
