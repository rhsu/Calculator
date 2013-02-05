package exceptions;

//FIXME: This exception does not work correctly. See; Int a = 99999998988 a + a etc...
public class NumberOverflowException extends ExceptionBase 
{
	public NumberOverflowException()
	{
		super("Expression Overflow: Please Try Again with {Feature Coming Soon...}");
	}
}
