import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Server {
	private static Random random=new Random();
     private static boolean flag=true;

	public static void main(String[] args) throws IOException {
		int portNumber = 5050;
		ServerSocket serverSocket = new ServerSocket(portNumber); // I created serversocket whose port number is 5050.//
		int rnumber = random.nextInt(1000); // Server generates random number.//
		Server server = new Server(); // I created server which is connected with client.//
		System.out.println("Server is ready");
		Socket socket = serverSocket.accept();  // When client is connected this socket variable accept.//
		System.out.println("Server got a client");
		System.out.println("Random number is "+rnumber); // Print random number on Server's terminal.//
		while(flag) {
		InputStream inputStream = socket.getInputStream(); //I created inputStream variable to use in dataInputStream.//
		DataInputStream dataInputStream = new DataInputStream(inputStream); // I created dataInputStream variable to read message which is sent by client.//
		String[] data = dataInputStream.readUTF().split(" "); // When client send data,data is split and assign data array.//
		OutputStream output = socket.getOutputStream();// I created output to use in DataoutputStream//
		DataOutputStream dot = new DataOutputStream(output);// I created  dot variable  to send data to server.// 
		int lastnumber=Integer.valueOf(data[0]);// When client enters a number.It assigns zeroth index of data array.lastnumber holds client's guessing number.//  
  
	      if(lastnumber==rnumber){    // If guessing number and rnumber equal server sends the message to client.//
	        dot.writeUTF("Server: Correct!");
	      }
	      else if(lastnumber>rnumber) {   // If guessing number greater than rnumber, server sends the message to client.//
	    	  dot.writeUTF("Server: Guess a smaller number."); 
	      }
	      else if(lastnumber<rnumber) {   // If guessing number smaller than rnumber, server sends the message to client.//
	    	  dot.writeUTF("Server: Guess a greater number.");	  
	      }
	         if(lastnumber==rnumber) {   // If guessing number and server's number are equal ,loop is stopped and socket is closed.//     	
	                   socket.close();
	                   break;
	         }

		}
		}
	}
