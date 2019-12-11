import java.io.*;
import java.util.*;
public class Fibonacci
{
	private int num;
	public int first=0, second=1, third = 0, temp = 0;
	HashMap<Integer, Integer> h1=new HashMap<>();
	public int fib_memrecur(int num)
	{
		if(h1.containsKey(num))
			return h1.get(num);
		else if(num < 2)
		{
			return num;
		}
		else
		{
			temp = fib_memrecur(num-1) + fib_memrecur(num-2);
			h1.put(num,temp);
			return temp;
		}
	}
	public void display1(int num)
	{
			for(int i=0;i<num;i++)
				System.out.print(fib_memrecur(i)+" ");
	}
		
	public void fib_iterative(int num)
	{
			this.num = num;
			first = 0; second = 1;
			for(int i=0;i<num;i++)
			{
				System.out.print(first+" ");
				third = first + second;
				first = second;
				second = third;
			}
	}
	
	public int fib_recursive(int num)
	{
			if(num<2)
				return num;
			else
				return fib_recursive(num-1) + fib_recursive(num-2);
	}
	public void display(int num)
	{
			for(int i=0;i<num;i++)
				System.out.print(fib_recursive(i)+" ");
	}	
	public static void main(String[] args)
	{
		int num, choice;
		Fibonacci method = new Fibonacci();
		System.out.println("Enter the number to Calculate the Fibonacci Sequence");
		Scanner s=new Scanner(System.in);
		num = s.nextInt();
		System.out.println("Select the mode of method");
		System.out.println("1. Iterative \n2. Recursive \n3.Memorization");
		choice = s.nextInt();
		switch(choice)
		{
			case 1:
				long start_time = System.nanoTime();
				method.fib_iterative(num);
				long end_time = System.nanoTime();
				System.out.println("\nExecution time in Nano seconds is: " + (end_time - start_time)); 
				break;
			case 2:
				start_time = System.nanoTime();
				method.display(num);
				end_time = System.nanoTime();
				System.out.println("\nExecution time in Nano seconds is: " + (end_time - start_time)); 
				break;
			case 3:
				start_time = System.nanoTime();
				method.display1(num);
				end_time = System.nanoTime();
				System.out.println("\nExecution time in Nano seconds is: " + (end_time - start_time)); 
				break;
			default:
				break;	
		}
	}
}