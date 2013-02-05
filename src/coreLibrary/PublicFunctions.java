package coreLibrary;

public class PublicFunctions
{	
	/**
	 * Tests if a string is an integer
	 * @param s
	 * @return true or false whether the string is an integer
	 */
	//TODO there is a better way to do this. Needs to be implemented if numeric
	public static boolean isInteger(String s)
	{
		return s.matches("-?[0-9]+");
	}
	
	/**
	 * @param token
	 * @return True or false whether the string is a valid token
	 */
    public static boolean isValidToken(String token)
    {
        if
        (        
           token.equals("+") || 
           token.equals("-") || 
           token.equals("*") || 
           token.equals("/") ||
           token.equals("(") ||
           token.equals(")")
         ) 
         {
            return true;
         }
         return false;
    }
    
	/**
	 * For testing purposes
	 * @param args 
	 */
    public static void main(String[] args)
    {
		//TODO: Exception handling now causes an error... catch the error and report the error.
       System.out.println(isInteger("78888888888888888888888889999"));
    }
    
}
