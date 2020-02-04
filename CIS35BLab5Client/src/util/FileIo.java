package util;
import model.*;
import java.io.*;
import java.util.Scanner;
import exception.*;

//builds Automobile, processing data from text file

/**
 * FileIo.java
 * @author Aadithya Anumala
 * @since January 23, 2019
 * 
 * The FileIo class uses the Automotive class to add data to
 * the Automotive. FileIo reads from a .txt file (formatted
 * properly) and uses the information available to fill in the
 * information necessary in an Automotive. Furthermore, the FileIo
 * class (de)serializes Automotives.
 */
public class FileIo
{
	/**
	 * uses readTextFile() and parsing tools to fill in information 
	 * into the Automotive passed as a parameter
	 * @param filename
	 * @param a1
	 * @return new Automotive with contents
	 */
	public Automotive buildAutoObject(String filename, Automotive a1)
	{
		String[] lines = readTextFile(filename);
		
		String name = lines[0];
		
		int basep = Integer.parseInt(lines[1]);
		int size = Integer.parseInt(lines[2]);;
		
		a1 = new Automotive(name, basep, size);
		String opSetTemp = "";
		String opTemp = "";
		int opPrice = 0;
		
		String currLine = "";
		int opCount = 0;
		int[] opInd = new int[2];
		
		/* process 
		 * text
		 * code 
		 * "," separates options (", name , price")
		 * "\n" separates optionsets
		 * enter values into the OptionSets in a1
		*/
		
		for(int i = 3; i < lines.length; i++)
		{
			currLine = lines[i];
			//System.out.println(currLine);
			opSetTemp = currLine.substring(0, currLine.indexOf(',')).trim();
			//System.out.println(opSetTemp);
			currLine = currLine.substring(currLine.indexOf(',')+1, currLine.length());
			//System.out.println(currLine);
			opCount = Integer.parseInt(currLine.substring(0, currLine.indexOf(',')).trim());
			currLine = currLine.substring(currLine.indexOf(',')+1, currLine.length());
			
			//System.out.println(i-3 + " " + opSetTemp + " " + opCount);
			try {
				a1.setOptionSet(i-3, opSetTemp, opCount);
			} catch (AutoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for(int j = 0; j < opCount; j++)
			{
				opInd[0] = i-3;
				opInd[1] = j;
				opTemp = currLine.substring(0, currLine.indexOf(',')).trim();
				currLine = currLine.substring(currLine.indexOf(',')+1, currLine.length());
				//System.out.println(currLine);
				if(currLine.contains(","))
				{
					//System.out.println(currLine);
					opPrice = Integer.parseInt(currLine.substring(0, currLine.indexOf(',')).trim());
				}
				else
					opPrice = Integer.parseInt(currLine.trim());
				currLine = currLine.substring(currLine.indexOf(',')+1, currLine.length());
				//System.out.println(currLine);
				//System.out.println(opInd[0] + " " + opInd[1] + " " + opTemp + " " + opPrice);
				a1.setOption(opInd, opTemp, opPrice);
			}
			
		}
		
		//a1.print();
		
		return a1;
		
	}
	
	/**
	 * Reads the contents of the .txt file whose filename is
	 * passed as a parameter and chunks it in such a way for
	 * buildAutoObject() process.
	 * @param filename
	 * @return String[] with all the info from .txt file
	 */
	public String[] readTextFile(String filename)
	{
		//System.out.println("reading...");
		String[] lines;
		String text = "";
		String line = "";
		int count = 0;
		
		try 
		{
			//System.out.println("tried...");
			File file = new File(filename);
			//FileReader file = new FileReader(filename);
			Scanner buff = new Scanner(file);
			//BufferedReader buff = new BufferedReader(file);
			//boolean eof = false;
			
			//System.out.println("passed instantiations...");
			
			while (buff.hasNext())
			{
				line = buff.nextLine();
				//line = buff.readLine();
				
				//if (line == null)
				//{
				text += line + "\n";
				count++;
				//}
				//else
					//System.out.println(line);
			}
			
			//System.out.println("Here's text" + text);
			
			buff.close();
		}
		
		catch (IOException e)
		{
			System.out.println("FileIO Error­­ " + e.toString());
		}
		
		text.substring(0, text.length()-1);
		//System.out.println(text);
		//System.out.println(count);
		
		lines = new String[count];
		line = "";
		for(int i = 0; i < count; i++)
		{
			line = text.substring(0, text.indexOf('\n'));
			text = text.substring(text.indexOf('\n')+1, text.length());
			//System.out.println(line);
			lines[i] = line;
		}
		
		return lines;
	}
	
	/**
	 * serializes Automotive into the filename passed
	 * @param a1
	 * @param serfilename
	 */
	public void serializeAuto(Automotive a1, String serfilename)
	{
		try
		{
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(serfilename));
			output.writeObject(a1);
		}
		catch(Exception e)
		{
			System.err.println("Error: " + e.toString());
		}
	}
	
	/**
	 * deserializes an Automotive from the filename passed
	 * @param serfilename
	 * @return
	 */
	public Automotive deserializeAuto(String serfilename)
	{
		try
		{
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(serfilename));
			return (Automotive)input.readObject();
		}
		catch(Exception e)
		{
			System.err.println("Error: " + e.toString());
		}
		return new Automotive();
	}
	
}
