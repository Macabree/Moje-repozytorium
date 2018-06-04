package interfejsy_dziedziczenie;

public class Lion extends Animal implements Carnivore
{
	public Lion()
	{
		super();
	}

	public Lion(String name)
	{
		super(name);
	}

	public void eatMeat(double weight)
	{
		eat(weight);
	}
}
