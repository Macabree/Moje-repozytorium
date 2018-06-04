package interfejsy_dziedziczenie;

public class Elephant extends Animal implements Herbivore
{
	public Elephant()
	{
		super();
	}

	public Elephant(String name)
	{
		super(name);
	}

	public void eatPlant(double weight)
	{
		eat(weight);
	}
}
