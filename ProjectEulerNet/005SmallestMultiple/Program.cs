using System;

namespace _005SmallestMultiple
{
	class Program
	{
		private static int GreatestCommonDiviser(int a, int b)
		{
			int temp;

			while (b > 0)
			{
				temp = a % b;
				a = b;
				b = temp;
			}

			return a;
		}

		private static int LeastCommonMultiple(int a, int b)
		{
			int gcd = Program.GreatestCommonDiviser(a, b);
			return a / gcd * b;
		}

		static void Main(string[] args)
		{
			int lcm = 2;

			for (int i = 3; i <= 20; i++)
			{
				lcm = Program.LeastCommonMultiple(lcm, i);
			}

			Console.WriteLine(lcm);
		}
	}
}
