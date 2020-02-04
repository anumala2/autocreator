package scale;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import model.*;

/**
 * Creates a LinkedHashMap of Automotives, storing, retrieving,
 * adding, and deleting Automotives as necessary.
 * @author Aadithya Anumala
 *
 * @param <T>
 */
public class AutoLHM<T> extends Automotive
{
	private T t;
	/**
	 * the main linkedhashmap
	 */
	private LinkedHashMap<String, Automotive> lhm = new LinkedHashMap<String, Automotive>();
	
	/**
	 * creates an AutoLHM
	 */
	public AutoLHM()
	{
		LinkedHashMap<String, Automotive> lhm = new LinkedHashMap<String, Automotive>();
	}
	
	public void add(String x, Automotive a)
	{
		if(lhm == null)
			System.out.println("no good");
		lhm.put(x, new Automotive(a));
	}
	
	public Automotive delete(String x)
	{
		if(lhm.containsKey(x))
		{
			return lhm.remove(x);
		}
		return null;
	}
	
	public Automotive find(String x)
	{
		return lhm.get(x);
	}
	
	public void print()
	{
		Iterator it = iterator();
		while(it.hasNext())
		{
			((Automotive)it.next()).print();
		}
	}
	
	private Iterator iterator()
	{
		Collection c = lhm.values();
		return c.iterator();
	}
}
