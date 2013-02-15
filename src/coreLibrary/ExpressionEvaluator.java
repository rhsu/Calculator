package coreLibrary;

import coreLibrary.Enums.ExpressionFormat;
import coreLibrary.Enums.Radix;
import exceptions.DivideByZeroException;
import exceptions.NumberOverflowException;
import java.math.BigInteger;
import java.util.LinkedList;

public class ExpressionEvaluator 
{
	/**
	 * Initializes the expression evaluator with default settings (Integer and Decimal)
	 */
    public ExpressionEvaluator()
    {
		radix = Radix.DECIMAL;
		format = ExpressionFormat.INTEGER;
        expression = new LinkedList<String>();
        stack = new LinkedList<String>(); 
    }
	
	/**
	 * Test constructor
	 * @param radix		set a radix
	 * @param format	set a format
	 */
	public ExpressionEvaluator(Radix radix, ExpressionFormat format)
	{
		this.radix = radix;
		this.format = format;
		expression = new LinkedList<String>();
        stack = new LinkedList<String>(); 
	}
	
	/**
	 * Sets the expression to be evaluated
	 * @param	expressionString the expression to set
	 */
    public void SetExpression(String expressionString)
    {
        expression = ShuntingYard.getList(expressionString);
    }
    
	/**
	 * @param radix		The radix to be set
	 */
	public void SetRadix(Radix radix)
	{
		this.radix = radix;
	}
	
	/**
	 * @param format	The format to be set
	 */
	public void SetFormat(ExpressionFormat format)
	{
		this.format = format;
	}
	
	/**
	 * clears the expression
	 */
    public void ClearExpression()
    {
        expression.clear();
    }
    	
	private String GetValue(String a, String b, String operator) throws Exception
	{		
		switch(format)
		{
			case INTEGER:
			{
				int result = 0;
				
				if(operator.equals("+"))
				{
					result = Integer.parseInt(b, radix.GetIndex()) + Integer.parseInt(a, radix.GetIndex());
				}
				else if (operator.equals("-"))
				{
					result = Integer.parseInt(b, radix.GetIndex()) - Integer.parseInt(a, radix.GetIndex());
				}
				else if (operator.equals("*"))
				{					
					result = Integer.parseInt(b, radix.GetIndex()) * Integer.parseInt(a, radix.GetIndex());
				}
				else if (operator.equals("/"))
				{
					try
					{
					result = Integer.parseInt(b, radix.GetIndex()) / Integer.parseInt(a, radix.GetIndex());
					}
					catch(Exception e)
					{
						throw new DivideByZeroException();
					}
				}
				
				return Integer.toString(result);
			}
			
			case BIGINTEGER:
			{
				BigInteger result = new BigInteger(b, radix.GetIndex());
				
				if(operator.equals("+"))
				{
					result = result.add(new BigInteger(a, radix.GetIndex()));
				}
				else if (operator.equals("-"))
				{
					result = result.subtract(new BigInteger(a, radix.GetIndex()));
				}
				else if (operator.equals("*"))
				{					
					result = result.multiply(new BigInteger(a, radix.GetIndex()));
				}
				else if (operator.equals("/"))
				{
					result = result.divide(new BigInteger(a, radix.GetIndex()));
				}
				
				return result.toString();
			}
			default:
			{
				return "SHOULD NOT GET HERE";
			}
			//case BIGDECIMAL:
			//case DECIMAL:
		}

	}
		
	/**
	 * Evaluates the expression
	 * @return The result of the evaluated expression as a string
	 * @throws Exception	a number overflow expression or a divide by zero expression
	 */
    public String evaluate() throws Exception
    {
        while(!expression.isEmpty())
		{
			String top = expression.pop();
		
			if(PublicFunctions.isInteger(top))
			{
				stack.push(top);
			}
			
			else
			{
				String val = "0";
				String a;
				String b;
			
				try
				{
					a = stack.pop();
					b = stack.pop();
					val = GetValue(a,b,top);
				}
				catch(Exception e)
				{
					throw new NumberOverflowException();
				}
				stack.push(val);
			}			
		}
        return stack.pop();
    }
    
	/**
	 * For testing use only
	 * @param args 
	 */
    public static void main(String[] args)
    {
        ExpressionEvaluator myproj = new ExpressionEvaluator(Radix.BINARY, ExpressionFormat.BIGINTEGER);
		//ExpressionEvaluator myproj = new ExpressionEvaluator();
        myproj.SetExpression(Constants.TESTSTRING3);
        try
        {
            System.out.println(myproj.evaluate());
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }
    
	/**
	 * A linked list representing the expression to be evaluated
	 */
    private LinkedList<String> expression;
	/**
	 * The stack for computing the expression
	 */
	private LinkedList<String> stack;
	
	/**
	 * The radix to use
	 */
	private Radix radix;
	/**
	 * The format of the expression: Either BigInteger, BigDecimal, Integer, or Decimal
	 */
	private ExpressionFormat format;
}
