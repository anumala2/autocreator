package scale;
import model.*;

public class RegularHelp extends Thread
{
	Automotive auto;
	String name;
	String nN;
	
	/**
	 * constructs a RegularHelp
	 * @param a
	 * @param n
	 * @param nn
	 */
	public RegularHelp(Automotive a, String n, String nn)
	{
		auto = new Automotive(a);
		name = n;
		nN = nn;
	}
	public void run()
	{
		Automotive a3 = new Automotive(auto);
		a3.setOption((int[])a3.findOption(name), nN);
		a3.print();;
	}
}