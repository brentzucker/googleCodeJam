/*
4
4 11111
1 09
5 110011
0 1
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class shyness
{
	public static void main(String[] args)throws IOException
	{
		//Scanner scan = new Scanner(new File("input.txt"));
		Scanner scan = new Scanner(System.in);
		ArrayList<String> output = new ArrayList<String>();
		FileWriter fw = new FileWriter("output.txt");

		int test_cases = scan.nextInt();

		for(int i=0; i<test_cases; i++)
		{
			int max_shyness = scan.nextInt();

			String audience = scan.next();

			int standing_count = 0; 

			int friends_to_invite = 0;

			for(int j=0; j < (max_shyness+1); j++ )
			{
				int people = Integer.parseInt(""+audience.charAt(j));

				int needed_to_stand = j;

				if(needed_to_stand <= (friends_to_invite + standing_count))
					standing_count += people;
				else
				{
					//System.out.println("Needed to stand "+ needed_to_stand + " -- " + "Standing Count " + standing_count + " -- Friends to Invite " + friends_to_invite);
					friends_to_invite += (needed_to_stand - (friends_to_invite + standing_count));
					standing_count += people;
				} 
			}
			output.add("Case #" + (i+1) +": " + friends_to_invite);
		}

		for(String s : output)
			System.out.println(s);//fw.write(s + "\n");

		fw.close();
	}
}