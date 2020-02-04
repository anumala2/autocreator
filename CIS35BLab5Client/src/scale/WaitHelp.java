package scale;
import model.*;

public class WaitHelp extends Thread
{
	Automotive auto;
	String name;
	String nN;
	
	/**
	 * constructs a WaitHelp
	 * @param a
	 * @param n
	 * @param nn
	 */
	public WaitHelp(Automotive a, String n, String nn)
	{
		auto = new Automotive(a);
		name = n;
		nN = nn;
	}
	
	/**
	 * overrides the run() method of Thread for an edit
	 * of an option
	 */
	public void run()
	{
		Automotive a3 = new Automotive(auto);
		try
		{
		    Thread.sleep(1000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		int[] arr = a3.findOption(name);
		a3.setOption(arr, nN);
		a3.print();;
	}
}
