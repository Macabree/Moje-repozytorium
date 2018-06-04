package paczka;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Kolekcje
{

	public static void List()
	{
		List<String> lista = new ArrayList<String>();

		lista.add("Kasia"); // Dodawanie element�w do listy
		lista.size(); // Wy�wietlenie rozmiaru listy
		lista.isEmpty(); // Sprawdzenie czy lista jest pusta
		lista.get(0); // Pobranie elementu o podanym indeksie
		lista.contains("Marek");// Sprawdzenie czy lista zawiera dany element
		lista.clear(); // Usuwanie zawarto�ci listy

	}

	public static void Set()
	{
		Set<Integer> set1 = new HashSet<Integer>();
		// HashSet to set zawieraj�cy unikalne + POMIESZANE warto�ci

		Set<Integer> set2 = new TreeSet<Integer>();
		// TreeSet to set zawieraj�cy unikalne + POSORTOWANE warto�ci

		Set<Integer> set3 = new LinkedHashSet<Integer>();
		// LinkedHashSet to set zawieraj�cy unikalne warto�ci + WY�WIETLONE W KOLEJNO�CI
		// DODAWANIA

		set1.add(5);
		set1.add(6); // W Secie mog� znajdowa� si� tylko unikalne warto�ci!
		set1.add(5);
		// Wynik programu: [5,6]

		// UWAGA!! Do setu nie mo�emy si� dosta� poprzez indeksowanie!!!
	}

	public static void Map()
	{
		// Mapy to kolekcje sk�adaj�ce si� z PARAMETRU i KLUCZA

		Map<String, Integer> oceny = new HashMap<>();

		oceny.put("Matematyka", 5);
		oceny.put("Fizyka", 4);
		oceny.put("Polski", 3);

		// {Matematyka=5, Polski=3, Fizyka=4}

		System.out.println(oceny.get("Matematyka"));

		for (String klucz : oceny.keySet())
			{
				System.out.println(oceny.get(klucz));
			}

	}

}