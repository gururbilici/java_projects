import java.util.logging.Level;
import java.util.logging.Logger;

public class TimeTable implements Runnable {  // I created this class for showing counter with using thread.//
private int starting;

public TimeTable() {          // I created TimeTable constructor which initialize int starting=0//
	starting=0;
}
public void run() {          // This run method adding 1 on int starting.//
	
		try {
			 
	           java.lang.Thread.sleep(1000);                  // I wrote this code because of updating starting.//
	          
	        } catch (InterruptedException ex) {
	            Logger.getLogger(Square2.class.getName()).log(Level.SEVERE, null, ex);
	        }
		
	
	starting++;
}
public int getStarting() { // This method getting starting countert//
	
	return starting;
}
}
