package scale;
import model.*;

/**
 * a helper class for EditOptions.java
 * @author aadianumala
 *
 */
public class Helper
{
	/**
	 * edits the program with synchronization
	 * @param auto
	 * @param name
	 * @param nN1
	 * @param nn2
	 */
	public synchronized void editSync(Automotive auto, String name, String nN1, String nn2)
	{
		/*
		System.out.println("synch");
		Automotive a2 = new Automotive(auto);
		a2 = syncchangeWait(auto, name, nn2);
		a2 = syncchange(auto, name, nN1);
		return a2;
		*/
		Thread t1 = new RegularHelp(auto, name, nN1);
		Thread t2 = new WaitHelp(auto, name, nn2);
		t1.start();
		t2.start();
	}
	
	/**
	 * edits the option indicated twice without synchronization
	 * @param auto
	 * @param name
	 * @param nN1
	 * @param nn2
	 */
	public void editUnSync(Automotive auto, String name, String nN1, String nn2)
	{
		/*
		System.out.println("unsynch");
		Automotive a2 = new Automotive(auto);
		a2 = changeWait(auto, name, nn2);
		a2 = change(auto, name, nN1);
		return a2;
		*/
		Thread t1 = new RegularHelp(auto, name, nN1);
		Thread t2 = new WaitHelp(auto, name, nn2);
		t1.start();
		t2.start();
	}
	
	/*
	public synchronized Automotive syncchange(Automotive auto, String name, String nN1)
	{
		Automotive a3 = new Automotive(auto);
		//int[] arr = ;
		a3.setOption((int[])a3.findOption(name), nN1);
		return a3;
	}
	
	public synchronized Automotive syncchangeWait(Automotive auto, String name, String nN1)
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
		a3.setOption(arr, nN1);
		return a3;
	}
	
	public Automotive change(Automotive auto, String name, String nN1)
	{
		Automotive a3 = new Automotive(auto);
		//int[] arr = ;
		a3.setOption((int[])a3.findOption(name), nN1);
		return a3;
	}
	
	public Automotive changeWait(Automotive auto, String name, String nN1)
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
		a3.setOption(arr, nN1);
		return a3;
	}
	*/
}
