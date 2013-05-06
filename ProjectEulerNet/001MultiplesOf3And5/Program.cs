using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MultiplesOf3And5
{
	class Program
	{
		static void Main(string[] args)
		{
			string input = Console.ReadLine();
			int n = int.Parse(input);

			Console.WriteLine(SumMultiplesOf3And5.Calculate(n));
		}
	}
}
