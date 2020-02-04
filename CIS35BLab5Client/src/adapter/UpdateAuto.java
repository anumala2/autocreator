package adapter;

/**
 * The interface UpdateAuto serves as an API for methods that
 * allow class BuildAuto to update elements of an Automotive
 * @author Aadithya Anumala
 *
 */
public interface UpdateAuto 
{
	/**
	 * Updates a specified Option
	 * @param inds
	 * @param n
	 * @param p
	 */
	public void updateOption(int[] inds, String n, int p);
	
	/**
	 * Updates a specified OptionSet
	 * @param inds
	 * @param n
	 * @param p
	 */
	public void updateOptionSet(int ind, String n, int s);
}
