package model;

import model.OptionSet.Option;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Automotive.java
 * @author Aadithya Anumala
 * @since January 23, 2019
 * 
 * OptionSet.java holds two classes, OptionSet and the inner 
 * class Option. 
 */
public class OptionSet implements Serializable
{
	/**
	 * options holds all Options in this OptionSet
	 */
	private ArrayList<Option> options;
	/**
	 * name holds the name of the OptionSet
	 */
	private String name;
	
	/**
	 * constructs an OptionSet, initializing all fields
	 * @param n
	 * @param size
	 */
	public OptionSet(String n, int size)
	{
		name = n;
		options = new ArrayList<Option>(size);
	}

	/**
	 * @return options
	 */
	protected Object[] getOptions()
	{
		return (Object[]) options.toArray();
	}
	
	/**
	 * @param ind
	 * @return Option requested by index
	 */
	protected Option getOption(int ind)
	{
		return options.get(ind);
	}
	
	/**
	 * sets an Option with name and price given the index
	 * @param ind
	 * @param n
	 * @param p
	 */
	protected void setOption(int ind, String n, int p)
	{
		if(options.size() <= ind)
		{
			options.add(ind, new Option(n, p));
		}
		else
		{
			options.get(ind).setName(n);
			options.get(ind).setPrice(p);
		}
	}
	
	/**
	 * @return name
	 */
	protected String getName()
	{
		return name;
	}
	
	/**
	 * @param n - name
	 */
	protected void setName(String n)
	{
		name = n;
	}
	
	/**
	 * sets options size
	 * @param s
	 */
	protected void setOptions(int s)
	{
		options = new ArrayList<Option>(s);
	}
	
	/**
	 * prints out contents of OptionSet using print() method
	 * from Option inner class
	 */
	protected void print()
	{
		System.out.println("\tOptionSet Name: " + name);
		for(int i = 0; i < options.size(); i++)
			options.get(i).print();
	}
	
	/**
	 * inner class Option
	 * @author Aadithya Anumala
	 * 
	 * stores the name and price of an option for an automobile.
	 */
	class Option implements Serializable
	{
	  /**
	   * name of Option
	   */
	  private String name;
	  /**
	   * price of Option
	   */
	  private int price;

	  public Option() {}
	  
	  /**
	   * constructs an Option, initializing all fields
	   * @param n
	   * @param p
	   */
	  public Option(String n, int p)
	  {
	    name = n;
	    price = p;
	  }
	  
	  /**
	   * sets name
	   * @param n
	   */
	  protected void setName(String n)
	  {
	    this.name = n;
	  }
	  
	  /**
	   * @return name
	   */
	  protected String getName()
	  {
	    return name;
	  }
	  
	  /**
	   * @param p - price
	   */
	  protected void setPrice(int p)
	  {
	    this.price = p;
	  }
	  
	  /**
	   * @return price
	   */
	  protected int getPrice()
	  {
	    return price;
	  }
	  
	  /**
	   * prints out the information stored in Option in a nice format.
	   */
	  protected void print()
	  {
		  System.out.println("\t\tOption Name: " + name + "\n\t\t       Price: " + price);
	  }
	}
}
