import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;

public class magic
{
	public static void main(String[] args)
	{
		Scanner scan  = new Scanner(System.in);

		int test_cases = scan.nextInt();

		ArrayList<String> output = new ArrayList<String>();

		for(int i=0; i<test_cases; i++)
		{
			int cards1_choice = scan.nextInt();
			int[][] cards1 = new int[4][4];

			//read in the deck
			for(int r=0; r<4; r++)
				for(int c=0; c<4; c++)
					cards1[r][c] = scan.nextInt();
					
			int cards2_choice = scan.nextInt();
			int[][] cards2 = new int[4][4];

			//read in the deck
			for(int r=0; r<4; r++)
				for(int c=0; c<4; c++)
					cards2[r][c] = scan.nextInt();

			Set<Integer> choice_set = new TreeSet<Integer>();
			ArrayList<Integer> resulting_card = new ArrayList<Integer>();

			//add the cards1 to choice_set
			for(int j=0; j<4; j++)
				choice_set.add(cards1[cards1_choice-1][j]);
				
			//add the cards2 to choice_set, if the card is in the set then add it to the resulting_card list
			for(int j=0; j<4; j++)
				if(!choice_set.add(cards2[cards2_choice-1][j]))
					resulting_card.add(cards2[cards2_choice-1][j]);

			if(resulting_card.size() == 0)
				output.add("Case #" + (i+1) + ": Volunteer Cheated!");
			else if(resulting_card.size() == 1)
				output.add("Case #" + (i+1) + ": " + resulting_card.get(0));
			else output.add("Case #" + (i+1) + ": Bad magician!");
		}

		for(String s : output)
			System.out.println(s);
	}
}


