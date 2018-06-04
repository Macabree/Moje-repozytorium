package interfejsy_dziedziczenie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZooApplication
{

	public static void main(String[] args)
	{
		Elephant elephant1 = new Elephant("Dumbo");
		Elephant elephant2 = new Elephant("Zygfryd");
		elephant1.eatPlant(100);
		elephant1.growOld(1);

		Lion lion1 = new Lion("Simba");
		Lion lion2 = new Lion("Mufasa");
		lion1.eat(10);
		lion1.growOld(1);
		lion1.eatMeat(10);

		List<Animal> animals = new ArrayList<>();
		animals.add(lion1);
		animals.add(lion2);
		animals.add(elephant2);
		animals.add(elephant1);
		List<Herbivore> herbivores = new ArrayList<>();
		herbivores.add(elephant1);
		herbivores.add(elephant2);
		List<Carnivore> carnivores = new ArrayList<>();
		carnivores.add(lion1);
		carnivores.add(lion2);

		// System.out.print("Liczba zwierz�t: " + animals.size());
		// System.out.println("Zwierz�ta: " + animals);
		// System.out.print("\nLiczba ro�lino�erc�w: " + herbivores.size());
		// System.out.println("ro�lino�ercy: " + herbivores);
		Iterator<Animal> i = animals.iterator();
		while (i.hasNext())
		{
			System.out.println(i.next());
		}
	}

}
