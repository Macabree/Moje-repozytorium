package oop_one;

public class TV
{
	private int size;
	private String name;
	private boolean OnOff;

	public TV()
	{
		this.name = "Brak danych";
	}

	public TV(int size, String name)
	{
		this.size = size;
		this.name = name;
	}

	public int getSize()
	{
		return size;
	}

	public String getName()
	{
		return name;
	}

	public void SetOnOff(boolean a)
	{
		this.OnOff = a;
	}

	public void getOnOff()
	{
		if (OnOff)
			{
				System.out.println("TV is On");
			} else
			{
				System.out.println("TV is Off");
			}
	}
}
