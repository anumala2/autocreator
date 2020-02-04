package driver;
import java.util.Scanner;
import server.*;
import adapter.*;
import model.Automotive;

/**
 * Driver.java
 * @author Aadithya Anumala
 * 
 * The class used to run the program in Lab 2.
 */
public class Driver 
{
	/*
	public static void main(String[] args)
	{
		CreateAuto a1 = new BuildAuto();
		a1.buildAuto("FordWagonZTW.txt");
		a1.printAuto();
		LHMAuto a2 = new BuildAuto();
		a1.buildAuto("FordWagon2.txt");
		System.out.println("took info from FordWagonZTW2.txt.");
		
		a2.find("Ford Wagon SECOND").print();
		System.out.println("printed Ford Wagon SECOND.");
		
		a1.printAuto();
		System.out.println("printed LHM.");
		
		a2.delete("Ford Wagon SECOND");
		System.out.println("deleted Ford Wagon SECOND.");
		
		a1.printAuto();
	}
	*/
	
	/**
	 * tests the synchronization editing of the editAutoOption() method
	 * @param args
	 */
	
	/*
	public static void main(String[] args)
	{
		CreateAuto a1 = new BuildAuto();
		a1.buildAuto("FordWagonZTW.txt");
		a1.printAuto();
		EditAuto a2 = new BuildAuto();
		a2.editAutoOption(true, "Ford Wagon ZTW", "Twilight Blue Clearcoat Metallic", "Twight", "Blueboy");
		a1.printAuto();
	}
	*/
	
	public static void main(String[] args)
	{
		WebAuto wa = new BuildAuto();
		wa.createWeb();
	}

}
