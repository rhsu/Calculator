package exceptions;

public class DivideByZeroException extends ExceptionBase
{	
	public DivideByZeroException()
	{
		super("ERROR: Cannot divide by 0");
	}
}