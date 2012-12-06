import java.util.*;

public class PlayerApp
{
  PlayerArray playerData;
	Scanner sc = new Scanner(System.in);

	public PlayerApp()
	{
		playerData = new PlayerArray();
		displayMenu();
	}

	public void displayMenu()
	{
		String choice = "-1";

		while(!choice.equals("0"))
		{
			System.out.println("0 = Exit");
			System.out.println("1 = Display All");
			System.out.println("2 = S");
			System.out.println("3 = Total Sales for Given Year");
			System.out.println("11= List Player's Carrer Scoring");
			System.out.print("Enter number of choice: ");
			choice = sc.nextLine();

			if (choice.equals("1"))
				System.out.println(playerData);
		/*	else if (choice.equals("2"))
				System.out.printf("\n $ %8.2f\n\n", playerData.get());
			else if (choice.equals("3"))
			{
				System.out.print("Year for Sales Amount: ");
				int year = Integer.parseInt(sc.nextLine());
				//System.out.printf("\n $ %8.2f\n\n", playerData.totalByYear(year));
			}*/
			else if (choice.equals("11"))
			{
				System.out.print("Enter customer first name: ");
				String fname = sc.nextLine();
				System.out.print("Enter customer last name: ");
				String lname = sc.nextLine();

			}
		}
	}

	public static void main(String[] args)
	{
		PlayerApp app = new PlayerApp();
	}
}