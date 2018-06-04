package biblioteka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Biblioteka
{
	public static final String DRIVER = "org.sqlite.JDBC";

	public static final String URL = "jdbc:sqlite:biblioteka.db";

	private Connection connection;
	private Statement statement;

	public Biblioteka()
	{
		try
		{
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL);
			statement = connection.createStatement();

		} catch (ClassNotFoundException e)
		{
			System.err.println("Nie uda³o siê nawi¹zaæ po³¹czenia z baz¹ danych !\n");
		} catch (SQLException e)
		{
			System.err.println("Nie uda³o siê za³adowac sterownika JDBC !\n");
		}
		createTable();
	}

	public void createTable()
	{
		String createCzytelnicy = "CREATE TABLE IF NOT EXISTS czytelnicy(id_czytelnika INTEGER PRIMARY KEY AUTOINCREMENT, imie VARCHAR(20), nazwisko VARCHAR(20), login VARCHAR(10))";
		String createKsiazki = "CREATE TABLE IF NOT EXISTS ksiazki(id_ksiazki INTEGER PRIMARY KEY AUTOINCREMENT, tytul VARCHAR(20), autor VARCHAR(20), czyJest BOOLEAN)";
		String createWypozyczenia = "CREATE TABLE IF NOT EXISTS wypozyczenia(id_wypozycz INTEGER PRIMARY KEY AUTOINCREMENT, id_czytelnika INTEGER, id_ksiazki INTEGER)";
		try
		{
			statement.execute(createCzytelnicy);
			statement.execute(createKsiazki);
			statement.execute(createWypozyczenia);
			statement.close();
		} catch (SQLException e)
		{
			System.err.println("B³¹d przy tworzeniu tabel !\n");
		}
	}

	public void insertCzytelnik(String imie, String nazwisko, String login)
	{
		try
		{
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO czytelnicy VALUES(NULL, ?, ?, ?)");
			preparedStatement.setString(1, imie);
			preparedStatement.setString(2, nazwisko);
			preparedStatement.setString(3, login);
			preparedStatement.execute();
			preparedStatement.close();
			System.out.println("\nCzytelnik dodany !\n");
		} catch (SQLException e)
		{
			System.err.println(e);
		}
	}

	public void insertKsiazka(String tytul, String autor)
	{
		try
		{
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO ksiazki VALUES(NULL, ?, ?, true)");
			preparedStatement.setString(1, tytul);
			preparedStatement.setString(2, autor);
			preparedStatement.execute();
			preparedStatement.close();
			System.out.println("\nKsi¹¿ka dodana !\n");
		} catch (SQLException e)
		{
			System.err.println("B³¹d przy wstawianiu ksi¹¿ki !\n");
		}
	}

	public boolean ksiêgozbiór()
	{
		try
		{
			ResultSet resultset = statement
					.executeQuery("SELECT id_ksiazki, tytul, autor FROM ksiazki WHERE czyJest=TRUE");
			if (resultset.next() == false)
			{
				System.out.println("Brak ksi¹¿ek w ksiêgozbiorze !\n");
				return false;
			}
			while (resultset.next())
			{
				System.out.print("ID = " + resultset.getInt("id_ksiazki") + "\n" + "Tytul = "
						+ resultset.getString("tytul") + " \n" + "Autor = " + resultset.getString("autor"));
				System.out.println("\n");
			}
			System.out.println();
			resultset.close();
			return true;
		} catch (SQLException e)
		{
			System.err.println("Problem z wyœwietleniem danych !\n");
			return false;
		}
	}

	public void listaCzytelnikow()
	{
		try
		{
			ResultSet resultset = statement.executeQuery("SELECT * FROM czytelnicy");
			if (resultset.next() == false)
			{
				System.out.println("Brak czytelników !\n");
				// return false;
			}
			while (resultset.next())
			{
				System.out.print("ID = " + resultset.getInt("id_czytelnika") + "\n" + "Imiê = "
						+ resultset.getString("imie") + " \n" + "Nazwisko = " + resultset.getString("nazwisko") + " \n"
						+ "Login = " + resultset.getString("login"));
				System.out.println("\n");
			}
			resultset.close();
			// return true;
		} catch (SQLException e)
		{
			System.err.println("Problem z wyœwietleniem danych !\n");
			// return false;
		}
	}

	public boolean listaWypozyczonychKsiazek()
	{
		try
		{
			ResultSet resultSet = statement
					.executeQuery("SELECT id_ksiazki, tytul, autor FROM ksiazki WHERE czyJest = false");
			if (resultSet.next() == false)
			{
				System.out.println("Brak wypo¿yczonych ksi¹¿ek !");
				return false;
			}
			while (resultSet.next())
			{
				System.out.println(resultSet.getInt("id_ksiazki") + " " + resultSet.getString("tytul") + " - "
						+ resultSet.getString("autor"));
			}
			System.out.println();
			resultSet.close();
			return true;
		} catch (SQLException e)
		{
			System.err.println("B³¹d z wyœwietleniem wypo¿yczonych ksi¹¿ek!\n");
			return false;
		}
	}

	public void wypozyczKsiazke(int idczytelnika, int idksiazki)
	{
		try
		{
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE ksiazki set czyJest = ? where id_ksiazki = ?");
			preparedStatement.setBoolean(1, false);
			preparedStatement.setInt(2, idksiazki);
			preparedStatement.execute();
			preparedStatement.close();
			System.out.println("Mi³ego czytania !\n");
		} catch (SQLException e)
		{
			System.err.println("Wyst¹pi³ problem z operacj¹ wypo¿yczenia !\n");
			System.err.println(e);
		}

	}

	public void oddajKsiazke(int idksiazki)
	{
		try
		{
			PreparedStatement operation1 = connection
					.prepareStatement("UPDATE ksiazki SET czyJest = ? WHERE id_ksiazki= ?");
			operation1.setBoolean(1, true);
			operation1.setInt(2, idksiazki);
			operation1.execute();
			operation1.close();
			PreparedStatement operation2 = connection.prepareStatement("DELETE from wypozyczenia where id_ksiazki = ?");
			operation2.setInt(1, idksiazki);
			operation2.execute();
			operation2.close();
			System.out.println("Dziêkujemy za oddanie ksi¹¿ki !");
		} catch (SQLException e)
		{
			System.err.println("Wyst¹pi³ problem z operacj¹ oddawania !\n");
		}
	}

	public void usunTabele()
	{
		try
		{
			String usunCzytelnikow = "DROP TABLE czytelnicy";
			String usunKsiazki = "DROP TABLE ksiazki";
			statement.execute(usunCzytelnikow);
			statement.execute(usunKsiazki);

			statement.close();
			System.out.println("Operacja usuwania powiod³a siê!\n");
		} catch (SQLException e)
		{
			System.err.println("Operacja usuwania nie powiod³a siê!\n");
			System.err.println(e);
		}
	}

	public void closeConnection()
	{
		try
		{
			connection.close();
		} catch (SQLException e)
		{
			System.err.println("Problem z zamkniêciem po³¹czenia !\n");
		}
	}
}
