package adapter;
import model.*;

public interface LHMAuto
{
	public void add(String x, Automotive a);
	
	public Automotive delete(String x);
	
	public Automotive find(String x);
}
