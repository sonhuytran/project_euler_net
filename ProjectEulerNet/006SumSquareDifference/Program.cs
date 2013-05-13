using System;

namespace _006SumSquareDifference
{
	class Program
	{
		static void Main(string[] args)
		{
			int n = 100;
			int squareSum = n * n * (n + 1) * (n + 1) / 4; // [n(n+1)/2]^2
			int sumSquare = n * (n + 1) * (n * 2 + 1) / 6; // [n(n+1)(2n+1)]/6

			Console.WriteLine(squareSum - sumSquare);
		}
	}
}
