package adapter;
import model.*;
import client.*;
import exception.*;
import util.*;
import scale.*;

import java.io.IOException;
import java.util.Scanner;

public abstract class ProxyAutomotive
{
	/**
	 * Holds the static Automotive object auto
	 */
	//private static Automotive auto;
	private static AutoLHM<Automotive> autoLHM = new AutoLHM<Automotive>();
	
	public void run()
	{
	}
	
	/**
	 * Builds an Automotive from a file (provided by its filename),
	 * using the FileIo method buildAutoObject()
	 * @param filename
	 */
	public void buildAuto(String filename)
	{
		FileIo f = new FileIo();
		Automotive a1 = new Automotive();
		a1 = f.buildAutoObject(filename, a1);
		add(a1.getname(), a1);
	}
	
	public static int size()
	{
		return autoLHM.getSize();
	}
	
	/**
	 * edits an auto option twice using synchronization and without 
	 * synchronization - forming a total of 4 threads
	 * @param sync
	 * @param auto
	 * @param name
	 * @param nN1
	 * @param nn2
	 */
	public void editAutoOption(boolean sync, String auto, String name, String nN1, String nn2)
	{
		Automotive a1 = find(auto);
		EditOptions eo = new EditOptions();
		/*a1 = */eo.editOption(sync, a1, name, nN1, nn2);
		/*Automotive a2 = */eo.editOption(false, a1, name, nN1, nn2);
		delete(auto);
		//add("SYNCHRONIZED", a1);
		//add("UNSYNCHRONIZED", a2);
	}
	
	/**
	 * Calls the print() method in auto
	 */
	public void printAuto()
	{
		autoLHM.print();
	}
	
	public void createClient() throws IOException
	{
		AutoClient ac = new AutoClient();
		ac.makeClient();
	}
	
	/**
	 * Updates Option information on auto by calling the 
	 * setOption() method
	 * @param inds
	 * @param n
	 * @param p
	 */
	/*
	public void updateOption(String x, int[] inds, String n, int p)
	{
		autoLHM.find(x).setOption(inds, n, p);
	}
	*/
	
	/**
	 * Updates OptionSet information on auto by calling the 
	 * setOptionSet() method. Also implements a try-catch
	 * block in order to cover for an exception.
	 * @param ind
	 * @param n
	 * @param s
	 */
	/*
	public void updateOptionSet(int ind, String n, int s)
	{
		try
		{
			auto.setOptionSet(ind, n, s);
		}
		catch (AutoException e)
		{
			int i = e.getErrorno();
			e.printmyproblem(i);
			//e.printStackTrace();
			Scanner sc = new Scanner(System.in);
			try {
				auto.setOptionSet(ind, "notcolor", s);
			} catch (AutoException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//System.out.println("Please re-enter the following error number: " + i);
		}
	}
	*/
	
	/**
	 * Uses the eID, error ID, to determine how to fix the problem
	 * presented by the exception.
	 * @param eID
	 */
	public void fix(int eID)
	{
		AutoException e = new AutoException(eID);
		e.fix(eID);
	}
	
	/**
	 * adds an Automotive to the autoLHM
	 * @param x
	 * @param a
	 */
	public void add(String x, Automotive a)
	{
		autoLHM.add(x, a);
	}
	
	/**
	 * deletes an Automotive from autoLHM
	 * @param x
	 * @return
	 */
	public Automotive delete(String x)
	{
		return autoLHM.delete(x);
	}
	
	/**
	 * finds an Automotive in autoLHM
	 * @param x
	 * @return
	 */
	public Automotive find(String x)
	{
		return autoLHM.find(x);
	}
}
