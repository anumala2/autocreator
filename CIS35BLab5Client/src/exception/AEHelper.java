package exception;
import java.util.Scanner;
import adapter.*;

/**
 * The AEHelper class serves as a helper class for AutoExcpetion,
 * reducing the lines of code and clunkliness of the its client class.
 * @author Aadithya Anumala
 *
 */
public class AEHelper
{
	/**
	 * Fixes a situation of a null String sent as a parameter for the name
	 * of a to-be-updated OptionSet. Asks the user for input.
	 */
	public void fixName()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the name for the OptionSet:");
		//UpdateAuto p = new BuildAuto();
		//p.updateOptionSet(1, sc.next(), 7);
	}
	
	/**
	 * Prints out a message for the user.
	 */
	public void print()
	{
		System.err.println("AutoNullOptionSetNameException Error. Please re-enter the following error number: 1");
	}
}
