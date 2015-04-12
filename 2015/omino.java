import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class omino
{
	public static void main(String[] args)throws IOException
	{
		Scanner scan = new Scanner(System.in);
		//Scanner scan = new Scanner(new File("input.txt"));
		ArrayList<String> output = new ArrayList<String>();
		FileWriter fw = new FileWriter("output.txt");

		int test_cases = scan.nextInt();

		for(int i=0; i<test_cases; i++)
		{
			int x_omino = scan.nextInt();

			int rows = scan.nextInt();

			int columns = scan.nextInt();

			int board_size = rows * columns;

			if(board_size % x_omino == 0)
			{
				if(x_omino == 1)
					output.add("Case #" + (i+1) + ": GABRIEL");
				else if(x_omino == 2)
					output.add("Case #" + (i+1) + ": GABRIEL");
				else if(x_omino == 3 && (rows == 1 || columns == 1))
				{
					output.add("Case #" + (i+1) + ": RICHARD");
				}
				else if(x_omino == 4 && ( ((rows == 2 && columns == 4) || (columns == 2 && rows == 4 ))|| ((rows == 1 || columns == 1) )) )
				{
					output.add("Case #" + (i+1) + ": RICHARD");
				}
				else if(x_omino > columns && x_omino > rows)
				{
					output.add("Case #" + (i+1) + ": RICHARD");
				}
				else if((x_omino > rows && x_omino != columns) || (x_omino > columns && x_omino != rows))
					output.add("Case #" + (i+1) + ": RICHARD");
				else
				{
					if((x_omino / 2 > rows || x_omino / 2 > columns) || (x_omino % 2 >= rows || x_omino % 2 >= columns) )
						output.add("Case #" + (i+1) + ": RICHARD");
					else
						output.add("Case #" + (i+1) + ": GABRIEL");
				}
			}
			else
			{
				output.add("Case #" + (i+1) + ": RICHARD");
			}
		}

		for(String s : output)
		{
			//fw.write(s + "\n");
			System.out.println(s);
		}

		fw.close();
		scan.close();
	}
}