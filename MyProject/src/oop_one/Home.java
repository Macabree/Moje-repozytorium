package oop_one;

public class Home
{
	public static void main(String[] args)
	{
		TV one = new TV();
		TV two = new TV(32, "Philips");

		System.out.println("Rozmiar: " + one.getSize() + "\n" + "Nazwa: " + one.getName());
		System.out.println("Rozmiar: " + two.getSize() + "\n" + "Nazwa: " + two.getName());
		one.getOnOff();
		one.SetOnOff(true);
		one.getOnOff();

		Dog rex = new Dog();

		rex.speak();
		rex.setSize(10);
		System.out.println(rex.getSize());

	}
}
