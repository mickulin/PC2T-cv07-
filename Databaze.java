import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.lang.model.util.ElementScanner14;

import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;

public class Databaze 
{
	Databaze()
	{
		prvkyDatabaze = new HashMap<String,Student>();
	}
	private Scanner sc;
	private int posledniStudent;
	private Map<String,Student> prvkyDatabaze;
	
	public  static String spouzeString(Scanner sc) 
	{
		String c;
		try
		{
			c = sc.next();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte platne jmeno. ");
			sc.nextLine();
			c = spouzeString(sc);
		}
		return c;
	}
	
	
	
	public boolean setStudent(String jmeno,int rok) 
	{
		
		if (prvkyDatabaze.put(jmeno,new Student(jmeno,rok)) == null)
		{
				return true;
		}
		else
		{
			return false;
		}
	}
	
	public Student getStudent(String jmeno)
	{
		return prvkyDatabaze.get(jmeno);
	}
	
	public boolean setPrumer(String jmeno, float prumer) throws prumerException
	{
		if (prvkyDatabaze.get(jmeno) == null)
		{
			return false;
		}
		else
		{
			return prvkyDatabaze.get(jmeno).setStudijniPrumer(prumer);
		}
	}

	public boolean vymazStudenta(String jmeno)
	{
		if (prvkyDatabaze.remove(jmeno) == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
	
	public void VypisDatabaze() throws prumerException
	{
		Set<String> seznamJmen = prvkyDatabaze.keySet();

		for (String jmeno:seznamJmen)
		{
			System.out.println(jmeno);
		}
		
	}


		
		
	


}