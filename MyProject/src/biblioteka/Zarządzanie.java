package biblioteka;

import java.util.Scanner;

public class Zarz¹dzanie
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
				System.out.println("2) Dodaj ksi¹¿kê");
				System.out.println("3) Wypo¿ycz ksi¹¿kê");
				System.out.println("4) Oddaj ksiazkê");
				System.out.println("5) Poka¿ ksiêgozbiór");
				System.out.println("6) Poka¿ listê czytelników");
				System.out.println("7) Poka¿ listê wypo¿yczeñ");
				System.out.println("8) Wyjœcie");
				char wybór = w.next().charAt(0);
				switch (wybór)
				{
				case 49:
				{
					System.out.print("Imiê: ");
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
					System.out.print("Tytu³: ");
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
				// if (biblioteka.ksiêgozbiór() == true)
				// {
				// System.out.println("\nJaka ksi¹¿ka Ciê interesuje?\n");
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
						System.out.println("\nJak¹ ksi¹¿kê wypo¿yczy³eœ?\n");
						int idksiazki = scanner.nextInt();
						biblioteka.oddajKsiazke(idksiazki);
						scanner.nextLine();
					}
				}
				case 53:
				{
					biblioteka.ksiêgozbiór();
				}
					break;
				case 54:
				{
					biblioteka.listaCzytelnikow();
				}
					break;
				case 55:
				{
					System.out.println("Nied³ugo tu pojawi sie kod!\n");
				}
					break;
				case 56:
				{
					System.out.println("Zamykanie po³¹czenia z baz¹...");
					System.out.println("Mi³ego dnia !");
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
				System.err.println("B³êdne dane !");
				w.nextLine();
			}
		} while (przerwij == false);
		scanner.close();
		w.close();
	}
}
