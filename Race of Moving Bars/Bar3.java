
import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Bar3 extends Thread{
private int x,y,h,w;
private Color c;
private JFrame myFrame;
private Random r=new Random();
public Bar3(JFrame Frame) {    // I have created Bar3 constructor which takes JFrame to all of the bars work together in one JFrame.//
	x=-500;
	y=320;
	h=30;
	w=500;
    myFrame=Frame;
	c=Color.GREEN;
}
public void movement() {     // This method changes location of x which takes between 1 and 8//
	x=x+r.nextInt(8);
}
public int getX() {     //This method gets x of bar3//
	return x;
}
public void setX(int x) {    //This method sets x of bar3//
	this.x = x;
}
public int getY() {     //This method gets y of bar3//
	return y;
}
public void setY(int y) {    //This method sets y of bar3//
	this.y = y;
}
public int getH() {        //This method gets h of bar3//
	return h;
}
public void setH(int h) {     //This method sets h of bar3//
	this.h = h;
}
public int getW() {      //This method gets w of bar3//
	return w;
}
public void setW(int w) {     //This method sets w of bar3//
	this.w = w;
}
public Color getC() {     //This method gets color of bar3//
	return c;
}
public void setC(Color c) {    //This method sets color of bar3//
	this.c = c;
}
public void  run() {         // This method provides using movement method when this thread is be used.//
          
    	  try {
  			 
	            java.lang.Thread.sleep(1000);
	          
	        } catch (InterruptedException ex) {
	            Logger.getLogger(Bar3.class.getName()).log(Level.SEVERE, null, ex);            
	        } 
    	   movement();
	
}
}