using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MultiplesOf3And5
{
	public class SumMultiplesOf3And5
	{
		public static int Calculate(int n)
		{
			int n3 = 1, n5 = 1, n15 = 1;

			if ((n % 3) == 0)
			{
				n3 = (n - 1) / 3;
			}
			else
			{
				n3 = n / 3;
			}

			if ((n % 5) == 0)
			{
				n5 = (n - 1) / 5;
			}
			else
			{
				n5 = n / 5;
			}

			if ((n % 15) == 0)
			{
				n15 = (n - 1) / 15;
			}
			else
			{
				n15 = n / 15;
			}

			int sum3 = n3 * (n3 + 1) / 2 * 3;
			int sum5 = n5 * (n5 + 1) / 2 * 5;
			int sum15 = n15 * (n15 + 1) / 2 * 15;

			return sum3 + sum5 - sum15;
		}
	}
}
