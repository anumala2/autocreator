package adapter;

/**
 * The interface CreateAuto serves as an API for methods that
 * allow class BuildAuto to create an Automotive
 * @author Aadithya Anumala
 *
 */
public interface CreateAuto 
{
	/**
	 * Builds an Automotive from a file (provided by its filename).
	 * @param filename
	 */
	public void buildAuto(String filename);
	
	/**
	 * Prints out the Automotive..
	 */
	public void printAuto();
}
