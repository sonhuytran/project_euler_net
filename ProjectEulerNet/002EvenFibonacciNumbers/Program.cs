using System;

namespace _002EvenFibonacciNumbers
{
	class Program
	{
		static void Main(string[] args)
		{
			// calculate the fibonacci
			long a = 0, b = 2, c = 4 * b + a, sum = b;

			while (c < 4000000)
			{
				// Every third Fibonacci number is even
				// Even-Fibonacci : F(n) = 4 * F(n - 1) + F(n - 2);
				sum += c;
				a = b;
				b = c;
				c = 4 * b + a;
			}

			Console.WriteLine(sum);
		}
	}
}
