package server;

import java.net.*;
import java.io.*;

public class AutoServer extends Thread
{
	private ServerSocket serverSocket;
	public static final int PORT = 7654;
	
	/**
	 * creates an AutoServer
	 */
	public AutoServer()
	{
		serverSocket = null;
	    try {
	        serverSocket = new ServerSocket(PORT);
	    } catch (IOException e) {
	        System.err.println("Could not listen on port: " + PORT + ".");
	        System.exit(1);
	    }
	}
	
	/**
	 * overrides the run() method from Thread, allowing for multithreaded
	 * capability for client-server relationship
	 */
	public void run()
	{
		Socket clientSocket = null;
	    clientSocket = new DefaultSocketClient("127.0.0.1", PORT).accept();
	    
	    PrintWriter out = null;
	    BufferedReader in = null;
	    
	    try {
			out = new PrintWriter(clientSocket.getOutputStream(), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    String inputLine, outputLine;
	    
	    AutoProtocol prot = new AutoProtocol();

        outputLine = prot.processInput(null);
        out.println(outputLine);

        try {
			while ((inputLine = in.readLine()) != null)
			{
			     outputLine = prot.processInput(inputLine);
			     out.println(outputLine);
			     if (outputLine.equals("Bye."))
			        break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        out.close();
        try {
			in.close();
			clientSocket.close();
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
