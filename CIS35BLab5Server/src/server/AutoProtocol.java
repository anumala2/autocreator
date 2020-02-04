package server;

import adapter.*;
import model.*;

public class AutoProtocol
{
	private int pos = 0;
	private int size = 0;
	private int opset = -1;
	private Automotive auto = null;
	
	/**
	 * processes the text given by the user
	 * @param input
	 * @return
	 */
	public String processInput(String input)
	{
		if(input == null)
		{
			pos = 1;
			return "Enter 1 to configure your Automotive. Enter 'Bye.' to exit.";
		}
		
		LHMAuto lh = new BuildAuto();
		
		switch (pos)
		{
		case 1:
			if(input.equalsIgnoreCase("1"))
				pos = 2;
				return "What is the make of the Automotive you want to configure?";
		case 2:
			auto = lh.find(input);
			auto.print();
			System.out.println("Total price: $" + auto.getTotalPrice());
			pos = 3;
			return "Choose an OptionSet to change.";
		case 3:
			opset = auto.findOptionSet(input);
			pos = 4;
			return "Choose an Option.";
		case 4:
			auto.setOptionChoice(input);
			pos = 2;
			return "Change noted. Enter anything to see your Automotive.";
		}
		/*
		size = auto.getSize();
		for(int i = 0; i < size; i++)
		{
			auto.getOptionSet(i)i.print();
		}
		*/
		
		return null;
	}
}
