import java.util.*;
import java.io.File;

public class PlayerArray
{

  Player[] pl;
	int n;
	final int maxRecords = 100000;

	public PlayerArray()
	{
		pl = new Player[maxRecords];
		readFile();
	}

	public void readFile()
	{
		try {
			
			Scanner sc = new Scanner(new File("myNBAdata.txt"));
			int i = 0;

			while (sc.hasNext())
			{
				String s = sc.nextLine();
				String[] sd = s.split(",");
				pl[i] = new Player(sd[0], sd[1], sd[2], Integer.parseInt(sd[3]),
						Integer.parseInt(sd[4]), Double.parseDouble(sd[5]), Double.parseDouble(sd[6]), 
								Double.parseDouble(sd[7]), Double.parseDouble(sd[8]), Double.parseDouble(sd[9])
								, Integer.parseInt(sd[10]));
				i++;
			}
			n = i;
		} catch (Exception e) {
			System.out.println("Exception with PlayerArray readFile");
		}
	}

	public double totalTeamScoring(String t)
	{
		int total = 0;
		for(int i=0; i<n; i++)
		{
			if(pl[i].getTeam().equalsIgnoreCase(t))
				total += pl[i].getpPts();
		}
		return total;
	}


	

	public String listPlayerScoring(String fname, String lname)
	{
		String s = "";
		
		for (int i=0; i< n; i++)
			if (fname.equalsIgnoreCase(pl[i].getpFirst()) &&
				lname.equalsIgnoreCase(pl[i].getpLast()))
					System.out.println(pl[i]);

		return s;
	}

	public void sortByName()
	{
		Arrays.sort(pl,0,n, new SortByName());
	}
public void sortByTeam() 
	{
		// Sorts Players by teams
		Arrays.sort(pl,0,n, new SortByTeam());
	}

	public void sortByPoints()
	{
		Arrays.sort(pl,0,n, new SortByPoints());
	}

	public void sortByYearsPlayed()
	{
		Arrays.sort(pl,0,n, new SortByYearsPlayed());
	
	}
	
	public String getTeamCon(String con)
	{
		String w = "", e = "";
		for(int i = 0; i < n;i++)
		{
			if(con.equals("Western Conference"))
			{
				if(pl[i].getTeam().equals("OKC") || pl[i].getTeam().equals("DEN") || pl[i].getTeam().equals("MIN") || pl[i].getTeam().equals("UTA") || pl[i].getTeam().equals("POR"))
					w += pl[i].getName() + " of " + pl[i].getTeam() + " has " + pl[i].getpPpg() + " points per game and " + pl[i].getpRpg() + " rebounds per game.\n";
				else if (pl[i].getTeam().equals("LAC") || pl[i].getTeam().equals("LAL") || pl[i].getTeam().equals("GSW") || pl[i].getTeam().equals("PHO") || pl[i].getTeam().equals("SAC"))
					w += pl[i].getName() + " of " + pl[i].getTeam() + " has " + pl[i].getpPpg() + " points per game and " + pl[i].getpRpg() + " rebounds per game.\n";
				else if(pl[i].getTeam().equals("MEM") || pl[i].getTeam().equals("SAS") || pl[i].getTeam().equals("HOU") || pl[i].getTeam().equals("DAL") || pl[i].getTeam().equals("NOH"))
					w += pl[i].getName() + " of " + pl[i].getTeam() + " has " + pl[i].getpPpg() + " points per game and " + pl[i].getpRpg() + " rebounds per game.\n";
				
			}
			else
			{
				if(pl[i].getTeam().equals("NYK") || pl[i].getTeam().equals("BKN") || pl[i].getTeam().equals("PHI") || pl[i].getTeam().equals("BOS") || pl[i].getTeam().equals("TOR"))
					e += pl[i].getName() + " of " + pl[i].getTeam() + " has " + pl[i].getpPpg() + " points per game and " + pl[i].getpRpg() + " rebounds per game.\n";
				else if (pl[i].getTeam().equals("MIL") || pl[i].getTeam().equals("IND") || pl[i].getTeam().equals("CHI") || pl[i].getTeam().equals("DET") || pl[i].getTeam().equals("CLE"))
					e += pl[i].getName() + " of " + pl[i].getTeam() + " has " + pl[i].getpPpg() + " points per game and " + pl[i].getpRpg() + " rebounds per game.\n";
				else if(pl[i].getTeam().equals("MIA") || pl[i].getTeam().equals("ATL") || pl[i].getTeam().equals("CHA") || pl[i].getTeam().equals("ORL") || pl[i].getTeam().equals("WAS"))
					e += pl[i].getName() + " of " + pl[i].getTeam() + " has " + pl[i].getpPpg() + " points per game and " + pl[i].getpRpg() + " rebounds per game.\n";
			
		    }
		}
	
		if(con.equals("Western Conference"))
		{
			return w;
		}
		else 
		{
			return e;
		}
	
	
	}
				
	
	public String getTeamDiv(String div) 
	{
		String a = "", sw = "", p = "", nw = "", c = "", se = "";
		
		for(int i = 0; i < n; i++)
		if(div.equals("Northwest Division"))
		{
			if(pl[i].getTeam().equals("OKC") || pl[i].getTeam().equals("DEN") || pl[i].getTeam().equals("MIN") || pl[i].getTeam().equals("UTA") || pl[i].getTeam().equals("POR"))
				nw += pl[i].getName() + " of " + pl[i].getTeam() + " has " + pl[i].getpPpg() + " points per game and " + pl[i].getpRpg() + " rebounds per game.\n";
		}
		else if(div.equals("Pacific Division"))
		{
			if(pl[i].getTeam().equals("LAC") || pl[i].getTeam().equals("LAL") || pl[i].getTeam().equals("GSW") || pl[i].getTeam().equals("PHO") || pl[i].getTeam().equals("SAC"))
				p += pl[i].getName() + " of " + pl[i].getTeam() + " has " + pl[i].getpPpg() + " points per game and " + pl[i].getpRpg() + " rebounds per game.\n";
		}
		else if(div.equals("Southwest Division"))
		{
			if(pl[i].getTeam().equals("MEM") || pl[i].getTeam().equals("SAS") || pl[i].getTeam().equals("HOU") || pl[i].getTeam().equals("DAL") || pl[i].getTeam().equals("NOH"))
				sw += pl[i].getName() + " of " + pl[i].getTeam() + " has " + pl[i].getpPpg() + " points per game and " + pl[i].getpRpg() + " rebounds per game.\n";
		}
		else if(div.equals("Atlantic Division"))
		{
			if(pl[i].getTeam().equals("NYK") || pl[i].getTeam().equals("BKN") || pl[i].getTeam().equals("PHI") || pl[i].getTeam().equals("BOS") || pl[i].getTeam().equals("TOR"))
				a += pl[i].getName() + " of " + pl[i].getTeam() + " has " + pl[i].getpPpg() + " points per game and " + pl[i].getpRpg() + " rebounds per game.\n";
		}
		else if(div.equals("Central Division"))
		{
			 if (pl[i].getTeam().equals("MIL") || pl[i].getTeam().equals("IND") || pl[i].getTeam().equals("CHI") || pl[i].getTeam().equals("DET") || pl[i].getTeam().equals("CLE"))
				c += pl[i].getName() + " of " + pl[i].getTeam() + " has " + pl[i].getpPpg() + " points per game and " + pl[i].getpRpg() + " rebounds per game.\n";
		}
		else
		{
			if(pl[i].getTeam().equals("MIA") || pl[i].getTeam().equals("ATL") || pl[i].getTeam().equals("CHA") || pl[i].getTeam().equals("ORL") || pl[i].getTeam().equals("WAS"))
				se += pl[i].getName() + " of " + pl[i].getTeam() + " has " + pl[i].getpPpg() + " points per game and " + pl[i].getpRpg() + " rebounds per game.\n";
		}
		
		if(div.equals("Northwest Division"))
		{
			return nw;
		}
		else if (div.equals("Atlantic Division"))
		{
			return a;
		}
		else if (div.equals("Southwest Division"))
		{
			return sw;
		}
		else if (div.equals("Pacific Division"))
		{
			return p;
		}
		else if (div.equals("Central Division"))
		{
			return c;
		}
		else
		{
			return se;
		}
	}
		
		
		public String get1Team(String tm) 
		{
			String t = "";
			
			for(int i = 0; i < n; i++)
			{
				if(pl[i].getTeam().equalsIgnoreCase(tm)) 
					t += pl[i].getName() + " of " + pl[i].getTeam() + " has " + pl[i].getpPpg() + " points per game and " + pl[i].getpRpg() + " rebounds per game.\n";
			}
			return t;
		}
			
		
		
		
	


	public String toString()
	{
		String s = "";

		for (int i=0; i<n; i++)
			s += pl[i] + "\n";

		return s;
	}

	public static void main(String[] args)
	{
		PlayerArray plle = new PlayerArray();
		plle.sortByName();
		System.out.println(plle);
	}

	public String yearDisplay() 
	{
		// A Special Output Method for Years Played
		String s = "";
		for(int i = 0; i < n; i++)
		{
			s += pl[i].getName() + " of " + pl[i].getTeam() + " has been in the NBA for " + pl[i].getYear() + ".\n";
		}
		return s;
	}

	public String pointDisplay() {
		// A Special Output Method for a players total career points
		String s = "";
		for(int i = 0; i < n; i++)
		{
			s += pl[i].getName() + " of " + pl[i].getTeam() + " has accumlated " + pl[i].getpPts() + " points.\n";
		}
		return s;
	}

}
	

class SortByName implements Comparator<Player>
{
	public int compare(Player s1, Player s2)
	{
		return s1.getName().compareTo(s2.getName());
	}
}

class SortByTeam implements Comparator<Player>
{
	public int compare(Player s1, Player s2)
	{
		return s1.getTeam().compareTo(s2.getTeam());
	}
}

class SortByPoints implements Comparator<Player>
{
	public int compare(Player s1, Player s2)
	{
		if (s1.getpPts() < s2.getpPts())
			return 1;
		else if (s1.getpPts() > s2.getpPts())
			return -1;
		else
			return 0;
	}
}

class SortByYearsPlayed implements Comparator<Player>
{
	public int compare(Player s1, Player s2)
	{
		if (s1.getYear() < s2.getYear())
			return 1;
		else if (s1.getYear() > s2.getYear())
			return -1;
		else
			return 0;
	}
}





