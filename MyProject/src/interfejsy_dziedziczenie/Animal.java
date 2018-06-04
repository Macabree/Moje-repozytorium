package interfejsy_dziedziczenie;

public class Animal
{
	private String name;
	private double weight;
	private int age;

	public Animal()
	{
	}

	public Animal(String name)
	{
		this.name = name;
	}

	public void growOld(int age)
	{
		this.age += age;
	}

	public void eat(double weight)
	{
		this.weight += 3 / 4 * weight;
	}

	public String toString()
	{
		return "Name: " + this.name;
	}
}
