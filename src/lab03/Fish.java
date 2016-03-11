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
	
	public String toStringWithSize()
	{
		return toString() + " (" + toSize() + ")";
	}
}
