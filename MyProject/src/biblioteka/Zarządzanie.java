package biblioteka;

import java.util.Scanner;

public class Zarz�dzanie
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		Scanner w = new Scanner(System.in);
		Biblioteka biblioteka = new Biblioteka();
		boolean przerwij = false;
		do
		{
			try
			{
				System.out.println("1) Dodaj czytelnika");
				System.out.println("2) Dodaj ksi��k�");
				System.out.println("3) Wypo�ycz ksi��k�");
				System.out.println("4) Oddaj ksiazk�");
				System.out.println("5) Poka� ksi�gozbi�r");
				System.out.println("6) Poka� list� czytelnik�w");
				System.out.println("7) Poka� list� wypo�ycze�");
				System.out.println("8) Wyj�cie");
				char wyb�r = w.next().charAt(0);
				switch (wyb�r)
				{
				case 49:
				{
					System.out.print("Imi�: ");
					String imie = scanner.nextLine();
					System.out.print("Nazwisko: ");
					String nazwisko = scanner.nextLine();
					System.out.print("Login: ");
					String login = scanner.nextLine();
					biblioteka.insertCzytelnik(imie, nazwisko, login);
				}
					break;
				case 50:
				{
					System.out.print("Tytu�: ");
					String tytul = scanner.nextLine();
					System.out.print("Autor: ");
					String autor = scanner.nextLine();
					biblioteka.insertKsiazka(tytul, autor);
				}
					break;
				// case 51:
				// {
				// if (biblioteka.listaCzytelnikow() == true)
				// {
				// System.out.println("Znajdz czytelnika:\n");
				// int idczytelnika = scanner.nextInt();
				// if (biblioteka.ksi�gozbi�r() == true)
				// {
				// System.out.println("\nJaka ksi��ka Ci� interesuje?\n");
				// int idksiazki = scanner.nextInt();
				// biblioteka.wypozyczKsiazke(idczytelnika, idksiazki);
				// scanner.nextLine();
				// }
				// }
				//
				// }
				// break;
				case 52:
				{
					if (biblioteka.listaWypozyczonychKsiazek() == true)
					{
						System.out.println("\nJak� ksi��k� wypo�yczy�e�?\n");
						int idksiazki = scanner.nextInt();
						biblioteka.oddajKsiazke(idksiazki);
						scanner.nextLine();
					}
				}
				case 53:
				{
					biblioteka.ksi�gozbi�r();
				}
					break;
				case 54:
				{
					biblioteka.listaCzytelnikow();
				}
					break;
				case 55:
				{
					System.out.println("Nied�ugo tu pojawi sie kod!\n");
				}
					break;
				case 56:
				{
					System.out.println("Zamykanie po��czenia z baz�...");
					System.out.println("Mi�ego dnia !");
					biblioteka.closeConnection();
					przerwij = true;
				}
					break;
				case 100:
				{
					biblioteka.usunTabele();
				}
					break;
				default:
				{
					System.out.println("Nie ma takiej opcji !");
					w.nextLine();
				}
				}
			} catch (Exception e)
			{
				System.err.println("B��dne dane !");
				w.nextLine();
			}
		} while (przerwij == false);
		scanner.close();
		w.close();
	}
}
