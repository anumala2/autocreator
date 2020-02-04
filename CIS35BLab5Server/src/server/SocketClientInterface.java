package server;

import java.net.Socket;

public interface SocketClientInterface
{
	public boolean openConnection();
	public Socket accept();
	public void handleSession();
	public void sendOutput(String strOutput);
	public void handleInput(String strInput);
	public void closeSession();
	public void setHost(String strHost);
	public void setPort(int iPort);
}
