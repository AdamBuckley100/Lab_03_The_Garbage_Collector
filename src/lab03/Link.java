package lab03;

public class Link {
	
	private Fish from;
	private Fish to;
	
	public Link(Fish from, Fish to)
	{
		this.from = from;
		this.to = to;
	}
	
	public String toString()
	{
		if (from == null)
		{
			return "variable -> " + to.toString();
		}
		else
		{
			return from.toString() + " ---> " + to.toString();
		}
	}
}
