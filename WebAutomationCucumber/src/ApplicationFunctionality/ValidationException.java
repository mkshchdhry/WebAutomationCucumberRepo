package ApplicationFunctionality;

@SuppressWarnings("serial")
public class ValidationException extends Exception 
{
	String errMessage;
	ValidationException(String str2) 
	{
		errMessage=str2;
	}
	
	public String toString()
	{ 
		return ("Validation Exception Occurred: "+ errMessage);
	 }
}
