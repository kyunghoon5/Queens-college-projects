//Theory of Computation - CSCI 320
//Assignment 2
//Kyunghoon Oh
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.HashMap;
public class problem2 {
	public static int coin(char i)
	{
			HashMap<Character, Integer> coin = new HashMap();
			
			coin.put('p', 1);
			coin.put('n', 5);
			coin.put('d', 10);
			coin.put('q', 25); 
			if (!coin.containsKey(i)) 
			{
					return -1;
			}
			return coin.get(i);
	}

	public static int t(int curr, char input)
	{
			int temp = coin(input);
			if (temp == -1) 
			{
					return temp; 
			}
			return Math.max(0, curr - temp);
	}

	public static void vsm(ArrayList<String> inputs, int state)
	{
			System.out.print("Vending machine for ");
			System.out.print(state);
			System.out.print(" cents\n\n");
			for (int i = 0; i < inputs.size(); i++)
			{ 
					System.out.print("Processing input #");
					System.out.print(i + 1);
					System.out.print("\n");
					System.out.print("Starting in state ");
					System.out.print(state);
					System.out.print("\n");
					int curr = state;
					for (int j = 0; j < inputs.get(i).length(); j++)
					{ 
							curr = t(curr, inputs.get(i).charAt(j)); 
							if (curr == -1)
							{ 
									System.out.print("Read ");
									System.out.print(inputs.get(i).charAt(j));
									System.out.print(", invalid input.\n");
									System.out.print("Computation halts abnormally. The partial word \"");
									System.out.print(inputs.get(i).substring(0, j + 1));
									System.out.print("\" is rejected.\n");
									break;
							}
							System.out.print("Read ");
							System.out.print(inputs.get(i).charAt(j));
							System.out.print(", moving to state ");
							System.out.print(curr);
							System.out.print("\n");
					}
					if (curr == 0) 
					{
							System.out.print("Computation halts in final state. The word \"");
							System.out.print(inputs.get(i));
							System.out.print("\" is accepted.\n\n");
					}
					else if (curr == -1) 
					{
							continue;
					}
					else
					{
							System.out.print("Computation halts in non-final state. The word \"");
							System.out.print(inputs.get(i));
							System.out.print("\" is rejected.\n\n");
					}
			}
	}
	

	public static void main(String[] args) throws FileNotFoundException
	{
		
			
			//initialize
			int state;			
			ArrayList<String> inputs = new ArrayList<String>();
			
			File inputFile = new File("/Users/oh/eclipse-workspace/cs320Assignment2/src/input2.txt");
			Scanner scan = new Scanner(inputFile);
			state = Integer.parseInt(scan.nextLine());
			while(scan.hasNextLine())
			{
				
				String data = scan.nextLine();
				inputs.add(data);
			}
			scan.close();
			

		
			
			vsm(inputs, state);
	}
	
}


