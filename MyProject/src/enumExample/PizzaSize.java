package enumExample;

public enum PizzaSize
{
	XXL(60), M(40), S(30);

	private int diameter;

	private PizzaSize(int diameter)
	{
		this.diameter = diameter;
	}

	public int getDiameter()
	{
		return diameter;
	}

	public double getArea()
	{
		return Math.PI * Math.pow(diameter / 2, 2);
	}

}