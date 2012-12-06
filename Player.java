public class Player
{
  String pFirst;
	String pLast;
	String team;
	int pGames;
	int pPts;
	double pPpg;
	double pApg;
	double pSpg;
	double pRpg;
	double pThreePct;
	int year;
	

	public Player (String f, String l, String t, int g, int pts, double p, double a, double s, double r, double three, int y)
	{
		pFirst = f;
		pLast = l;
		team = t;
		pGames = g;
		pPts = pts;
		pPpg = p;
		pRpg = r;
		pSpg = s;
		pRpg = r;
		pThreePct = three;
		year = y;
	}


	public String getName() { return pLast + ", " + pFirst;}
	
	public String getTeam() { return team;}
	
	public int getpPts() { return pPts;}


	public String getpFirst() {
		return pFirst;
	}


	public String getpLast() {
		return pLast;
	}


	public int getpGames() {
		return pGames;
	}


	public double getpPpg() {
		return pPpg;
	}


	public double getpApg() {
		return pApg;
	}


	public double getpSpg() {
		return pSpg;
	}


	public double getpRpg() {
		return pRpg;
	}


	public double getpThreePct() {
		return pThreePct;
	}


	public int getYear() {
		return year;
	}


	public String toString()
	{
		return pLast + ", " + pFirst + " of " + team + " scored " + pPpg + " points per game on " + pRpg + " rebounds per game.";
	}
}