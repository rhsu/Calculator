package exceptions;
//REFERENCES: 
//http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Thread.html#setDefaultUncaughtExceptionHandler%28java.lang.Thread.UncaughtExceptionHandler%29
//http://docs.oracle.com/javase/1.5.0/docs/api/java/lang/Thread.UncaughtExceptionHandler.html
//http://www.nomachetejuggling.com/2006/06/13/java-5-global-exception-handling/
//http://docs.oracle.com/javase/6/docs/api/java/util/logging/Logger.html
//http://www.vogella.com/articles/Logging/article.html

public class ExceptionHandler 
{
		public static void main(String[] args) throws Exception
		{
			Handler handler = new Handler();
			Thread.setDefaultUncaughtExceptionHandler(handler);
			
			//Thread t = new Thread(new SomeThread(), "Some Thread");
			//t.start();
			
			//Thread.sleep(1000);
			
            int i = 1/0;
            
            System.out.println("here");
			//throw new RuntimeException("Thrown from main");
		}
}	
		
class Handler implements Thread.UncaughtExceptionHandler
{
    @Override
	public void uncaughtException(Thread t, Throwable e)
	{
		//System.out.println("Throwable: " + e.getMessage());
		System.out.println(t.toString());
        
	}
}		

/*class SomeThread implements Runnable
{
    @Override
	public void run()
	{
		throw new RuntimeException("Thrown from Thread");
	}
}*/

