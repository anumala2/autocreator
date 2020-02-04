package client;

import java.io.*;
import java.net.*;

public class AutoClient
{
	/**
	 * creates a client for the use in configuring an automotive using
	 * a corresponding server
	 * @throws IOException
	 */
	public void makeClient() throws IOException
	{
		Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            socket = new Socket("127.0.0.1", 7654);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;

        while ((fromServer = in.readLine()) != null)
        {
            System.out.println(fromServer);
            if (fromServer.equals("Bye."))
                break;
		    
            fromUser = stdIn.readLine();
            if (fromUser != null)
            {
                System.out.println(fromUser);
                out.println(fromUser);
            }
        }
        
        out.close();
        in.close();
        stdIn.close();
        socket.close();
	}
}
