package lab03;

public class Fish {

	public String toString()
	{
		return "fish";
	}
	
	public int toSize()
	{
		return -1;
	}
	
	/**
	 * Appropraite class specifications apply to this method.
	 * @return
	 */
	public String toStringWithSize()
	{
		return toString() + " (" + toSize() + ")";
	}
}
