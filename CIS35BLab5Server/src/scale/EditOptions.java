package scale;
import model.*;

/**
 * class meant for the editing of options in a multithreaded fashion
 * @author aadianumala
 *
 */
public class EditOptions
{
	Helper help;
	
	/**
	 * constructs an EditOptions
	 */
	public EditOptions()
	{
		help = new Helper();
	}
	
	/**
	 * edits a specified option in a given Automotive
	 * @param sync
	 * @param auto
	 * @param name
	 * @param nN1
	 * @param nn2
	 */
	public void editOption(boolean sync, Automotive auto, String name, String nN1, String nn2)
	{
		if(sync)
		{
			help.editSync(auto, name, nN1, nn2);
		}
		else
		{
			help.editUnSync(auto, name, nN1, nn2);
		}
	}
}
