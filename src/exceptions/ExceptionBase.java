package exceptions;


//TODO: Ability to get stacktrace
//TODO: Further review on if this is a good way of handling things.
public class ExceptionBase extends Exception 
{	
	public ExceptionBase(String message) 
	{
		super(message);
	}
	
	@Override
	public String toString()
	{
		return this.getMessage();
	}
}
