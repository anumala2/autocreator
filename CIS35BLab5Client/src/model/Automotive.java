package model;

import java.io.*;
import java.util.ArrayList;

import exception.*;
import model.*;
import model.OptionSet.Option;

/**
 * Automotive.java
 * @author Aadithya Anumala
 * @since January 23, 2019
 * 
 * The Automotive class holds all the options available for
 * a car, organized within the sets they exist within. The
 * Automotive class uses OptionSet.java and its inner class
 * Option to accomplish this goal. The class also contains
 * the name of the vehicle and its base price. The class 
 * uses getters and setters for encapsulation. The class can
 * also find, update, and delete OptionSets and Options
 * stored.
 */
public class Automotive implements Serializable, Runnable
{
  /**
   * sets holds all OptionSets, and therefore all Options
   */
  private ArrayList<OptionSet> sets;
  /**
   * name holds the name of the vehicle
   */
  private String name;
  /**
   * basePrice holds the base price of the vehicle
   */
  private int basePrice;
  private int size;
  
  private String make;
  private String model;
  
  private ArrayList<Option> choices;
  
  /**
   * getters and setters of make and model
   * @return
   */
  public String getMake() {return make;}
  public void setMake(String make) {this.make = make;}
  public String getModel() {return model;}
  public void setModel(String model) {this.model = model;}

  /**
   * constructs a "Ford Wagon ZTW" by default
   */
  public Automotive()
  {
	  name = "Ford Wagon ZTW";
	  make = "Ford";
	  model = "Wagon ZTW";
	  basePrice = 18445;
	  sets = new ArrayList<OptionSet>(5);
	  size = 5;
  }
  
  public Automotive(Automotive a)
  {
	  name = a.name;
	  make = a.make;
	  model = a.model;
	  basePrice = a.basePrice;
	  sets = a.sets;
	  size = a.size;
  }
  
  /**
   * constructs a generic Automotive, with all field variables
   * ready for instantiation
   * @param s
   * @param base
   * @param size
   */
  public Automotive(String s, int base, int size)
  {
    name = s;
    basePrice = base;
    sets = new ArrayList<OptionSet>(size);
    this.size = size;
  }
  
  /**
   * @return size
   */
  
  public int getSize()
  {
	  return size;
  }
  
  /**
   * @return name
   */
  
  public String getname()
  {
	  return name;
  }
  
  /**
   * set name
   * @param s
   */
  public void setName(String s)
  {
	  name = s;
  }
  
  /**
   * @return basePrice
   */
  public int getBasePrice()
  {
	  return basePrice;
  }
  
  /**
   * set basePrice
   * @param bp
   */
  public void setBasePrice(int bp)
  {
	  basePrice = bp;
  }
  
  /**
   * get OptionSet by index value
   * @param ind
   * @return OptionSet requested
   */
  
  public OptionSet getOptionSet(int ind)
  {
	  return sets.get(ind);
  }
  
  /**
   * get Option by index values
   * @param inds
   * @return Option requested
   */
  
  public Option getOption(int[] inds)
  {
	  return sets.get(inds[0]).getOption(inds[1]);
  }
  
  /**
   * set the name and size (given index) of an OptionSet. Also
   * throws AutoException from the exception package.
   * @param ind
   * @param n
   * @param s
   */
  
  public void setOptionSet(int ind, String n, int s) throws AutoException
  {
	  if(sets.size() <= ind)
	  {
		  sets.add(ind, new OptionSet(n, s));
	  }
	  if(n == null)
	  {
		  throw new AutoException(1);
	  }
	  else
	  {
		  sets.get(ind).setName(n);
		  sets.get(ind).setOptions(s);
	  }
  }
  
  /**
   * using an int[] of size 2 with OptionSet index at
   * inds[0] and Option index at inds[1], set Option 
   * value name and price
   * @param inds
   * @param n
   * @param p
   */
  public void setOption(int[] inds, String n, int p)
  {
	  sets.get(inds[0]).setOption(inds[1], n, p);
  }
  
  public void setOption(int[] inds, String n)
  {
	  sets.get(inds[0]).setOption(inds[1], n, sets.get(inds[0]).getOption(inds[1]).getPrice());
  }
  
  /**
   * find OptionSet with name
   * @param ref
   * @return index of OptionSet
   */
  
  public int findOptionSet(String ref)
  {
	  for(int i = 0; i < sets.size(); i++)
	  {
		  if(sets.get(i).getName().equals(ref)) 
		  {
			  return i;
		  }
	  }
	  
	  return -1;
  }
  
  /**
   * find Option with name
   * @param ref
   * @return int[] indices with OptionSet index at
   * inds[0] and Option index at inds[1]
   */
  
  public int[] findOption(String ref)
  {
	  int[] ind = new int[2];
	  for(int i = 0; i < sets.size(); i++)
	  {
		  Object[] tempOptions = sets.get(i).getOptions();
		  for(int j = 0; j < tempOptions.length; j++)
		  {
			  if(((Option)tempOptions[j]).getName().equals(ref)) 
			  {
				  ind[0] = i;
				  ind[1] = j;
				  return ind;
			  }
		  }
	  }
	  return ind;
  }
  
  /**
   * delete an OptionSet
   * @param ind
   * @return the deleted OptionSet
   */
  
  public OptionSet deleteOptionSet(int ind)
  {
	  OptionSet temp = sets.get(ind);
	  sets.set(ind, null);
	  return temp;
  }
  
  /**
   * delete an Option
   * @param inds
   * @return the deleted Option
   */
  public Option deleteOption(int[] inds)
  {
	  Option temp = sets.get(inds[0]).getOption(inds[1]);
	  sets.get(inds[0]).setOption(inds[1], "", 0);
	  return temp;
  }
  
  /**
   * update OptionSet (basically find + set)
   * @param nOri - original name
   * @param nNew - new name
   * @param s
   */
  
  public void updateOptionSet(String nOri, String nNew, int s)
  {
	  try {
		setOptionSet(findOptionSet(nOri), nNew, s);
	} catch (AutoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  /**
   * update Option (basically find + set)
   * @param nOri - original name
   * @param nNew - new name
   * @param p
   */
  public void updateOption(String nOri, String nNew, int p)
  {
	  setOption(findOption(nOri), nNew, p);
  }
  
  /**
   * gets chosen option
   * @param setName
   * @return
   */
  public String getOptionChoice(String setName)
  {
	  int set = findOptionSet(setName);
	  return choices.get(set).getName();
  }
  
  /**
   * gets chosen option price
   * @param setName
   * @return
   */
  public int getOptionChoicePrice(String setName)
  {
	  int set = findOptionSet(setName);
	  return choices.get(set).getPrice();
  }
  
  /**
   * sets option choice
   * @param setName
   * @param opChoice
   */
  public void setOptionChoice(String setName, String opChoice)
  {
	  int[] inds = findOption(opChoice);
	  choices.set(inds[0], sets.get(inds[0]).getOption(inds[1]));
  }
  
  /**
   * adds and returns total price
   * @return
   */
  public int getTotalPrice()
  {
	  int total = 0;
	  for(int i = 0; i < choices.size(); i++)
	  {
		  total += choices.get(i).getPrice();
	  }
	  return total;
  }
  
  /**
   * prints the contents of the Automotive by calling the
   * print() method in OptionSet.java
   */
  public void print()
  {
	  System.out.println("Automotive Name: " + name);
	  for(int i = 0; i < sets.size(); i++)
	  {
		  if(sets.get(i) != null)
			  sets.get(i).print();
	  }
  }

  public void run()
  {
	  
	
  }
  
}

