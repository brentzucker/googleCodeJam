/*
1
2 6
ji
*/
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.io.*;

public class Dijkstra
{
	public static class character
	{
		String value;

		public character(String str)
		{
			value = str; 
		}

		public boolean equals(character c)
		{
			if((this.value).equals(c.value))
				return true;
			else return false;
		}
	}

	public static void main(String[] args) throws IOException
	{
		//Scanner scan = new Scanner(System.in);
		Scanner scan = new Scanner(new File("input.txt"));
		ArrayList<String> output = new ArrayList<String>();
		FileWriter fw = new FileWriter("output.txt");

		int test_cases = scan.nextInt();

		for(int i=0; i<test_cases; i++)
		{
			int characters = scan.nextInt();

			double x_times = scan.nextDouble();

			String input = scan.next();

			String string_to_evaluate = "";
			String sqrt_string = "";

			int sqrt = (int)Math.sqrt(x_times);

			//System.out.println(sqrt);

			double remainder = x_times - (double)Math.pow(sqrt, 2);

			//System.out.println(remainder);

			for(int j=0; j<sqrt; j++)
				sqrt_string += input;

			for(int j=0; j<sqrt; j++)
				string_to_evaluate += sqrt_string;

			for(int j=0; j<remainder; j++)
				string_to_evaluate += input;

			Stack<character> stack_to_evaluate = new Stack<character>();
			Stack<character> stack_evaluated = new Stack<character>();

			for(int j = string_to_evaluate.length()-1; j>=0; j--)
				stack_to_evaluate.push( new character(""+string_to_evaluate.charAt(j)) );

			//Solve for i
			while(stack_to_evaluate.size() >= 2 && !stack_to_evaluate.peek().equals(new character("i")))
			{
				character x = stack_to_evaluate.pop();

				character y = stack_to_evaluate.pop();

				character result = new character( multiply(x.value, y.value) );

				//System.out.println("x: " + x.value + "  --  y: " + y.value + " -- " + "result: " + result.value);

				stack_to_evaluate.push(result);
			}

			//System.out.println(stack_to_evaluate.peek().value);

			if(stack_to_evaluate.size() > 0 && (stack_to_evaluate.peek().value).equals("i"))
				stack_evaluated.push( stack_to_evaluate.pop() );

			//Solve for j
			while(stack_to_evaluate.size() >= 2 && !stack_to_evaluate.peek().equals(new character("j")))
			{
				character x = stack_to_evaluate.pop();

				character y = stack_to_evaluate.pop();

				character result = new character( multiply(x.value, y.value) );

				//System.out.println("x: " + x.value + "  --  y: " + y.value + " -- " + "result: " + result.value);

				stack_to_evaluate.push(result);
			}

			//System.out.println(stack_to_evaluate.peek().value);

			if(stack_to_evaluate.size() > 0 && (stack_to_evaluate.peek().value).equals("j"))
				stack_evaluated.push( stack_to_evaluate.pop() );

			//Solve for k
			while(stack_to_evaluate.size() >= 2 )//&& !stack_to_evaluate.peek().equals(new character("k")))
			{
				character x = stack_to_evaluate.pop();

				character y = stack_to_evaluate.pop();

				character result = new character( multiply(x.value, y.value) );

				//System.out.println("x: " + x.value + "  --  y: " + y.value + " -- " + "result: " + result.value);

				stack_to_evaluate.push(result);
			}

			//System.out.println(stack_to_evaluate.peek().value);

			if(stack_to_evaluate.size() > 0 && (stack_to_evaluate.peek().value).equals("k"))
				stack_evaluated.push( stack_to_evaluate.pop() );


			if(stack_evaluated.size() == 3 && stack_to_evaluate.size() == 0)
				output.add("Case #" + (i+1) + ": " + "YES");
			else
				output.add("Case #" + (i+1) + ": " + "NO");
		}

		for(String s : output)
		{
			fw.write(s + "\n");
			//System.out.println(s);
		}
			

		fw.close();
	}

	public static String multiply(String x, String y)
	{
		String ret = "ERROR";
		if(x.charAt(x.length() - 1) == '1')
		{
			if(y.charAt(y.length() - 1) == '1')
			{
				ret =  "1";
			}
			else if(y.charAt(y.length() - 1) == 'i')
			{
				ret =  "i";
			}
			else if(y.charAt(y.length() - 1) == 'j')
			{
				ret =  "j";
			}
			else if(y.charAt(y.length() - 1)== 'k')
			{
				ret =  "k";
			}
		}
		else if(x.charAt(x.length() - 1) == 'i')
		{
			if(y.charAt(y.length() - 1) == '1')
			{
				ret =  "i";
			}
			else if(y.charAt(y.length() - 1) == 'i')
			{
				ret =  "-1";
			}
			else if(y.charAt(y.length() - 1) == 'j')
			{
				ret =  "k";
			}
			else if(y.charAt(y.length() - 1) == 'k')
			{
				ret =  "-j";
			}
		}
		else if(x.charAt(x.length() - 1) == 'j')
		{
			if(y.charAt(y.length() - 1) == '1')
			{
				ret =  "j";
			}
			else if(y.charAt(y.length() - 1) == 'i')
			{
				ret =  "-k";
			}
			else if(y.charAt(y.length() - 1) == 'j')
			{
				ret =  "-1";
			}
			else if(y.charAt(y.length() - 1) == 'k')
			{
				ret =  "i";
			}
		}
		else if(x.charAt(x.length() - 1) == 'k')
		{
			if(y.charAt(y.length() - 1) == '1')
			{
				ret =  "k";
			}
			else if(y.charAt(y.length() - 1) == 'i')
			{
				ret =  "j";
			}
			else if(y.charAt(y.length() - 1) == 'j')
			{
				ret =  "-i";
			}
			else if(y.charAt(y.length() - 1) == 'k')
			{
				ret =  "-1";
			}
		}

		if(ret.equals("ERROR"))
			System.out.println(ret);

		if(x.charAt(0) == '-')
		{
			if(y.charAt(0) == '-')
				return ret; 
			else if(ret.charAt(0) == '-')
				return ""+ret.charAt(ret.length() - 1);
			else 
				return "-"+ret;
		}
		else
		{
			if(y.charAt(0) == '-')
			{
				if(ret.charAt(0) == '-')
					return ""+ret.charAt(ret.length() - 1);
			else 
				return "-"+ret;
			}
				return ret; 
		}
	}
}