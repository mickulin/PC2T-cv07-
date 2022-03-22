
public class Student
{
	private String jmeno;
	private int rocnik;
	private float studijniPrumer;
	
	public Student(String jmeno, int rocnik)
	{
		this.jmeno=jmeno;
		this.rocnik=rocnik;
	}
	
	public String getJmeno()
	{
		return jmeno;
	}
	
	public int getRocnik()
	{
		return rocnik;
	}
	
	public float getStudijniPrumer() throws prumerException
	{
		if (studijniPrumer < 0 || studijniPrumer == 0)
		{
			throw new prumerException();
		}
		return studijniPrumer;
	}

	public boolean setStudijniPrumer(float studijniPrumer) throws prumerException
	{
		if (studijniPrumer < 1 || studijniPrumer > 5)
		{
			System.out.println("Zadej prumer ve spravnem rozsahu (1-5)");
			return false;
		}
		else
		{
			this.studijniPrumer = studijniPrumer;
			return true;
		}
		
	}


}
