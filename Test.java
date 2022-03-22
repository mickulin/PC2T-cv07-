import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

import java.io.File;  // Import the File class
import java.io.IOException;


public class Test {



	public static int pouzeCelaCisla(Scanner sc) 
	{
		int cislo = 0;
		try
		{
			cislo = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cele cislo ");
			sc.nextLine();
			cislo = pouzeCelaCisla(sc);
		}
		return cislo;
	}
	
	
	
	public static void main(String[] args) throws IOException, prumerException {	
		Scanner sc=new Scanner(System.in);
		Databaze mojeDatabaze=new Databaze();
		int idx;
		float prumer;
		int rok;
		String jmeno;
		String volba;
		boolean run=true;		
		boolean databaze_existuje = false;
		while(run)
		{
			System.out.println("-------------Menu---------------");
			System.out.println("Vyberte pozadovanou cinnost:");
			System.out.println("1 .. vlozeni noveho studenta");
			System.out.println("2 .. nastaveni prumeru studenta");
			System.out.println("3 .. vypis informace o studentovi");
			System.out.println("4 .. Odstraneni studenta");
			System.out.println("5 .. Vypis studentu ");
			System.out.println("6 .. ukonceni aplikace (exit)");
			System.out.println("---------------------------------");
			System.out.print("Volba: ");
			volba = sc.next();		
			
			switch(volba)
			{
				case "1":
					
					System.out.println("Zadejte jmeno,rok");
					jmeno = sc.next();
					rok = sc.nextInt();
					if (mojeDatabaze.setStudent(jmeno,rok) == false)
					{
						System.out.println("Student jiz existuje");
					}
				
					break;
					
				case "2":
					
					System.out.println("Zadejte prumer a jmeno stundeta, kterému chcete prumer priradit: ");
					jmeno= sc.next();
					prumer = sc.nextFloat();
					if (mojeDatabaze.setPrumer(jmeno, prumer) == false)
					{
						System.out.println("Prumer nelze nastavit");
					}
						

					break;
					
					
				case "3":
					System.out.println("Zadejte jmeno studenta: ");
					jmeno = sc.next();
					Student info = null;
					info=mojeDatabaze.getStudent(jmeno);
					if (info != null)
					{
						System.out.println("Jmeno: " + info.getJmeno() + " | rok narozeni: " + info.getRocnik() + " | prumer: " + info.getStudijniPrumer());
					}
					else
					{
						System.out.println("Nelze,chyba");
					}
					break;
					
					
				case "4":
				{
					System.out.println(("Jmeno studenta k odstraneni: "));
					jmeno = sc.next();
					if (mojeDatabaze.vymazStudenta(jmeno) == true)
					{
						System.out.println(jmeno + " je odstranen");
					}
					else
					{
						System.out.println("Uzivatel: " + jmeno + " neni v databazi. ");
					}
					break;
				}
				case "5":
				{
					mojeDatabaze.VypisDatabaze();
					break;
				}

				case "exit":
				{
					run = false;
					break;
				}
						
				case "7":
				{
					run = false;
					break;
				}
				default:
				{
					System.out.println("Neplatna volba");
					break;
				}
					
				
			}
			
		}
	}

}
