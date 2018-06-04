package paczka;

public class Static
{
	private String firstName;
	private String lastName;
	private static int ID = 1;

	public Static(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		int memberID = ID++;
		System.out.printf("First Name: %s%n LastName: %s%n Number of member: %d%n%n", firstName, lastName, memberID);
	}

	public static void main(String[] args)
	{
		Static member1 = new Static("Karolina", "Dzika");
		Static member2 = new Static("Adrian", "Fajny");

		System.out.println(Static.getSomeInt(5)); // przy metodach STATYCZNYCH nie trzeba tworzyæ nowych obiektów!
	}

	public static int getSomeInt(int a)
	{
		return ID + a;
	}
}
