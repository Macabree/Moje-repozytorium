package enumExample;

public class Pizza
{
	private PizzaSize size;

	public Pizza(PizzaSize size)
	{
		this.size = size;
	}

	public void getData()
	{
		System.out.println("Pizza diameter: " + size.getDiameter());
	}

	public static void main(String[] args)
	{
		Pizza pizza = new Pizza(PizzaSize.M);
		pizza.getData();
	}
}
