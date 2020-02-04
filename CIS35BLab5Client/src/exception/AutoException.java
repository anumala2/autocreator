package exception;

//must log exceptions in some kind of output .txt file
//raise 5 exceptions (instantiate an exception)
//fix 1 exception (call fix() method)

/**
 * The AutoException class aims to implement self-healing
 * code into the program, allowing the code to solve its
 * own problems, specifically crafted for the UpdateAuto
 * interface methods.
 * @author Aadithya Anumala
 *
 */
public class AutoException extends Exception
{
	/**
	 * the error ID for specific exception
	 */
	private int errorno;
	
	/**
	 * creates an AutoException
	 * @param errorno
	 */
	public AutoException(int errorno)
	{
		super();
		this.setErrorno(errorno);
		//printmyproblem(errorno);
		//fix(errorno);
	}
	
	/**
	 * prints out the problem for the user to
	 * understand specifically why the exception was
	 * thrown.
	 * @param x
	 */
	public void printmyproblem(int x)
	{
		switch(x)
		{
			case 1:
				AEHelper h = new AEHelper();
				h.print();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
		}
	}
	
	/**
	 * Uses a swtich-case block to fix the problems
	 * that are presented in the problem, with these
	 * error IDs corresponding with these problems in
	 * the UpdateAuto interface.
	 * 1 - null OptionSet name
	 * 2 - null Option name
	 * 3 - null OptionSet index
	 * 4 - null Option indices
	 * 5 - null OptionSet size
	 * @param x
	 */
	public void fix(int x)
	{
		switch(x)
		{
			case 1:
				AEHelper h = new AEHelper();
				h.fixName();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
		}
		
	}

	/**
	 * @return error number
	 */
	public int getErrorno() {
		return errorno;
	}

	/**
	 * sets error number
	 * @param errorno
	 */
	public void setErrorno(int errorno) {
		this.errorno = errorno;
	}
}