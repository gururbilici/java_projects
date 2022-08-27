import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Bars extends JFrame implements ActionListener{
	private JButton start,reset;
	private Timer timer;
	private Bar1 b1=new Bar1(this);                   // I initialized bar 1.//
	private Bar2 b2=new Bar2(this);                   // I initialized bar 2.//
	private Bar3 b3=new Bar3(this);                   // I initialized bar 3.//
	private Bar4 b4=new Bar4(this);                   // I initialized bar 4.//
	private Bar5 b5=new Bar5(this);                   // I initialized bar 5.//
	
	public void paint(Graphics g){  
		super.paint(g);
		         g.setColor(b1.getC());
         g.fillRect(b1.getX(),b1.getY(),b1.getW(),b1.getH());      // Drawing of first bar.//
         
         g.setColor(b2.getC());
         g.fillRect(b2.getX(),b2.getY(),b2.getW(),b2.getH());     // Drawing of second bar.//   
        
         
         g.setColor(b3.getC());
         g.fillRect(b3.getX(),b3.getY(),b3.getW(),b3.getH());       // Drawing of third bar.//
         
         g.setColor(b4.getC());
         g.fillRect(b4.getX(),b4.getY(),b4.getW(),b4.getH());       // Drawing of fourth bar.//
         
         g.setColor(b5.getC());
         g.fillRect(b5.getX(),b5.getY(),b5.getW(),b5.getH());         // Drawing of fifth bar.//
         
	}
	public Bars(){
		 setLayout(null);                                              // I used null layout.//
		setSize(500,500);                                             // I created JFrame which size is 500,500
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		timer= new Timer(100, this);    // I initialized timer.//
		
		 start=new JButton("Start");    // I initialized Start button.//
	     start.setSize(90,30);          // I set size of Start button.//
	     start.setLocation(100,25);     // I set location of Start button.//
	     add(start);
	     start.addActionListener(this);  
	     
	     reset=new JButton("Reset");     // I initialized Reset button.//
	     reset.setSize(90,30);           // I set size of Reset button.//
	     reset.setLocation(300, 25);     // I set location of Reset button.//
	     add(reset);
	     reset.addActionListener(this);
	     
	}
public static void main(String[]args) {
	new Bars();
}
@Override
public void actionPerformed(ActionEvent e) {
	Thread t1=new Thread(b1);                 // I created the thread for b1 object to use run method.//
	Thread t2=new Thread(b2);                 // I created the thread for b2 object to use run method.//
    Thread t3=new Thread(b3);                 // I created  the thread for b3 object to use run method.//
	Thread t4=new Thread(b4);                 // I created the thread for b4 object to use run method.//
	Thread t5=new Thread(b5);                 // I created the thread for b5 object to use run method.//
	if(e.getSource().equals(start)) {         // When you click start button timer is started.//
		start.setEnabled(false);
		timer.start();
		
		
		
	}
	else if(e.getSource().equals(timer)) {
		
			
			
		if(!(b1.getX()>=0 || b2.getX()>=0 || b3.getX()>=0 || b4.getX()>=0 || b5.getX()>=0)) {  // One of the bars of x reaches end of frame, animation will stop.//
			
		try {
				java.lang.Thread.sleep(200);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		
		t2.start();
		t1.start();
		t3.start();
		t4.start();
		t5.start();
		 
		repaint();
	}
		else if(b1.getX()>=0) {                                // If bar1 is reached end of frame,timer is stopped and the pop-up will be shown.//
			timer.stop();
			JOptionPane.showMessageDialog(this,"Red has won!");
		
		}
		else if(b2.getX()>=0) {                                  // If bar2 is reached end of frame,timer is stopped and the pop-up will be shown.//
			timer.stop();
			JOptionPane.showMessageDialog(this,"Black has won!");
			
			
		}
		else if(b3.getX()>=0) {                                    // If bar3 is reached end of frame,timer is stopped and the pop-up will be shown.//
			timer.stop();
			JOptionPane.showMessageDialog(this,"Green has won!");
			
		}
		else if(b4.getX()>=0) {                                    // If bar4 is reached end of frame,timer is stopped and the pop-up will be shown.//
			timer.stop();
			JOptionPane.showMessageDialog(this,"Yellow has won!");
			
		}
		else if(b5.getX()>=0) {                                      // If bar5 is reached end of frame,timer is stopped and the pop-up will be shown.//
			timer.stop();
			JOptionPane.showMessageDialog(this,"Blue has won!");
			
		}
		
		
}
		else if(e.getSource().equals(reset)) {       // If you click restart, all of the bars' location will be default location.Also, you can't enable start button.//
			
			timer.stop();
			b1.setX(-500);
			b2.setX(-500);
			b3.setX(-500);
			b4.setX(-500);
			b5.setX(-500);
			repaint();
			start.setEnabled(true);
			
			
			
		}
}
}

