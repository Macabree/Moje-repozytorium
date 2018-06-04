package paczka;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Imiona
{
	public static Set<String> GetName()
	{
		Scanner scanner = new Scanner(System.in);
		Set<String> ListName = new TreeSet<String>();
		String Name = "";
		while (Name.equals("-") == false)
			{
				System.out.print("Podaj imiê: ");
				Name = scanner.nextLine();
				if (Name.equals("-"))
					{
						break;
					}
				ListName.add(Name);
			}
		scanner.close();
		return ListName;
	}

	public static void main(String[] args)
	{
		System.out.println("Wpisuj imiona. Koniec wpisywania po wpisaniu znaku '-'.\n");
		System.out.println("\nLista imion:\n" + GetName());
	}
}